package CollectionText;

//        3. Вывести топ 10 самых частых слов и фраз.

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WorkWithText3 {

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap){
        // 1. конвертируем Map в List Map
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
        //2.  Сортируем лист при помощи Collections.sort(), применяя переопределенный Comparator
        // Меняем позиции о1 и о2
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue()); //меняя местами o2 и о1 можно задать чтобы Map был
                // возрастающий или убывающий по значению
            }
        });
        // 3. Создаем цикл для листа и помещаем в Map со новым порядком вставки
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry: list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public static <K,V> void printMap(Map<K, V> map){
        for (Map.Entry<K, V> entry : map.entrySet()){
            System.out.println("Слово: " + entry.getKey() + " Повторений: " + entry.getValue());
        }
    }
    public static <K, V> void top10 (Map<K, V> map){ //выводим десятку популярных слов со значениями
        int c =0;
        for (Map.Entry<K, V> entry : map.entrySet()){
            System.out.println("Слово: " + entry.getKey() + " Повторений: " + entry.getValue());
            c += 1;
            if (c == 10)
                break;
        }
    }


    public static void main(String[] args) throws IOException {

        File wp = new File("src/wp.txt");
        List<String> txtList = Files.readAllLines(wp.toPath());
        Set<String> txtSet = new HashSet<>();
        List<String> anotherList = new ArrayList<>();

        Map<String, Integer> wordStat = new HashMap<String, Integer>();
//        Map<String, Integer> mapText = workText.fillMap(wordStat, txtList );
        for(String txtStr: txtList){
            String strVal = txtStr.trim().toLowerCase().replaceAll("\\pP|\\d","");
            String arrStr [] = strVal.split(" ");
            for (int i = 0; i < arrStr.length; i ++){
                Integer value = wordStat.get(arrStr[i]);
                wordStat.put(arrStr[i], value == null ? 1 : value + 1);
            }
        }
        wordStat.remove("");
//        System.out.println(wordStat);

        Map<String, Integer> sortWP = sortByValue(wordStat);
//        printMap(sortWP);
        top10(sortWP);

//        for (String txtStr : txtList){ // доюавляем не повторяющиеся слова в Set
//            String tempStr = txtStr.trim().toLowerCase().replaceAll("\\pP|\\d", "");
//            String strArr []= tempStr.split(" ");
//            for (int i = 0; i < strArr.length; i ++){
//                txtSet.add(strArr[i]);
//            }
//
//        }
//        for (String txtStr : txtList) { // доюавляем все слова в ArrayList
//            String tempStr2 = txtStr.trim().toLowerCase().replaceAll("\\pP|\\d", "");
//            String strArr2[] = tempStr2.split(" ");
//            for (int i = 0; i < strArr2.length; i++) {
//                anotherList.add(strArr2[i]);
//            }
//        }
//
////      вложенный цикл, для проверки колличества слов между (Set и ArrayList)
//            for (String setStr : txtSet){
//                int val = 0;
//                for (String arrStr : anotherList){
//                    if (arrStr.equals(setStr)){
//                        val += 1;
//                    }
//                }
//                System.out.println(setStr + " : " + val);
//            }


    }
}

