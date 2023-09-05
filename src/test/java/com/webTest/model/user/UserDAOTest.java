package com.webTest.model.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    UserDAO dao = new UserDAO();

    @Test
    void test01() {
        List<UserVO> userList = dao.getUserList();
        for (UserVO userVO : userList) {
            System.out.println("userVO = " + userVO);
        }
    }

}