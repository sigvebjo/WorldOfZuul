package no.ntnu.sigvebjo.app;

public class App 
{
    private static Room position;

    public static void main( String[] args )
    {
        IOManager ioManager = IOManager.getInstance();

        Room startRoom = new Room("Alpha", "You started here. There's a safe zone here, whatever that means.");
        Room nextRoom = new Room("Beta", "Your first destination. There are braindead enemies scattered about.");
        Room endRoom = new Room("Gamma", "The final room. The door disappears behind you. There is some inactive boss here.");

        startRoom.addDestinationMutual("Beta", nextRoom, "Alpha");
        nextRoom.addDestination("Gamma", endRoom);

        position = startRoom;

        while (true) {
            position.printExits();
            String input = ioManager.input();
            ioManager.output(input);
            if (position.getDestination(input) != null) {
                position = position.getDestination(input);
            }
        }
    }
}
