package com.satyendra.lld.meetingRoomAllocator;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Scheduler {

    UserService userService;
    MeetingRoomService meetingRoomService;

    MeetingService meetingService;

    public Scheduler(UserService userService, MeetingRoomService meetingRoomService) {
        this.userService = userService;
        this.meetingRoomService = meetingRoomService;
        this.meetingService = new MeetingService();
    }

    public MeetingRoom scheduleMeeting(Duration duration, User organizer, List<User> participants, String title, String description, String link) {

        for(MeetingRoom meetingRoom : meetingRoomService.getMeetingRooms()) {
            if(meetingRoom.getCalendar().isAvailable(duration)) {
                Meeting bookMeeting = meetingService.addMeeting(meetingRoom, duration, organizer, participants, title, description, link);
                return bookMeeting.getMeetingRoom();

            }
        }
        return null;
    }


    public static void main(String[] args) {
        MeetingRoom meetingRoom1 = new MeetingRoom("Meeting Room 1", 10);
        MeetingRoom meetingRoom2 = new MeetingRoom("Meeting Room 2", 20);

        MeetingRoomService meetingRoomService = new MeetingRoomService();
        meetingRoomService.addMeetingRoom(meetingRoom1);
        meetingRoomService.addMeetingRoom(meetingRoom2);

        User user1 = new User("Satyendra", "satyendra@gmail.com");
        User user2 = new User("Amit", "amit@gmail.com");
        User user3 = new User("Rahul", "rahul@gmail.com");

        UserService userService = new UserService();
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        Scheduler scheduler = new Scheduler(userService, meetingRoomService);

        List<User> participants = Arrays.asList(user2, user3);

        MeetingRoom meetingRoom11 = scheduler.scheduleMeeting(new Duration("2024-01-01T12:00:00Z", "2024-01-01T13:00:00Z"), user1, participants, "Design Meeting", "Design discussion", "https://meet.google.com/xyz");
        log.info("Meeting scheduled with id: {}", meetingRoom11.getName());
        MeetingRoom meetingRoom22 = scheduler.scheduleMeeting(new Duration("2024-01-01T12:00:00Z", "2024-01-01T13:00:00Z"), user1, participants, "Design Meeting1", "Design discussion", "https://meet.google.com/xyz");
        log.info("Meeting scheduled with id: {}", meetingRoom22.getName());
        for(Meeting meeting : user2.getCalendar().getMeetings()) {
            log.info("user2 meeting : " + meeting.getTitle());
        }

        for(Meeting meeting : user3.getCalendar().getMeetings()) {
            log.info("user3 meeting : " + meeting.getTitle());
        }

        for(Meeting meeting : user1.getCalendar().getMeetings()) {
            log.info("user1 meeting : " + meeting.getTitle());
        }

        for(Meeting meeting : meetingRoom1.getCalendar().getMeetings()) {
            log.info("user room1 meeting : " + meeting.getTitle());
        }

        for(Meeting meeting : meetingRoom2.getCalendar().getMeetings()) {
            log.info("user room2 meeting : " + meeting.getTitle());
        }
    }

}
