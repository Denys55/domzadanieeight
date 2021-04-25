public class MyArrayList <E> {

    private E[]array;
    private int initialCapacity;
    private int pointer = 0;



    public MyArrayList() {
        this.initialCapacity= 16;
        this.array=((E[])new Object[initialCapacity]);
    }
    //добавляет элемент в конец
    /*public boolean add(E e){

        for(int i = 0; i<array.length; i++){
            if(array[i] == null){
                array[i] = e;
                return true;
            }
        }
        return false;
    }

     */

    public void add(E item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = (E[]) newArray;
    }



    //удаляет элемент под индексом
    public E remove(int index){
        E tmp = array[index];
        if(index < size()){
            array[index] = null;
            createNewArray(array);
        }
        return tmp;

    }

    private void createNewArray(E[] array){
        E[] newArray = ((E[]) new Object[array.length]);
        int j = 0;
        for(int i = 0; i< newArray.length; i++){
            newArray[j] = (array[i]!=null) ? array[i] : array[++i];
            j++;
            if(array[i]==null && i+1 < initialCapacity && array[i+1]==null){
                break;
            }
        }
        this.array = newArray;
    }


    //очищает коллекцию
    public void clear(){

        for(int i = 0; i<array.length; i++){
            array[i]=null;
        }

    }

    //размер массива
    public int length(){
        return array.length;
    }


    //возвращает размер коллекции
    public int size(){
        for(int i = 0; i < array.length; i++){
            if(array[i]==null) {
                return i;
            }

        }
        return 0;
    }

    //возвращает элемент под индексом
    private E get(int index){
        return (E)array[index];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(9);
        System.out.println(arr.length());
        System.out.println(arr.get(0));
        System.out.println(arr.size());
        arr.remove(0);
        System.out.println(arr.get(0));
        arr.clear();
        System.out.println(arr.size());

    }
}
