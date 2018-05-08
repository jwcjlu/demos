package com.jwcjlu.demos.kafka.charpter03;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaSender {
    private KafkaProducer producer;
    private boolean isCreate=false;
    public KafkaProducer   createProducer(){
        Properties prop=new Properties();
       prop.put("bootstrap.servers","10.60.35.84:9092,10.60.35.69:9092,10.60.35.93:9092");
       prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
       prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
       return new KafkaProducer<String,String>(prop);

    }
    public void send(){
        ProducerRecord<String,String> record=new ProducerRecord<String,String>("ConstomerCountry","producer Products","France");
        if(!isCreate){
            producer=createProducer();
            isCreate=true;
        }
        try {
            producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]agrs){
        KafkaSender sender=new KafkaSender();
        sender.send();
    }

}
