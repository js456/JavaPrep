package com.jitendrasaini.inmdb;

public class BSTFilterNode {
	
	private String field;
	private Object value;
	
	private BSTFilterNode leftOperand;
	private BSTFilterNode rightOperand;
	
	private Operation operation;

	public String getField() {
		return field;
	}

	public Object getValue() {
		return value;
	}

	public BSTFilterNode getLeftOperand() {
		return leftOperand;
	}

	public BSTFilterNode getRightOperand() {
		return rightOperand;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setLeftOperand(BSTFilterNode leftOperand) {
		this.leftOperand = leftOperand;
	}

	public void setRightOperand(BSTFilterNode rightOperand) {
		this.rightOperand = rightOperand;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	

}
