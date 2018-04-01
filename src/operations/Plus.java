package operations;

public class Plus extends  Operation {
    @Override
    protected int execute(int a, int b){
        System.out.println("Plus execute " + (a + b));
        return a + b;
    }
}
