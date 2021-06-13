package programming;

import java.util.List;

public class FP01Functional {
	public static void main (String args[]) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot ","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");
		//printAllNumbersInListFunctional(numbers);
		//printEvenNumbersInListFunctional(numbers);
		//printOddNumbersInListFunctional(numbers);
		//printAllCourse(courses);
		//printCourseWithSpring(courses);
		//printCourseWithName(courses);
		//printSquareOfEvenNumbers(numbers);
		//printCubeOfOddNumbers(numbers);
		//printLengthOfCourse(courses);
		printEvenNumbersInListFunctional(numbers);
	}

	private static void printLengthOfCourse(List<String> courses) {
		// TODO Auto-generated method stub
		  courses.stream()
		  .map(course -> course +" " +course.length())
		  .forEach(System.out::println);
	}

	private static void printCubeOfOddNumbers(List<Integer> numbers) {
           numbers.stream()
           .filter(number -> number % 2 !=0)
           .map(number -> number * number * number)
           .forEach(System.out::println);
	}

	private static void printSquareOfEvenNumbers(List<Integer> numbers) {
           numbers.stream()
           .filter(number -> number%2 == 0)
           //mapping -x -> x*x
           .map(number -> number * number)
           .forEach(System.out::println);
	}

	private static void printCourseWithName(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.filter(course -> course.length()>=4)
		.forEach(System.out::println);
	}

	private static void printCourseWithSpring(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
		
	}

	private static void printAllCourse(List<String> courses) {
            courses.stream()
            .forEach(System.out::println);
	}

	//public static void print(int number) {
	//	System.out.println(number);
	//}
	
//	private static boolean isEven(int number) {
//		return number%2 == 0;
//	}
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		//numbers.stream().forEach(FP2Functional::print);//method reference approach 1
		numbers.stream().forEach(System.out::println); //approach2

	}
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
		.filter(number -> number%2 ==0) //Lambda Expression is nothing but simplified version of the method
		.forEach(System.out::println);
//		numbers.stream()
//		.filter(FP2Functional::isEven)////allow only even numbers
//		.forEach(System.out::println); 

	}
private static void printOddNumbersInListFunctional(List<Integer> numbers) {
	    numbers.stream()
	    .filter(number -> number%2 ==1) //Lambda expression
	    .forEach(System.out::println);
	}
}
