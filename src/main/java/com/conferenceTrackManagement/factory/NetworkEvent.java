package com.conferenceTrackManagement.factory;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.DELIMETER;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_BREAK;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.NETWORKING_EVENT_DURATION;

import com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant;
import com.conferenceTrackManagement.constant.DurationUnit;
import com.conferenceTrackManagement.util.Time;

public class NetworkEvent extends ConferenceEvent {
	private String name;

	public NetworkEvent(int duration, int startTime, DurationUnit unit) {
		super(duration, startTime, unit);
		this.name = ConferenceTrackManagementCostant.NETWORKING_EVENT_NAME;
	}

	
	public void modifyEventTime(int remainTime) {
		if (remainTime >= 0 && remainTime <= 60 ) {
			int startTime = getStartTime() + (NETWORKING_EVENT_DURATION - remainTime);
			setStartTime(startTime);
		}
		setSlotTime(Time.minutesToDisplayTime(getStartTime()));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getSlotTime()).append(DELIMETER).append(name).append(DELIMETER).append(getDuration())
				.append(getUnit()).append(LINE_BREAK);
		return builder.toString();

	}

}
