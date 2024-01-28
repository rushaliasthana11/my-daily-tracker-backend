package com.myproject.dailytracker.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse extends BaseResponse{
    String error_message;

    public ErrorResponse(Boolean success, String status, String error_message) {
        super(success, status);
        this.error_message = error_message;
    }
}
