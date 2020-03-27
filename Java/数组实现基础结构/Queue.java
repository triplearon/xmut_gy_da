
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private int st;
    private int index;
    @SuppressWarnings("unchecked")
    private Item[] a=(Item[]) new Object[1];

    public boolean isEmpty(){
        return index==0;
    }

    public int size(){
        return a.length;
    }

    public void enQueue(Item item){
        a[index++]=item;

        if (index >=a.length) enlarge();


    }

    public Item exQueue(){
        Item item=a[st++];
        a[st-1]=null;
        if (index-st <= a.length/4) shorten();
        return item;
    }

    public Item get(int i){
        return a[i];
    }
    @SuppressWarnings("unchecked")
    private void enlarge(){
        Item[] temp=(Item[])new Object[this.a.length*2];

        System.arraycopy(a, 0, temp, 0, a.length);

        a=temp;

    }
    @SuppressWarnings("unchecked")
    private void shorten(){
        Item[] temp=(Item[])new Object[this.a.length/2];
        for (int i = 0; st < index ; i++) {
            temp[i]=a[st++];
        }
        st=0;index/=2;
        a=temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int n;


        @Override
        public Item next() {

            return a[n++];
        }

        @Override
        public boolean hasNext() {
            return n!=index;
        }
    }

}
