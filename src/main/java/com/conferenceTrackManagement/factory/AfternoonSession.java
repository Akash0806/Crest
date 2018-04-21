package com.conferenceTrackManagement.factory;

import java.util.ArrayList;
import java.util.List;

public class AfternoonSession extends ConferenceSession{
	
	private List<Talk> afternoonTalks;
	
	public AfternoonSession(int durations, int startTime) {
		super(durations, startTime);
	}


	public List<Talk> getAfternoonTalks() {
		if (afternoonTalks == null)
			afternoonTalks = new ArrayList<Talk>();
		return afternoonTalks;
	}

	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void addTalk(Talk talk){
		getAfternoonTalks().add(talk);
		}


	@Override
	public List<Talk> getTalks() {
		// TODO Auto-generated method stub
		return afternoonTalks;
	}

}
