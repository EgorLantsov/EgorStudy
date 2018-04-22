package task;

// написать Stack в Generic
public class TaskStack<T> {
    StackBox<T> first;
    StackBox<T> last;
    int size;

    public void pushElem(T element){
        StackBox<T> ob = new StackBox<>();
        ob.setObject(element);
        if (first == null){
            first = ob;
        } else {
            last.setNext(ob); // создаем ссылку на текущий объект
            ob.setPrev(last); // текущему объекту создаем ссылку на последний объект который станет предыдущим
        }
        last = ob; // текущий объект делаем последним
        size ++;
    }

    public T pullElem(){
        if (size == 0){
            return null;
        }
        T obj = last.getObject();
        last = last.getPrev();
        if (last == null){
            first = null;
        }
        size --;
        return obj;
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        TaskStack<String> taskStack = new TaskStack<>();
        taskStack.pushElem("Ooops this is first");
        taskStack.pushElem("this is second");
        taskStack.pushElem("this is third");
        taskStack.pushElem("and forth");
        while (taskStack.size > 0){
            System.out.println(taskStack.pullElem());
        }

    }


    ///вложенный класс
    private class StackBox <T>{
        T object;
        StackBox<T> next; // ссылка на следующий объект
        StackBox<T> prev; // ссылка на предыдущий объект

        public void setObject(T obj){
            this.object = obj;
        }

        public T getObject(){
            return object;
        }

        public void setNext(StackBox<T> next){
            this.next = next;
        }

        public StackBox<T> getNext() {
            return next;
        }

        public void setPrev(StackBox<T> prev){
            this.prev = prev;
        }

        public StackBox<T> getPrev() {
            return prev;
        }
    }
}
