package com.codeChallenge.codeChallenge.client;

import java.util.List;

public interface ClientOperations {
    String assignRoom();

    String checkoutRoom(String room);

    String cleanRoom(String room);

    String repairRoom(String room);

    List<String> listAvailableRooms();
}
