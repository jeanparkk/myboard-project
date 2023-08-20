package com.myboard.reply.service;

import com.myboard.reply.dto.ReplyDto;

public interface ReplyService {
    void addReply(ReplyDto.ReplyRequestDto replyRequestDto);

    void removeReply(Long id);
}
