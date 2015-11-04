import com.google.gson.Gson;
import java.io.IOException;
import java.net.*;


public class ThreadsUDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int BUFFERSIZE = 50;
		
		TestClass tc5 = new TestClass();
		tc5.name = "Peter";
		tc5.age = 15;
		
		
		Gson g1 = new Gson();
		
		String json2 = g1.toJson(tc5);
				
		
		DatagramPacket pack = new DatagramPacket(new byte[BUFFERSIZE],BUFFERSIZE);
		DatagramSocket sock = null;
		
		BUFFERSIZE = pack.getLength();
		
		try {
			sock = new DatagramSocket(2000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Multithread mt1 = new Multithread(sock,pack);
		
		//mt1.start();
		try {
			sock.receive(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BUFFERSIZE = pack.getLength();
		
		String json = new String(pack.getData());
		
		
		System.out.println(json);
		
		
		//TestClass tc1 = g1.fromJson(json, TestClass.class);
		
		//System.out.println(tc1.name);
		
		//System.out.println(new String(pack.getData()));
		
		

	}

}
