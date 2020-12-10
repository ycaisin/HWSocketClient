package main;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import client.DataClient;

public class Application {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		List <Integer> data = new ArrayList<Integer>();
		data.add(10);
		data.add(20);
		data.add(30);
		
		DataClient client = new DataClient(data);
		
		client.getData();

	}

}
