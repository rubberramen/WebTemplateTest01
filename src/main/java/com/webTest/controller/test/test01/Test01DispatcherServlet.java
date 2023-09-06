package com.webTest.controller.test.test01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testDomain01/*")
public class Test01DispatcherServlet extends HttpServlet {

    private Test01HandlerMapping handlerMapping;
    private Test01ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        handlerMapping = new Test01HandlerMapping();
        viewResolver = new Test01ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/test01/");
        viewResolver.setSuffix(".jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        Test01Controller ctrl = handlerMapping.getController(path);

        String viewName = ctrl.handleRequest(request, response);

        String view = viewResolver.getView(viewName);

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
