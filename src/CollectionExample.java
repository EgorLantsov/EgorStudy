import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    private String name;
    private int count;

    public CollectionExample(String name, int count){
        this.name = name;
        this.count = count;
    }
// переопределение методов hashCode и Equals под наши параметры (сравнение по атрибутам). Т.к. они от родительского
// класса Object
//    если методы equals и hashCode не будут переопределены как ниже, то в методах не будут задействованы нужные параметры
//    в данном случае name и count и сравнение и хэш код будут действовать не правильно, не будут учитывать эти
//    параметры
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionExample that = (CollectionExample) o;
        return count == that.count &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, count);
    }

    public static void main(String[] args) throws IOException {
        CollectionExample col = new CollectionExample("ColEx", 4);
        CollectionExample col2 = new CollectionExample("ColEx", 4);
//        CollectionExample col2 = col; //в данном случе тут ссылки будут на один объект
        CollectionExample col3 = new CollectionExample("Example", 2);

        System.out.println(col.hashCode()); // метод hashCode возвращает хэш код объекта (ссылка на объект)
        System.out.println(col2.hashCode());
        System.out.println(col3.hashCode()); // сравнение объектов на принадлежность к одной ячейки памяти

        System.out.println(col.equals(col2)); // вернет  true если ссылки на один и тот же объект (==)

//        Collection Framework
//        все коллекции имплементируют интерфейс Collection:
//        size(); тип int
//        isEmpty(); проверяет пусто или нет true или false
//        contains(Object obj) проверяет ли есть данный элемент в коллекции true или false
//        add(elem) добавление элемента и возрващает true или false
//        remove(Object obj) удаление элемента одного! возвращает true или false
//        containsAll(Collection<?> c) метод, на вхо передается коллекция, вернет true если ваша коллекция содержит
//        все такие же элементы как и в проверяемой коллекции true false
//        addAll() добавляет элементы все элементы в коллекцию
//        removeAll(Collection <?> c) из исходной коллекции будет удалять все элементы коллекции в аргументе "c" true или
//        false возвращает
//        retain(Collection <?> c ) оставляет все элементы которые есть в коллекции аргументе, остальные удаляет
//        clear() очищает коллекцию
//        for (Object o: collection){
//         System.out.println(o);
//        }  пройтись по элементам коллекции

//          Collection общий для Set, List, Queue

//        1.  Set коллекция которая не может содержать дублирующих элементов
//        Чтобы был уникальный набор данных то надо пользоваться Set - ом
//        Set включает в себя: HashSet, LinkedHashSet, TreeSet:

//        HashSet - для поиска и добавления элементов удобна, и так же не содержит дублирующиъ элементов
        Set<String> strings = new HashSet<>(); // коллекция строковая
        System.out.println(strings.add("12")); // добавляем строковые элементы
        System.out.println(strings.add("34"));
        System.out.println(strings.add("12")); // будет false потому что объект дублируеся
        System.out.println(strings.add("45"));

        for (String str: strings){ // перебираем коллекцию, указываем имя переменной str куда мы будем класть значения
            System.out.println(str);
        }

        Set<CollectionExample> colex = new HashSet<>();
        System.out.println(colex.add(col));
        System.out.println(colex.add(col2)); // если методы хэш и еквалс переопределить то все элементы не добавяться (оба)
        System.out.println(strings.size());

        System.out.println(colex.contains(col2)); // проверяем есть и такой объект в коллекции (будет true)
//        если важен порядок то есть LinkedHashSet и TreeSet, хранят элементы упорядоченно,но работат медленнее

        Iterator<String> iterator = strings.iterator(); // последовательно выведем элементы из коллекции strings
        while (iterator.hasNext()){ // идем по коллекции пока есть следующий элемент
            System.out.println("with iterator " + iterator.next());
        }
        colex.remove(col); // удаляем элемент и возвращется значение true или false по результату удаления

//      2.  interface List - упорядоченная коллекция которая может содержать дублирущие элементы
//          к предыдущим методам добавляются методы Листа:
//        доступ, удаление, добавление элементов по индексу
//        поиск элементов
//        замена элементов
//        операции с частью списка - subList(int from, int to)
//        ListIterator - расширенный итератор
        ArrayList<String> arrLst = new ArrayList<>(); // можно и так List<String> arrLst = new ArrayList<>();
//        шде ArrayList то класс
        LinkedList<String> linkedLst = new LinkedList<>(); // List<String> linkedLst = new LinkedList<>();
//        LinkedList - связанный лист,требует больше памяти, если надо что то добавлять в середину списка то лучше
//        использовать его
//        arrLst.subList(1,3).clear(); // указать начальную и конечный позиции (индексы), а потом через точку указать метод
//        того что мы хотим сделать с этим выделенным списком (последний элемент не включается, первый включается)
        arrLst.size();
//  стэки - первый элемент пришел, последним ушел, элементы читаются с конца
//        очереди - первым элемент пришел, первым ушел

//       3. interface Queue - однонаправленная очередь (это тоже хранение данных, коллекция)
//        здесь на каждое действие будут по два метода:
//        element(); возвращает, но НЕ удаляет элемент из начала очереди, если нет элемента то сгенерирует исключение
//        peek(); возвращает БЕЗ удаления элемент из начала очереди, если нет такого значения то вернет null
//        remove();
//        poll(); возвращает С удалением элемент из начала очереди, если нет такого значения то вернет null

//        interface Deque - двунаправленная очередь
        Queue<String> queue = new PriorityQueue<>(); // Queue это интерфейс, PriorityQueue - класс
        Queue<String> deque = new ArrayDeque<>(); // создавать объект надо на основе класса а не интерфейса!

//        для каждой строки
//        File txt = new File("путь к файлу от корня проекта");
        File txt = new File("src/collection.txt");
        List<String> lines = Files.readAllLines(txt.toPath()); // строки файла в коллекции
//        1. перевести в нижний регистр
//        2. убрать пробелы в начале и конце строки
//        3. поместить в коллекцию только не пустые слова (не пробелы) - каждое слово добавить на отдельну строку в
//        коллекции (разбиваем строку на слова, слово на новой строчке)
        System.out.println(lines);
//        создаем пустую коллекцию для слов
        List<String> wordsLst = new ArrayList<>();
        for (String str1: lines){ //идем по строкам коллекции через цикл
            String arrText [] = str1.split(" ");
            for (int i = 0; i < arrText.length; i ++) {
                wordsLst.add(arrText[i].toLowerCase().trim()); // действия со строками
            }
        }
        for (String wordL:wordsLst){
            System.out.println(wordL); // выводим результат
        }

//      доделал задание


     }
}
