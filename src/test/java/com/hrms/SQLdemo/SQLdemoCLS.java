package com.hrms.SQLdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLdemoCLS {
    public static void main(String[] args) throws SQLException {
        //driver-jdbc,database-mysql,oracle,sybase etc,host address-server, port address, name database
        String DBUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        String query="select * from hs_hr_employees";
        Connection connection= DriverManager.getConnection(DBUrl,userName,password);
       List<EmployeeInfo>employeeInfosList=extracted(query, connection);

        System.out.println(employeeInfosList);


    }

    private static List<EmployeeInfo> extracted(String query,Connection connection) throws SQLException {
      DatabaseMetaData metaData=connection.getMetaData();
        System.out.println(metaData.getDatabaseProductName()); // TO IDENTIFY database type
        Statement statement=null;
        ResultSet resultSet = null;
        List<EmployeeInfo> allEmployees=new ArrayList<>();
        try {
          statement= connection.createStatement();
            resultSet= statement.executeQuery(query);

            while (resultSet.next()){
                String emp_firstname= resultSet.getString("emp_firstname");
                String emp_lastname= resultSet.getString("emp_lastname");
                EmployeeInfo employeeInfo=new EmployeeInfo(emp_firstname,emp_lastname);
                allEmployees.add(employeeInfo);
            }

}catch (SQLException sqlException){
            System.out.println("Task failed successfully");
        }finally {
            if (resultSet!=null){resultSet.close();}
            if (statement!=null){statement.close();}

            connection.close();
        }
return allEmployees;
    }
}
