package br.com.ribeiro.calculator.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton{

	private static final long serialVersionUID = 4L;
	
	public Button(String label, Color color) {
		setText(label);
		setOpaque(true);
		setBackground(color);
		setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
