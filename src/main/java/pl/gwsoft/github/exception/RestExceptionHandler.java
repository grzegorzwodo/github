package pl.gwsoft.github.exception;

import org.kohsuke.github.GHFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="The repository does not exist!")
    @ExceptionHandler(GHFileNotFoundException.class)
    public void repositorynotFound() {
        // Nothing to do
    }
}
