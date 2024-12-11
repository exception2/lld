package com.satyendra.lld.meetingRoomAllocator;

import lombok.Data;

import java.util.List;

@Data
public class User implements InviteObserver {

    private String name;
    private String email;
    private Calendar calendar;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.calendar = new Calendar();
    }

    public void addMeeting(Meeting meeting) {
        calendar.getMeetings().add(meeting);
    }

    @Override
    public void notify(Meeting meeting) {
        this.calendar.addMeeting(meeting);
    }
}
