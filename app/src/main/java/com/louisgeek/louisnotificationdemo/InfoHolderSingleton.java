package com.louisgeek.louisnotificationdemo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by louisgeek on 2016/5/19.
 */
public class InfoHolderSingleton {
    //单例模式实例
    private static InfoHolderSingleton instance = null;


    private InfoHolderSingleton()
    {
        mHashMap = new HashMap<String,Object>();
        mArrayList=new ArrayList<Object>();
    }

    //synchronized 用于线程安全，防止多线程同时创建实例
    public synchronized static InfoHolderSingleton getInstance(){
        if(instance == null){
            instance = new InfoHolderSingleton();
        }
        return instance;
    }


    final HashMap<String, Object> mHashMap;
    public void putMapObj(String key,Object value){
        mHashMap.put(key,value);
    }

    public Object getMapObj(String key)
    {
        return mHashMap.get(key);
    }

    final ArrayList<Object> mArrayList;
    public void addListObj(Object o){
        mArrayList.add(o);
    }

    public Object getListObj(int pos)
    {
        return mArrayList.get(pos);
    }
}
