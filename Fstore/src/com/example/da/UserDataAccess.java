package com.example.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccess {
    public static boolean checkUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean st = false;
        DbConnection db = new DbConnection();
        if ( username != null && password != null){
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("select * from tbuser where username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs =preparedStatement.executeQuery();
            st = rs.next();

        }
        return st;
    }
}
