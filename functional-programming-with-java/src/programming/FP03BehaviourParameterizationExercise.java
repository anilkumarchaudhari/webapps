package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterizationExercise {

	public static void main (String args[]) {

		List<Integer> numbers=List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//Function<Integer, Integer> squareFunction = x -> x*x;
		List<Integer>  squarenos=mapAndCreateNewList(numbers, x -> x*x);
		System.out.println(squarenos);
		List<Integer>  cubenos=mapAndCreateNewList(numbers, x -> x*x*x);
		System.out.println(cubenos);
		Function<Integer, Integer> doubleFunction = x -> x+x;
		List<Integer> doublenos=mapAndCreateNewList(numbers, doubleFunction);
		System.out.println(doublenos);
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
		return numbers.stream()
		.map(function)
		.collect(Collectors.toList());
	}
	

}
