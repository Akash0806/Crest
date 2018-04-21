package com.conferenceTrackManagement.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant;
import com.conferenceTrackManagement.validator.ConferenceTalkValidator;

public class ConferenceBuilder {
	
	private ConferenceTalkValidator conferenceTalkValidator;

	public ConferenceBuilder(ConferenceTalkValidator conferenceTalkValidator) {
		this.conferenceTalkValidator = conferenceTalkValidator;
	}

	public Conference preparedConference(BufferedReader input) throws IOException {
		Conference conference = null;
		List<String> inputStringList = readInput(input);
		if (inputStringList.size() > 0) {
			String isErrorPresent = conferenceTalkValidator.validateInput(inputStringList);
			if (isErrorPresent.isEmpty()) {
				conference = new Conference(ConferenceTrackManagementCostant.THROUGHT_WORKS_CONFERENCE);
				conference.createConference(inputStringList);
			}

		}
		return conference;
	}

	public List<String> readInput(BufferedReader input) throws IOException {
		List<String> events = new ArrayList<String>();
		for (String line; (line = input.readLine()) != null;) {
			line = line.trim();
			events.add(line);
		}
		return events;

	}
}
