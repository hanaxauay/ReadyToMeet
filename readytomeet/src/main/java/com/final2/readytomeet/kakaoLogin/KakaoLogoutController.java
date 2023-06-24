package com.final2.readytomeet.kakaoLogin;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class KakaoLogoutController {

    @GetMapping("/kakao/logout")
    public String logout() {
        // 로그아웃 요청
        String accessToken = "VLGvAo9xMMFqCJLBVlXE74YRtsb-wFv-zLfdJ8cVCj10mAAAAYi90CDW";
        RestTemplate restTemplate = new RestTemplate();
        String logoutUrl = "https://kapi.kakao.com/v1/user/logout";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(logoutUrl, HttpMethod.POST, entity, String.class);

        // 로그아웃 성공 여부 확인
        if (response.getStatusCode() == HttpStatus.OK) {
            // 로그아웃 성공
            return "카카오 로그인을 로그아웃했습니다.";
        } else {
            // 로그아웃 실패
            return "카카오 로그인 로그아웃에 실패했습니다.";
        }
    }
}
