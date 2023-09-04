package listascirculares;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Tomás Chiriví
 */
public class ListasCirculares<Item extends Comparable<? super Item>> implements Iterable<Item> {

    //Atributos
    Node<Item> first;
    Node<Item> last;

    private class Node<Item> {

        //Atributos
        Item item;
        Node<Item> next;
        Node<Item> previous;

        //Constructor
        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
        //get y set

        public Node() {
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

    }
    //Constructor

    public ListasCirculares() {
        first = null;
        last = null;
    }

    public boolean search(Item item) {

        if (isEmpty()) {
            return false;
        } else {
            Node<Item> tmp = first;
            while (tmp != null) {
                if (tmp.getItem().equals(item)) {
                    return true;
                }
                tmp = tmp.next;
            }
            return false;

        }
    }

    public Item maxItem() {

        if (isEmpty()) {
            return null;
        }
        Node<Item> tmp = first;
        Item candidato = tmp.getItem();
        while (tmp != null) {
            if (candidato.compareTo(tmp.getItem()) < 0) {
                candidato = tmp.getItem();
            }
            tmp = tmp.next;
        }
        return candidato;

    }

    public boolean SonIguales(ListasCirculares<Item> otherList) {
        if (this.size() != otherList.size()) {
            return false;
        }
        Iterator<Item> thisIterator = this.iterator();
        Iterator<Item> otherIterator = otherList.iterator();

        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            Item thisItem = thisIterator.next();
            Item otherItem = otherIterator.next();

            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }
        return true;
    }

    public void addLast(Item item) {
        Node<Item> nuevo = new Node<>(item);

        if (isEmpty()) {
            nuevo.next = nuevo;
            nuevo.previous = nuevo;
            first = nuevo;
        } else {
            nuevo.next = first;
            nuevo.previous = first.previous;
            first.previous.next = nuevo;
            first.previous = nuevo;
        }
    }

    public void addFirst(Item item) {
        Node<Item> nuevo = new Node<>(item);

        if (isEmpty()) {
            nuevo.next = nuevo;
            nuevo.previous = nuevo;
        } else {
            nuevo.next = first;
            nuevo.previous = first.previous;
            first.previous.next = nuevo;
            first.previous = nuevo;
        }

        first = nuevo;
    }

    public void addInMiddle(Item item) {
        Node<Item> nuevo = new Node<Item>(item);
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
        } else {
            Node<Item> slowPtr = first;
            Node<Item> fastPtr = first;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }

            nuevo.next = slowPtr.next;
            slowPtr.next = nuevo;
            nuevo.previous = slowPtr;

            if (nuevo.next == null) {
                last = nuevo;
            }
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        Node<Item> tmp = first;
        int i = 0;
        while (tmp != null) {
            tmp = tmp.next;
            i++;
        }
        return i;
    }

    public void showList() {

        Node<Item> tmp = first;
        do {
            System.out.println(tmp.getItem());
            tmp = tmp.next;
        } while (tmp != first);

    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public Iterator<Item> clockwiseIterator() {
        return new ClockwiseListIterator<Item>(first);
    }

    private class ClockwiseListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;
        private boolean firstIteration = true;

        public ClockwiseListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null && (firstIteration || current != first);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            firstIteration = false;
            return item;
        }
    }

    public Iterator<Item> counterClockwiseIterator() {
        return new CounterClockwiseListIterator<Item>(first);
    }

    private class CounterClockwiseListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;
        private boolean firstIteration = true;

        public CounterClockwiseListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null && (firstIteration || current != first);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.previous;
            firstIteration = false;
            return item;
        }
    }

}
