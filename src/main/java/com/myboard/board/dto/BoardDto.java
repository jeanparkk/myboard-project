package com.myboard.board.dto;

import com.myboard.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class BoardDto {

    @Getter
    @Setter
    public static class CreateRequest {
        @NotBlank(message = "제목은 필수 입력 값입니다.")
        @Length(max = 255, message = "제목은 255자를 넘어갈 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 필수 입력 값입니다.")
        @Length(max = 20000, message = "본문은 20,000자를 넘어갈 수 없습니다.")
        private String content;
    }

    @Getter
    @Setter
    public static class UpdateRequest {
        private Long id;
        private String title;
        private String content;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ListResponse {
        private Long id;
        private String title;
        private String content;
        private String thumbnail;
        private String nickname;

        public static ListResponse fromEntity(Board board) {
            return ListResponse.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .thumbnail(board.getThumbnail())
                    .nickname("임시닉네임") // TODO: Member 연관관계 설정되면 수정
                    .build();
        }
    }

    @Getter
    @Setter
    public static class DetailResponse {
        private Long id;
        private String title;
        private String content;
        private String thumbnail;

        // TODO: private Member member;
        // TODO: private List<Comment> comment;
    }
}
