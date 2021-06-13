package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP09Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
		Files.lines(Paths.get("file.txt"))
		.map(str -> str.split(""))
		.flatMap(Arrays::stream)
		 .forEach(System.out::println);
		
		Files.lines(Paths.get("file.txt"))
		.map(str -> str.split(" "))
		.flatMap(Arrays::stream)
		 .forEach(System.out::println);
		
		Files.lines(Paths.get("file.txt"))
		.map(str -> str.split(" "))
		.flatMap(Arrays::stream)
		.distinct()
		 .forEach(System.out::println);
		
		Files.lines(Paths.get("file.txt"))
		.map(str -> str.split(" "))
		.flatMap(Arrays::stream)
		.distinct()
		.sorted()
		 .forEach(System.out::println);
		
		Files.list(Paths.get("."))
		.filter(Files :: isDirectory)
		.forEach(System.out::println);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
