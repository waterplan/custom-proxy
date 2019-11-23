package com.imitate.test;

public interface IndexDao {

     Object query(String name);

     void insert(String name);

     String listAll(String orgCode, String outUserCode);
}
