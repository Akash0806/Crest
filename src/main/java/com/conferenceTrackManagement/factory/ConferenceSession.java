package com.conferenceTrackManagement.factory;

import java.util.Iterator;
import java.util.List;

import com.conferenceTrackManagement.util.Time;

public abstract class ConferenceSession {
	protected int duration;
	protected int startTime;
	protected int remainTime;

	public ConferenceSession(int duration, int startTime) {
		super();
		this.duration = duration;
		this.startTime = startTime;

	}

	public abstract void addTalk(Talk talk);

	public abstract List<Talk> getTalks();

	public void addConferenceSession(Talk talk) {
	
		addTalk(talk);
		String minutesToDisplayTime = Time.minutesToDisplayTime(startTime);
		talk.setSlotTime(minutesToDisplayTime);
		startTime += talk.getTalkDuration();
		duration -= talk.getTalkDuration();
		remainTime = duration;
	}

	public int asignTalksToSession(List<Talk> talks) {
		for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext();) {
			Talk talk2 = (Talk) iterator.next();
			int talkDuration = talk2.getTalkDuration();
			if (duration < talkDuration) {
				return duration;
			}
			addConferenceSession(talk2);
			iterator.remove();
		}
		return duration;
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

	@Override
	public String toString() {
	
		StringBuilder builder = new StringBuilder();
		String conferenceString = "";
		List<Talk> talks = getTalks();
		if (talks != null && talks.size() > 0) {
			for (Talk talk : talks) {
				builder.append(talk.toString());
				conferenceString = builder.toString();
			}
		}
		return conferenceString;
	}

}
