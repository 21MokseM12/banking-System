package config;

import java.io.*;

public class ConfigTools{
    final private static String path = "src/main/resources/source.bin";
    public static boolean empty(File file){
        return file.length() == 0;
    }

    public static boolean isValidPin(int pin){
        return Integer.toString(pin).length() == 4;
    }
    public static boolean isValidNickname(String nickname){
        //ДОДЕЛАТЬ ПРОВЕРКУ
        if (nickname.length() < 4) return false;
        else return true;
    }
    public static String getPath(){return path;}
    public static Object toRead(String path) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(file);

        Object object = ois.readObject();
        ois.close();

        return object;
    }
    public static void toWrite(Object object, String path) throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(file);

        oos.writeObject(object);

        oos.close();
    }

}
