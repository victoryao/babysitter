package com.happymama.be.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by yaoqiang on 2018/6/30.
 */
public class HttpClientFactoryBean implements InitializingBean, FactoryBean<CloseableHttpClient> {
    private static final int DEFAULT_CONNECTION_TIMEOUT = 3000;
    private static final int DEFAULT_SO_TIMEOUT = 15000;
    private static final int MAX_CONN_TOTAL = 300;

    private int connectTimeOut = DEFAULT_CONNECTION_TIMEOUT;
    private int soTimeOut = DEFAULT_SO_TIMEOUT;
    private int connRequestTimeOut = DEFAULT_CONNECTION_TIMEOUT;
    private int maxConnTotal = MAX_CONN_TOTAL;
    private int maxConnPerRoute = MAX_CONN_TOTAL;
    private CloseableHttpClient httpClient;


    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getSoTimeOut() {
        return soTimeOut;
    }

    public void setSoTimeOut(int soTimeOut) {
        this.soTimeOut = soTimeOut;
    }

    public int getConnRequestTimeOut() {
        return connRequestTimeOut;
    }

    public void setConnRequestTimeOut(int connectManagerTimeOut) {
        this.connRequestTimeOut = connectManagerTimeOut;
    }

    public int getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(int maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    public int getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(int maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    @Override
    public CloseableHttpClient getObject() throws Exception {
        return httpClient;
    }

    @Override
    public Class<?> getObjectType() {
        return CloseableHttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        httpClient = HttpClientBuilder
                .create()
                .setMaxConnTotal(maxConnTotal)
                .setMaxConnPerRoute(maxConnPerRoute)
                .setDefaultSocketConfig(SocketConfig.custom().setSoKeepAlive(true).setSoReuseAddress(true).setSoTimeout(soTimeOut).build())
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
                .setDefaultRequestConfig(
                        RequestConfig.custom().setConnectionRequestTimeout(connRequestTimeOut).setConnectTimeout(connectTimeOut).setSocketTimeout(soTimeOut)
                                .build()).build();
    }


}