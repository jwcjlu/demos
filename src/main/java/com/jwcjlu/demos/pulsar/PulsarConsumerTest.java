package com.jwcjlu.demos.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;


public class PulsarConsumerTest {
    public static void main(String[] args) throws PulsarClientException {
        String localClusterUrl = "pulsar://10.4.6.109:6650";
        PulsarClient client = PulsarClient.builder().serviceUrl(localClusterUrl).build();

       final Consumer consumer = client.newConsumer()
                .topic("my-topic2","my-topic3")
                .subscriptionName("my-subscription")
                .subscribe();
      new Thread(()->{
        while (true) {
            // Wait for a message

            Message msg = null;
            try {
                msg = consumer.receive();
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }

            try {
                // Do something with the message
                System.out.println("my-subscription Message received: "+ new String(msg.getData()));

                // Acknowledge the message so that it can be deleted by the message broker
             /*   consumer.acknowledge(msg);*/
            } catch (Exception e) {
                // Message failed to process, redeliver later
            }
        }}).start();

       /* final Consumer consumer1 = client.newConsumer()
                .topic("my-topic")
                .subscriptionName("my-subscription1")
                .subscribe();
        new Thread(()->{
            while (true) {
                // Wait for a message

                Message msg = null;
                try {
                    msg = consumer1.receive();
                } catch (PulsarClientException e) {
                    e.printStackTrace();
                }

                try {
                    // Do something with the message
                    System.out.println("my-subscription1 Message received: "+ new String(msg.getData()));

                    // Acknowledge the message so that it can be deleted by the message broker
                    consumer1.acknowledge(msg);
                } catch (Exception e) {
                    // Message failed to process, redeliver later
                }
            }}).start();*/

    }
}
