package pro.sky.java.course2.examineservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidAmountOfQuestionsException extends RuntimeException {
    public NotValidAmountOfQuestionsException() {
    }

    public NotValidAmountOfQuestionsException(String message) {
        super(message);
    }

    public NotValidAmountOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidAmountOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public NotValidAmountOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
