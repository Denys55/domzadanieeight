
public class MyyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyyLinkedList() {
        size =0;
    }
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        Node(E item){
            this.item = item;
        }
    }

    //добавляет элемент в конец
    public void add(E value){
        Node newNode = new Node(value);
        if( first == null) first = newNode;
        else{
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }


    private Node<E> getNodeByIndex(int index){
        if(index<0 || index>=size) throw new IndexOutOfBoundsException("Index "+ index +", Size "+size);
        Node<E> result;
        if(size/2 > index) {
            result=first;
            for (int i = 0; i < index; i++) result = result.next;
        }
            else {
                result=last;
                for(int i = size-1; i>index; i-- ) result = result.previous;
        }
            return result;
    }

    //удаляет элемент под индексом
    public void remove(int index){
        Node<E> node = getNodeByIndex(index);
        if(node.previous == null) first = node.next;
        else node.previous.next = node.next;
        if(node.next == null) last = node.previous;
        else node.next.previous = node.previous;
        size--;
    }

    //очищает коллекцию
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    //возвращает размер коллекции
    public int size(){
        return size;
    }

    //возвращает элемент под индексом
    public E get(int index){
        return getNodeByIndex(index).item;
    }


    public static void main(String[] args) {
        MyyLinkedList<String> list = new MyyLinkedList<>();
        list.add("Hello");
        list.add("Java");
        list.add("World");
        System.out.println(list.size);
        System.out.println(list.get(2));
        list.remove(1);
        System.out.println(list.size);
        list.clear();
        System.out.println(list.size);

    }



}
