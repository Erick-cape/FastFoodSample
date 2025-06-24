package org.heaper.net.controller;

import org.heaper.net.view.View;

public class Controller {
    View view;

    public Controller() {
        view = new View("FastFoodSample");

        initialize();
    }

    public void initialize() {
        view.drawInitPanel();

        view.setVisible(true);

        view.refreshFrame();
    }
}
