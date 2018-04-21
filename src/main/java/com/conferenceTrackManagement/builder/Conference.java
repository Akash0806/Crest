package com.conferenceTrackManagement.builder;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.DELIMETER;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.LINE_BREAK;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.TRACK;

import java.util.ArrayList;
import java.util.List;

import com.conferenceTrackManagement.factory.ConferenceTrack;
import com.conferenceTrackManagement.factory.Talk;

public class Conference {
	String conferenceName;
	private List<ConferenceTrack> tracks;

    public Conference(String conferenceName) {
    	this.conferenceName=conferenceName;
        tracks = new ArrayList<ConferenceTrack>();
    }

    private void addTrack(ConferenceTrack track) {
        tracks.add(track);
    }
    
    public void createConference(List<String>inputStringList){
    	List<Talk> talks = Talk.createTalks(inputStringList);
    	int trackNumber = 1;
    	while (talks.size()!= 0) {
    		ConferenceTrack conferenceTrack=new ConferenceTrack(TRACK + trackNumber);
    		conferenceTrack.createConfereceTrack(talks);
    	    addTrack(conferenceTrack);
    	    trackNumber++;
       }
    } 
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append(conferenceName).append(DELIMETER).append(LINE_BREAK);
    	for(ConferenceTrack track:tracks){
    	   builder.append(track.toString());
    	}
    	return builder.toString();
    }
    
    public void showConferenceDetails(){
    	System.out.println(toString());
    }

}
