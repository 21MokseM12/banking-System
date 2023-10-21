package test;

import client.Client;
import config.ConfigTools;

import java.io.IOException;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(ServiceTools.isValidPin(12345));
//        System.out.println(ServiceTools.isValidPin(1234));

//        System.out.println(ServiceTools.isValidNickname("Mike"));;
//        System.out.println(ServiceTools.isValidNickname("Mik1,./"));
//        System.out.println(ServiceTools.isValidNickname("Mik"));
//        System.out.println(ServiceTools.isValidNickname("     "));
//        System.out.println(ServiceTools.isValidNickname(""));

        HashMap<Character, List<Client>> arr = new HashMap<>();
        for (int i = 65; i < 91; i++) arr.put((char) i, new ArrayList<>());
        for (int g = 97; g < 122; g++) arr.put((char) g, new ArrayList<>());

        ConfigTools.toWrite(arr, "src/main/resources/source.bin");

        HashMap<Character, List<Client>> finaly = (HashMap<Character, List<Client>>) ConfigTools.toRead("src/main/resources/source.bin");

        Set<Character> set = finaly.keySet();
        Collection<List<Client>> collection = finaly.values();
        for (char i : set) System.out.print(i + " ");
        for (List<Client> g : collection) System.out.print(g + " ");
    }
}
