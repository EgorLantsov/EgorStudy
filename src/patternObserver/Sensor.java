package patternObserver;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private List<Alarm> alarms = new ArrayList<>();

    public  void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public void removeAlarm(Alarm alarm){
        alarms.remove(alarm);
    }

    public void alarmSignal(int temp){ // передаем всем устройствам температуру
        for (Alarm level: alarms){
            level.tempChanged(temp);
        }
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.addAlarm(new Green());
        sensor.addAlarm(new Yellow());
        sensor.addAlarm(new Red());
        sensor.alarmSignal(190);
        sensor.alarmSignal(280);
        sensor.alarmSignal(350);
        sensor.alarmSignal(275);


    }


}
