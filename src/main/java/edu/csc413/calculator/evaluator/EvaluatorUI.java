package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Alexander
 *
 */
public class EvaluatorUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6884244063721926338L;
	private TextField txField = new TextField();
	private Panel buttonPanel = new Panel();

	private String output = "";
	static boolean initFlag = false;

	// total of 20 buttons on the calculator,
	// numbered from left to right, top to bottom
	// bText[] array contains the text for corresponding buttons
	private static final String[] bText = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "^", "=",
			"/", "(", ")", "C", "CE" };

	/**
	 * C is for clear, clears entire expression CE is for clear expression (or
	 * entry), clears last entry up until the last operator.
	 */
	private Button[] buttons = new Button[bText.length];

	public static void main(String argv[]) {
		EvaluatorUI calc = new EvaluatorUI();
	}

	public EvaluatorUI() {
		setLayout(new BorderLayout());
		this.txField.setPreferredSize(new Dimension(600, 50));
		this.txField.setFont(new Font("Courier", Font.BOLD, 28));

		add(txField, BorderLayout.NORTH);
		txField.setEditable(false);

		add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(5, 4));

		// create 20 buttons with corresponding text in bText[] array
		Button bt;
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			bt = new Button(bText[i]);
			bt.setFont(new Font("Courier", Font.BOLD, 28));
			buttons[i] = bt;
		}

		// add buttons to button panel
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			buttonPanel.add(buttons[i]);
		}

		// set up buttons to listen for mouse input
		for (int i = 0; i < EvaluatorUI.bText.length; i++) {
			buttons[i].addActionListener(this);
		}

		setTitle("Calculator");
		setSize(400, 400);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * This function is triggered anytime a button is pressed on our Calculator
	 * GUI.
	 * 
	 * @param eventObject
	 *            Event object generated when a button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {

		Evaluator ev = new Evaluator();

		if (e.getActionCommand() == "1" || e.getActionCommand() == "2" || e.getActionCommand() == "3"
				|| e.getActionCommand() == "4" || e.getActionCommand() == "5" || e.getActionCommand() == "6"
				|| e.getActionCommand() == "7" || e.getActionCommand() == "8" || e.getActionCommand() == "9"
				|| e.getActionCommand() == "0" || e.getActionCommand() == "00" || e.getActionCommand() == ".") {
			output += e.getActionCommand();
			this.txField.setText(output);
		}

		if (e.getActionCommand() == "+" || e.getActionCommand() == "-" || e.getActionCommand() == "*"
				|| e.getActionCommand() == "/" || e.getActionCommand() == "^") {
			output += e.getActionCommand();
			this.txField.setText(output);
			initFlag = true;
		}

		if (initFlag && e.getActionCommand() == "=") {
			double d_result = ev.eval(this.txField.getText());
			String result = "";
			if (d_result % 1 == 0)
				result = String.valueOf((int) d_result);
			else
				result = String.valueOf(d_result);
			this.txField.setText(result);
			initFlag = false;
		}

		if (e.getActionCommand() == "C") {
			output = "";
			this.txField.setText(output);
			initFlag = false;
		}

	}
}
