/*
 * @(#)CollectionUtils.java	2012-11-27
 *
 * Copyright 2012 Mobile Internet, Inc. All rights reserved.
 * XiaoMi PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.happymama.be.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author edwin
 * @email wangfuye@xiaomi.com
 * @date 2012-11-27 上午11:28:34
 * 
 */
public abstract class CollectionUtils {

	public static <T> List<T> newArrayList(){
		return new ArrayList<T>();
	}
	public static <T> List<T> newArrayList(int size){
		return new ArrayList<T>(size);
	}
	
	public static <T> Set<T> newHashSet(){
		return new HashSet<T>();
	}
	
	public static <T> Set<T> newHashSet(int size){
		return new HashSet<T>(size);
	}
	
	public static <K, V> Map<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public static <K, V> Map<K, V> newConcurrentHashMap() {
		return new ConcurrentHashMap<K, V>();
	}
	
	public static <K, V> Map<K, V> newLinkedHashMap() {
		return new LinkedHashMap<K, V>();
	}

	public static <K, V> Map<K, V> newLinkedHashMap(int size) {
		return new LinkedHashMap<K, V>();
	}
}
