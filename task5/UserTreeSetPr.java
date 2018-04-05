package task5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UserTreeSetPr<E> implements Iterable<E> {
    private Node<E> root;
    private List<E> list;
    private int size;

    public UserTreeSetPr() {
        list = new LinkedList<>();
        root = new Node<>(null);
    }

    public boolean add(E element) {
        if (size == 0) {
            return initRootNode(element);
        }

        Node<E> newNode = new Node<>(element);
        Node<E> lastNode = findLastNode(root, newNode);

        if (lastNode == null) return false;

        size++;
        newNode.parent = lastNode;

        if (lastNode.compareTo((E) newNode) < 0) {
            lastNode.setRight((Node<E>) newNode);
            return true;
        } else {
            lastNode.setLeft(newNode);
            return true;
        }
    }


    public Node find(E element) {
        Node<E> elNode = new Node<>(element);
        return search(root, elNode);
    }

    private Node<E> search(Node<E> node, Node<E> elNode) {
        int compare = node.compareTo((E) elNode);
        if (compare < 0 && node.right != null) {
            return search(node.right, elNode);
        }
        if (compare > 0 && node.left != null) {
            return search(node.left, elNode);
        }
        if (compare == 0) return node;
        return null;
    }

    // Поиск последнего узла для конкретного нового объекта
    private Node<E> findLastNode(Node<E> oldNode, Node<E> newNode) {
        Node<E> lastNode = oldNode;
        int compare = oldNode.compareTo((E) newNode);
        if (compare < 0 && oldNode.getRight() != null) {
            lastNode = findLastNode(oldNode.getRight(), newNode);
            return lastNode;
        }

        if (compare > 0 && oldNode.getLeft() != null) {
            lastNode = findLastNode(oldNode.getLeft(), newNode);
            return lastNode;
        }

        if (compare == 0) return null;
        return lastNode;
    }

    private boolean initRootNode(E element) {
        root.element = element;
        size++;
        return true;
    }

    public List<E> getList() {
        for (E e : this) {
            list.add(e);
        }
        return list;
    }

    public boolean remove(E element){
        Node<E> current = new Node<>(element);
        //Node<E> parent = new Node<>(null);
        current = find(current.element);
            //parent = current.parent;
            if (current == null) {
                return false;
            }
            size--;
            if (current.right == null && current.left!= null) {
                current.left.parent = current.parent;
                //   current.element = current.left.element;
            }
            if (current.right != null && current.left == null) {
                current.right.parent = current.parent;
                //    current.element = current.right.element;
            }
            if (current.right != null && current.right.right == null && current.right.left != null) {
                current.right.left.parent = current.parent;
                current.right.parent = current.right.left;
            }
            if(current.right == null && current.left==null){
                current.element = null;

            }
            return  true;
    }

    public E mostSmall(){
        Node<E> left = root.getLeft();
        if (left.left != null){
            return (E) left.left;
        }else{
            return (E) left.element;
        }
    }

    public E mostLarge(){
        Node<E> right = root.getRight();
        if (right.right != null){
            return (E) right.right;
        }else{
            return (E) right.element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;
            Iterator<Node<E>> iterator = new TreeIterator<>(root);

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public E next() {
                count++;
                return iterator.next().element;
            }
        };
    }

    private class TreeIterator<E> implements Iterator<Node<E>> {
        private Node<E> next;

        private TreeIterator(Node<E> root) {
            next = root;
            goToLeftMost();
        }

        private void goToLeftMost() {
            while (next.left != null) {
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null && next.element != null;
        }

        @Override
        public Node<E> next() {
            Node<E> r = next;
            if (next.right != null) {
                return goRight(r);
            }
            return goUp(r);
        }

        private Node<E> goRight(Node<E> r) {
            next = next.right;
            while (next.left != null) {
                next = next.left;
            }
                    return r;
                }


        private Node<E> goUp(Node<E> r) {
            while (true) {
                if (next.parent == null) {
                    next = null;
                    return r;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return r;
                }
                next = next.parent;
            }
        }
    }



    public int getSize() {
        return size;
    }

    class Node<E> implements Comparable<E> {
        private Node<E> parent; // ссылка на родительский узел
        private Node<E> right;
        private Node<E> left;
        private E element;

        private Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }


        @Override
        public int compareTo(E element) {
            Node<E> n = (Node<E>) element;
            return this.hashCode() - n.hashCode();
        }

        @Override
        public int hashCode() {
            int hash = 31;
            hash = hash * 17 + element.hashCode();
            return hash;
        }

    }


    public static void main(String[] args) {
        UserTreeSetPr<Integer> tree = new UserTreeSetPr<>();
        tree.add(1);
        tree.add(13);
        tree.add(-21);
        tree.add(6);
        //tree.add(20);
        //System.out.println(tree.getSize());


        System.out.println(tree.mostSmall());
        System.out.println(tree.mostLarge());
        System.out.println(tree.getSize());
       System.out.println(tree.remove(13));
        System.out.println(tree.getSize());
        System.out.println(tree.mostLarge());
//        //tree.getList().forEach(System.out::println);
//        System.out.println(tree.remove(12));
//        System.out.println(tree.remove(-21));
//        //tree.getList().forEach(System.out::println);
    }
}

//    public void add(E element){
//        if (root == null){
//            root = (Node<E>) element;
//        }else{
//            addTo(root, element);
//        }
//        size++;
//    }
//
//    private void addTo(Node<E> root, E value)
//    {
//        // Случай 1: Вставляемое значение меньше значения узла
//        if (root.compareTo(value) < 0)
//        {
//            // Если нет левого поддерева, добавляем значение в левого ребенка,
//            if (root.getLeft() == null)
//            {
//                root.setLeft((Node<E>) value);
//            }
//            else
//            {
//                // в противном случае повторяем для левого поддерева.
//                addTo(root.getLeft(), value);
//            }
//        }
//        // Случай 2: Вставляемое значение больше или равно значению узла.
//        else
//        {
//            // Если нет правого поддерева, добавляем значение в правого ребенка,
//            if (root.getRight() == null)
//            {
//                root.setRight((Node<E>) value);
//            }
//            else
//            {
//                // в противном случае повторяем для правого поддерева.
//                addTo(root.getRight(), value);
//            }
//        }
//    }



