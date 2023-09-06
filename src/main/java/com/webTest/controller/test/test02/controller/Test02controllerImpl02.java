package com.webTest.controller.test.test02.controller;

import com.webTest.controller.test.test02.Test02Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test02controllerImpl02 implements Test02Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "test02";
    }
}
