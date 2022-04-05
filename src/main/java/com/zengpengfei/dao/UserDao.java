package com.zengpengfei.dao;

import com.zengpengfei.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    /*String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String birthdate = request.getParameter("birthdate");*/
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {

        String sql="insert into dbo values('"+user+"')";

        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from dbo where username="+user;
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update dbo set username="+user;
        PreparedStatement st= con.prepareStatement(sql);
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from dbo where id="+id;
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from dbo where username=username and password=password";
        PreparedStatement st= con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
        user=new User();
        user.setId(rs.getInt("id"));
        user.getUsername(rs.getString("username"));
        user.getPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setGender(rs.getString("gender"));
        user.setBithDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from dbo where username=username";
        PreparedStatement st= con.prepareStatement(sql);

        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from dbo where pqssword=password";
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from dbo where email=email";
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from dbo where gender=gender";
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from dbo where birthdate=birthDate";
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from dbo ";
        PreparedStatement st= con.prepareStatement(sql);
        return null;
    }
}
