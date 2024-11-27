package source;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Controller {

	@FXML
	private TextField inputField;
	@FXML
	private Label result;
	
	private void resultInclude() {

		String expression = inputField.getText().toString();
		expression = expression.replace(Operator.SUBTRACTION, '-');
		expression = expression.replace(Operator.MULTIPLICATION, '*');
		expression = expression.replace(Operator.DIVISION, '/');

		String finalResult;
		Expression exp;
		try {
			
			exp = new ExpressionBuilder(expression).build();
		
			if (expression.contains("."))
				finalResult = String.valueOf(exp.evaluate());
			else
				finalResult = String.valueOf((int) exp.evaluate());
			
		} catch (IllegalArgumentException e) {
			
			// remove last operator to validate computation
			expression = expression.substring(0, expression.length() - 1);
		    exp = new ExpressionBuilder(expression).build();
			
			if (expression.contains("."))
				finalResult = String.valueOf(exp.evaluate());
			else
				finalResult = String.valueOf((int)exp.evaluate());
		}
		
		result.setText("= " + finalResult);
	}

	protected void addOutput(int digit) {
		var inputFieldContentIsZero = inputField.getText().equals(String.valueOf(Number.ZERO));

		if (inputFieldContentIsZero && digit != 0) inputField.setText(String.valueOf(digit));
		else if (!inputFieldContentIsZero) inputField.setText(inputField.getText() + digit);
	}

	protected void addOutput(char opr) {

		char previousOperator = inputField.getText().charAt(inputField.getText().length() - 1);

		var lastWrittenIsOperator = switch (previousOperator) {
		case Operator.ADDITION, Operator.SUBTRACTION,
		Operator.MULTIPLICATION, Operator.DIVISION -> true;
		default -> false;
		};

		if (lastWrittenIsOperator) {
			if (opr != previousOperator) {
				StringBuilder finalOutput = new StringBuilder(inputField.getText().toString());
				finalOutput.deleteCharAt(finalOutput.length() - 1);
				finalOutput.append(opr);
				inputField.setText(finalOutput.toString());
			}
		} else inputField.setText(inputField.getText() + opr);
	}


	// equal Button function
	@FXML
	private void resultFunc() {
		var output = result.getText().toString();
		var size = output.length();
		var finalResult = output.equals("") ? String.valueOf(Number.ZERO) : output.substring(2, size);
		
		inputField.setText(finalResult);
		
		try {
			if (result.getText().substring(2, result.getText().length()).equals(String.valueOf(Number.ZERO))) {
				result.setText("");
			}
		} catch (IndexOutOfBoundsException e) {
		}
	}

	// decimal function
	@FXML
	private void decimalFunc() {
		
		String[] operands = inputField.getText().toString().split("[−+×÷]", -1);
		var lastOperand = operands[operands.length - 1];
		
		if (!lastOperand.contains(".")) inputField.setText(inputField.getText() + ".");
	}

	// clear buttons

	@FXML
	private void clearInputFieldContent() {
		inputField.setText(String.valueOf(Number.ZERO));
		result.setText(null);
	}

	@FXML
	private void clearInputFieldLastContent() {
		var contentIsNotZero = !inputField.getText().equals(String.valueOf(Number.ZERO));
		if (contentIsNotZero) {
			
			int contentLength = inputField.getText().length();
			String modifiedContent = inputField.getText().substring(0, contentLength - 1);
			
			if (modifiedContent.equals("")) {
				modifiedContent = String.valueOf(Number.ZERO);
			}
			
			inputField.setText(modifiedContent);

			resultInclude();
			
			
			if (modifiedContent.equals(String.valueOf(Number.ZERO))) {
				result.setText("");
			}
		}
		
	}

	// operators button function

	@FXML
	private void addOperator() {
		addOutput(Operator.ADDITION);
		resultInclude();
	}
	@FXML
	private void subOperator() {
		addOutput(Operator.SUBTRACTION);
		resultInclude();
	}
	@FXML
	private void mulOperator() {
		addOutput(Operator.MULTIPLICATION);
		resultInclude();
	}
	@FXML
	private void divOperator() {
		addOutput(Operator.DIVISION);
		resultInclude();
	}

	// numbers button function

	@FXML
	private void zeroFunc() {
		addOutput(Number.ZERO);
		resultInclude();
	}	
	@FXML
	private void oneFunc() {
		addOutput(Number.ONE);
		resultInclude();
	}	
	@FXML
	private void twoFunc() {
		addOutput(Number.TWO);
		resultInclude();
	}	
	@FXML
	private void threeFunc() {
		addOutput(Number.THREE);
		resultInclude();
	}	
	@FXML
	private void fourFunc() {
		addOutput(Number.FOUR);
		resultInclude();
	}	
	@FXML
	private void fiveFunc() {
		addOutput(Number.FIVE);
		resultInclude();
	}	
	@FXML
	private void sixFunc() {
		addOutput(Number.SIX);
		resultInclude();
	}
	@FXML
	private void sevenFunc() {
		addOutput(Number.SEVEN);
		resultInclude();
	}
	@FXML
	private void eightFunc() {
		addOutput(Number.EIGHT);
		resultInclude();
	}
	@FXML
	private void nineFunc() {
		addOutput(Number.NINE);
		resultInclude();
	}

}
