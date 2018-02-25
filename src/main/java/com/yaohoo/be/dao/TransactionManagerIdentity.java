/*
 * @(#)TransactionManagerIdentity.java	2012-12-5
 *
 * Copyright 2012 Mobile Internet, Inc. All rights reserved.
 * XiaoMi PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yaohoo.be.dao;

/**
 * @author	edwin
 * @email 	wangfuye@xiaomi.com
 * @date	2012-12-5 下午02:29:16
 *
 */
public interface TransactionManagerIdentity {

	public static final String DEFAULT_MANAGER = "transactionManager";
	
	public static final String HIBERNATE_MANAGER = "hibernateTransactionManager";
}
