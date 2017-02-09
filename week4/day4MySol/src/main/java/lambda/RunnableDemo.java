package lambda;

public class RunnableDemo {

	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("I'm running in thread: " + Thread.currentThread().getName());
		}

	}
	
	public static void main(String[] args) {

		Runnable runnable = new MyRunnable(); 
		new Thread(runnable).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm running in thread: " + Thread.currentThread().getName());
			}
		}).start();
		
		new Thread(() -> {
			System.out.println("I'm running in thread: " + Thread.currentThread().getName());
		}
		).start();
		
		new Thread(() -> System.out.println("I'm running in thread: " + Thread.currentThread().getName())).start();
		
	}

}
