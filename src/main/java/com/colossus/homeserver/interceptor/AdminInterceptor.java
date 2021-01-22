package com.colossus.homeserver.interceptor;

import com.colossus.homeserver.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//
//        if (ObjectUtils.isEmpty(user)) {
//            response.sendRedirect("/login");
//            return false;
//        } else {
//            session.setMaxInactiveInterval(30 * 60);
//            return true;
//        }
        return true;
    }
}
