package com.jwcjlu.demos.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;

import java.util.concurrent.TimeUnit;

public class TestPulsarClient {
    public static void main(String[] args) throws Exception {
        String localClusterUrl = "pulsar://10.4.6.109:6650";
        PulsarClient client = PulsarClient.builder().serviceUrl(localClusterUrl).build();
        new Thread(() -> {
            try {
            Producer<byte[]> producer = client.newProducer().topic("my-topic2").create();
            int index = 0;
            while (true) {

                    producer.send(("sssss" + index).getBytes());
                    index++;
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (Exception e) {

            }
        }
        ).start();
        new Thread(() -> {
            try {
                Producer<byte[]> producer = client.newProducer().topic("my-topic3").create();
                int index = 0;
                while (true) {

                    producer.send(("aaaaa" + index).getBytes());
                    index++;
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (Exception e) {

            }
        }
        ).start();

    }
}
