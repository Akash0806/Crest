package com.conferenceTrackManagement.factory;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.*;;

public class ConferenceSessionFactory {

	public static ConferenceSession createSessionObject(String sessionType) {

		if (MORNING.equals(sessionType)) {
			return new MorningSession(MORNING_SLOT_DURATION, MORNING_SLOT_START_TIME);

		} else if (AFTERNOON.equals(sessionType)) {
			return new AfternoonSession(AFTERNOON_SLOT_DURATION, AFTERNOON_SLOT_START_TIME);
		}
		return null;
	}
}
