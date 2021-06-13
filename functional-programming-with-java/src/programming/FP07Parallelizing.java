package programming;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP07Parallelizing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       long time=System.currentTimeMillis();
       //600
       System.out.println(
    		   LongStream.range(0, 1000000000).sum());
       //336
       //parallet makes better performance and also it performs operation paralleling rather executing each part seperately and adding them later
       System.out.println(
    		   LongStream.range(0, 1000000000).parallel().sum());
       System.out.println(System.currentTimeMillis()-time);
	}

}
