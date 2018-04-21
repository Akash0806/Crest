package com.conferenceTrackManagement.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private FileUtil() {}

	public static BufferedReader getBufferedReaderForResourceFile(String resourceFile,
			Object context) {
		InputStream inputStream = context.getClass().getResourceAsStream(resourceFile);
		return new BufferedReader(new InputStreamReader(inputStream));
	}

	
	public static List<String> getListStringForBufferReader(String resourceFile,
			Object context) throws IOException {
		 return getListInputString(getBufferedReaderForResourceFile(resourceFile,
				context)); 
	}

	public static List<String> getListInputString(BufferedReader bufferedReader) throws IOException {
		List<String> events=new ArrayList<String>();
		for (String line; (line = bufferedReader.readLine()) != null;) {
            line = line.trim();
            events.add(line);
        }
		bufferedReader.close();
		return events;
	}
	public static boolean contentEquals(String resourceFile, String string, Object context)
			throws IOException {
		BufferedReader fileReader = getBufferedReaderForResourceFile(resourceFile,
				context);
		BufferedReader stringReader = new BufferedReader(new StringReader(string));
		while (true) {
			String fileLine = getNextLine(fileReader);
			String stringLine = getNextLine(stringReader);
			if (fileLine == null && stringLine == null) {
				break;
			}

			if (fileLine == null || stringLine == null) {
				return false;
			}

			if (fileLine.equals(stringLine) == false) {
				return false;
			}
		}
		return true;
	}

	private static String getNextLine(BufferedReader reader) throws IOException {
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				return null;
			}

			if (line.trim().length() != 0) {
				return line;
			}
		}
	}
}
