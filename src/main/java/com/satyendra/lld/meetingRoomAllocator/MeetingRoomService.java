package com.satyendra.lld.meetingRoomAllocator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MeetingRoomService {

    List<MeetingRoom> meetingRooms;

    public MeetingRoomService() {
        this.meetingRooms = new ArrayList<>();
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }
}
