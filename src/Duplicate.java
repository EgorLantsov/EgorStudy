

import java.util.*;

public class Duplicate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data");
            String num = scanner.nextLine();
            System.out.println(num);

            Set<String> set = new HashSet<>();
            String [] name = num.split(" ");
            int value = 0;
            Map<String, Integer> hashMap = new HashMap<>();
            for (String str : name) {
                if (str.matches("[a-zA-Zа-яА-Я]*")) {
                    System.out.println("Enter correct data");
                    break;
                } else {
                    if (!str.isEmpty()) {
                        if (!set.add(str)) {
                            if (hashMap.containsKey(str)) ;
                            hashMap.put(str, hashMap.get(str) + 1);

                        } else {
                            hashMap.put(str, 1);
                        }
//                    System.out.println(str.length()); // выводим длин укаждой строки
                    }
                }
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
    }

}
