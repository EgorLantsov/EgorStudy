package mydiary;

import mydiary.monthss.October;

import java.util.ArrayList;

public class MyDiary {
    protected ArrayList<Month> months = new ArrayList<>(12);
// через цикл for добавить в массив объекты (индекс = new Object()) проверить где ошибка
    public void setNote(Month month, int day, String text){
        month.setDaytext(day,text);
        months.add(month);
        System.out.println("month " + months.size());

    }

    public String getNote(Month month, int day){
//        month.getDaytext(day);
        System.out.println(month.getDaytext(day));
        return month.getDaytext(day);
    }


    public static void main(String[] args) {
        MyDiary fdiary = new MyDiary();
        Month october = new October(); // предварительно создали объект October с ссылкой october
        fdiary.setNote(october,1,"Hello"); //Здесь поместили ссылку на объект October в список массивов
        System.out.println(fdiary.months.indexOf(october)); // объект без ссылки нельзя вытащить из массива*
        fdiary.getNote(october,1);

    }
}

