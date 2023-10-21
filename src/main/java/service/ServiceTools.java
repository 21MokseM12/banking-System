package service;

import client.Client;
import config.ConfigTools;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ServiceTools {
    public static void registration(HashMap<Character, List<Client>> clients){
        Scanner scan = new Scanner(System.in);

        String name;
        int pin;

        while (true) {
            System.out.print("Enter your nickname: ");
            name = scan.nextLine();
            System.out.print("Enter your PIN (4 digits) : ");
            pin = scan.nextInt();
            if (ConfigTools.isValidPin(pin) && ConfigTools.isValidNickname(name)) {
                List<Client> tmp = clients.get(name.charAt(0));
                tmp.add(new Client(name, pin, tmp.size()));
                clients.put(name.charAt(0), tmp);
                System.out.println("You are welcome to our beautiful bank!");
                break;
            }
            else System.out.println("Your nickname or PIN is valid, try again");
        }
    }
    public static  Client logIn(HashMap<Character, List<Client>> clients, Client currentClient){
        Scanner scan = new Scanner(System.in);

        String name;
        int pin, reg, isRegistered;

        while (true) {
            System.out.print("Enter your nickname: ");
            name = scan.nextLine();
            System.out.print("Enter your PIN (4 digits) : ");
            pin = scan.nextInt();

            isRegistered = isRegisteredClientId(clients, name, pin);

            if (isRegistered == -1) {
                System.out.println("\nYou are not registered yet.\n\nWould you register in our bank?\n1) Yes\n2) No");
                reg = scan.nextInt();
                switch (reg) {
                    case 1:
                        ServiceTools.registration(clients);
                        break;
                    case 2:
                        System.out.println("Come back soon!");
                        break;
                    default:
                        break;
                }
            }
            else currentClient = clients.get(name.charAt(0)).get(isRegistered);
            break;
        }
        return currentClient;
    }
    public static int isRegisteredClientId(HashMap<Character, List<Client>> clients, String name, int pin){
        List<Client> tmp = clients.get(name.charAt(0));

        if (tmp.isEmpty()) return -1;
        else {
            for (Client i : tmp)
                if (i.getUsername().equals(name) && i.getPin() == pin) return i.getId();
            return -1;
        }
    }
}
