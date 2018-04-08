package typesorting;

public class ParamHandler {
    String name;
    public ParamHandler(String fileName){
        this.name = fileName;
    }
    public static ParamHandler getIntanse(String fileName){
        if (fileName.endsWith("Json")){
            return new JsonHandler(fileName);
        }
        else if (fileName.endsWith("Xml")){
            return new XmlHandler(fileName);
        }
        else {
            return new SqlHandler(fileName);
        }
    }

    public void read(){
      System.out.println("reading... " + name);
    }
    public void write(){
        System.out.println("writing/// " + name);
    }
    public static void main(String[] args) {
        ParamHandler handler = getIntanse("Play.Sql"); // тип объекта должен быть родительского класса
        handler.read();
        ParamHandler handler1 = getIntanse("Stack.Xml");
        handler1.write();

    }
}
