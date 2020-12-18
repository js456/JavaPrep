package com.jitendrasaini.inmdb;


public class Filter {

	private Operator operator;
	
	private LogicalOperator logicalOperator;
	
	private String field;
	
	private Object value;
	
	private Filter leftOperand;
	
	private Filter rightOperand;
	
	public Filter(String field, Operator operator, Object value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
		
	}
	
	public Filter(Filter leftOperand, LogicalOperator logicalOperator, Filter rightOperand) {
		this.leftOperand = leftOperand;
		this.logicalOperator = logicalOperator;
		this.rightOperand = rightOperand;
	}

	public Operator getOperator() {
		return operator;
	}

	public LogicalOperator getLogicalOperator() {
		return logicalOperator;
	}

	public String getField() {
		return field;
	}

	public Object getValue() {
		return value;
	}

	public Filter getLeftOperand() {
		return leftOperand;
	}

	public Filter getRightOperand() {
		return rightOperand;
	}

	
	
}
