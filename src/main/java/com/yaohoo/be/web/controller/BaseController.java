package com.yaohoo.be.web.controller;

import java.io.PrintWriter;

import org.apache.noggit.JSONUtil;

public class BaseController {
	
	public void ajax(PrintWriter printWriter,Object object) { 
        String jsonString = JSONUtil.toJSON(object);
        printWriter.write(jsonString); 
        printWriter.flush(); 
        printWriter.close(); 
    } 

}
