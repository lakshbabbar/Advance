package com.hcl.JsonExample;

import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;  
public class JsonDecode {  
public static void main(String[] args) {  
    String s="{\"name\":\"laksh\",\"salary\":45000.0,\"age\":12}";
    System.out.println(s);
    Object obj=JSONValue.parse(s);  
    JSONObject jsonObject = (JSONObject) obj;  
  
    String name = (String) jsonObject.get("name");  
    double salary = (Double) jsonObject.get("salary");  
    long age = (Long) jsonObject.get("age");  
    System.out.println(name+" "+salary+" "+age);  
}  
}  