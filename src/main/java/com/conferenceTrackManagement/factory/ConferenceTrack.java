package com.conferenceTrackManagement.factory;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.AFTERNOON;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.EMPTY_STRING;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_BREAK;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LUNCH_SLOT_NAME;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.MORNING;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.NETWORKING_EVENT_NAME;

import java.util.ArrayList;
import java.util.List;

public class ConferenceTrack {

	String trackName;
	List<ConferenceSession> sessions;
	List<ConferenceEvent> events;

	public void createConfereceTrack(List<Talk> talks) {
		int remainTime = getConferenceSession(talks);
		createConferenceEvent(remainTime);
	}

	private void createConferenceEvent(int remainTime) {
		String[] eventArrays = {LUNCH_SLOT_NAME,NETWORKING_EVENT_NAME};
		for (String eventType : eventArrays) {
			ConferenceEvent conferenceEvent = ConferenceEventFactory.createEventObject(eventType);
			conferenceEvent.modifyEventTime(remainTime);
			getEvents().add(conferenceEvent);
		}
	}

	private int getConferenceSession(List<Talk> talks) {
		String[] sessionArrays = {MORNING,AFTERNOON };
		int remainTime = 0;
		for (String sessionType : sessionArrays) {
			ConferenceSession session = ConferenceSessionFactory.createSessionObject(sessionType);
			remainTime = session.asignTalksToSession(talks);
			getSessions().add(session);
		}
		return remainTime;
	}

	public ConferenceTrack(String trackName) {
		this.trackName = trackName;
	}

	public List<ConferenceEvent> getEvents() {
		if (events == null)
			events = new ArrayList<ConferenceEvent>();

		return events;
	}

	public void setEvents(List<ConferenceEvent> events) {
		this.events = events;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public List<ConferenceSession> getSessions() {
		if (sessions == null) {
			sessions = new ArrayList<ConferenceSession>();
		}
		return sessions;
	}

	public void setSessions(List<ConferenceSession> sessions) {
		this.sessions = sessions;
	}

	public void addSession(ConferenceSession conferenceSession) {
		sessions.add(conferenceSession);
	}

	public void addEvent(ConferenceEvent conferenceEvent) {
		events.add(conferenceEvent);
	}

	@Override
	public String toString() {
		String talksToString = EMPTY_STRING;
		StringBuilder builder = new StringBuilder();
		builder.append(trackName).append(LINE_BREAK);
		builder.append(talksToString);
		for (ConferenceSession conferenceSession : sessions) {
			builder.append(conferenceSession.toString());

		}
		for (ConferenceEvent event : events) {
			builder.append(event.toString());

		}
		return builder.toString();
	}

}
