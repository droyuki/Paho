package edu.nccu.iotlab.mqtt;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by WeiChen on 2016/2/6.
 */
public class MqttSubscribeSample implements MqttCallback {
    MqttClient client;
    Config conf = ConfigFactory.load();
    String broker = conf.getString("broker");
    String subTopic = "mqtt_test";

    public MqttSubscribeSample() {
    }

    public static void main(String[] args) {
        new MqttSubscribeSample().start();
    }

    public void start() {
        try {
            client = new MqttClient(broker, "Sending");
            client.connect();
            client.setCallback(this);
            client.subscribe(subTopic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void connectionLost(Throwable throwable) {

    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("------------ Message Arrived ------------\n" + "Topic: " + s + "\nMsg: " + mqttMessage + "\n-----------------------------------------");
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
