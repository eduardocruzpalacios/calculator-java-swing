package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BasicCalculator {

	public BasicCalculator() {
	}

	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;

	private JTextField textField;

	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;

	private List<JButton> jButtonsNumbers;

	private JButton btnSum;
	private JButton btnSubtract;
	private JButton btnMultiply;
	private JButton btnDivide;

	private List<JButton> jButtonsOperators;

	private JButton btnCalculate;

	private JButton btnIsEven;

	private JButton btnC;

	private String number1 = "";
	private String number2 = "";
	private boolean operationIsDefined = false;
	private String operator = "";

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		loadView();
		loadLogic();
	}

	private void loadView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setText("");
		textField.setEnabled(false);
		textField.setBounds(49, 30, 391, 70);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btn1 = new JButton("1");
		btn1.setBounds(49, 231, 56, 59);
		frame.getContentPane().add(btn1);

		btn2 = new JButton("2");
		btn2.setBounds(115, 231, 56, 59);
		frame.getContentPane().add(btn2);

		btn3 = new JButton("3");
		btn3.setBounds(181, 231, 56, 59);
		frame.getContentPane().add(btn3);

		btn4 = new JButton("4");
		btn4.setBounds(49, 320, 56, 59);
		frame.getContentPane().add(btn4);

		btn5 = new JButton("5");
		btn5.setBounds(115, 320, 56, 59);
		frame.getContentPane().add(btn5);

		btn6 = new JButton("6");
		btn6.setBounds(181, 320, 56, 59);
		frame.getContentPane().add(btn6);

		btn7 = new JButton("7");
		btn7.setBounds(49, 411, 56, 59);
		frame.getContentPane().add(btn7);

		btn8 = new JButton("8");
		btn8.setBounds(115, 411, 56, 59);
		frame.getContentPane().add(btn8);

		btn9 = new JButton("9");
		btn9.setBounds(181, 411, 56, 59);
		frame.getContentPane().add(btn9);

		btn0 = new JButton("0");
		btn0.setBounds(49, 500, 56, 59);
		frame.getContentPane().add(btn0);

		btnSum = new JButton("+");
		btnSum.setBounds(384, 231, 56, 59);
		frame.getContentPane().add(btnSum);

		btnSubtract = new JButton("-");
		btnSubtract.setBounds(384, 320, 56, 59);
		frame.getContentPane().add(btnSubtract);

		btnMultiply = new JButton("*");
		btnMultiply.setBounds(384, 411, 56, 59);
		frame.getContentPane().add(btnMultiply);

		btnDivide = new JButton("/");
		btnDivide.setBounds(384, 500, 56, 59);
		frame.getContentPane().add(btnDivide);

		btnCalculate = new JButton("=");
		btnCalculate.setBounds(115, 500, 122, 59);
		frame.getContentPane().add(btnCalculate);

		btnIsEven = new JButton("even?");
		btnIsEven.setBounds(115, 141, 89, 59);
		frame.getContentPane().add(btnIsEven);

		btnC = new JButton("C");
		btnC.setBounds(49, 141, 56, 59);
		frame.getContentPane().add(btnC);
	}

	private void loadLogic() {
		setEventToNumberButtons();
		setEventToOperatorsButtons();
		setEventToCbutton();
		setEventToIsEvenButton();
		setEventToCalculateButton();
	}

	private void setEventToNumberButtons() {
		jButtonsNumbers = new ArrayList<JButton>();
		jButtonsNumbers.add(btn0);
		jButtonsNumbers.add(btn1);
		jButtonsNumbers.add(btn2);
		jButtonsNumbers.add(btn3);
		jButtonsNumbers.add(btn4);
		jButtonsNumbers.add(btn5);
		jButtonsNumbers.add(btn6);
		jButtonsNumbers.add(btn7);
		jButtonsNumbers.add(btn8);
		jButtonsNumbers.add(btn9);
		for (int i = 0; i < jButtonsNumbers.size(); i++) {
			setActionListenerToJButtonNumber(jButtonsNumbers.get(i));
		}
	}

	private void setEventToOperatorsButtons() {
		jButtonsOperators = new ArrayList<JButton>();
		jButtonsOperators.add(btnSum);
		jButtonsOperators.add(btnSubtract);
		jButtonsOperators.add(btnMultiply);
		jButtonsOperators.add(btnDivide);
		for (int i = 0; i < jButtonsOperators.size(); i++) {
			setActionListenerToJButtonOperator(jButtonsOperators.get(i));
		}
	}

	private void setEventToCbutton() {
		btnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");

				for (int i = 0; i < jButtonsNumbers.size(); i++) {
					jButtonsNumbers.get(i).setEnabled(true);
				}
				for (int i = 0; i < jButtonsOperators.size(); i++) {
					jButtonsOperators.get(i).setEnabled(true);
				}
				btnCalculate.setEnabled(true);
				btnIsEven.setEnabled(true);

				number1 = "";
				number2 = "";
				operator = "";
				operationIsDefined = false;
			}
		});
	}
	private void setEventToIsEvenButton() {
		btnIsEven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (number1.length() == 0) {
					textField.setText("Hi, no number here!");
				} else {
					float num = Float.parseFloat(number1);
					if (num % 2 == 0) {
						textField.setText("Even");
					} else {
						textField.setText("Odd");
					}
				}

				for (int i = 0; i < jButtonsNumbers.size(); i++) {
					jButtonsNumbers.get(i).setEnabled(false);
				}
				for (int i = 0; i < jButtonsOperators.size(); i++) {
					jButtonsOperators.get(i).setEnabled(false);
				}
				btnCalculate.setEnabled(false);
				btnIsEven.setEnabled(false);
			}
		});
	}

	private void setEventToCalculateButton() {
		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (number1.length() == 0 || number2.length() == 0) {
					textField.setText("error");
					btnIsEven.setEnabled(false);
				} else if (number2.equals("0")) {
					textField.setText("Indetermination");
				} else {
					float num1 = Float.parseFloat(number1);
					float num2 = Float.parseFloat(number2);
					float result = 0f;
					switch (operator) {
					case "+":
						result = num1 + num2;
						break;
					case "-":
						result = num1 - num2;
						break;
					case "*":
						result = num1 * num2;
						break;
					case "/":
						result = num1 / num2;
						break;
					default:
						break;
					}
					textField.setText(String.valueOf(result));
				}

				for (int i = 0; i < jButtonsNumbers.size(); i++) {
					jButtonsNumbers.get(i).setEnabled(false);
					if (i < jButtonsOperators.size()) {
						jButtonsOperators.get(i).setEnabled(false);
					}
				}

				btnCalculate.setEnabled(false);
			}
		});
	}

	private void setActionListenerToJButtonNumber(JButton jButton) {
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!operationIsDefined) {
					number1 += jButton.getText().toString();
					textField.setText(number1);
				} else {
					number2 += jButton.getText().toString();
					textField.setText(number2);
				}
			}
		});
	}

	private void setActionListenerToJButtonOperator(JButton jButton) {
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operator = jButton.getText().toString();

				if (number1.length() == 0) {
					textField.setText("error");
					btn0.setEnabled(false);
					btn1.setEnabled(false);
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn4.setEnabled(false);
					btn5.setEnabled(false);
					btn6.setEnabled(false);
					btn7.setEnabled(false);
					btn8.setEnabled(false);
					btn9.setEnabled(false);
					btnCalculate.setEnabled(false);
				} else {
					textField.setText("");
					operationIsDefined = true;
				}

				btnIsEven.setEnabled(false);
				btnSum.setEnabled(false);
				btnSubtract.setEnabled(false);
				btnMultiply.setEnabled(false);
				btnDivide.setEnabled(false);
			};
		});
	}

}
