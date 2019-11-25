package com.imitate.test;

import com.imitate.handler.IndexHandler;
import com.imitate.handler.UserHandler;
import com.imitate.proxy.ProxyUtil;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        IndexDao indexDao = new IndexDaoImpl();

//        IndexDao proxyDao = (IndexDao) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IndexDao.class}, new IndexHandler(indexDao));
//        IndexDao proxyDao = (IndexDao) ProxyUtil.newProxyInstance(IndexDao.class,new Class[]{IndexDao.class} ,new IndexHandler(indexDao));
//        proxyDao.query("张");
    	UserDao userDao = (UserDao) ProxyUtil.newProxyInstance(UserDao.class, new Class[]{UserDao.class}, new UserHandler());
    	userDao.queryForName("李彤");
    	
        
    }
}
