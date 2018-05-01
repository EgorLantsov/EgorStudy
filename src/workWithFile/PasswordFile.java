package workWithFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// Зашифровать/ дешифровать файл паролем (XOR)

public class PasswordFile {

    public void writeToFile(File file, String string) throws IOException{
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeUTF(string);
            System.out.println("written");
        }
    }

    public void readWithPass(File file) throws IOException{
        String passwor = "qwerty";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Pass:");
        String somePass = scanner.nextLine();
        if (!somePass.equals(passwor)){
            System.out.println("Wrong Pass!");
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")){
            raf.seek(0); // отступили
            String str = raf.readUTF(); // считали
            System.out.println("Mess: " + str);
        }
    }

    public static void main(String[] args) throws IOException {
        PasswordFile psw = new PasswordFile();
        File file = new File("secret.txt");
        psw.writeToFile(file, "Some private information");
        psw.readWithPass(file);
    }
}
