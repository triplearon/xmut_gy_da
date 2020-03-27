import java.util.Iterator;
import java.util.NoSuchElementException;


class Stack<Item> implements Iterable<Item> {
    @SuppressWarnings("unchecked")
    private Item[] a=(Item []) new Object[1];   //stack entries
    private int N;      //size

    public Stack(){}
    @SuppressWarnings("unchecked")
    public Stack(int size){
        a=(Item []) new Object[size];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if(N == a.length) this.resize(a.length*2);

        a[N++] = item;
    }

    public Item pop() {
        Item item=a[--N];

        a[N]=null;

        if (N < a.length/4) this.resize(a.length/2);

        return item;
    }
    @SuppressWarnings("unchecked")
    private void resize(int max){
        Item[] ans=( Item[] ) new Object[max];

        if (N >= 0) System.arraycopy(this.a, 0, ans, 0, N);

        this.a=ans;
    }

    public Item peek(){


        return a[N-1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            if (i == 0) throw new NoSuchElementException();
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
