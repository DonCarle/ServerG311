//import com.google.gson.Gson;
import java.io.IOException;
import java.net.*;

public class ThreadsUDPServer {

	static byte[] data;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int BUFFERSIZE = 50;

		DatagramSocket sock = null;

		try {
			sock = new DatagramSocket(2000);

			// Multithread mt1 = new Multithread(sock,pack);

			// mt1.start();
			while (true)

			{

				String json = "";
				String IPAdress = "";

				data = new byte[BUFFERSIZE];

				DatagramPacket pack = new DatagramPacket(data, BUFFERSIZE);

				sock.receive(pack);
				
				IPAdress = new String("IP: " + pack.getAddress());

				json = new String(pack.getData());
				
				
				System.out.println(json + " " + IPAdress );
				

				if (json.startsWith("quit")) {
					System.out.println("quitting");

					break;
				}
			}

			sock.close();

		}

		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// TestClass tc1 = g1.fromJson(json, TestClass.class);

// System.out.println(tc1.name);

// System.out.println(new String(pack.getData()));

