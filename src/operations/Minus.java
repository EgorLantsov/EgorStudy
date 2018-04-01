package operations;

public class Minus extends  Operation {
    @Override
    protected int execute(int a, int b){
        System.out.println("Minus execute " + (a - b));
    return a - b;
    }
}
