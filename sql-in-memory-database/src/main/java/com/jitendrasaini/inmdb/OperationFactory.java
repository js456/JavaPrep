package com.jitendrasaini.inmdb;

public class OperationFactory {

	OperationParam operationParam;

	public OperationFactory(OperationParam operationParam) {
		this.operationParam = operationParam;
	}

	public Operation getOperation(Operator operator) {

		Operation operation = null;

		switch (operator) {
		case EQ:
			operation = new EqualOperation();
		default:
			System.out.println("Operation is not supported");
		}
		return operation;
	}

	public Operation getOperation(LogicalOperator operator) {
		Operation operation = null;

		switch (operator) {
		case AND:
			operation = new AndOperation();
		case OR:
			operation = new OrOperation();
		default:
			System.out.println("Operation is not supported");
		}

		return operation;
	}

}
