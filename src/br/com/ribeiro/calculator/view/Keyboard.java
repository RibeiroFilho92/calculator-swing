package br.com.ribeiro.calculator.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.ribeiro.calculator.model.Memory;

public class Keyboard extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3L;

	private Color C_GRAY_STRONG = new Color(68, 68, 68);
	private Color C_GRAY = new Color(99, 99, 99);
	private Color C_ORANGE = new Color(242, 163, 60);
	
	public Keyboard() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
			
		setLayout(layout);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		
		constraints.gridwidth = 2;
		addButton("AC", C_GRAY_STRONG, constraints, 0, 0);
		constraints.gridwidth = 1;
		addButton("+/-", C_GRAY_STRONG, constraints, 2, 0);
		addButton("/", C_ORANGE, constraints, 3, 0);
		
		addButton("7", C_GRAY, constraints, 0, 1);
		addButton("8", C_GRAY, constraints, 1, 1);
		addButton("9", C_GRAY, constraints, 2, 1);
		addButton("*", C_ORANGE, constraints, 3, 1);
		
		addButton("4", C_GRAY, constraints, 0, 2);
		addButton("5", C_GRAY, constraints, 1, 2);
		addButton("6", C_GRAY, constraints, 2, 2);
		addButton("-", C_ORANGE, constraints, 3, 2);
		
		addButton("1", C_GRAY, constraints, 0, 3);
		addButton("2", C_GRAY, constraints, 1, 3);
		addButton("3", C_GRAY, constraints, 2, 3);
		addButton("+", C_ORANGE, constraints, 3, 3);
		
		constraints.gridwidth = 2;
		addButton("0", C_GRAY, constraints, 0, 4);
		constraints.gridwidth = 1;
		addButton(",", C_GRAY, constraints, 2, 4);
		addButton("=", C_ORANGE, constraints, 3, 4);
	}

	private void addButton(String text, Color color, GridBagConstraints constraint, int x, int y) {
		constraint.gridx = x;
		constraint.gridy = y;
		Button button = new Button(text, color);
		button.addActionListener(this);
		add(button, constraint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			Memory.getInstance().operation(button.getText());
		}
		
	}
}
