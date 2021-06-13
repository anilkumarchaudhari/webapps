package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces2 {
	
	
	  public boolean isEven(int num) {
		  return num%2 ==0;
	  }
	  public int squared(int num) {
		  return num* num;
	  }
      public static void main (String args[]) {
    	 
    	  List<Integer> numbers=List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    	  
    	  Predicate<Integer> isEvenPredicate= x -> x%2==0;
    	  
    	  Function<Integer,Integer>squareFunction = x -> x * x ;
    	  
    	  Function<Integer,String>stringOutputFunction = x -> x +" " ;
    	  
    	  Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
    	  
    	  BinaryOperator<Integer> sumBinaryOperator= (x,y) -> x+y;
    	  
    	  //Supplier --  No input -->Return sth
    	 // Supplier<Integer> randomIntegerSupplier = () -> 2 ; //() -- no parameter to method and return 2 output
         // System.out.println(randomIntegerSupplier.get());
    	  Supplier<Integer> randomIntegerSupplier = () -> {
    		 
    		  Random random= new Random();
    		  return random.nextInt(1000);
    	  };
    	 // System.out.println(randomIntegerSupplier.get());
    	  
    	  UnaryOperator<Integer> unaryOperator = (x) -> 3 * x ;
    	  
    	  //System.out.println(unaryOperator.apply(10));
    	  
    	  // accepts 2 inputs and returns true
    	  BiPredicate<Integer, String> biPredicate= (number ,str) -> {
    		  return number <10 && str.length() >5 ;
    	  };
    	  
    	  System.out.println(biPredicate.test(15, "in28minutes"));
    	  
    	  //input ,input ,return type
    	  BiFunction<Integer, String,String> biFunction= (number ,str) -> {
    		  return number+"  "+str;
    	  };
    	  
    	  System.out.println(biFunction.apply(5, "Anil"));
    	  
    	  BiConsumer<Integer, String> biConsumer= (s1 ,s2) -> {
    		  System.out.println(s1);
    		  System.out.println(s2);
    	  };
    	  biConsumer.accept(25, "in28minutes");
    	  
    	  
    	  //it works with Wrapper class object hence inefficient in case of primittive
    	  BinaryOperator<Integer> binaryOperator= (Integer x,Integer y) -> x+y;
    	  
    	  //it works wth primitive data type
    	  IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
    	  
    	  Consumer<String > consumer= (str) -> System.out.println();
    	  
    	  Consumer<String > consumer1= System.out::println;
    	  
    	  Consumer<String > consumer2= (str) -> System.out.println(str);
    	  
    	  BiConsumer<String,String > biConsumer1= (str,str2) -> System.out.println(str);
    	  
    	  Supplier<Integer> supplier1 = () -> 2 ;
    	  
    	  Supplier<String> supplier2 = () -> {return "Anil";} ;
    	  
    	  Consumer<String > consumer3= (str) -> {System.out.println(str);System.out.println(str);};
    	  //IntBinaryOperator
    	  //IntFunction
    	  //IntConsumer
    	  //IntPredicate
    	  //IntSupplier
    	  //IntToDoubleFunction
    	  //IntToLongFunction
    	  //IntUnaryOperator
      }
	
}
