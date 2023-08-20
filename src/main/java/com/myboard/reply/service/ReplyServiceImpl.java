package com.myboard.reply.service;

import com.myboard.reply.domain.Reply;
import com.myboard.reply.dto.ReplyDto;
import com.myboard.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    // 댓글 등록
    @Override
    public void addReply(ReplyDto.ReplyRequestDto replyRequestDto) {
        Reply reply = replyRequestDto.toEntity();
        replyRepository.save(reply);
    }

    // 댓글 삭제
    @Override
    public void removeReply(Long id) {

        replyRepository.deleteById(id);

    }
}