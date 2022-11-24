package com.hibit.kusitms26tht3hibitback.service;

import com.hibit.kusitms26tht3hibitback.domain.Alarm;
import com.hibit.kusitms26tht3hibitback.domain.Matching;
import com.hibit.kusitms26tht3hibitback.domain.UserMatching;
import com.hibit.kusitms26tht3hibitback.domain.Users;
import com.hibit.kusitms26tht3hibitback.dto.AlarmSaveRequestDto;
import com.hibit.kusitms26tht3hibitback.repository.AlarmRepository;
import com.hibit.kusitms26tht3hibitback.repository.MatchingRepository;
import com.hibit.kusitms26tht3hibitback.repository.UserMatchingRepository;
import com.hibit.kusitms26tht3hibitback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AlarmService {
    private final AlarmRepository alarmRepository;
    private final UserRepository userRepository;
    private final MatchingRepository matchingRepository;
    private final UserMatchingRepository userMatchingRepository;

    @Transactional
    public int saveMatching(int writer, int mid){
        AlarmSaveRequestDto requestDto = new AlarmSaveRequestDto();
        Users user = userRepository.findByIdx(writer).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다."));
        Matching matching = matchingRepository.findById(mid).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
        String content = user.getNickname() + "님이 매칭 신청을 했습니다.";
        requestDto.setUser(user);
        requestDto.setCategory();
        requestDto.setReaded();
        requestDto.setOpenchat(matching.getOpenchat());
        requestDto.setContent(content);
        Alarm alarm = requestDto.toEntity();
        alarmRepository.save(alarm);
        return alarm.getIdx();
    }

    public int saveMatchingTF(String nickname, int mid){
        AlarmSaveRequestDto requestDto = new AlarmSaveRequestDto();
        Users user = userRepository.findByNickname(nickname).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다."));
        Matching matching = matchingRepository.findById(mid).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
        UserMatching userMatching = userMatchingRepository.findByMid(mid).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
//        Users write = userRepository.findByIdx(userMatching.getWriter()).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다."));
        if (userMatching.getMatching_check() == 'T'){
            String content;
            content = matching.getUser().getNickname()+"이 매칭을 수락했습니다.";
            requestDto.setContent(content);
        }
        else if(userMatching.getMatching_check() == 'F'){
            String content;
            content = matching.getUser().getNickname()+"이 매칭을 거절했습니다.";
            requestDto.setContent(content);
        }
        requestDto.setUser(user);
        requestDto.setCategoryTF();
        requestDto.setReaded();
        requestDto.setOpenchat(matching.getOpenchat());
        Alarm alarm = requestDto.toEntity();
        alarmRepository.save(alarm);
        return alarm.getIdx();
    }



}
