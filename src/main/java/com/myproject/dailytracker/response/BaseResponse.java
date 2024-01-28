package com.myproject.dailytracker.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BaseResponse {
    private Boolean success;
    private String status;
}
