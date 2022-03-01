package com.example.shortform.controller;

import com.example.shortform.config.jwt.TokenDto;
import com.example.shortform.dto.request.SigninRequestDto;
import com.example.shortform.dto.request.SignupRequestDto;
import com.example.shortform.dto.resonse.CMResponseDto;
import com.example.shortform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/auth/signup")
    public ResponseEntity<CMResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    // 이메일 중복체크
    @PostMapping("/auth/email-check")
    public ResponseEntity<CMResponseDto> emailCheck(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.emailCheck(signupRequestDto);
    }

    // 닉네임 중복체크
    @PostMapping("/auth/nickname-check")
    public ResponseEntity<CMResponseDto> nicknameCheck(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.nicknameCheck(signupRequestDto);
    }

    // 이메일 인증 확인
    @GetMapping("/auth/check-email-token")
    public ResponseEntity<CMResponseDto> checkEmailToken(String token, String email) {
        return userService.checkEmailToken(token, email);
    }

    // 이메일 인증 재전송
    /*@GetMapping("/auth/resend-check-email")
    public ResponseEntity<CMResponseDto> resendCheckEmailToken() {

    }*/

    @PostMapping("/auth/signin")
    public ResponseEntity<TokenDto> signin(@RequestBody SigninRequestDto signinRequestDto) {
        return userService.login(signinRequestDto);
    }

}

