package programming;

import java.util.Comparator;
import java.util.List;

public class FP02Exercise {
      public static void main (String args[]) {
    	  List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
  		List<String> courses = List.of("Spring", "Spring Boot ","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");

		//printAllNumbersInListStructured(numbers);
    	 // int sum =addListFunctional(numbers);
    	 // System.out.println(sum);
    	  
    	// int sum =findSumOfSquareOfNumbers(numbers);
    	 // System.out.println(sum);
    	 // int sumofCube=findSumOfCubeOfNumbers(numbers);
    	 // System.out.println(sumofCube);
    	 // int sumOfOdd=findSumOfOddNumbers(numbers);
    	 // System.out.println(sumOfOdd);
    	 // printDistinctNumbersInList(numbers);
    	  //printSortedList(numbers);
    	 // printSortedListofCourses(courses);
    	 // printSortedListofCoursesInReverse(courses);
    	  //printSortedListofCourseswithLength(courses);
  		
    	  

      }

    private static void printSortedListofCourseswithLength(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

	private static void printSortedListofCoursesInReverse(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		//.sorted(Comparator.naturalOrder()) //natural sorting
		.sorted(Comparator.reverseOrder())//reverse order
		.forEach(System.out::println);
	}

	private static void printSortedListofCourses(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.sorted().forEach(System.out::println);
	}

	private static void printSortedList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		numbers.stream().distinct()  //Stream<T>
		.sorted()   //Stream<T>
		.forEach(System.out::println);
	}

	private static void printDistinctNumbersInList(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	
    	numbers.stream()
    	.distinct()
    	.forEach(System.out::println);  //Void
		
		
	}

	private static int findSumOfOddNumbers(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	return numbers.stream()
    	.filter(number -> number%2 !=0) //only find odd numbers
    	.reduce(0,Integer:: sum); //calc sum of add no's
		
	}

	private static int findSumOfCubeOfNumbers(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream()
				.map(x -> x * x * x)
				.reduce(0,Integer :: sum);
	}

	private static int findSumOfSquareOfNumbers(List<Integer> numbers) {
		// TODO Auto-generated method stub
    	return numbers.stream()
    	.map(x -> x * x)  //map first no to square of no's
    	.reduce(0, Integer :: sum); //calc sum of squares
		
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
	      .reduce(0,Integer :: sum);     //3rd Approach
		//stream of number -> one result value
		//combine them into one result -- One value
		// 0 and FP02Functional:: sum --(a,b) -> a+b
		
	}

	
}
