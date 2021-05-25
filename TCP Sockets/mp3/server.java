package mp3;
import java.net.*;
import java.io.*;
import java.util.*;

public class server {
	public server() {}
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		if (args.length != 2) {
	        System.err.println("Usage: java server <port number> <max. clients>");
	        System.exit(1);
	    }
		 int portNumber = Integer.parseInt(args[0]);
		 int maxClients = Integer.parseInt(args[1]);
	     boolean listening = true;
	     try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
	    	 	System.out.println("Please enter a string");
				String str = sc.nextLine();
				System.out.println("Please enter an integer");
				String n = sc.nextLine();
				int N = Integer.parseInt(n);
	            while (listening) {
	            	//System.out.println("IP address : " + InetAddress.getLocalHost());
		            new ServerThread(serverSocket.accept(),str,N).start();
		        }
		    } catch (IOException e) {
	            System.err.println("Could not listen on port " + portNumber);
	            System.exit(-1);
	        }
	    }
	}
