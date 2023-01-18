package no.ntnu.sigvebjo.app;

import java.util.Scanner;

public class IOManager {
    private Scanner scanner;

    private static IOManager instance = null;

    private IOManager() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Singleton retriever.
     *
     * @return singleton instance
     */
    public static IOManager getInstance() {
        if (instance == null) {
            instance = new IOManager();
        }

        return instance;
    }

    /**
     * Outputs to interface.
     *
     * @param text text to output.
     */
    public void output(String text) {
        System.out.println(text);
    }

    /**
     * Retrieves input from interface.
     *
     * @return string input from the user.
     */
    public String input() {
        System.out.print(" > ");
        return scanner.nextLine();
    }
}
