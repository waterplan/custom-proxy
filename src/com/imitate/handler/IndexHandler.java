package com.imitate.handler;

import com.imitate.test.IndexDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IndexHandler implements InvocationHandler {

    private IndexDao indexDao;

    public IndexHandler(IndexDao indexDao){
        this.indexDao = indexDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录时间");
        return  method.invoke(indexDao,args);
    }
}
