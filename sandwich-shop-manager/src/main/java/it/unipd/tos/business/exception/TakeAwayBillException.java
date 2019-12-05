//Giacomo Bulbarelli 1144046
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {

    public TakeAwayBillException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
