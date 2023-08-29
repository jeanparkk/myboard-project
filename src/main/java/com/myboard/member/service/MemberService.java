package com.myboard.member.service;

import com.myboard.member.dto.MemberRegistration;
import com.myboard.response.dto.CommonResult;
import com.myboard.response.dto.SingleResult;

public interface MemberService {

    SingleResult<Long> register(MemberRegistration parameter);

    CommonResult authConfirm(Long id, String emailAuthToken);
}
