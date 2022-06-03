package com.hrms.SQLdemo;

import java.sql.*;

public class SQLusingMaps {
    public static void main(String[] args) throws SQLException {
        String DBurl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        Connection connection= DriverManager.getConnection(DBurl,username,password);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from hs_hr_employees");
        ResultSetMetaData metaData=resultSet.getMetaData();
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            System.out.println(metaData.getColumnName(i));
        }

            if (resultSet!=null){resultSet.close();}
            if (statement!=null){statement.close();}

            connection.close();

    }
}
