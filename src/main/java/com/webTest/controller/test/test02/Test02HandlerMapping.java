package com.webTest.controller.test.test02;

import com.webTest.controller.test.test01.Test01Controller;
import com.webTest.controller.test.test01.controller.Test01ControllerImpl01;
import com.webTest.controller.test.test02.controller.Test02controllerImpl01;
import com.webTest.controller.test.test02.controller.Test02controllerImpl02;

import java.util.HashMap;
import java.util.Map;

public class Test02HandlerMapping {

    private Map<String, Test02Controller> mappings = new HashMap<>();

    public Test02HandlerMapping() {
        mappings.put("/test01", new Test02controllerImpl01());
        mappings.put("/test02", new Test02controllerImpl02());
    }

    public Test02Controller getController(String path) {
        return mappings.get(path);
    }
}
