package com.webTest.controller.user;

import com.webTest.controller.ViewResolver;

public class UserViewResolver extends ViewResolver {

    public String prefix;
    public String suffix = ".jsp";

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getView(String viewName) {
        return prefix + viewName + suffix;
    }
}
