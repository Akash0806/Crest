package com.conferenceTrackManagement.exception;

public class InvalidTalkNameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidTalkNameException(String msg) {
		super(msg);
	}
}
