package com.satyendra.lld.meetingRoomAllocator;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Data
@Builder
public class Meeting {

    @Serial
    private Long id;
    private String title;
    private Duration duration;
    private User organizer;
    private MeetingRoom meetingRoom;
    private List<User> participants;
    private String description;
    private String link;
    private Calendar calendar;

}
