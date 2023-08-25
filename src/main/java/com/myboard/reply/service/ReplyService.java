package com.myboard.reply.service;

import com.myboard.reply.dto.ReplyDto;

public interface ReplyService {

    ReplyDto.BoardWithReplyDto findBoardWithReplies(Long boardId);
    void addReply(ReplyDto.ReplyRequestDto replyRequestDto);

    void removeReply(Long id);
}
