package com.conferenceTrackManagement.factory;

import com.conferenceTrackManagement.constant.DurationUnit;

public abstract class ConferenceEvent {
     
	private int duration;
	private int startTime;
	private String slotTime;
	private DurationUnit unit;

	
	public ConferenceEvent(int duration, int startTime, DurationUnit unit) {
		super();
		this.duration = duration;
		this.startTime = startTime;
		this.setUnit(unit);
	}

	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}



	public DurationUnit getUnit() {
		return unit;
	}



	public void setUnit(DurationUnit unit) {
		this.unit = unit;
	}
	
	public abstract void modifyEventTime(int remainTime);
	
	
}
