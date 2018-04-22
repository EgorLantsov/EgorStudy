package task;
// задание 2
// Написать LinkedList, Stack, Queue - generic

public class TaskQueue<T> {

    private QueueBox<T> head;
    private QueueBox<T> end;
    int size;

    public void push(T object){
        QueueBox<T> obj = new QueueBox<T>();
        obj.setObject(object);
        if (head == null){ // если первый объект в очереди
            head = obj;
        } else {
            end.setNext(obj); // если в очереди уже были объекты
        }
        end = obj;
        size++;
    }

    public T pull(){
        if (size == 0){
            return null;
        }
        T obj = head.getObject();
        head = head.getNext();

        if (head == null){
            end = null;
        }
        size --;
        return obj;
    }

    public int sizeQueue(){
        return size;
    }

    public static void main(String[] args) {
        TaskQueue<String> task = new TaskQueue<>();
        task.push("Hello");
        task.push("Are");
        task.push("You");
        task.push("Ok?");
        while (task.size > 0) {
            System.out.println(task.pull());
        }

    }

///вложенный класс
    private class QueueBox <T>{
        T object;
        QueueBox<T> next; // ссылка на следующий объект

        public void setObject(T obj){
            this.object = obj;
        }

        public T getObject(){
            return object;
        }

        public void setNext(QueueBox<T> next){
            this.next = next;
        }

        public QueueBox<T> getNext() {
            return next;
        }
    }

}
