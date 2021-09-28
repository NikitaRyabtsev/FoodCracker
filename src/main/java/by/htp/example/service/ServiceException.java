package by.htp.example.service;

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Exception e,String message) {
		super(message,e);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}
	
}
