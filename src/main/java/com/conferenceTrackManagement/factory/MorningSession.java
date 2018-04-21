package com.conferenceTrackManagement.factory;

import java.util.ArrayList;
import java.util.List;

public class MorningSession extends ConferenceSession {

	private List<Talk> morningTalks;
	
	
	public MorningSession(int duration, int startTime) {
		super(duration, startTime);
	}

	
	public List<Talk> getMorningTalks() {
		if (morningTalks == null)
			morningTalks = new ArrayList<Talk>();
		return morningTalks;
	}

	public void setMorningTalks(List<Talk> morningTalks) {
		this.morningTalks = morningTalks;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int remainingDuration) {
		this.duration = remainingDuration;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void addTalk(Talk talk){
	getMorningTalks().add(talk);
	}


	@Override
	public List<Talk> getTalks() {
		// TODO Auto-generated method stub
		return morningTalks;
	}

}
