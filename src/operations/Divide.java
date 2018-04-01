package operations;

public class Divide extends Operation {
    @Override
    protected int execute (int a, int b){
        System.out.println("Divide execute " + (a / b));
    return a / b;
    }
}
