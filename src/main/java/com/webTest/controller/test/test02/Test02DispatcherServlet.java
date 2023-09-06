package com.webTest.controller.test.test02;

import com.webTest.controller.test.test01.Test01Controller;
import com.webTest.controller.test.test01.Test01HandlerMapping;
import com.webTest.controller.test.test01.Test01ViewResolver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testDomain02/*")
public class Test02DispatcherServlet extends HttpServlet {

    private Test02HandlerMapping handlerMapping;
    private Test02ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        handlerMapping = new Test02HandlerMapping();
        viewResolver = new Test02ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/test02/");
        viewResolver.setSuffix(".jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        Test02Controller ctrl = handlerMapping.getController(path);

        String viewName = ctrl.handleRequest(request, response);

        String view = viewResolver.getView(viewName);

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
