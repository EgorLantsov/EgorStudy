package patternObserver;

public class Yellow implements Alarm {
    int counter = 0;
    @Override
    public void tempChanged(int temp) {
        if (temp >= 300 && temp < 600) {
            counter++;
            if (counter == 1) {
                System.out.println("Green alarm! Yellow alarm!");
            }
        } else if (temp < 300 || temp >= 600){
            counter = 0;
        }
    }
}
