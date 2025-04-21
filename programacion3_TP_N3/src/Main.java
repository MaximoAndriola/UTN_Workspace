import View.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Menu.launchMenu(in);

        in.close();
    }
}