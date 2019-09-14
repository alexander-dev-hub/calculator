package edu.csc413.calculator.operators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Alexander
 *
 */
public class OperatorTester {

	@Test
    public void check01Test(){
        assertTrue(Operator.check("+"));
        
    }

    @Test
    public void check02Test(){
        assertTrue(Operator.check("*"));
    }

    @Test
    public void check03Test(){
        assertTrue(Operator.check("^"));
        
    }

    @Test
    public void check04Test(){
        assertTrue(Operator.check("-"));
    }

    @Test
    public void check05Test(){
        assertTrue(Operator.check("/"));
        
    }

    @Test
    public void check06Test(){
        assertFalse(Operator.check("156"));
    }

    @Test
    public void check07Test(){
        assertFalse(Operator.check("156.0"));
    }

    @Test
    public void check08Test(){
        assertFalse(Operator.check("x"));
    }

    @Test
    public void Check09Test(){
        assertFalse(Operator.check("**"));
    }
    @Test
    public void getOperator01Test(){
        Operator op = Operator.getOperator("+");
        assertTrue(op instanceof AddOperator);
    }

    @Test
    public void getOperator02Test(){
        Operator op = Operator.getOperator("-");
        assertTrue(op instanceof SubtractOperator);
        
    }

    @Test
    public void getOperator03Test(){
        Operator op = Operator.getOperator("/");
        assertTrue(op instanceof DivideOperator);
        
    }

    @Test
    public void getOperator04Test(){
        Operator op  = Operator.getOperator("*");
        assertTrue(op instanceof MultiplyOperator);
        
    }

    @Test
    public void getOperator05Test(){
        Operator op = Operator.getOperator("^");
        assertTrue(op instanceof PowerOperator);
    }

}
