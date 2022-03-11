package com.dio_class.devweek.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msgErro) {
		super(msgErro);
	}
	
	public ObjectNotFoundException(String MsgErro, Throwable causa) {
		super(MsgErro, causa);
	}


}
