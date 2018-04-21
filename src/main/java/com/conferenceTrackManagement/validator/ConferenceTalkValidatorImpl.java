package com.conferenceTrackManagement.validator;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.DELIMETER;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.DOT;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERROR;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_DURATION_MORE_THEN_MAXTIME;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_DURATIION;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_INPUT;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_LINE;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.EVENT_DURATION_INDEX;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.EVENT_DURATION_UNIT_INDEX;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LIGHTNING;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_BREAK;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_NUM;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.MAX_EVENT_DURATION;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.MINITES;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.Regex;
import static com.conferenceTrackManagement.util.ConferenceTrackManagementUtil.getPattern;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.conferenceTrackManagement.exception.InvalidTalkNameException;

public class ConferenceTalkValidatorImpl implements ConferenceTalkValidator {
    
	private void validateInputString(String inputLinens, Pattern pattern) {
		if (inputLinens.isEmpty()) {
			throw new InvalidTalkNameException(ERR_INVAILD_INPUT);

		}
		Matcher match = pattern.matcher(inputLinens);
		boolean find = match.find();
		if (find == false) {
			throw new InvalidTalkNameException(ERR_INVAILD_LINE);
		}
		String durationInString = match.group(EVENT_DURATION_INDEX);
		String durationUnit = match.group(EVENT_DURATION_UNIT_INDEX);
		if (durationInString == null && MINITES.equalsIgnoreCase(durationUnit)) {
			throw new InvalidTalkNameException(ERR_INVAILD_DURATIION);
		}

		if (durationInString != null && !LIGHTNING.equalsIgnoreCase(durationInString)) {
			int duration = Integer.parseInt(durationInString);
			if (duration > MAX_EVENT_DURATION) {
				throw new InvalidTalkNameException(ERR_DURATION_MORE_THEN_MAXTIME);

			}
		}

	}
	
	@Override
	public String validateInput(List<String> inputLinens) {
		StringBuilder errorBuilder = new StringBuilder();
		Pattern pattern = getPattern(Regex);
		int lineNumber = 1;
		for (String inputLine : inputLinens) {
			try {
				validateInputString(inputLine.trim(), pattern);
			} catch (InvalidTalkNameException e) {
				errorBuilder.append(ERROR).append(LINE_BREAK);
				errorBuilder.append(LINE_NUM).append(lineNumber).append(DOT).append(inputLine)
						.append(DELIMETER + e.getMessage()).append(LINE_BREAK);
			}
			lineNumber++;

		}
		if(!errorBuilder.toString().isEmpty()){
			
		}
		return errorBuilder.toString();
	}

}
