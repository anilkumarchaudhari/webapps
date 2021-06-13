package programming;

import java.util.stream.IntStream;

public class FP10Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Runnable runnable=new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(Thread.currentThread().getId() +" : "+i);
				}
				
			}
        	  
          };
          Runnable runnable2=() -> {
				/*
				 * for (int i = 0; i < 1000; i++) {
				 * System.out.println(Thread.currentThread().getId() +" : "+i); }
				 */
        	  IntStream.range(0, 1000).forEach(i->System.out.println(Thread.currentThread().getId() +" : "+i));
            };
          Thread thread=new Thread(runnable2);
          thread.start();
          Thread thread1=new Thread(runnable2);
          thread1.start();
          Thread thread2=new Thread(runnable2);
          thread2.start();
          
          
	}

}
