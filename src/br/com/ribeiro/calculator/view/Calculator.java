package br.com.ribeiro.calculator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Calculator extends JFrame{

	private static final long serialVersionUID = 1L;

	public Calculator() {
		
		startLayout();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(232, 322);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	private void startLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233, 60));
		add(display, BorderLayout.NORTH);
		Keyboard keyboard = new Keyboard();
		add(keyboard, BorderLayout.CENTER);
		
	}
}
