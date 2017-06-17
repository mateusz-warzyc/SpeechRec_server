package pl.mateuszwarzyc.sr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.mateuszwarzyc.sr.common.UserNotFoundException;
import pl.mateuszwarzyc.sr.persistence.entities.Bookmark;
import pl.mateuszwarzyc.sr.persistence.repository.AccountRepository;
import pl.mateuszwarzyc.sr.persistence.repository.BookmarkRepository;

import java.net.URI;
import java.util.Collection;

/**
 * Created by mateusz-warzyc.
 */
@RestController
@RequestMapping("/{userId}/bookmarks")
public class BookmarkRestController {

    private final BookmarkRepository bookmarkRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository ) {
        this.accountRepository = accountRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Bookmark> readBookmarks(@PathVariable String userId) {
        //this.validateUser(userId);
        return this.bookmarkRepository.findByAccountUsername(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
        this.validateUser(userId);
        return this.accountRepository.findByUsername(userId).map(account -> {
            Bookmark result = bookmarkRepository.save(new Bookmark(account, input.getUrl(),input.getDescription()));
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(location).build();
        }).orElse(ResponseEntity.noContent().build());
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
    public Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
        this.validateUser(userId);
        return this.bookmarkRepository.findOne(bookmarkId);

    }

    private void validateUser(String userId) {
        this.accountRepository.findByUsername(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
