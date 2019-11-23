package com.imitate.test;

import com.imitate.handler.IndexHandler;
import com.imitate.proxy.ProxyUtil;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        IndexDao indexDao = new IndexDaoImpl();

//        IndexDao proxyDao = (IndexDao) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IndexDao.class}, new IndexHandler(indexDao));
        IndexDao proxyDao = (IndexDao) ProxyUtil.newProxyInstance(indexDao,new Class[]{IndexDao.class} ,new IndexHandler(indexDao));
        proxyDao.query("张");
    }
}
