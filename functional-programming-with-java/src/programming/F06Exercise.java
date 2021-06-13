package programming;

import java.util.List;
import java.util.stream.Collectors;

public class F06Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring", "Spring Boot","API", "Microservices", "Azure", "AWS", "Docker", "Kuberneteses");

		System.out.println(
				courses.stream()
				.filter(course -> course.length() > 11)
				.map(String :: toUpperCase)
				.collect(Collectors.toList())
				);
		System.out.println(
				courses.stream()
				.peek(System.out::println)
				.filter(course -> course.length() > 11)
				.map(String :: toUpperCase)
				.peek(System.out::println)
				.findFirst()
				
				);
	}

}
