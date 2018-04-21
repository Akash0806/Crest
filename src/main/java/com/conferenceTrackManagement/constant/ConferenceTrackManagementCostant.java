package com.conferenceTrackManagement.constant;

import java.util.Arrays;
import java.util.Collections;

public interface ConferenceTrackManagementCostant {
	String LIGHTNING = "lightning";
	String MINITES = "min";
	String AFTERNOON = "Afternoon";
	String MORNING = "Morning";
	String LINE_BREAK = "\n";
	String DELIMETER = " : ";
	String EMPTY_STRING = "";
	String LINE_PATTERN = "^(.+)\\s(\\d+)?\\s?((min)|(lightning))$";
	String TRACK = "Track"+DELIMETER ;
	int EVENT_NAME_INDEX = 1;
	int EVENT_DURATION_INDEX = 2;
	int EVENT_DURATION_UNIT_INDEX = 3;
	int MORNING_SLOT_DURATION = 180;
	int LUNCH_SLOT_DURATION = 60;
	int AFTERNOON_SLOT_DURATION = 240;
	int MORNING_SLOT_START_TIME = 9 * 60;
	int LUNCH_SLOT_START_TIME = MORNING_SLOT_START_TIME + MORNING_SLOT_DURATION;
	int AFTERNOON_SLOT_START_TIME = LUNCH_SLOT_START_TIME + LUNCH_SLOT_DURATION;
 	int MAX_EVENT_DURATION = Collections
			.max(Arrays.asList(MORNING_SLOT_DURATION, LUNCH_SLOT_DURATION, AFTERNOON_SLOT_DURATION));
 	String LUNCH_SLOT_NAME = "Lunch";
	String NETWORKING_EVENT_NAME = "Networking Event";
	int NETWORKING_EVENT_DURATION = 60;
	int NETWORKING_EVENT_MIN_START_TIME = (12 * 60) + (4 * 60); // 4 PM.
	String DOT = ".";
	String LINE_NUM = "Line " + DELIMETER;
	String ERROR = "ERROR " + DELIMETER;
	String ERR_INVAILD_DURATION_UNIT = "Invaild Duration unit";
	String ERR_DURATION_MORE_THEN_MAXTIME = "Duration of event is more than the maximum duration";
	String ERR_INVAILD_TALK_NAME = "Invaild talk name";
	String Regex = "^(.+)\\s(\\d+)?\\s?((min)|(lightning))$";
	String ERR_INVAILD_INPUT = "Please provide valid inputs";
	String ERR_INVAILD_LINE = "Invalid input line";
	String ERR_INVAILD_DURATIION = "Invalid Durations";
	String THROUGHT_WORKS_CONFERENCE = "ThroughtWorks Conference";

}
