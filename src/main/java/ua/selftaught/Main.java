package ua.selftaught;

import java.util.HashMap;
import java.util.Map;

import ua.selftaught.model.Calculator;

public class Main {

	private static final Map<Triple<Integer, Integer, Operation>, Integer> RESULTS = new HashMap<>();
	
	static {
		RESULTS.put(new Triple<Integer, Integer, Operation>(2, 2, Operation.Add), 4);
		RESULTS.put(new Triple<Integer, Integer, Operation>(12, 6, Operation.Divide), 2);
		RESULTS.put(new Triple<Integer, Integer, Operation>(12, 3, Operation.Multiply), 36);
		RESULTS.put(new Triple<Integer, Integer, Operation>(12, 8, Operation.Subtract), 4);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		RESULTS.entrySet().stream()
			.forEach(e -> {
				int operand1 = e.getKey().getFirst();
				int operand2 = e.getKey().getSecond();
				int result = e.getValue();
				
				Operation op = e.getKey().getThird();
				
				int calculated = Integer.MIN_VALUE;
				
				switch (op) {
				case Add:
					calculated = calc.getCalculatorSoap().add(operand1, operand2);
					println(operand1, operand2, Operation.Add, result, calculated);
					break;
				case Subtract:
					calculated = calc.getCalculatorSoap().subtract(operand1, operand2);
					println(operand1, operand2, Operation.Subtract, result, calculated);
					break;
				case Multiply:
					calculated = calc.getCalculatorSoap().multiply(operand1, operand2);
					println(operand1, operand2, Operation.Multiply, result, calculated);
					break;
				case Divide:
					calculated = calc.getCalculatorSoap().divide(operand1, operand2);
					println(operand1, operand2, Operation.Divide, result, calculated);
					break;
				default:
					break;
				}
			});
	}	
	private static void println(int first, int second, Operation op, int result, int calculated) {
		System.out.println(String.format("(%d, %d, %s, expected = %d), calculated = %d", first, second, op, result, calculated));
	}
	
}

enum Operation {
	Add,
	Divide,
	Multiply,
	Subtract;
	
}

class Triple<T1, T2, T3> {
	
	private T1 first;
	private T2 second;
	private T3 third;
	
	public Triple(T1 first, T2 second, T3 third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}


	public T1 getFirst() {
		return first;
	}


	public T2 getSecond() {
		return second;
	}
	
	public T3 getThird() {
		return third;
	}
}
