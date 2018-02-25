/*
 * @(#)StrutsUtils.java	2012-11-26
 *
 * Copyright 2012 Mobile Internet, Inc. All rights reserved.
 * XiaoMi PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yaohoo.be.utils;

/**
 * @author edwin
 * @email wangfuye@xiaomi.com
 * @date 2012-11-26 下午08:15:35
 * 
 */
public abstract class StrutsUtils {

	public static final String DEFAULT_SUFFIX = "Action";
	public static final String DEFAULT_SEPARATOR = "_";

	/**
	 * Transfer classname to uri
	 * 
	 * @param className
	 * @return
	 */
	public static String transfer2URI(String className) {
		if (StringUtils.isBlank(className)) throw new IllegalArgumentException();
		if (className.endsWith(DEFAULT_SUFFIX)) className = className.substring(0, className.indexOf(DEFAULT_SUFFIX));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < className.length(); i++) {
			char c = className.charAt(i);
			boolean isUpperCase = StringUtils.isUpperCase(c);
			if (isUpperCase) {
				if (i > 0) sb.append(DEFAULT_SEPARATOR);
				c = StringUtils.toLowerCase(c);
			}
			sb.append(c);
			
		}
		return sb.toString();
	}

}
