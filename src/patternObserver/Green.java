package patternObserver;

public class Green implements Alarm {
    int counter = 0;
    @Override
    public void tempChanged(int temp) {
        if (temp >= 100 && temp < 300) {
            counter++;
            if (counter == 1) {
                System.out.println("Green alarm!");
            }
        } else if (temp < 100 || temp >= 300){
            counter = 0;
        }
    }
}
