package reflection;

public class SomeClass {

    private String word = "what";
    public int count = 45;
    private double speed = 128.4;
    @Exclude(Exclude = "toString")
    String say = "Hello world";
    public String answer = "Yes";
}
