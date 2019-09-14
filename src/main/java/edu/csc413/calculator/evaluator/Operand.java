package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
	
	String token;
    /**
     * construct operand from string token.
     */
    public Operand(String token) {
    	this.token = token;
    }

    /**
     * construct operand from integer
     */
//    public Operand(int value) {
//    	this.token = String.valueOf(value);
//    }
    
    /**
     * construct operand from double
     */
    public Operand(double value) {
    	this.token = String.valueOf(value);
    }

    /**
     * return int value of operand
     */
//    public int getValue() {
//        return Integer.parseInt(token);
//    }
    
    /**
     * return value of operand
     */
    public double getValue() {
        return Double.parseDouble(token);
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
    	try {
			Double.parseDouble(token);
			return true;
		} catch(Exception e) {
			return false;
		}
    }
}
