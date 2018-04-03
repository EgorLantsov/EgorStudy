package typesorting;

public class SqlHandler {
    public String name;
    protected SqlHandler(String name){
        this.name = name;
        System.out.println(name);
    }
    public void text() {
        System.out.println("another Sql file");
    }
}
