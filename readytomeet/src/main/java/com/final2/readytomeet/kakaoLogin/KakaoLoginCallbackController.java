package com.final2.readytomeet.kakaoLogin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class KakaoLoginCallbackController {

    private final String clientId = "464e1b3f69dc1186658ba3def0b52ead";
    private final String redirectUri = "http://localhost:8080/login/kakao/callback";

    @GetMapping("/login/kakao/callback")
    public String kakaoLoginCallback(@RequestParam("code") String code, Model model) {
        // 카카오 로그인 API로부터 받은 인증 코드(code)를 활용하여 액세스 토큰(access token) 요청

        // 액세스 토큰 요청
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        RestTemplate restTemplate = new RestTemplate();
        KakaoTokenResponse tokenResponse = restTemplate.postForObject(tokenUrl +
                "?grant_type=authorization_code&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&code=" + code, null, KakaoTokenResponse.class);

        if (tokenResponse != null) {
            String accessToken = tokenResponse.getAccess_token();
            // 액세스 토큰을 활용하여 사용자 정보 요청

            // 사용자 정보 요청
            String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

            KakaoUserInfoResponse userInfoResponse = restTemplate.getForObject(userInfoUrl +
                    "?access_token=" + accessToken, KakaoUserInfoResponse.class);

            if (userInfoResponse != null) {
                // 사용자 정보를 활용하여 원하는 작업 수행

                // 모델에 필요한 정보를 추가
                model.addAttribute("nickname", userInfoResponse.getNickname());
                model.addAttribute("email", userInfoResponse.getEmail());

                return "redirect:/main"; // 로그인 성공 후 리다이렉트할 페이지 설정
            }
        }

        return "redirect:/login"; // 로그인 실패 시 리다이렉트할 페이지 설정
    }
}
