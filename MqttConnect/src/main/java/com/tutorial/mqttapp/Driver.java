package com.tutorial.mqttapp;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import com.tutorial.mqttapp.model.Sensor;

public class Driver {

	public static void main(String[] args) throws MqttSecurityException, MqttException, InterruptedException {

		System.out.println("Mqtt connect application..");

		MqttListener listener = new MqttListener();

		Publisher pub = new Publisher();
		pub.connect();
		Thread.sleep(5000);
		pub.publish();
		System.out.println("Application executed..");

	}
}

class Publisher {
	String publisherId = UUID.randomUUID().toString();
	String serverUri = "tcp://localhost:1883";

	IMqttClient publisher;

	public void connect() throws MqttSecurityException, MqttException {
		try {
			publisher = new MqttClient(serverUri, publisherId);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		publisher.connect(options);

		System.out.println("Connection established successfully..");
	}

	public void publish() throws MqttPersistenceException, MqttException {
		Sensor sensor = new Sensor(publisher);
		sensor.publishMsg();
	}

}
