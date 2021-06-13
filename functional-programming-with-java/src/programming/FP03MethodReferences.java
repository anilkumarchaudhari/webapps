package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

	public static void print(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring", "Spring Boot ","API", "Microservices", "Azure", "AWS", "Docker", "Kubernetes");
	
        courses.stream()
        //.map( str -> str.toUpperCase()) //1st
        .map(String :: toUpperCase) //2nd approach
        .forEach(FP03MethodReferences::print);
        
       // Supplier<String> supplier = () -> new String();
        Supplier<String> supplier = String :: new;
	}

}
