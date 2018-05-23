package bankTask;

import java.util.Map;

public class Bank {
    User user;


    public synchronized static void transferMoney(Account src, Account dst, int value) throws InterruptedException {
        if (src.amount >= value) {
            dst.amount = +value;
            src.amount = -value;
            System.out.println("transaction is done");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        User user1 = bank.new User(123);
        Account account1 = bank.new Account(01,123, 2000);
        Account account2 = bank.new Account(02, 123, 1500);
        Account account3 = bank.new Account(03, 123, 1000);
        Account account4 = bank.new Account(04, 123, 3000);
        // необходимо синхронизтроваться на объектах аккаунт, чтобы можно было одновременно проводить несколько операций
        // с разными аккаунтами, несколькими потоками
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                    synchronized (bank){
                        try {
                            transferMoney(account1,account2,2500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                    synchronized (bank){
                        try {
                            transferMoney(account3, account1, 1300);
                            bank.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        };
        thread1.start();

        thread2.start();


    }



    private class Account {
        int amount;
        int id;
        int userId;
        public Account(int id, int userId, int amount){
            this.id = id;
            this.userId = userId;
            this.amount = amount;
        }

    }

    private class User {
        int userId;
        String email;
        Map<Integer, Account> accountMap;
        public User(int userId){
            this.userId = userId;
        }
    }
}
