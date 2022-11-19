package com.codeChallenge.codeChallenge.client.impl;

import com.codeChallenge.codeChallenge.client.ClientOperations;
import com.codeChallenge.codeChallenge.handler.impl.AssignRoomHandler;
import com.codeChallenge.codeChallenge.handler.impl.AvailableRoomsHandler;
import com.codeChallenge.codeChallenge.handler.impl.CheckoutRoomHandler;
import com.codeChallenge.codeChallenge.handler.impl.CleanRoomHandler;
import com.codeChallenge.codeChallenge.handler.impl.RepairRoomHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ClientOperationsImpl implements ClientOperations {

    @Autowired
    private AssignRoomHandler assignRoomHandler;

    @Autowired
    private CheckoutRoomHandler checkoutRoomHandler;

    @Autowired
    private CleanRoomHandler cleanRoomHandler;

    @Autowired
    private RepairRoomHandler repairRoomHandler;

    @Autowired
    private AvailableRoomsHandler availableRoomsHandler;

    @Override
    @ShellMethod(value = "Assign the nearest available room")
    public String assignRoom() {
        return assignRoomHandler.handle();
    }

    @Override
    @ShellMethod(value = "Checkout from the room. The room input can be provided by adding -R *roomNumber* " +
            "or --room *roomNumber*. Don't include * in input.")
    public String checkoutRoom(@ShellOption({"-R", "--room"}) String room) {
        return checkoutRoomHandler.handle(room);
    }

    @Override
    @ShellMethod(value = "Clean the room. The room input can be provided by adding -R *roomNumber* " +
            "or --room *roomNumber*. Don't include * in input.")
    public String cleanRoom(@ShellOption({"-R", "--room"}) String room) {
        return cleanRoomHandler.handle(room);
    }

    @Override
    @ShellMethod(value = "Repair the room. The room input can be provided by adding -R *roomNumber* " +
            "or --room *roomNumber*. Don't include * in input.")
    public String repairRoom(@ShellOption({"-R", "--room"}) String room) {
        return repairRoomHandler.handle(room);
    }

    @Override
    @ShellMethod(value = "List all available rooms.")
    public List<String> listAvailableRooms() {
        return availableRoomsHandler.handle();
    }
}
