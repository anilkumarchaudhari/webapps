package programming;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP02StreamOperations {
      public static void main (String args[]) {
    	  List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    		List<String> courses = List.of("Spring", "Spring Boot ","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");

		//printAllNumbersInListStructured(numbers);
    	 // int sum =addListFunctional(numbers);
    	 // System.out.println(sum);
    	 // List<Integer>squareList=squareList(numbers); //return list wth square of each no
    	 // System.out.println(doubleList);
    	 //  List<Integer>evenNumbers=evenNumbers(numbers);
    	  //System.out.println(evenNumbers);
    	  List<Integer>listOfCourseLength=listOfCourseLength(courses);
    	  System.out.println(listOfCourseLength);
      }

    private static List<Integer> listOfCourseLength(List<String> courses) {
		// TODO Auto-generated method stub
    	return courses.stream()
    	.map(str -> str.length()) //Stream<R> 
    	.collect(Collectors.toList());
	}

	private static List<Integer> evenNumbers(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	
    	return numbers.stream()
    	.filter(x -> x%2==0)
    	.collect(Collectors.toList());
		
	}

	private static List<Integer> squareList(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	return numbers.stream()
    	.map(x -> x*x)   //Stream<R>
    	.collect(Collectors.toList()); //R like map ,list ,set convert stream to list
	}

	private static int sum(int aggregate ,int nextNumber) {
    	System.out.println(aggregate+ " "+nextNumber);
    	return aggregate+nextNumber;
    }
	private static int addListFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
		
		return numbers.stream()
		//.reduce(0, FP02Functional :: sum);  //1 st approach
		//  .reduce(0,(x,y) -> x + y);   // 2nd approach
	      .reduce(0,Integer :: sum);     //3rd Approach  //return perform result of reduction
		//stream of number -> one result value
		//combine them into one result -- One value
		// 0 and FP02Functional:: sum --(a,b) -> a+b
		
	}

	
}
