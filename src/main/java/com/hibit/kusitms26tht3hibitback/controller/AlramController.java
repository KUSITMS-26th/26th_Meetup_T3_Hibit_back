package com.hibit.kusitms26tht3hibitback.controller;

import com.hibit.kusitms26tht3hibitback.domain.Users;
import com.hibit.kusitms26tht3hibitback.dto.MatchingSaveRequestDto;
import com.hibit.kusitms26tht3hibitback.service.AlarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="alarm", description = "알람 api")
@RestController
@RequestMapping("/alram")
@RequiredArgsConstructor
public class AlramController {
    private final AlarmService alarmService;

//    @PostMapping("/{idx}/application")
//    @Operation(summary = "alarm/{idx}/application", description = "매칭메이트 신청 시 알람")
//
//    public int save(@RequestBody MatchingSaveRequestDto requestDto){
//        Users user =
//
//    }

}
