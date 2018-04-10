package CollectionText;
//1. Сосчитать частоту встречаемости слов в книге War and peace.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkWithText {

    public static void main(String[] args) throws IOException {
        int count = 0;
        String thatString = "are";
        File wp = new File("src/wp.txt");
        List<String> txtList = Files.readAllLines(wp.toPath());

//        можно блыо бы наверно использовать Set для отсеивания и учета повторяющися символов
//        Set<String> txtSet = new HashSet<>();
         for (String strTxt: txtList){
             if (strTxt.contains(thatString)){
                 String arrTxt [] = strTxt.split(" "); // если в строке несколько таких слов, переводим в массив
                 for (int i = 0; i < arrTxt.length; i++){
                     if (arrTxt[i].contains(thatString)){ // проверяем каждую ячейку на наличие похожего слова
                         count += 1;
                     }
                 }
             }
         }
         System.out.println("Количество повторени слов в тексте " + count); // выводим результат

//      2. Собрать все слова в группы по количеству букв: например, в одну группу попадут слова:
//       [the, war, jar, get, met...], в другую [on, up, no, of...].
        List<String> threeChars = new ArrayList<>();
        List<String> twoChars = new ArrayList<>();
        for (String strGroup: txtList){
           String arrGroup [] = strGroup.split(" ");
           for (int i = 0; i < arrGroup.length; i++) {
               if (arrGroup[i].length() == 3){
                   threeChars.add(arrGroup[i]);
               } else if (arrGroup[i].length() == 2){
                   twoChars.add(arrGroup[i]);
               }
           }
        }
        System.out.println(threeChars); // выводим результат группы 3 символьной
        System.out.println(twoChars); // выводим результат группы 2 символьной

//        3. Вывести топ 10 самых частых слов и фраз.
        count = 0;
        Set<String> otherWords = new HashSet<>();
        for (String strTxt: txtList){
            String arrTxt [] = strTxt.split(" "); // переводим в массив
                for (int i = 0; i < arrTxt.length; i++){
                    otherWords.add(arrTxt[i]); // добавляем слово по индексу в коллекцию без дубликатов
                }
        }
        for (String strTxt: otherWords){
            String arrTxt2 [] = strTxt.split(" "); // переводим строку в массив
            for (int i = 0; i < arrTxt2.length; i ++){
                for (String strTxt3: txtList){
                    String arrTxt3 [] = strTxt3.split(" "); // если в строке несколько таких слов, переводим в массив
                    for (int j = 0; j < arrTxt3.length; j++){
                        if (arrTxt3[i].contains(arrTxt2[i])){ // проверяем каждую ячейку на наличие похожего слова
                            count += 1;
                        }
                    }
                }

                count = 0;
            }
        }
        System.out.println();
//        запутался, переделать


    }
}
