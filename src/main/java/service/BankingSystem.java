package service;
import client.Client;
import config.ConfigTools;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BankingSystem {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File source = new File(ConfigTools.getPath());
        Scanner scan = new Scanner(System.in);
        HashMap<Character, List<Client>> clients = new HashMap<>();
        Client currentClient = new Client();

        if (!ConfigTools.empty(source)) clients = (HashMap<Character, List<Client>>) ConfigTools.toRead(ConfigTools.getPath());

        int flag = 1, answer;

        while (flag != 0){
            System.out.print("\n\n\nWelcome to our MoksemBank!\nAre you is client of bank?\n1) Yes\n2) No\n3) Exit\n");
            answer = scan.nextInt();

            switch (answer){
                case 1: // Yes
                    currentClient = ServiceTools.logIn(clients, currentClient);
                    if (currentClient.getPin() != 0) System.out.println("Welcome, " + currentClient.getUsername() + "!");
                    break;
                case 2: // No
                    ServiceTools.registration(clients);
                    break;
                case 3: // Exit
                    System.out.print("Come back soon!");
                    flag = 0;
                    break;
                default:
                    System.out.println("An error has occurred, please come back later");
                    break;
            }
        }





        ConfigTools.toWrite(clients, ConfigTools.getPath());
    }
}
