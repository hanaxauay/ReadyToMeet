//package com.final2.readytomeet.config;
//
//import com.final2.readytomeet.dto.UserDto;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        UserDto loggedInUser = (UserDto) session.getAttribute("loggedInUser");
//
//        if (loggedInUser == null) {
//            // 로그인되지 않은 사용자의 경우 로그인 페이지로 리다이렉트
//            response.sendRedirect("/login");
//            return false;
//        }
//
//        // 로그인된 사용자에게만 접근 권한 부여
//        return true;
//    }
//}
