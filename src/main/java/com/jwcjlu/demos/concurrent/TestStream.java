package com.jwcjlu.demos.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

/**
 * Created by jwcjlu on 2019/5/30.
 */
public class TestStream {
    public static void main(String[] args) {
        String names="asdfsd";
        List<EventData> list1=new ArrayList<EventData>();
        List<EventData> list2=new ArrayList<EventData>();
        List<EventData> list3=new ArrayList<EventData>();
        List<EventData> list4=new ArrayList<EventData>();
        Random random=new Random();
        for(int i=0;i<16000;i++){
            int index=random.nextInt(5)+1;
            list1.add(new EventData(names.substring(0,index),i));
            list2.add(new EventData(names.substring(0,index),i));
            list3.add(new EventData(names.substring(0,index),i));
            list4.add(new EventData(names.substring(0,index),i));
        }
        long startTime=0;
        startTime=System.currentTimeMillis();
        list4.parallelStream().collect(groupingBy(EventData::getName));
        System.out.println("parallelStream->groupingBy["+(System.currentTimeMillis()-startTime)+"]");
        startTime =System.currentTimeMillis();
        list2.stream().collect(groupingByConcurrent(EventData::getName));
        System.out.println("stream->groupingByConcurrent["+(System.currentTimeMillis()-startTime)+"]");
        startTime=System.currentTimeMillis();
        list1.parallelStream().collect(groupingByConcurrent(EventData::getName));
        System.out.println("parallelStream->groupingByConcurrent["+(System.currentTimeMillis()-startTime)+"]");
        startTime=System.currentTimeMillis();
        list3.stream().collect(groupingBy(EventData::getName));
        System.out.println("stream->groupingBy["+(System.currentTimeMillis()-startTime)+"]");



    }
}
class EventData{
    public EventData(String name,int age){
        this.name=name;
        this.age=age;
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
