package edu.csc413.calculator.operators;


import edu.csc413.calculator.evaluator.Operand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperandTest {

	@Test
    public void getValueTest(){
        Operand op = new Operand(6);
        assertEquals("6.0", String.valueOf(op.getValue()));
    }

    @Test
    public void getValueTypeTest(){
        Operand op = new Operand(6);

        equals(isDouble(op.getValue()));
    }

    @Test
    public void checkValue01Test(){
        assertTrue(Operand.check("13"));
    }

    @Test
    public void checkValue02Test(){
        assertTrue(Operand.check("19"));
    }

    @Test
    public void checkValue03Test(){
        assertTrue(Operand.check("465465"));
    }

    @Test
    public void checkValue04Test(){
        assertFalse(Operand.check("c"));
    }

    @Test
    public void checkValue05Test(){
    	assertTrue(Operand.check("3.0"));

    }

    @Test
    public void checkValue06Test(){
    	assertTrue(Operand.check("3."));

    }

    @Test
    public void checkValue07Test(){
        assertFalse(Operand.check("343324fd"));
    }

    private boolean isDouble(Object o){
        return o instanceof Double;
    }
}
