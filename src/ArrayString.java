import java.util.Arrays;
import java.util.Random;

public class ArrayString {
    public static void main(String[] args) {
        //1) Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы
        // массива на экран сначала в строку, отделяя один элемент от другого
        // пробелом, а затем в столбик (отделяя один элемент
        // от другого началом новой строки). Перед созданием массива подумайте,
        // какого он будет размера. 2 4 6 … 18 20 2 4 6 … 20
        int [] arr1 =  new int [10];
        int c = 2;
        for (int i = 0; i < arr1.length; i++){
            arr1 [i] = arr1[i]+ c;
            c +=2;
        }
        //System.out.println(Arrays.toString(arr1));

        for (int i = 0; i < arr1.length; i++){
           // System.out.println(arr1[i]);
        }
        ////////////////////////////////////////////////////////////////////////////////

        //2) Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран
        // в строку, а затем этот же массив выведите на экран тоже в строку, но
        // в обратном порядке (99 97 95 93 … 7 5 3 1)
        int [] arr2 = new int [50];
        c = 1;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] += c;
            c +=2;
        }
        System.out.println(Arrays.toString(arr2));
        int [] arr2clone = arr2.clone();
        for (int i = arr2clone.length-1; i >= 0; i--) {
            arr2 [i] = arr2clone[arr2clone.length - 1 - i];
        }
        System.out.println(Arrays.toString(arr2));
        /////////////////////////////////////////////////////////////////////////////////

        //3) Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите
        // массив на экран. Подсчитайте сколько в массиве чётных элементов и выведете
        // это количество на экран на отдельной строке.
        int [] arrRandom = new int [15];
        c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // использовал генератор случайных чисел для внесения значений в массив
            Random random = new Random();
            int num = 0 + random.nextInt(9 - 0);
            arrRandom[i] = num;
            if (arrRandom[i]%2 == 0) {
                if (arrRandom[i] != 0) c++;
                         }
        }
        System.out.println(Arrays.toString(arrRandom));
        System.out.println(c);
        ///////////////////////////////////////////////////////////////////////////////

        //4) Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
        // выведите массивы на экран в двух отдельных строках. Посчитайте среднее
        // арифметическое элементов каждого массива и сообщите, для какого из массивов
        // это значение оказалось больше (либо сообщите, что их средние арифметические равны)
        int [] arrA = new int [5];
        int [] arrB = new int [5];
        int numA = 0;
        int numB = 0;
        double dblA = 0;
        double dblB = 0;
        // использовал генератор случайных чисел
        for (int i = 0; i < arrA.length; i++) {
            Random random = new Random();
            int num = 0 + random.nextInt(5 - 0);
            arrA[i] = num;
            numA = numA + num;
        }
        System.out.println(Arrays.toString(arrA));
        for (int i = 0; i < arrB.length; i++) {
            Random random = new Random();
            int num = 0 + random.nextInt(5 - 0);
            arrB[i] = num;
            numB = numB + num;
        }
        System.out.println(Arrays.toString(arrB));
        dblA = ((double)numA) / 5;
        dblB = (double)numB / 5;

        if (numA == numB) System.out.println("Средние арифметические равны");
        if (numA < numB) System.out.println("У второго среднее арифметическое больше");
        if (numA > numB) System.out.println("У первого среднее арифметическое больше");
        ////////////////////////////////////////////////////////////////////////////////////////////

        //5) Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран
        // в строку. Определить и вывести на экран сообщение о том, является ли массив строго
        // возрастающей последовательностью.
        int [] arrQ = new int [4];
        for (int i = 0; i < arrQ.length; i++) {
            Random random = new Random();
            int num = 10 + random.nextInt(99 - 10);
            arrQ[i] = num;
        }
        System.out.println(Arrays.toString(arrQ));
        int a0 = arrQ[0];
        int a1 = arrQ[1];
        int a2 = arrQ[2];
        int a3 = arrQ[3];
        if (a0 > a1 && a1 >a2 && a2 > a3) System.out.println("Возрастает");
        else System.out.println("Не возрастает");
        ////////////////////////////////////////////////////////////////////////////////////////////

        //1) Найти в строке указанную подстроку и заменить ее на новую. Строку, ее подстроку
        // для замены и новую подстроку вводит пользователь.

        String str = "BAS.BAD.mon00/1";
        String substr = "BAD";
        String newsubstr = "GOOD";
        boolean isContain = str.contains(substr);
        if (isContain) {
            String newStr = str.replace(substr, newsubstr);
            str = newStr;
        }
        System.out.println(str);
    }
}
