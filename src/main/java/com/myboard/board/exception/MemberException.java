package com.myboard.board.exception;

import com.myboard.response.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberException extends RuntimeException{

    private ErrorCode errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public MemberException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }
}
