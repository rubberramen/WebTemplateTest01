package com.webTest.controller.user.controller;

import com.webTest.controller.Controller;
import com.webTest.model.user.UserDAO;
import com.webTest.model.user.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);

        UserDAO dao = new UserDAO();
        UserVO user = dao.getUser(vo);

        // 3. 화면 이동
        HttpSession session = request.getSession();
        if (user != null && user.getPassword().equals(password)) {
            // 상태 정보를 세션에 저장한다.
            session.setAttribute("user", user);
            // 글 목록 화면으로 이동한다.
            return "index";
        } else {
            return "/login";
        }
    }
}
