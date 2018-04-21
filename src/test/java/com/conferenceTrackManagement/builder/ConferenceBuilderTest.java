package com.conferenceTrackManagement.builder;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant;
import com.conferenceTrackManagement.util.FileUtil;
import com.conferenceTrackManagement.validator.ConferenceTalkValidator;


public class ConferenceBuilderTest {

	
	ConferenceTalkValidator conferenceTalkValidator;

	ConferenceBuilder conferenceBuilder;

	List<String> inputList = null;

	@Before
	public void setUp() {
		inputList = new ArrayList<>();
		conferenceTalkValidator = Mockito.mock(ConferenceTalkValidator.class);
		conferenceBuilder = new ConferenceBuilder(conferenceTalkValidator);

	}

	@Test
	public void testConferenceTrackManagementMultipleFullDayEvents() throws IOException {
		String inputFileName = "/input_file_actual";
		BufferedReader bufferedReader = getMockObject(inputFileName);
		Conference conference = conferenceBuilder.preparedConference(bufferedReader);
		testConferenceTrackManagment(inputFileName, conference);
	}

	@Test
	public void testConferenceTrackManagementMultipleDayLessEvents() throws IOException {
		String inputFileName = "/input_file_less_events";
		BufferedReader bufferedReader = getMockObject(inputFileName);
		Conference conference = conferenceBuilder.preparedConference(bufferedReader);
		//conference.showConferenceDetails();
		testConferenceTrackManagment(inputFileName, conference);

	}

	@Test
	public void testConferenceTrackManagementSingleDayEvents() throws IOException {
		String inputFileName = "/input_file_single_day_events";
		BufferedReader bufferedReader = getMockObject(inputFileName);
		Conference conference = conferenceBuilder.preparedConference(bufferedReader);
		testConferenceTrackManagment(inputFileName, conference);

	}

	private BufferedReader getMockObject(String inputFileName) throws IOException {
		BufferedReader bufferedReader = FileUtil.getBufferedReaderForResourceFile(inputFileName, this);
		List<String> inputStringList = FileUtil.getListStringForBufferReader(inputFileName, this);
		Mockito.when(conferenceTalkValidator.validateInput(inputStringList))
				.thenReturn(ConferenceTrackManagementCostant.EMPTY_STRING);
		return bufferedReader;
	}

	private void testConferenceTrackManagment(String inputFileName, Conference conference) throws IOException {
		String expectedOutputFile = getExpectedOutputFile(inputFileName);
		String actualOutputFile = conference.toString();
		assertTrue(FileUtil.contentEquals(expectedOutputFile, actualOutputFile, this));
	}

	private String getExpectedOutputFile(String inputFile) {
		return inputFile + "_expected";
	}

}
