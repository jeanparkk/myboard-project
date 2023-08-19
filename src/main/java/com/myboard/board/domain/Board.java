package com.myboard.board.domain;

import com.myboard.type.Category;
import com.myboard.type.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Setter
    private String thumbnail;

    private Long member_id; //TODO : member Many ToOne 관계 형성

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Status status;

    private LocalDateTime createdAt; //TODO: BaseEntity 분리
    private LocalDateTime updatedAt; //TODO: BaseEntity 분리

}
