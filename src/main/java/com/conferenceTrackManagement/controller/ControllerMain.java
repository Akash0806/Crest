package com.conferenceTrackManagement.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.conferenceTrackManagement.builder.Conference;
import com.conferenceTrackManagement.builder.ConferenceBuilder;
import com.conferenceTrackManagement.validator.ConferenceTalkValidatorImpl;

public class ControllerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path=sc.next();
	    if (path.isEmpty()) {
			System.out.println("Input file with events must be supplied to this program.");
			System.exit(1);
		}

		File inputFile = new File(path);
		try {
			ConferenceBuilder conferenceBuilder = new ConferenceBuilder(new ConferenceTalkValidatorImpl());
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			Conference conference = conferenceBuilder.preparedConference(reader);
			conference.showConferenceDetails();

		} catch (IOException e) {
			sc.close();
			System.out.println("Cannot read from input file: " + inputFile.getAbsolutePath());
			System.out.println("Please provide name e.g. input_file.txt");
			System.exit(1);
		}
	}

}
