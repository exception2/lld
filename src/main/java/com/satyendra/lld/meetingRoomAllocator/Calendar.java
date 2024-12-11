package com.satyendra.lld.meetingRoomAllocator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Calendar {
    private List<Meeting> meetings;

    public Calendar() {
        this.meetings = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public boolean isAvailable(Duration duration) {
        if (meetings.isEmpty()) {
            return true;
        }
        for(Meeting meeting : meetings) {
            if(meeting.getDuration().isFree(duration)) {
                return true;
            }
        }
        return false;
    }

}
