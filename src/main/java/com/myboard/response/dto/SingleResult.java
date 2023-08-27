package com.myboard.response.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SingleResult<T> extends CommonResult {
    private T data;
}
