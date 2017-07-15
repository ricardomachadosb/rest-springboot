package br.com.rest.exceptions;

public class RestBusinessRunTimeException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309192848705952288L;

	/**
     * 
     */
    public RestBusinessRunTimeException() {
        super();
    }
    
    /**
     * @param s
     */
    public RestBusinessRunTimeException(String s) {
        super(s);
    }
    
    /**
     * @param s
     * @param throwable
     */
    public RestBusinessRunTimeException(String s, Throwable throwable) {
        super(s, throwable);
    }
    
    /**
     * @param throwable
     */
    public RestBusinessRunTimeException(Throwable throwable) {
        super(throwable);
    }

}
