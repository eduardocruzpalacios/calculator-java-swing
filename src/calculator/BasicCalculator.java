package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;

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

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
