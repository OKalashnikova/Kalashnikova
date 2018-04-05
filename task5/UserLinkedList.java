package task5;


import java.util.Iterator;

public class UserLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    static int size;

    public UserLinkedList() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null, null, last);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    public class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> previouseElement;

        public Node(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node(E currentElement, Node<E> previouseElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.previouseElement = previouseElement;
        }


        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public Node<E> getPreviouseElement() {
            return previouseElement;
        }

        public void setPreviouseElement(Node<E> previouseElement) {
            this.previouseElement = previouseElement;
        }

    }

    public void add(E currentElement) {
        Node<E> prev = last;
        prev.setCurrentElement(currentElement);
        last = new Node<E>(null, prev, null);
        prev.setNextElement(last);
        size++;
    }

//    public void addFirst(E currentElement) {
//        Node<E> next = first;
//        next.setCurrentElement(currentElement);
//        first = new Node<E>(null, null, next);
//        next.setPreviouseElement(first);
//        size++;
//    }

    public E getElementByIndex(int counter) {
        Node<E> target = first.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextElement2(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement2(Node<E> current) {
        return current.getNextElement();
    }

//    private Node<E> getPreviousElement2(Node<E> current) {
//        return current.getPreviouseElement();
//    }

    public boolean contains(E currentElement) {
        Node<E> current = first.getNextElement();
        while (current != null) {
            if (current.getCurrentElement().equals(currentElement)) {
                return true;
            }
            current = current.getNextElement();
        }
        return false;
    }

    public static int size() {
        return size;
    }

    public boolean isEmpty() {
        boolean result;
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(E value) {
        Node<E> current = first;
        while (current.getNextElement() != null) {
            if (current.getNextElement().getCurrentElement().equals(value)) {
                current.setNextElement((Node<E>) current.getNextElement().getNextElement());
                --size;
                return true;
            }
            current = current.getNextElement();
            if (current.getNextElement().getCurrentElement() == null) break;
    }
    return false;
}


//    public static void main(String[] args) {
//        UserLinkedList<String> stringLinked = new UserLinkedList<>();
//        stringLinked.add("abc");
//        stringLinked.add("de");
//        System.out.println(size());
//        System.out.println(stringLinked.getElementByIndex(1));
//        stringLinked.add("abc");
//        stringLinked.add("abc2");
//        stringLinked.add("abc3");
//
//        for (String s : stringLinked) {
//            System.out.println(s);
//        }
//        // System.out.println(stringLinked.remove("abc2"));
//        stringLinked.contains("abc2");
//        stringLinked.remove("abc2");
//        System.out.println(stringLinked.remove("ab"));
//        for (String s : stringLinked) {
//            System.out.println(s);
//        }
//    }
}
