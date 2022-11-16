package com.hibit.kusitms26tht3hibitback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hibit.kusitms26tht3hibitback.domain.Matching;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
public class MatchingUpdateRequestDto {

    private String title;
    private String exhibition;
    private String content;
    private int number;
    private LocalDateTime start_date;
    private LocalDateTime finish_date;
    private LocalDateTime end_date;
    private String openchat;
    private String want;


    @Builder
    public MatchingUpdateRequestDto(String title, String exhibition, String content, int number, LocalDateTime start_date, LocalDateTime finish_date, LocalDateTime end_date, String openchat, String want){
        this.title= title;
        this.exhibition= exhibition;
        this.content= content;
        this.number= number;
        this.start_date= start_date;
        this.finish_date=finish_date;
        this.end_date=end_date;
        this.openchat=openchat;
        this.want=want;
    }
}
