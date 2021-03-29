package com.custom.test;

import com.custom.handler.IndexHandler;
import com.custom.proxy.ProxyUtil;


public class ProxyTest {

    public static void main(String[] args) {
        IndexDao indexDao = new IndexDaoImpl();
        

//        IndexDao proxyDao = (IndexDao) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IndexDao.class}, new IndexHandler(indexDao));
//        IndexDao proxyDao = (IndexDao) ProxyUtil.newProxyInstance(new Class[]{IndexDao.class} ,new IndexHandler(indexDao));
//        proxyDao.query("张");
    	UserDao userDao = (UserDao) ProxyUtil.newProxyInstance(new Class[]{UserDao.class,IndexDao.class}, new IndexHandler(indexDao));
    	userDao.queryForName("李彤");
    	
        
    }
}
