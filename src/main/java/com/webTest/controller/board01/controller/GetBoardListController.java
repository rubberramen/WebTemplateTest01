package com.webTest.controller.board01.controller;

import com.webTest.controller.Controller;
import com.webTest.model.board01.BoardDAO;
import com.webTest.model.board01.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1. 사용자 입력정보 추출
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");

        // Null Check
        if(searchCondition == null) searchCondition = "TITLE";
        if(searchKeyword == null) searchKeyword = "";

        // 세션에 검색 관련 정보를 저장한다.
        HttpSession session = request.getSession();
        session.setAttribute("condition", searchCondition);
        session.setAttribute("keyword", searchKeyword);

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");  // TODO: 2023-09-06 수정 예정 

        BoardDAO dao = new BoardDAO();
        List<BoardVO> boardList = dao.getBoardList(vo);

        // 3. 화면 이동
        request.setAttribute("boardList", boardList);
//        return "getBoardList";
        return "getBoardList_backup";
    }
}
