package com.custom.test;

import com.custom.handler.UserHandler;
import com.custom.proxy.ProxyUtil;


public class ProxyTest {

    public static void main(String[] args) {
        IndexDao indexDao = new IndexDaoImpl();
        

//        IndexDao proxyDao = (IndexDao) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IndexDao.class}, new IndexHandler(indexDao));
//        IndexDao proxyDao = (IndexDao) ProxyUtil.newProxyInstance(IndexDao.class,new Class[]{IndexDao.class} ,new IndexHandler(indexDao));
//        proxyDao.query("张");
    	UserDao userDao = (UserDao) ProxyUtil.newProxyInstance(new Class[]{UserDao.class}, new UserHandler());
    	userDao.queryForName("李彤");
    	
        
    }
}
