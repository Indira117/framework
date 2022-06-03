package com.hrms.utils;

import org.json.JSONObject;

public class APIPayloadCommonMethods {

    public static String createEmployeeBody(){
        String createEmployeeBody="{\n" +
                "  \"emp_firstname\": \"Elya\",\n" +
                "  \"emp_lastname\": \"Satim\",\n" +
                "  \"emp_middle_name\": \"\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1987-04-26\",\n" +
                "  \"emp_status\": \"Freelance\",\n" +
                "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                "}";
        return createEmployeeBody;
    }


    public static String createEmployeePayload(){
        JSONObject obj= new JSONObject();
        obj.put("emp_firstname","Elya");
        obj.put("emp_lastname","Satim");
        obj.put("emp_middle_name","F");
        obj.put("emp_birthday","1987-04-26");
        obj.put("emp_status","Freelance");
        obj.put("emp_job_title","Cloud Consultant");
        return obj.toString();
    }
    public static String createEmployeePayloadMoreDynamic(String emplfirstName,String emplLastname,String emplMiddlename,
                                                          String emplGEnder,String emplDOB,String emplStatus,String emplJobTitle){
        JSONObject obj= new JSONObject();
        obj.put("emp_firstname",emplfirstName);
        obj.put("emp_lastname",emplLastname);
        obj.put("emp_middle_name",emplMiddlename);
        obj.put("emp_birthday",emplGEnder);
        obj.put("emp_gender",emplDOB);
        obj.put("emp_status",emplStatus);
        obj.put("emp_job_title",emplJobTitle);
        return obj.toString();
    }
}
