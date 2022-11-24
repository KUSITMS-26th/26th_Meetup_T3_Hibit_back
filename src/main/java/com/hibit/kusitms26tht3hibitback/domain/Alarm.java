package com.hibit.kusitms26tht3hibitback.domain;

import com.hibit.kusitms26tht3hibitback.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@Table(name ="alarm")
public class Alarm extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Users user;

    @Column(nullable = false)
    @Schema(description = "알림 타입", example = "M")
    //M = 매칭 신청 왔음, R= 매칭 결과 갱신 + 평가는 나중에..
    private char category;


    @Column(nullable = false, length = 200)
    @Schema(description = "내용", example = "새로운 매칭 신청이 있습니다.")
    private String content;

    @Column(nullable = false)
    @Schema(description = "읽음", example = "false")
    private char readed;

    @Column(nullable = true, length = 50)
    @Schema(description = "오픈채팅 url", example = "https://openchat~~")
    private String openchat;

    @Builder
    public Alarm(Users user, char category, String content, char reads, String openchat) {
        this.user = user;
        this.category = category;
        this.content = content;
        this.readed = readed;
        this.openchat = openchat;
    }

}
