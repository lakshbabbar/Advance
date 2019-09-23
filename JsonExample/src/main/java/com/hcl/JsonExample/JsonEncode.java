package com.hcl.JsonExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonEncode {
	public static void main(String args[]) {
		JSONObject obj = new JSONObject();
		obj.put("name", "laksh");
		obj.put("age", new Integer(43));
		obj.put("salary", new Double(45000));
		System.out.println(obj);
		
		Map obj1=new HashMap();    
		  obj1.put("name","laksh");    
		  obj1.put("age",24);    
		  obj1.put("salary",new Double(849999));   
		  String jsonText = JSONValue.toJSONString(obj1);  
		  System.out.println(jsonText); 
		  
		  
		  JSONObject objarr = new JSONObject();
		  for(int i=0;i<=5;i++){
		  JSONArray arr = new JSONArray();  
		  arr.add("sonoo");    
		  arr.add(new Integer(27));    
		  arr.add(new Double(600000)); 
		  objarr.put(i, arr);
		  }

		  System.out.println(objarr);
		  
		  
		  JSONArray jsonarr1 = new JSONArray();
		  
		  for(int i=0;i<=5;i++){
		  JSONArray arr = new JSONArray();  
		  arr.add("Emp"+i);    
		  arr.add(new Integer(27) + i);    
		  arr.add(new Double(600000)+i); 
		  jsonarr1.add(arr);
		  }

		  System.out.println(jsonarr1);
		  
		  
		  JSONArray jsonarr2 = new JSONArray();
		  Scanner sc = new Scanner(System.in);
		  for(int i=0;i<2;i++){
		  JSONArray arr = new JSONArray();  
		  arr.add(sc.next());    
		  arr.add(sc.next());    
		  arr.add(sc.next()); 
		  jsonarr2.add(arr);
		  }

		  System.out.println(jsonarr2);
	}
}