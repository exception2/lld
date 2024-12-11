package com.satyendra.lld.meetingRoomAllocator;

import java.util.List;

public class MeetingService {

    public Meeting addMeeting(MeetingRoom meetingRoom, Duration duration, User organizer, List<User> participants, String title, String description, String link) {
        Meeting meeting = Meeting.builder()
                .description(description)
                .duration(duration)
                .organizer(organizer)
                .participants(participants)
                .title(title)
                .link(link)
                .meetingRoom(meetingRoom)
                .build();

        notifyAll(meeting);
        return meeting;
    }

    private void notifyAll(Meeting meeting) {
        meeting.getMeetingRoom().notify(meeting);
        meeting.getOrganizer().notify(meeting);
        for(User participant : meeting.getParticipants()) {
            participant.notify(meeting);
        }
    }
}
