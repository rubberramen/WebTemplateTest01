package com.webTest.model.user;


import com.webTest.model.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    // JDBD 관련 멤버 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // 사용자 관리용 SQL
    private String USER_LIST = "select * from users";
    private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
    private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";
    private String DELETE = "delete users where id = ?";
    private String USER_GET = "select * from users where id = ?";

    public UserVO getUser(UserVO vo) {
        UserVO user = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                user = new UserVO();

                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return user;
    }

    public void deleteUser(String id) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void updateUser(UserVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_UPDATE);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getRole());
            stmt.setString(3, vo.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<UserVO> getUserList() {
//        List<UserVO> userList = new ArrayList<UserVO>();
        List<UserVO> userList = new ArrayList<UserVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt  = conn.prepareStatement(USER_LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
//                System.out.print(rs.getString("ID") + " : ");
//                System.out.print(rs.getString("PASSWORD") + " : ");
//                System.out.print(rs.getString("NAME") + " : ");
//                System.out.println(rs.getString("ROLE"));

                UserVO user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return userList;
    }

    public void insertUser(UserVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);

            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getRole());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
}
