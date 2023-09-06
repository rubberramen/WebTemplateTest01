package com.webTest.controller.board01;

import com.webTest.controller.Controller;
import com.webTest.controller.HandlerMapping;
import com.webTest.controller.board01.controller.GetBoardListController;

import java.util.HashMap;
import java.util.Map;

public class Board01HandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public Board01HandlerMapping() {
        mappings.put("/getBoardList", new GetBoardListController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
