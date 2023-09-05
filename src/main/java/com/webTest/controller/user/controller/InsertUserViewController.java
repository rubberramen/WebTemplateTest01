package com.webTest.controller.user.controller;

import com.webTest.controller.user.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUserViewController implements UserController {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "insertUser";
    }
}
