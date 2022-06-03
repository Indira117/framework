package com.hrms.stepdefintions;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DButils;

import java.util.List;
import java.util.Map;

public class FunctionTest {
    public static void main(String[] args) {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query="select emp_firstname, emp_lastname from hs_hr_employees;";

       List<Map<String,String>> list= DButils.getDBdataINTOlist(query);
        System.out.println(  list.size());
        for (Map<String,String>l:list
             ) {
            System.out.println(l);
        }


    }


}
