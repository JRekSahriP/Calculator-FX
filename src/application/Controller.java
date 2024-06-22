package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	  public Controller(){}
	
	@FXML
	private TextField display = new TextField("");
	
	private double memory=0;
	private char operator;
	private boolean pointUsed = false;
	
	@FXML
	private void clean() { //reset the calculator
		display.clear();
		memory = 0;
		operator = ' ';
		pointUsed = false;
	}
	
	@FXML
	private void compute() { // Ends the current calculation
		storeMemory();
		display.setText(memory+"");
		
		memory = 0;
		operator = ' ';
	}
	

	@FXML
	private void pressed(ActionEvent e){
		String character = ((Button)e.getSource()).getText();
		
		switch(type(character)) {
			case "numbers":{
				addNumber(character);
			}break;
			
			case "operators":{
				addOperator(character);
			}break;
			
			case "point": {
				addPoint();
			}break;
		}

	}
	
	private void addNumber(String number) {
		if(type(display.getText()+"").equals("operators")) {display.clear(); pointUsed = false;} //clearing if the last character was an operator
		display.setText(display.getText()+number); //display += character
	}
	
	private void addOperator(String operator) {
		storeMemory(); 
		this.operator = operator.charAt(0); //stores the selected operator
		display.setText(operator); //display = character
	}
	
	private void addPoint(){
		if(!pointUsed) {
			if(type(display.getText()+"").equals("operators")) {display.clear();} //clearing if the last character was an operator
			if(display.getText().length()==0) {display.setText(0+"");}
			display.setText(display.getText()+"."); //display += character
			pointUsed = true;
		}
	}
	
	
	private void storeMemory() {
		switch(operator) {
			default:
			case '+':{memory+=displayValue();}break;
			case '-':{memory-=displayValue();}break;
			case '*':{memory*=displayValue();}break;
			case '/':{memory/=displayValue();}break;
		}
	}
	
	
	private double displayValue() {
		return Double.parseDouble(display.getText());
	}
	
	private String type(String item) {
		
		if(item.matches("[0-9]"   )) { return "numbers"	  ;} // 1,2,3...8,9
		if(item.matches("[/*+\\-]")) { return "operators" ;} // +,-,*,/
		return "point"; // .
			
	}

}


