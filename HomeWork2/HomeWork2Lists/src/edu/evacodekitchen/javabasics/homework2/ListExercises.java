package edu.evacodekitchen.javabasics.homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListExercises {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(7, 1, 8, 3, -4, 9);
		System.out.println("min: " + findMin(numbers));
		System.out.println("max: " + findMax(numbers));
		System.out.println("odd numbers: " + findOddNumbers(numbers));
		System.out.println("sum of elements: " + sumOfElements(numbers));
	}

	public static int findMin(List<Integer> numbers) {
		return numbers.stream().min(Comparator.comparing(Integer::intValue)).get();
	}

	public static int findMax(List<Integer> numbers) {
		return numbers.stream().max(Comparator.comparing(Integer::intValue)).get();
	}

	public static List<Integer> findOddNumbers(List<Integer> numbers) {
		List<Integer> s = new ArrayList<Integer>();
		for (Integer integer : numbers) {
			if (integer % 2 != 0) {
				s.add(integer);
			}
		}
		return s;
	}

	public static Integer sumOfElements(List<Integer> numbers) {
		return numbers.stream().collect(Collectors.summingInt(Integer::intValue));
	}

}
