import java.util.ArrayList;

import java.lang.Object;
import java.util.*;

// This is the main class that is run.

public class Team {

    public void start() {
        GUI userInfo = new GUI();
        userInfo.makebutton();
        userInfo.makedropdownmenu();
        userInfo.makelabels();
        userInfo.initializescreen();

        userInfo.addcomponents();
        userInfo.actionlisteners();
        userInfo.startgui();
    }

    public static void main(String[] args) {
        Team main = new Team();
        main.start();
    }
}
