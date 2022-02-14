package com.tutorial.mqttapp;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttListener implements MqttCallback {

	String clientId = UUID.randomUUID().toString();
	String serverUri = "tcp://localhost:1883";
	String topicName = "iqcloud";

	public MqttListener() {
		MqttClient client = null;
		try {
			client = new MqttClient(serverUri, clientId);
			client.setCallback(this);

			MqttConnectOptions mqOptions = new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);

			client.subscribe(topicName);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void connectionLost(Throwable cause) {
		System.out.println("Subscription connection lost");

	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("message received on topic " + topic + " is: " + message);

	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		System.out.println("Delivery completed at subscription side..");

	}

}
