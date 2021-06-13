package programming;

import java.util.ArrayList;
import java.util.List;

public class FP08Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring", "Spring Boot","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");
		List<String> modifyableCourses=new ArrayList<String>(courses);
		modifyableCourses.replaceAll(course -> course.toUpperCase());
		System.out.println(modifyableCourses);
		System.out.println(modifyableCourses.removeIf(course -> course.length()<6));
		System.out.println(modifyableCourses);

	}

}
