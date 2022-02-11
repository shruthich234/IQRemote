package com.tutorial.mqttapp.model;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Sensor {

	IMqttClient client;

	String msg = "DoorClosed";
	String topicName = "test";

	public Sensor(IMqttClient client) {
		this.client = client;

	}

	public void publishMsg() throws MqttPersistenceException, MqttException {
		if (!client.isConnected()) {
			return;
		}

		byte[] payload = msg.getBytes();
		MqttMessage msg = new MqttMessage(payload);

		client.publish(topicName, msg);
		System.out.println("Published msg successfully..");
		return;
	}

}
