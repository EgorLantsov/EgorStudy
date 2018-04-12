package CollectionText;
//1. Сосчитать частоту встречаемости слов в книге War and peace.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WorkWithText {


    public static void main(String[] args) throws IOException {
        int count = 0;
        String thatString = "are";
        File wp = new File("src/wp.txt");
        List<String> txtList = Files.readAllLines(wp.toPath());

//        можно блыо бы наверно использовать Set для отсеивания и учета повторяющися символов
//        Set<String> txtSet = new HashSet<>();
        for (String strTxt : txtList) {
            if (strTxt.contains(thatString)) {
                String arrTxt[] = strTxt.split(" "); // если в строке несколько таких слов, переводим в массив
                for (int i = 0; i < arrTxt.length; i++) {
                    if (arrTxt[i].contains(thatString)) { // проверяем каждую ячейку на наличие похожего слова
                        count += 1;
                    }
                }
            }
        }
//         System.out.println("Количество повторени слов в тексте " + count); // выводим результат

//      2. Собрать все слова в группы по количеству букв: например, в одну группу попадут слова:
//       [the, war, jar, get, met...], в другую [on, up, no, of...].
        List<String> threeChars = new ArrayList<>();
        List<String> twoChars = new ArrayList<>();
        for (String strGroup : txtList) {
            String arrGroup[] = strGroup.split(" ");
            for (int i = 0; i < arrGroup.length; i++) {
                if (arrGroup[i].length() == 3) {
                    threeChars.add(arrGroup[i]);
                } else if (arrGroup[i].length() == 2) {
                    twoChars.add(arrGroup[i]);
                }
            }
        }
//        System.out.println(threeChars); // выводим результат группы 3 символьной
//        System.out.println(twoChars); // выводим результат группы 2 символьной


//        4. Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...).

        List<String> twootherChars = new ArrayList<>();
        twootherChars.add("on");
        twootherChars.add("of");
        twootherChars.add("to");
        List<String> threeotherChars = new ArrayList<>();
        threeotherChars.add("the");

        threeChars.removeAll(threeotherChars);
        twoChars.removeAll(twootherChars);
        System.out.println(threeChars); // выводим результат группы 3 символьной
        System.out.println(twoChars); // выводим результат группы 2 символьной

        // потом надо это причесать и сделать через методы а не через быдло кодинг

//        3. Вывести топ 10 самых частых слов и фраз.


////        WorkWithText workText = new WorkWithText();
//        Map<String, Integer> wordStat = new HashMap<>();
////        Map<String, Integer> mapText = workText.fillMap(wordStat, txtList );
//        for(String txtStr: txtList){
//            String strVal = txtStr.trim().toLowerCase().replaceAll("\\pP|\\d","");
//            String arrStr [] = strVal.split(" ");
//            for (int i = 0; i < arrStr.length; i ++){
//                Integer value = wordStat.get(arrStr[i]);
//                wordStat.put(arrStr[i], value == null ? 1 : value + 1);
//            }
//        }
//        wordStat.remove("");
//
//        System.out.println(wordStat); // выводим ключ значения
//
////        wordStat.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
////        .forEach(System.out::print);
//
//        List list = new ArrayList(wordStat.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
//                return a.getValue() - b.getValue();
//            }
//        });
//        System.out.println(wordStat); // выводим ключ значения
    }
}


