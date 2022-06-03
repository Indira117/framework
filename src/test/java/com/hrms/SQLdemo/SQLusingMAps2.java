package com.hrms.SQLdemo;

import java.sql.*;
import java.util.*;

public class SQLusingMAps2 {
    public static void main(String[] args) throws SQLException {
        String DBurl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        Connection connection= DriverManager.getConnection(DBurl,username,password);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from hs_hr_employees");
        ResultSetMetaData metaData=resultSet.getMetaData();

        List<Map<String,String>> tableData=new ArrayList<>();
        Map <String,String>map;
        while (resultSet.next()){
            map=new HashMap();
            for (int i = 1; i < metaData.getColumnCount(); i++) {

                map.put(metaData.getColumnName(i), resultSet.getString(i));
            }
            tableData.add(map);
        }
        if (resultSet!=null){resultSet.close();}
        if (statement!=null){statement.close();}

        connection.close();

        for (Map<String,String> map1:tableData) {
            Set<Map.Entry<String, String>> entries = map1.entrySet();
            for (Map.Entry<String,String>entry:entries
                 ) {
                System.out.print(entry.getValue()+" ");
            }
            System.out.println();
        }



    }
}
