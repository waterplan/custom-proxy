package com.imitate.test;

public class IndexDaoImpl  implements IndexDao{
    @Override
    public Object query(String name) {
        System.out.println(" 查询数据库");
        return null;
    }

    @Override
    public void insert(String name) {
        System.out.println("插入数据");
    }

    @Override
    public String listAll(String orgCode, String outUserCode) {
        System.out.println("查询所有");
        return null;
    }
}
