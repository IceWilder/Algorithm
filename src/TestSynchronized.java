import java.util.concurrent.TimeUnit;


public class TestSynchronized {
	private Object syObject=new Object();
	public void f(){
		System.out.println("线程f还没上锁！"+Thread.currentThread().getName());
		synchronized (syObject) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"已上锁!");
				 try {
	                  TimeUnit.SECONDS.sleep(2);
	              } catch (InterruptedException e) {
	                  e.printStackTrace();
	              }
			}
		}

	}
	public void g() {
		System.out.println("线程g还未上锁！"+Thread.currentThread().getName());
		synchronized (syObject) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"已上锁!");
				 try {
	                  TimeUnit.SECONDS.sleep(2);
	              } catch (InterruptedException e) {
	                  e.printStackTrace();
	              }
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TestSynchronized testSynchronized=new TestSynchronized();
		new Thread(){
			public void run(){
				testSynchronized.f();
			}
		}.start();
		new Thread(){
			public void run(){
				testSynchronized.g();
			}
		}.start();
	}

}
