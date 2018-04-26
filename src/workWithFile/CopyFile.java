package workWithFile;

import java.io.*;

public class CopyFile {

    private void writeToFile(String str, File file) throws IOException { // что пишем, в какой файл пишем
        try (Writer writer = new FileWriter(file)) { // не закрываем потому что в try
            writer.write(str);
        }
    }

    public void copyToFile(File original, File copyTo) {
        try (InputStream fileIn = new FileInputStream(original);
        OutputStream fileOut = new FileOutputStream(copyTo)){
            byte [] buf = new byte [1024];
            int len;
            while ((len = fileIn.read(buf)) > 0){
                fileOut.write(buf, 0, len); // записываем в выходящий поток в файл
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File f1 = new File("original.txt");
        File f2 = new File("copy.txt");
        CopyFile copyFile = new CopyFile();
        copyFile.writeToFile("Hello buddy", f1); // записываем что то в файл
        System.out.println(f1.toString());
        copyFile.copyToFile(f1, f2); // копируем из одного файла в другой
        System.out.println(f2.toString());



    }
}
