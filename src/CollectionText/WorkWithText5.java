package CollectionText;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//5. Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы.

public class WorkWithText5 {
Double val;
    public void mapFill(Map<String, Double> someMap, List<String> thatList) {
        for (String wpString : thatList) {
            String tempString = wpString.trim().toLowerCase().replaceAll("\\pP|\\d|\\s", "");
            String[] arrWP = tempString.split("");
            for (int i = 0; i < arrWP.length; i++) {
                Double value = someMap.get(arrWP[i]);
                someMap.put(arrWP[i], value == null ? 1 : value + 1);
            }
        }
    }

    public void removeSimbol(Map<String, Double> map) {
        map.remove("");
        map.remove("=");
    }

    public void sumSimbol(Map<String, Double> someMap) {
        val = 0.0;
        for (Map.Entry entry : someMap.entrySet()) { // цикл для сложения всех букв
            val += (Double) entry.getValue();
        }
    }
    public void freqSimbol (Map<String, Double> anotherMap) {
        for (Map.Entry entry : anotherMap.entrySet()) { // цикл для определения частоты встречаемости букв
            System.out.println(entry.getKey() + " : " + (Math.round((Double) entry.getValue() / val * 100) + "%"));
        }
    }

    public static void main(String[] args) throws IOException {

        WorkWithText5 wpText = new WorkWithText5();

        Map<String, Double> wpMap = new HashMap<>();
        File wp = new File("src/wp.txt");
        List<String> txtList = Files.readAllLines(wp.toPath());

        wpText.mapFill(wpMap, txtList);
        wpText.removeSimbol(wpMap);
        wpText.sumSimbol(wpMap);
        wpText.freqSimbol(wpMap);

    }
}
