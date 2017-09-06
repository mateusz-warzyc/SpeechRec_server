package pl.mateuszwarzyc.sr.security.auth.jwt.extractor;

import io.jsonwebtoken.lang.Assert;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateusz-warzyc.
 */
public class SkipPathRequestMatcher implements RequestMatcher {

    private OrRequestMatcher matchers;
    private RequestMatcher processingMatecher;

    public SkipPathRequestMatcher(List<String> pathsToSkip, String processingPath) {
        Assert.notNull(pathsToSkip);
        List<RequestMatcher> m = pathsToSkip.stream().map( path -> new AntPathRequestMatcher(path)).collect(Collectors.toList());
        matchers = new OrRequestMatcher(m);
        processingMatecher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (matchers.matches(request)) {
            return false;
        }
        return processingMatecher.matches(request) ? true : false;
    }
}
