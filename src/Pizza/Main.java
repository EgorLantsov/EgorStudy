package Pizza;

import java.util.Map;

public class Main {
    private boolean ready;
    Order order;
    private static Waiter waiter;
    private static Cooker cooker;

    public Main(Order order){
        this.order = order;
    }

    public void notifyCustomer(){
        synchronized (this){
            this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main(new Order("Pizza"));
        waiter = main.new Waiter();
        cooker = main.new Cooker();
        waiter.start();
        cooker.start();
//        main.notify();

        Thread.sleep(2000);

        waiter.notifyWaiter();
        synchronized (main){
            main.wait();
            System.out.println("Order got!");
        }

//        waiter.join();
//        cooker.join();

    }


    private class Waiter extends Thread{
        private Object momitor = new Object();

        public Waiter() {
            super("WaiterThread");
        }

        @Override
        public void run() {
            while(!isInterrupted()){
                synchronized (momitor){
                    try {
                        momitor.wait();
                        if (ready){
                            System.out.println("Waiter");
                            System.out.println("Notifying cooker");
                            cooker.notifyCooker();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        public void notifyWaiter() {
            synchronized (momitor) {
                ready = true;

                momitor.notify();
            }
        }
    }

    private class Cooker extends Thread{
        private Object momitor = new Object();

        public Cooker() {
            super("CookerThread");
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                synchronized (momitor){
                    try {
                        momitor.wait();
                        if (ready){
                            System.out.println("Cooker");
                            System.out.println("Cooking...");

                            sleep(1000);

                            System.out.println("Order is ready");
                            notifyCustomer();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        public void notifyCooker() {
            synchronized (momitor) {
                ready = true;

                momitor.notify();
            }
        }
    }
}
