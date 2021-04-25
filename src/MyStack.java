public class MyStack<E> {
    private E[] stack;
    private int top = 0;
    private int initialCapacity;


    public MyStack() {
        this.initialCapacity= 16;
        this.stack=((E[])new Object[initialCapacity]);
    }

    //добавляет элемент в конец
    public void push(E e){
        stack[top] = e;
        top++;
    }

    //вывожу полностью стек в консоль
    public void show(){
        for(int i = 0; i<top; i++){
            System.out.println(stack[i] + " ");
        }
    }

    //возвращает первый элемент в стеке и удаляет его из коллекции
    public E pop(){
        E data;
        top--;
        data = stack[top];
        stack[top]=null;
        return data;
    }

    //возвращает первый элемент в стеке (LIFO)
    public E peek(){
        E data;
        data = stack[top-1];
        return data;
    }

    //удаляет элемент под индексом
    public void remove(int index) {
        if (index < 0 || index > top - 1) {
            throw new IllegalArgumentException();
        } else {
            stack[index] = null;
            for (int i = index; i < top; i++) {
                stack[i] = stack[i + 1];
            }
            top--;
        }
    }

        //очищает коллекцию
    public void clear(){
        for(int i = 0; i<stack.length; i++){
            stack[i]=null;
        }
        top=0;
    }

    //возвращает размер коллекции
    public int size (){
        return top;
    }




    public static void main(String[] args) {
        MyStack<String> test = new MyStack<>();
        test.push("Denis");
        test.push("Kolya");
        test.push("Victor");
        test.show();
        System.out.println("------");
        test.remove(2);
        test.show();
        String s = test.peek();
        System.out.println(s);
        System.out.println("------");
        String s1 = test.pop();
        System.out.println(s1);
        System.out.println("------");
        test.show();

    }





}
