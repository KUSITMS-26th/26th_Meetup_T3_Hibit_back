package com.hibit.kusitms26tht3hibitback.dto;

import com.hibit.kusitms26tht3hibitback.domain.Alarm;
import com.hibit.kusitms26tht3hibitback.domain.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PublicKey;

@NoArgsConstructor
@Getter
public class AlarmSaveRequestDto {
    private Users user;
    private char category;
    private String content;
    private char readed;
    private String openchat;

    @Builder
    public AlarmSaveRequestDto(Users user, char category, String content, char read, String openchat){
        this.user = user;
        this.category=category;
        this.content = content;
        this.readed=readed;
        this.openchat=openchat;
    }

    public Alarm toEntity(){
        return Alarm.builder()
                .user(user)
                .category(category)
                .content(content)
                .reads(readed)
                .openchat(openchat)
                .build();
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public void setCategory(){this.category = 'M';}
    public void setCategoryTF(){this.category = 'R';}
    public void setReaded(){this.readed='N';}
    public void setContent(String content){this.content=content;}
    public void setOpenchat(String open){this.openchat = open;}

}
