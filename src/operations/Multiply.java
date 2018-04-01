package operations;

public class Multiply extends Operation{
    @Override
    protected int execute (int a, int b){
        System.out.println("Multiply execute " + (a * b));
    return a * b;
    }
}
