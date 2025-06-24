package org.heaper.net;

import org.heaper.net.controller.Controller;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Controller controller = new Controller();
            } catch (Exception exception) {
                System.out.println("An error has occurred. Error: " + exception);
            }
        });
    }
}
