package com.satyendra.lld.meetingRoomAllocator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Duration {

    private String startTime;
    private String endTime;


    public boolean isFree(Duration duration) {
        if (duration.getStartTime().compareTo(endTime) >= 0 || duration.getEndTime().compareTo(startTime) <= 0) {
            return true;
        }
        return false;
    }
}
