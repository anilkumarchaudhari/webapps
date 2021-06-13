package programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP04Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count());
		System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer :: sum));
		int []numberArray= {12, 9, 13, 4, 6, 2, 4, 12, 15};
		System.out.println(Arrays.stream(numberArray));
		System.out.println(Arrays.stream(numberArray).average());
		System.out.println(Arrays.stream(numberArray).sum());
		System.out.println(Arrays.stream(numberArray).min());
		System.out.println(Arrays.stream(numberArray).max());
		
		System.out.println(IntStream.range(0, 10));
		System.out.println(IntStream.range(0, 10).sum());
		System.out.println(IntStream.rangeClosed(0, 10).sum());
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum());
		System.out.println(IntStream.iterate(2, e -> e+2).limit(10).peek(System.out::println).sum());
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum());
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).boxed().collect(Collectors.toList()));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		//calc factorial of no
		System.out.println(IntStream.rangeClosed(1, 5).reduce(1, (x,y) -> x*y));
		System.out.println(IntStream.rangeClosed(1, 50).reduce(1, (x,y) -> x*y));
		System.out.println(LongStream.rangeClosed(1, 50).reduce(1, (x,y) -> x*y));
		System.out.println(LongStream.rangeClosed(1, 20).reduce(1, (x,y) -> x*y));
		System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));//convert value to biginteger

	}

}
