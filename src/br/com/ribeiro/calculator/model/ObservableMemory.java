package br.com.ribeiro.calculator.model;

@FunctionalInterface
public interface ObservableMemory {

	void changingValue(String value);
}
