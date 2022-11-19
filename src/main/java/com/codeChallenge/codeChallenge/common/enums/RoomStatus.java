package com.codeChallenge.codeChallenge.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoomStatus {
    AVAILABLE("Available"),
    OCCUPIED("Occupied"),
    VACANT("Vacant"),
    REPAIR("Repair");

    private String roomStatus;

    private static Map<String, RoomStatus> roomStatusMap;
    RoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    static {
        roomStatusMap = new HashMap<>();

        for(RoomStatus roomStatus: RoomStatus.values()) {
            roomStatusMap.put(roomStatus.getRoomStatus(), roomStatus);
        }
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    @Override
    public String toString() {
        return roomStatus;
    }
}
