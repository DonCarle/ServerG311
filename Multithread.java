import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Multithread extends Thread {
	
	DatagramSocket sock;
	DatagramPacket pack;

	
	Multithread(DatagramSocket _sock, DatagramPacket _pack){
		sock = _sock;
		pack = _pack;
	}
	
	
	@Override
	public void run(){
		try {
			sock.receive(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
