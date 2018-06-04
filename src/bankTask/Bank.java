package bankTask;

import java.util.Map;

public class Bank {
    User user;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // сделать потокобезопасный метод
    public static void transferMoney(Account src, Account dst, int value) throws InterruptedException {
      Account from = src;
      Account to = dst;
      if (from.hashCode() >= to.hashCode()){
          from = dst;
          to = src; // меняем местами
      }
        synchronized (src) {
            synchronized (dst) {
                // нужно чтобы была синхронизация на двух объектах и не было дедлока
                if (src.amount >= value) {
                    dst.amount += value;
                    src.amount -= value;
                    System.out.println("transaction is done, money left: " + src.amount);
                }
            }
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
                try {
                    transferMoney(account1, account2, 500);
                    System.out.println("thread 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    transferMoney(account2, account1, 500);
                    System.out.println("thread 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
