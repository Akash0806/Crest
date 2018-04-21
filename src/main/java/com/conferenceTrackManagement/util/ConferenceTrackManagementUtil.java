package com.conferenceTrackManagement.util;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.EVENT_DURATION_UNIT_INDEX;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LIGHTNING;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.MINITES;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConferenceTrackManagementUtil {

	public static Pattern getPattern(String regex){
		return Pattern.compile(regex);
	}
	
	
	public static boolean isNullOrEmpty(String name) {
		return name==null||name.isEmpty();
	}

	public static boolean isVaildUnitOfDuration(Matcher match) {
		String group = match.group(EVENT_DURATION_UNIT_INDEX);
		boolean isIncorrect=false;
		if(!(group.equalsIgnoreCase(LIGHTNING)||group.equalsIgnoreCase(MINITES)))
			isIncorrect=true;
		return isIncorrect;
	}

	

	
	 
}
