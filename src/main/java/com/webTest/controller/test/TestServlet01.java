package com.webTest.controller.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test01/*")
public class TestServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test = "test";
//        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/view/tecsttest/test01.jsp");
//        dispatcher.forward(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/view/testtest/test01.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect("/WEB-INF/view/testtest/test01.jsp");
    }
}
