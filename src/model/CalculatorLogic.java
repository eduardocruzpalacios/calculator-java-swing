package model;

public class CalculatorLogic {

	private String operand;
	private String operator;
	private double computation;

	public CalculatorLogic() {
		reset();
	}

	public void reset() {
		this.operand = "";
		this.operator = null;
		this.computation = 0;
	}

	public String getCurrentOperand() {
		return this.operand;
	}

	public double getComputation() {
		return this.computation;
	}

	public void assignOperand(String operand) {
		if (this.computation == 0 || operand.equals("")) {
			this.operand = operand;
		} else {
			this.operand += operand;
		}
		if (this.operator == null) {
			this.computation = Double.parseDouble(this.operand);
		}
	}

	public void setOperator(String operator) {
		if (this.operand.equals("") && this.computation == 0) {
			return;
		}
		if (this.operator != null) {
			this.compute();
		}
		this.operator = operator;
		this.operand = "";
	}

	public void compute() {
		if (this.operand.equals(" ")) {
			return;
		}
		switch (this.operator) {
		case "+":
			this.computation += Double.parseDouble(this.operand);
			break;
		case "-":
			this.computation -= Double.parseDouble(this.operand);
			break;
		case "*":
			this.computation *= Double.parseDouble(this.operand);
			break;
		case "/":
			this.computation /= Double.parseDouble(this.operand);
			break;
		default:
			return;
		}
		this.operand = "";
		this.operator = null;
	}

	public boolean isEven() {
		return Double.parseDouble(this.operand) % 2 == 0;
	}

	public boolean isIndetermination() {
		return this.computation != 0 && this.operand.equals("0");
	}

}
