package com.myboard.response.service.impl;

import com.myboard.response.dto.CommonResult;
import com.myboard.response.dto.ListResult;
import com.myboard.response.dto.SingleResult;
import com.myboard.response.service.ResponseService;
import com.myboard.response.type.ErrorCode;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.myboard.response.type.SuccessCode.SUCCESS;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Override
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = SingleResult.<T>builder()
                .data(data)
                .build();

        result.update(true, SUCCESS.getCode(), SUCCESS.getMessage());
        return result;
    }

    @Override
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = ListResult.<T>builder()
                .data(list)
                .build();

        result.update(true, SUCCESS.getCode(), SUCCESS.getMessage());
        return result;
    }

    @Override
    public CommonResult getSuccessResult() {
        return new CommonResult(true, SUCCESS.getCode(), SUCCESS.getMessage());
    }

    @Override
    public CommonResult getFailResult(ErrorCode errorCode) {
        return new CommonResult(false, errorCode.toString(), errorCode.getMessage());
    }

}
