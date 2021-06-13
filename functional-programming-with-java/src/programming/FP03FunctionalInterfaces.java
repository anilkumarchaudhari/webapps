package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {
	
	
	  public boolean isEven(int num) {
		  return num%2 ==0;
	  }
	  public int squared(int num) {
		  return num* num;
	  }
      public static void main (String args[]) {
    	 
    	  List<Integer> numbers=List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    	  //Functional Interface -interface with exactly one abstract method
    	  //Lambda exp converted as object
    	 // Predicate<Integer> isEvenPredicate = x -> x%2 ==0; 
    	  Predicate<Integer> isEvenPredicate1 = new  Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t %2 ==0;
			}
    	  };
    	  
		//Function<Integer,Integer> squareFunction = x -> x* x;
		Function<Integer,Integer> squareFunction1 = new Function<Integer,Integer> (){

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}
			
		};
		//Consumer<Integer> systemConsumer = System.out::println;
		
		Consumer<Integer> systemConsumer1= new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		};
		//calc square of even nos
		numbers.stream()
    	  .filter(isEvenPredicate1)
    	  .map(squareFunction1)
    	  .forEach(systemConsumer1);
		
		//calc sum of all no's in list
		
		BinaryOperator<Integer> sumBinaryOperator = Integer :: sum;
		BinaryOperator<Integer> sumBinaryOperator1 = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a+b;
			}
			
		};
		int sum=numbers.stream()
		.reduce(0,sumBinaryOperator);
		System.out.println("sum is "+sum);
      }
	
}
