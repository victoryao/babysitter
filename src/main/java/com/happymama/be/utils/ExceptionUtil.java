package com.happymama.be.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常处理
 * @author dengjianli@xiaomi.com
 *
 */
public class ExceptionUtil {

	
	/**
	 * 获取换货处理的exception详情信息
	 * 
	 * @param e
	 *            Excetipn type
	 * @return String type
	 */
	 public static  String getStackTraceInfo(Throwable t) {
	        StringWriter sw = new StringWriter();
	        sw.write("异常如下:\n\n");
	        PrintWriter pw = new PrintWriter(sw);
	        try {
	            t.printStackTrace(pw);
	            return sw.toString();
	        } finally {
	            pw.close();
	        }
	    }
}
