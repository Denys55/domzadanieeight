import java.util.ArrayList;

public class MyQueue<E>{

    private E[] queue;
    private int top = 0;
    private int initialCapacity;


    public MyQueue() {
        this.initialCapacity= 16;
        this.queue=((E[])new Object[initialCapacity]);
    }

    //добавляет элемент в конец
    public void add(E e){
        queue[top] = e;
        top++;
    }

    //вывожу полностью в консоль
    public void show(){
        for(int i = 0; i<top; i++){
            System.out.println(queue[i] + " ");
        }
    }

    //возвращает первый элемент в очереди и удаляет его из коллекции
    public E poll(){
        E data;
        data = queue[0];
        queue[0]=null;
        for(int i= 1; i<top; i++){
            queue[i-1] = queue[i];
        }
        top--;
        return data;
    }

    //возвращает первый элемент в стеке (FIFO)
    public E peek(){
        E data;
        data = queue[0];
        return data;
    }

    //удаляет элемент под индексом
    public void remove(int index) {
        if (index < 0 || index > top - 1) {
            throw new IllegalArgumentException();
        } else {
            queue[index] = null;
            for (int i = index; i < top; i++) {
                queue[i] = queue[i + 1];
            }
            top--;
        }
    }

    //очищает коллекцию
    public void clear(){
        for(int i = 0; i<queue.length; i++){
            queue[i]=null;
        }
        top=0;
    }

    //возвращает размер коллекции
    public int size (){
        return top;
    }

    public static void main(String[] args) {
        MyQueue<String> list = new MyQueue<>();
        list.add("Denis");
        list.add("Petr");
        list.add("Nikolay");
        list.add("Vladislav");
        list.show();
        System.out.println(list.size());
        list.remove(3);
        list.show();
        System.out.println(list.size());
        String s = list.poll();
        System.out.println("--------");
        System.out.println(s);
        list.show();
        System.out.println(list.size());
        System.out.println("1 element in queue - "+list.peek());



    }

}
