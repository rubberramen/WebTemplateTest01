package com.webTest.controller.user;

import com.webTest.controller.Controller;
import com.webTest.controller.HandlerMapping;
import com.webTest.controller.user.controller.InsertUserViewController;
import com.webTest.controller.user.controller.LoginController;
import com.webTest.controller.user.controller.LoginViewController;

import java.util.HashMap;
import java.util.Map;

public class UserHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public UserHandlerMapping() {
        mappings.put("/loginView", new LoginViewController());
        mappings.put("/insertUserView", new InsertUserViewController());
        mappings.put("/login", new LoginController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
