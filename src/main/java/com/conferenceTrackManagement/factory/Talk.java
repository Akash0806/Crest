package com.conferenceTrackManagement.factory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.conferenceTrackManagement.constant.DurationUnit;
import com.conferenceTrackManagement.util.ConferenceTrackManagementUtil;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.*;

public class Talk implements Comparable<Talk> {

	private String subject;
	private Integer talkDuration;
	private String slotTime;
	private DurationUnit unit;

	Duration SHORT_TALK_DURATION = Duration.ofMinutes(5L);

	public Talk(String subject, int talkLength, DurationUnit unit) {
		super();
		this.subject = subject;
		this.talkDuration = talkLength;
		this.unit = unit;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTalkDuration() {
		return talkDuration;
	}

	public void setTalkDuration(int talkLength) {
		this.talkDuration = talkLength;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	@Override
	public int compareTo(Talk talk) {
		// TODO Auto-generated method stub
		return this.talkDuration.compareTo(talk.talkDuration);
	}

	public int getDurationInMinutes() {
		return unit.inMinutes(talkDuration);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(slotTime).append(DELIMETER).append(subject).append(DELIMETER).append(talkDuration).append(unit)
				.append(LINE_BREAK);
		return builder.toString();

	}
//Create through the Factory
	public static List<Talk> createTalks(List<String> inputStringList) {
		List<Talk> talks = new ArrayList<Talk>();
	    Pattern pattern = ConferenceTrackManagementUtil.getPattern(Regex);
		for (String inputLine : inputStringList) {
			Matcher match = pattern.matcher(inputLine);
			if (match.find()) {
				DurationUnit unit=DurationUnit.MINUTES;
				String durationInString = "";
				String name = match.group(EVENT_NAME_INDEX);
				if (match.group(EVENT_DURATION_UNIT_INDEX).equalsIgnoreCase("min")) {
					durationInString = match.group(EVENT_DURATION_INDEX);
				} else {
					durationInString = String.valueOf(DurationUnit.LIGHTENING.getFactor());
				}

				int duration = Integer.parseInt(durationInString);
				// totalDuration = +duration;
				Talk talk = new Talk(name, duration, unit);
				talks.add(talk);
			}
		}
		Collections.sort(talks);
		return talks;
	}
}
