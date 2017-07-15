package br.com.rest.exceptions;

public class RestDataBaseRunTimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9055450976900323020L;
	
    /**
     * 
     */
    public RestDataBaseRunTimeException() {
        super();
    }
    
    /**
     * @param s
     */
    public RestDataBaseRunTimeException(String s) {
        super(s);
    }
    
    /**
     * @param s
     * @param throwable
     */
    public RestDataBaseRunTimeException(String s, Throwable throwable) {
        super(s, throwable);
    }
    
    /**
     * @param throwable
     */
    public RestDataBaseRunTimeException(Throwable throwable) {
        super(throwable);
    }
}
