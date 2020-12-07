package br.com.ribeiro.calculator.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.ribeiro.calculator.model.Memory;
import br.com.ribeiro.calculator.model.ObservableMemory;

public class Display extends JPanel implements ObservableMemory {

	private static final long serialVersionUID = 2L;

	private JLabel label;
	
	public Display() {
		Memory.getInstance().addObserver(this);
		
		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memory.getInstance().getText());
		label.setForeground(Color.WHITE);
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		add(label);
	}

	@Override
	public void changingValue(String value) {
		label.setText(value);
		
	}
}
