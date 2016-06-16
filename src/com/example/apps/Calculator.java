package com.example.apps;

import java.util.Observable;

import util.XLException;
import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class Calculator extends Observable implements Environment {
	Expr result;
	ExprParser parser;
	double resultDouble;

	public Calculator() {
		parser = new ExprParser();
	}

	public void calc(String expr) {
		try {
			result = parser.build(expr);
		} catch (Exception e) {
			throw new XLException("Parsing Error");
		}
		resultDouble = result.value(this);
		setChanged();	
		notifyObservers();
	}

	public String getText() {
		return String.valueOf(resultDouble);
	}

	public double value(String s) {
		return 6;
	}

}
