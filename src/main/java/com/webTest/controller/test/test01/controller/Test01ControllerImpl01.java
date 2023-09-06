package com.webTest.controller.test.test01.controller;

import com.webTest.controller.test.test01.Test01Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01ControllerImpl01 implements Test01Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "test01";
    }
}
