package com.yaohoo.be.dao;

import com.yaohoo.be.config.DBType;

public class ContextHolder {
	  private static final ThreadLocal<Object> holder = new ThreadLocal<Object>();

	    public static void setDbType(DBType dbType) {
	        holder.set(dbType);
	    }

	    public static DBType getDbType() {
	        return (DBType) holder.get();
	    }

	    public static void clearDbType() {
	        holder.remove();
	    }
}
