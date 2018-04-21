package com.conferenceTrackManagement.factory;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.DELIMETER;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_BREAK;

import com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant;
import com.conferenceTrackManagement.constant.DurationUnit;
import com.conferenceTrackManagement.util.Time;

public class LunchEvent extends ConferenceEvent{
	private String name;
	public LunchEvent(int duration, int startTime, DurationUnit unit) {
		super(duration, startTime, unit);
		this.name = ConferenceTrackManagementCostant.LUNCH_SLOT_NAME;;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getSlotTime()).append(DELIMETER).append(name).append(DELIMETER).append(getDuration()).append(getUnit()).append(LINE_BREAK);
		return builder.toString();

	}

	@Override
	public void modifyEventTime(int remainTime) {
		// TODO Auto-generated method stub
		setSlotTime(Time.minutesToDisplayTime(getStartTime()));
	}

}
