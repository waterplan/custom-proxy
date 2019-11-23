package com.imitate.test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
public class Proxy$0  implements  com.imitate.test.IndexDao
{
    public Proxy$0(InvocationHandler h, Object source) {
        this.h = h; this.source = source; }
    private  InvocationHandler h;
    private Object source;
    public void insert(java.lang.String arg0) {
        try { Method method = source.getClass().getMethod("insert",arg0.getClass());
            method.setAccessible(true);
            h.invoke( this, method, new Object[]{arg0});} catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public java.lang.Object query(java.lang.String arg0) {
        try { Method method = source.getClass().getMethod("query",arg0.getClass());
            method.setAccessible(true);
            return (java.lang.Object)h.invoke( this, method, new Object[]{arg0});} catch (Throwable throwable) {
            throwable.printStackTrace();
        }return null;
    }
    public java.lang.String listAll(java.lang.String arg0,java.lang.String arg1) {
        try { Method method = source.getClass().getMethod("listAll",arg0.getClass(),arg1.getClass());
            method.setAccessible(true);
            return (java.lang.String)h.invoke( this, method, new Object[]{arg0,arg1});} catch (Throwable throwable) {
            throwable.printStackTrace();
        }return null;
    }
}