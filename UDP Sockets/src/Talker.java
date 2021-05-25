import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Talker {
	public static void main(String args[]) throws IOException
    {
		if (args.length != 1) {
	        System.err.println("Usage: java Talker <port number>");
	        System.exit(1);
	    }
		int portNumber = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        //System.out.println("IP address : " + ip);
        byte buf[] = null;
        byte[] ack = new byte[1];
        while (true)
        {
        	int numMessages = 0;
        	String message0 = null;
        	System.out.println("Please enter a string of length 50 or less");
            String inp = sc.nextLine();
            if (inp.length() > 51) {
            	System.out.println("The inputed string exceeds length 50");
            	continue;
            }
            if (inp.length() > 40 & inp.length() < 51) {
            	numMessages = 5;
            	message0 = "0, 5 Messages"; }
            if (inp.length() > 30 & inp.length() < 41) {
            	numMessages = 4;
            	message0 = "0, 4 Messages"; }
            if (inp.length() > 20 & inp.length() < 31) {
            	numMessages = 3;
            	message0 = "0, 3 Messages"; }
            if (inp.length() > 10 & inp.length() < 21) {
            	numMessages = 2;
            	message0 = "0, 2 Messages"; }
            if (inp.length() > 0 & inp.length() < 11) {
            	numMessages = 1;
            	message0 = "0, 1 Message"; }
            int j = 0;
            buf = message0.getBytes();
            DatagramPacket packet0 = new DatagramPacket(buf, buf.length, ip, portNumber);
            DatagramPacket ackPacket = new DatagramPacket(ack,ack.length);
            String TxMessage = null;
            while (j !=1 ) {
            	ds.send(packet0);
            	System.out.println("Talker sent: " + message0);
            	ds.receive(ackPacket);
            	try {
            		TimeUnit.SECONDS.sleep(2);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            	String message = new String(ackPacket.getData());
            	j = Integer.parseInt(message);
            	System.out.println("Talker received ack: " + j);
            } 
       	 	if (j == 1) {
       	 		for (int i = 0; i< numMessages;) {
       	 			if (i == numMessages -1 ) {
       	 			TxMessage = ((i+1)+", "+inp.substring(i*10)); 
       	 			}
       	 			else { TxMessage = ((i+1)+", "+inp.substring(i*10,(i*10)+10)); }
       	 			buf = TxMessage.getBytes();
       	 			DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, portNumber);
       	 			ds.send(packet);
       	 			System.out.println("Talker sent: " + TxMessage);
       	 			try {
       	 				TimeUnit.SECONDS.sleep(2);
       	 			} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
       	 			ds.receive(ackPacket);
       	 			String message2 = new String(ackPacket.getData());
       	 			j = Integer.parseInt(message2);
       	 			System.out.println("Talker received ack: " + j);
       	 			if (j == i + 2) { i++; }
       	 			else continue;
       	 		}
       	 	}
       	 	else { continue;}
        }
    }
}

