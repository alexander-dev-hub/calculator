package edu.csc413.calculator.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csc413.calculator.evaluator.Operand;
import edu.csc413.calculator.operators.SubtractOperator;

/**
 * 
 * @author Alexander
 *
 */
public class SubtractOperatorTest {

	@Test
    public void subtractionTest01(){
        Operand op1 =  new Operand(6);
        Operand op2 =  new Operand(11);
        SubtractOperator so =  new SubtractOperator();
        Operand res = new Operand(so.execute(op1,op2).getValue());
        assertEquals("-5.0", String.valueOf(res.getValue()));
    }

    @Test
    public void subtractionTest02(){
        Operand op1 =  new Operand(11);
        Operand op2 =  new Operand(6);
        SubtractOperator so =  new SubtractOperator();
        Operand res = new Operand(so.execute(op1,op2).getValue());
        assertEquals("5.0", String.valueOf(res.getValue()));
    }

    @Test
    public void subtractionTest03(){
        Operand op1 =  new Operand(-11);
        Operand op2 =  new Operand(6);
        SubtractOperator so =  new SubtractOperator();
        Operand res = new Operand(so.execute(op1,op2).getValue());
        assertEquals("-17.0", String.valueOf(res.getValue()));
    }

    @Test
    public void subtractionTest04(){
        Operand op1 =  new Operand(11);
        Operand op2 =  new Operand(-6);
        SubtractOperator so =  new SubtractOperator();
        Operand res = new Operand(so.execute(op1,op2).getValue());
        assertEquals("17.0", String.valueOf(res.getValue()));
    }

    @Test
    public void subtractionPriorityTest(){
        assertEquals(1, (new SubtractOperator().priority()));
    }
}
