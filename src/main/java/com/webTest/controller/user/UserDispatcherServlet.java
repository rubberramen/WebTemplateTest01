package com.webTest.controller.user;

import com.webTest.controller.Controller;
import com.webTest.controller.DispatcherServlet;
import com.webTest.controller.ViewResolver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserDispatcherServlet extends DispatcherServlet {
    private UserHandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        handlerMapping = new UserHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/user/");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        Controller ctrl = handlerMapping.getController(path);

        String viewName = ctrl.handleRequest(request, response);

        String view = null;

        if (viewName.equals("index")) {
//            view = viewName + ".jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//            dispatcher.forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            view = viewResolver.getView(viewName);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}
