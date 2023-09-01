package com.myboard.member.domain;

import com.myboard.member.type.EmailAuthStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.myboard.member.type.EmailAuthStatus.UNVERIFIED;
import static com.myboard.member.type.EmailAuthStatus.VERIFIED;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EmailAuth extends BaseEntity {

    @Column(nullable = false)
    private String emailAuthToken;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmailAuthStatus emailAuthStatus;

    @Column
    private LocalDateTime emailAuthAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    public EmailAuth confirmAuth() {
        this.emailAuthStatus = VERIFIED;
        this.emailAuthAt = LocalDateTime.now();
        return this;
    }

    public static EmailAuth generateEmailAuth(Member member) {
        return EmailAuth.builder()
                .emailAuthToken(UUID.randomUUID().toString())
                .emailAuthStatus(UNVERIFIED)
                .member(member)
                .build();
    }
}
