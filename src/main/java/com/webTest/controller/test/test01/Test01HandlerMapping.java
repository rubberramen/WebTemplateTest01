package com.webTest.controller.test.test01;

import com.webTest.controller.test.test01.controller.Test01ControllerImpl01;

import java.util.HashMap;
import java.util.Map;

public class Test01HandlerMapping {

    private Map<String, Test01Controller> mappings = new HashMap<>();

    public Test01HandlerMapping() {
        mappings.put("/test01", new Test01ControllerImpl01());
    }

    public Test01Controller getController(String path) {
        return mappings.get(path);
    }
}
