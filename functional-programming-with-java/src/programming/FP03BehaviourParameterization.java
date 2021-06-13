package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {


	public boolean isEven(int num) {
		return num%2 ==0;
	}
	public int squared(int num) {
		return num* num;
	}
	public static void main (String args[]) {

		List<Integer> numbers=List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //x -> x%2==0 passing behaviour to the methd as argument
		findAndPrint(numbers, x -> x%2==0);
		findAndPrint(numbers, x -> x%2!=0);
		findAndPrint(numbers, x -> x%3==0);
	}
	private static void findAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out:: println);
	}

}
