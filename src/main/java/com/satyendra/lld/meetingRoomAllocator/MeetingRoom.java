package com.satyendra.lld.meetingRoomAllocator;

import lombok.Data;

import java.util.List;

@Data
public class MeetingRoom implements InviteObserver {

    private String name;
    private int capacity;
    private Calendar calendar;

    public MeetingRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.calendar = new Calendar();
    }

    @Override
    public void notify(Meeting meeting) {
        this.calendar.addMeeting(meeting);
    }
}
