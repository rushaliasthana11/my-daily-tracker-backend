package com.myproject.dailytracker.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SuccessResponse extends BaseResponse{
    private Object response;

    public SuccessResponse(Boolean success, String status, Object response) {
        super(success, status);
        this.response = response;
    }
}
