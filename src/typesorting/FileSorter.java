package typesorting;

//Pеализовать простое средство для считывания и записи информации из конфигурационных файлов.
//Реализацию механизмов чтения/записи файла опустим, чтобы сосредоточить внимание на структере кода
//Ханние данных в файле в формате ключ:значение
//
//За работу с каждым типом файла будет отвечать отдельный класс (например, XmlHandler, JsonHandler и тд),
// в родительском классе будет реализован метод getInstanse(), он, в зависимости от переданного
// в него имени файла, будет определять, к какому типу он относится и возвращать объект! соответствующего класса
//(например, return new XmlHandler(), return new JsonHandler() и тд).

public class FileSorter {

    public Object getIntanse(String fileName){ //передаем имя файла и возвращаем соответствующий имени объект
        switch (fileName) {
            case "XmlHandler": {
                return new XmlHandler(fileName);

            }
            case "JsonHandler": {
                return  new JsonHandler(fileName);

            }
            case "SqlHandler": {
                return  new SqlHandler(fileName);

            }
            default: return  null;
        }

    }

    public static void main(String[] args) {
    FileSorter sort = new FileSorter();
        sort.getIntanse("XmlHandler");
        sort.getIntanse("SqlHandler");
        sort.getIntanse("JsonHandler");
        Object file = sort.getIntanse("XmlHandler");
        Object fileS = new XmlHandler("XmlHandler");
//        fileS.text(); // почему я не могу обратиться к методу объекта?

    }
}
