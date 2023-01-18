package no.ntnu.sigvebjo.app;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a room.
 * Can be navigated to and from.
 * Contains a name and description of the room.
 */
public class Room {
    private IOManager ioManager = IOManager.getInstance();

    private HashMap<String, Room> destinations;

    private String name = "ERR_NO_NAME";
    private String desc = "ERR_NO_DESC";

    /**
     * .ctor
     *
     * @param name name of the room
     * @param desc description of the room
     */
    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;

        this.destinations = new HashMap<String, Room>();
    }

    /**
     * Attempts to add a destination to the room.
     *
     * @param prompt the prompt leading to the room
     * @param destination the room to add as a destination
     * @return success boolean
     */
    public boolean addDestination(String prompt, Room destination) {
        boolean success = false;

        if (!this.destinations.containsKey(prompt)) {
            success = true;
            this.destinations.put(prompt, destination);
        }

        return success;
    }

    /**
     * Adds an exit to the room, and assigns this room as an exit from the target.
     * @param prompt prompt to exit to the target
     * @param destination the target destination
     * @param thisPrompt prompt from the target to this room
     * @return success boolean
     */
    public boolean addDestinationMutual(String prompt, Room destination, String thisPrompt) {
        boolean success = false;

        if (!this.destinations.containsKey(prompt) && destination.getDestination(thisPrompt) == null) {
            success = true;
            this.destinations.put(prompt, destination);
            destination.addDestination(thisPrompt, this);
        }

        return success;
    }

    public Room getDestination(String prompt) {
        Room retval = null;

        if (this.destinations.containsKey(prompt)) {
            retval = this.destinations.get(prompt);
        }

        return retval;
    }

    public void printExits() {
        ioManager.output("You can go to:");
        for (String prompt : destinations.keySet()) {
            ioManager.output(prompt);
        }
    }

    // ** * * * * * * * * * * ** //
    // ** Getters and Setters ** //
    // ** * * * * * * * * * * ** //
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
