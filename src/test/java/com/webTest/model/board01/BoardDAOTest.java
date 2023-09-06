package com.webTest.model.board01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardDAOTest {

    BoardDAO dao = new BoardDAO();

    @Test
    void test01() {
        BoardVO boardVO = new BoardVO();
        boardVO.setSearchCondition("TITLE");
        boardVO.setSearchKeyword("");

        List<BoardVO> boardList = dao.getBoardList(boardVO);
        for (BoardVO vo : boardList) {
            System.out.println("vo = " + vo);
        }
    }

}