package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author Alexander
 *
 */
public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/ ";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public double eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                	// an Operand object is created from the token
                    operandStack.push(new Operand(token));
                } else {
                	// If an operator token is scanned
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        throw new RuntimeException("*****invalid token******");
                    }

                    // TODO Operator is abstract - these two lines will need to be fixed:
                    // The Operator class should contain an instance of a HashMap,
                    // and values will be instances of the Operators.  See Operator class
                    // skeleton for an example.
                    Operator newOperator = Operator.getOperator(token);
                    
                    //the operator Stack is not empty, and the
                    //operator’s precedence is greater than the precedence of the Operator at the
                    //top of the Stack
					while (!operatorStack.empty() && operatorStack.peek().priority() >= newOperator.priority()) {
						// note that when we eval the expression 1 - 2 we will
						// push the 1 then the 2 and then do the subtraction operation
						// This means that the first number to be popped is the
						// second operand, not the first operand - see the
						// following code
						Operator oldOpr = operatorStack.pop();
						Operand firstOperand = operandStack.pop();
						Operand secondOperand = operandStack.pop();
						operandStack.push(oldOpr.execute(secondOperand, firstOperand));
					}
					
                    operatorStack.push(newOperator);
                }
            }
        }


        // Control gets here when we've picked up all of the tokens; you must add
        // code to complete the evaluation - consider how the code given here
        // will evaluate the expression 1+2*3
        // When we have no more tokens to scan, the operand stack will contain 1 2
        // and the operator stack will have + * with 2 and * on the top;
        // In order to complete the evaluation we must empty the stacks,
        // that is, we should keep evaluating the operator stack until it is empty;
        // Suggestion: create a method that processes the operator stack until empty.

        //Don't forget to change the return value!
        while (!operatorStack.empty()) {
        	
        	Operator topOperator = operatorStack.pop();
        	Operand firstOperand = operandStack.pop();
        	Operand secondOperand = operandStack.pop();
        	operandStack.push(topOperator.execute(secondOperand, firstOperand));
        }
        return operandStack.pop().getValue();
    }
}
