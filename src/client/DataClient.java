package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DataClient {
	List<Integer> data;

	public void getData() throws UnknownHostException, IOException {
		System.out.println("Client getData() started");
		
		Socket clientSocket = new Socket("localhost", 8888);
	
		StringBuilder strToSent = dataValueToString(); 
		
		System.out.println("Cl sending");
		DataOutputStream dout = new DataOutputStream( clientSocket.getOutputStream());
		
		dout.writeUTF(strToSent.toString());
		DataInputStream din = new DataInputStream( clientSocket.getInputStream());		
		
		System.out.println("Server's answer: avg = "+		din.readByte());
		
		System.out.println("Cl ending");
	
		
		dout.flush();
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public DataClient(List<Integer> data) {
		this.data = data;
	}
	
	public StringBuilder dataValueToString() {
		StringBuilder strToSent = new StringBuilder() ;
		for (Integer integer : data) {
			strToSent.append(integer.intValue());
			strToSent.append(",");
		}
		strToSent.deleteCharAt(strToSent.length()-1);
		return strToSent;	
	}

}
