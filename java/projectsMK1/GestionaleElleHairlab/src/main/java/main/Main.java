package main;

import controller.MainController;
import com.formdev.flatlaf.FlatLightLaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new MainController();

    }

}

