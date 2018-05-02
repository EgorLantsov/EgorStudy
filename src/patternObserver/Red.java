package patternObserver;

public class Red implements Alarm {
    int counter = 0;
    @Override
    public void tempChanged(int temp) {
        if (temp >= 600) {
            counter++;
            if (counter == 1) {
                System.out.println("Green alarm! Yellow alarm! Red alarm!");
            }
        } else if (temp < 600){
            counter = 0;
        }
    }
}
