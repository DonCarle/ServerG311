import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool { //With race condition :)
	public static long total = 0;
	
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.submit(new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<100000;i++)
					System.out.println(total++);
			}
		});
		
		exec.submit(new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<100000;i++)
					System.out.println(total++);
			}
		});
	}
}