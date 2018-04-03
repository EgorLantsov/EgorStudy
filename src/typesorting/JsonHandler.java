package typesorting;

public class JsonHandler {
    public String name;
    protected JsonHandler(String name){
        this.name = name;
        System.out.println(name);
    }
    public void text() {
        System.out.println("This Json File");
    }
}
