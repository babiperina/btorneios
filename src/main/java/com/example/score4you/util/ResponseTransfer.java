package com.example.score4you.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ResponseTransfer {
    private HttpStatus httpCode;
    private String text;


    public ResponseTransfer(HttpStatus httpCode, String text) {
        this.httpCode = httpCode;
        this.text = text;
    }
    public ResponseTransfer(String text) {
        this.text = text;
    }
}
