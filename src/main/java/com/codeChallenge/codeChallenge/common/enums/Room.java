package com.codeChallenge.codeChallenge.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum Room {

    OneA("1A",1),
    OneB("1B",2),
    OneC("1C",3),
    OneD("1D",4),
    OneE("1E",5),
    TwoA("2A",6),
    TwoB("2B",7),
    TwoC("2C",8),
    TwoD("2D",9),
    TwoE("2E",10),
    ThreeA("3A",11),
    ThreeB("3B",12),
    ThreeC("3C",13),
    ThreeD("3D",14),
    ThreeE("3E",15),
    FourA("4A",16),
    FourB("4B",17),
    FourC("4C",18),
    FourD("4D",19),
    FourE("4E",20);

    private String room;
    private int distance;
    Room(String room, int distance) {
        this.room = room;
    }

    private static Map<String, Room> roomMap;

    static {
        roomMap = new HashMap<>();

        for(Room room: Room.values()) {
            roomMap.put(room.getRoom(), room);
        }
    }

    public String getRoom() {
        return room;
    }

    public int getDistance() {
        return distance;
    }

    public static Room getEnumFromPersistentValue(String room) {
        return roomMap.getOrDefault(room, null);
    }

    @Override
    public String toString() {
        return room;
    }
}
