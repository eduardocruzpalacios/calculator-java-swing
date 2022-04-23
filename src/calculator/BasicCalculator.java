package calculator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	// VIEW
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

	private JButton btnSum;
	private JButton btnSubtract;
	private JButton btnMultiply;
	private JButton btnDivide;

	private JButton btnCalculate;

	private JButton btnIsEven;

	private JButton btnC;

	// LOGIC
	private String number1 = "";
	private String number2 = "";
	private boolean operationIsDefined = false;

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {

		// VIEW

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

		btnIsEven = new JButton("Par");
		btnIsEven.setBounds(115, 141, 89, 59);
		frame.getContentPane().add(btnIsEven);

		btnC = new JButton("C");
		btnC.setBounds(49, 141, 56, 59);
		frame.getContentPane().add(btnC);

		// LOGIC: 0-9 NUMBER BUTTONS

		JButton[] jButtonsNumbers = { btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 };

		for (int i = 0; i < jButtonsNumbers.length; i++) {
			setActionListenerToJButtonNumber(jButtonsNumbers[i]);
		}
	}

	public void setActionListenerToJButtonNumber(JButton jButton) {
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

}
