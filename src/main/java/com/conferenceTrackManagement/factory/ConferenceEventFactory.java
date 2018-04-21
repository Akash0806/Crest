package com.conferenceTrackManagement.factory;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.*;
import com.conferenceTrackManagement.constant.DurationUnit;

public class ConferenceEventFactory {

	public static ConferenceEvent createEventObject(String eventType) {
		if (LUNCH_SLOT_NAME.equals(eventType)) {
			return new LunchEvent(LUNCH_SLOT_DURATION, LUNCH_SLOT_START_TIME, DurationUnit.MINUTES);
		} else if (NETWORKING_EVENT_NAME.equals(eventType)) {
			return new NetworkEvent(NETWORKING_EVENT_DURATION, NETWORKING_EVENT_MIN_START_TIME, DurationUnit.MINUTES);
		}
		return null;
	}

}
