package com.myboard.response.service;

import com.myboard.response.dto.CommonResult;
import com.myboard.response.dto.ListResult;
import com.myboard.response.dto.SingleResult;

import java.util.List;

public interface ResponseService {

    <T> SingleResult<T> getSingleResult(T data);

    <T> ListResult<T> getListResult(List<T> list);

    CommonResult getSuccessResult();

    CommonResult getFailResult(ErrorCode errorCode);

}
