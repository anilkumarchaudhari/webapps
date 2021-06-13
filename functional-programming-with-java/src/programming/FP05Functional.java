package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP05Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring", "Spring Boot","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");
		List<String> courses2 = List.of("Spring", "Spring Boot","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");
		System.out.println(courses.stream().collect(Collectors.joining(" ")));
		System.out.println(courses.stream().collect(Collectors.joining(",")));
		System.out.println(courses.stream().map(course -> course.split(" ")).collect(Collectors.toList()));
		
		//flatMap -- ["A","W","S"] --> "A","W","S"
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
		
		System.out.println(
			  courses.stream().flatMap(course -> courses2.stream().map(course2 ->List.of(course,course2)))
			  .collect(Collectors.toList()));
		
		//get elements where element in list 1 equals to list2
		System.out.println(
				  courses.stream().flatMap(course -> courses2.stream().map(course2 ->List.of(course,course2)))
				  .filter(list -> list.get(0).equals(list.get(1)))
				  .collect(Collectors.toList()));
		//same elements shd not come
		System.out.println(
				  courses.stream().flatMap(course -> courses2.stream().map(course2 ->List.of(course,course2)))
				  .filter(list -> !list.get(0).equals(list.get(1)))
				  .collect(Collectors.toList()));
		
		//same elements shd not come
				System.out.println(
						  courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length()== course.length()).map(course2 ->List.of(course,course2)))
						  .filter(list -> !list.get(0).equals(list.get(1)))
						  .collect(Collectors.toList()));
		
		
		
	}

}
