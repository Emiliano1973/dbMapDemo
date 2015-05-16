package it.echi.services.beans;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public final class ErrorMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	private final String message;

	public ErrorMessage(final String code,final String message) {
		super();
		this.code=code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}



	
}
