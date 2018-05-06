package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectedtoString {

    public static String toString(Object o) throws IllegalAccessException {
    Class unknownClass = o.getClass();
        Map<String, Object> fieldMap = new HashMap<>();
        Field[] fields = unknownClass.getFields(); // получаем все поля в массив
        for (int i = 0; i < fields.length; i ++){ // перебираем массив полей
            Field tempField = fields[i]; // получаем конкретное поле из массива
            Object value = tempField.get(o); // получаем значение данного поля
            String fieldName = tempField.getName(); // получаем имя поля
            fieldMap.put(fieldName,value); // помещаем в мап, ключ это имя поля
        }

        Field[] decFields = unknownClass.getDeclaredFields(); // массив приватных полей
        for (int i = 0; i < decFields.length; i++){ // пробегаем по массиву
            Field privateField = decFields[i]; // берем конкретное приватное поле
            privateField.setAccessible(true); // делаем его доступным для чтения
            Object prValue = privateField.get(o); // получаем значение приватного поля
            String prFieldName = privateField.getName(); // получаем имя приватного поля
            fieldMap.put(prFieldName,prValue); // помещаем в то же отобраение что и обычные поля
        }

    return fieldMap.toString();
}

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(toString(new SomeClass()));
    }
}
