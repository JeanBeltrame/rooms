package com.scheduling.exception;

import java.io.Serial;

public class NotFoundException extends Exception {
	@Serial
	private static final long serialVersionUID = -9155418751486181663L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}
}
