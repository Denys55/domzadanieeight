import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.*;

public class MyHashMap<K, V> {

    private Node<K, V> []hashTable;
    private int size=0;
    private float threshold;

    public MyHashMap(){
        hashTable = new Node[16];
        threshold = hashTable.length*0.75f;
    }
    //добавляет пару ключ + значение
    public void put(K key, V value){
        Node<K, V> newNode = new Node<>(key, value);
        int index = key.hashCode()% hashTable.length-1;
        hashTable[index] = newNode;
        size++;
    }

    //удаляет пару по ключу
    public void remove(Object key){
        int index = key.hashCode()% hashTable.length-1;
        hashTable[index]=null;
        size--;

    }

    //очищает коллекцию
    public void clear() {
        for(Node s : hashTable){
            s=null;
        }
        size = 0;
    }

    //size() возвращает размер коллекции
    public int size(){
        return size;
    }

    //возвращает значение(Object value) по ключу
    public V get(Object key){
        int index = key.hashCode()% hashTable.length-1;
        return hashTable[index].getValue();
    }


    private int hash(Node<K, V> node){
        return node.hashCode()%hashTable.length;
    }

    private class Node<K, Y>{
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        private int hash(){
            return key.hashCode()%hashTable.length-1;
        }
        private K getKey(){
            return key;
        }
        private V getValue(){
            return value;
        }
        private void setValue(V value){
            this.value=value;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash*17+key.hashCode();
            hash = hash*17+ value.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }

            if(obj instanceof Node){
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Denis");
        map.put(2, "Sergei");
        map.put(3, "Victor");
        map.put(4, "Ilya");
        System.out.println(map.get(2));
        map.remove(3);
        map.put(2, "Jeka");
        System.out.println(map.get(2));
        map.clear();
        System.out.println(map.size());

    }

}
