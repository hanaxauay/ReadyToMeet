package com.final2.readytomeet.kakaoLogin;

import com.final2.readytomeet.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class KakaoLoginCallbackController {

    private final KakaoMapper kakaoMapper;


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

            if (userInfoResponse != null) { // && userInfoResponse.getNickname() != null
                // 사용자 정보를 활용하여 원하는 작업 수행

                // 모델에 필요한 정보를 추가
                model.addAttribute("nickname", userInfoResponse.getNickname());
                model.addAttribute("email", userInfoResponse.getEmail());
                System.out.println("accessToken : " + accessToken);

                // User 정보를 데이터베이스에 저장
                UserDto userDto = new UserDto();
                userDto.setUser_id(UUID.randomUUID().toString()); // UUID로 랜덤한 값을 설정
                userDto.setUser_pw(UUID.randomUUID().toString()); // UUID로 랜덤한 값을 설정
                userDto.setUser_phone(UUID.randomUUID().toString()); // UUID로 랜덤한 값을 설정
                userDto.setUser_email(userInfoResponse.getEmail()); // UUID로 랜덤한 값을 설정
                userDto.setUser_name("gara data"); // UUID로 랜덤한 값을 설정
                userDto.setUser_nickname(UUID.randomUUID().toString());
                userDto.setUser_age(new Random().nextInt(100)); // 0부터 99까지의 랜덤한 정수 설정
                userDto.setUser_gender(new Random().nextInt(100)); // UUID로 랜덤한 값을 설정
                userDto.setUser_location(UUID.randomUUID().toString()); // UUID로 랜덤한 값을 설정

                // ... 다른 필드 설정

                kakaoMapper.insertUser(userDto.getUser_id(), userDto.getUser_pw(), userDto.getUser_phone(), userDto.getUser_email(),
                        userDto.getUser_name(), userDto.getUser_nickname(), userDto.getUser_age(), userDto.getUser_gender(), userDto.getUser_location());

                System.out.println("Logged in user:");
                System.out.println("Nickname: " + userInfoResponse.getNickname());
                System.out.println("Email: " + userInfoResponse.getEmail());

                return "redirect:/main"; // 로그인 성공 후 리다이렉트할 페이지 설정
            }
        }

        return "redirect:/login"; // 로그인 실패 시 리다이렉트할 페이지 설정
    }
}