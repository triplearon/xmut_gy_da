import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private class Node{
        Node next;
        Item item;
        Node(Item item, Node next){
            this.next=next;
            this.item=item;
        }
    }
    private Node first;
    private int N;

    public void add(Item item){
        Node oldFirst=first;
        first=new Node(item,oldFirst);
        N++;
    }

    public boolean isEmpty(){
        return N==0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current=first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
