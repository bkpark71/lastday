package com.company.service;

import com.company.domain.Status;

public class StatusService {
	private static StatusService instance;
	private static Status currentStatus;

	private StatusService(){
		currentStatus = Status.MAIN;
	};

	public static StatusService getInstance() {
		if (instance == null) {
			instance = new StatusService();
		}
		return instance;
	}

	public static void setCurrentStatus(Status status) {
		currentStatus = status;
	}

	public static Status getCurrent() {
		return currentStatus;
	}
}
