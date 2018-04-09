package mydiary;

import java.util.ArrayList;

public class Month {
    ArrayList<String> days = new ArrayList<>(31);

    public void setDaytext(int day, String text){
        days.add((day-1),text);
        System.out.println("Days " + days.size());
    }
    public String getDaytext(int day){
        return days.get(day-1);
    }
//    public void getDaytext(int day){
//        System.out.println(days.size());
////        return days.get(day-1);
//    }

}
