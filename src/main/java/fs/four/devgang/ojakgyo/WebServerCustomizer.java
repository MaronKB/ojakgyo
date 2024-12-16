package fs.four.devgang.ojakgyo;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage error400Page = new ErrorPage(org.springframework.http.HttpStatus.BAD_REQUEST, "/error/400");
        ErrorPage error401Page = new ErrorPage(org.springframework.http.HttpStatus.UNAUTHORIZED, "/error/401");
        ErrorPage error403Page = new ErrorPage(org.springframework.http.HttpStatus.FORBIDDEN, "/error/403");
        ErrorPage error404Page = new ErrorPage(org.springframework.http.HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage error500Page = new ErrorPage(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");

        factory.addErrorPages(error400Page, error401Page, error403Page, error404Page, error500Page);
    }
}
