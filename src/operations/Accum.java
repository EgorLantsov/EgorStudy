package operations;

public class Accum {
    private int value;
    private Operation operation; //потому что у операции будем вызывать метод execute
    public Accum(Operation operation, int value) {
                this.value = value;
                this.operation = operation;
    }

    protected void accum(int someInt){
        this.value = this.operation.execute(this.value, someInt); // присвоение результата в value
    }
    public int getValue(){
        return this.value;
    }

    public static void main(String[] args) {
        Accum acc = new Accum(new Plus(), 3);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());
    }
}
// добавить классы вычитания умножения и деления