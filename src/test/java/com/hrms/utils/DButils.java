package com.hrms.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DButils {
public static Connection connection;
public static Statement statement;
public static ResultSet resultSet;
    public static Connection getConnection(){
        try {
            connection= DriverManager.getConnection(ConfigsReader.getPropertyValue("dbURL")
                      ,ConfigsReader.getPropertyValue("dbUsername")
                       ,ConfigsReader.getPropertyValue("dbPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(String query){

        try {
             statement=getConnection().createStatement();
           resultSet= statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static List<Map<String,String>> getDBdataINTOlist(String query){

        List<Map<String,String>> dbList=new ArrayList<>();
        Map<String,String> map;
        try {
            ResultSetMetaData resultSetMetaData= getResultSet(query).getMetaData();
            while (resultSet.next()){ //loops though all rows
            map=new LinkedHashMap<>();
                for (int i = 1; i <=resultSetMetaData.getColumnCount() ; i++) { //loops trough each column of the row

                    map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));

                }

                dbList.add(map);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }

        return dbList;
    }
    public static void closeConnection(){

            try {
                if (resultSet!=null){resultSet.close(); }

                if (statement!=null){statement.close();}
                if (connection!=null){ connection.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
