package com.pokedex.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceNotAvailable extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ServiceNotAvailable.class);
	
	public ServiceNotAvailable(String errorMessage) {
        super(errorMessage);
    }
	
}
