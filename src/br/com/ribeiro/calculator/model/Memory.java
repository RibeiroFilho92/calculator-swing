package br.com.ribeiro.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private enum CommandType {
		ZERO, NUMBER, DIVI, MULT, SUBT, SUM, EQUAL, COMMA, CHANG;
	}

	private static Memory instance = new Memory();
	private String text = "";
	private String textBuffer = "";
	private boolean needToChange = false;
	private CommandType lastOperation = null;
	private List<ObservableMemory> observers = new ArrayList<>();
	
	private Memory() {}

	public static Memory getInstance() {
		return instance;
	}

	public String getText() {
		return text.isEmpty() ? "0" : text; 
	}
	
	public void addObserver(ObservableMemory observer) {
		observers.add(observer);
	}
	
	public void operation(String operation) {
		CommandType command = getCommand(operation);
		
		if (command == null) {
			return;
		} else if (command == CommandType.ZERO) {
			text = "";
			textBuffer = "";
			needToChange = false;
			lastOperation = null;
		} else if (command == CommandType.CHANG && text.contains("-")) {
			text = text.substring(1);
		} else if (command == CommandType.CHANG && !text.contains("-")) {
			text = "-" + text;
		} else if (command == CommandType.NUMBER || command == CommandType.COMMA) {
			text = needToChange ? operation : text + operation;
			needToChange = false;
		} else {
			needToChange = true;
			text = resultOfOperation();
			textBuffer = text;
			lastOperation = command;
		}
		
		observers.forEach(o -> o.changingValue(getText()));
	}

	private String resultOfOperation() {
		if (lastOperation == null || lastOperation == CommandType.EQUAL) {
			return text;
		}
		
		double numberBuffer = Double.parseDouble(textBuffer.replace(",", "."));
		double holdingNumbers = Double.parseDouble(text.replace(",", "."));
		double result = 0.0;
		
		System.out.println(numberBuffer);
		System.out.println(holdingNumbers);
		
		if (lastOperation == CommandType.SUM) {
			result = numberBuffer + holdingNumbers;
		} else if (lastOperation == CommandType.SUBT) {
			result = numberBuffer - holdingNumbers;
		} else if (lastOperation == CommandType.MULT) {
			result = numberBuffer * holdingNumbers;
		} else if (lastOperation == CommandType.DIVI) {
			result = numberBuffer / holdingNumbers;
		} 
		
		String resultToString = Double.toString(result).replace(".", ",");
		boolean takingOffTheComma = resultToString.endsWith(",0");
		System.out.println(resultToString);
		System.out.println(takingOffTheComma);
		System.out.println(result);
		return takingOffTheComma ? resultToString.replace(",0", "") : resultToString;
	}

	private CommandType getCommand(String operation) {
		if (text.isEmpty() && operation == "0") {
			return null;
		}
		try {
			Integer.parseInt(operation);
			return CommandType.NUMBER;
		} catch (NumberFormatException e) {
			if ("AC".equals(operation)) {
				return CommandType.ZERO;
			} else if ("/".equals(operation)) {
				return CommandType.DIVI;
			} else if ("*".equals(operation)) {
				return CommandType.MULT;
			} else if ("+".equals(operation)) {
				return CommandType.SUM;
			} else if ("-".equals(operation)) {
				return CommandType.SUBT;
			} else if ("=".equals(operation)) {
				return CommandType.EQUAL;
			} else if ("+/-".equals(operation)) {
				return CommandType.CHANG;
			} else if (",".equals(operation) && !text.contains(",")) {
				return CommandType.COMMA;
			}
		}
		return null;
	}
}
