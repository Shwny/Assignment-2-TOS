//Giacomo Bulbarelli 1144046
package it.unipd.tos;

import it.unipd.tos.business.exception.TakeAwayBillException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillExceptionTest {

    @Test
    public void testGetMessage(){
        TakeAwayBillException exception = new TakeAwayBillException("Test");
        assertEquals(exception.getMessage(), "Test");
    }
}
