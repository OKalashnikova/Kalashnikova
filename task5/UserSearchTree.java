package task5;

public class UserSearchTree<E> {

    Node root;
    public int size;
    public int ask;

    public class Node {
        int key;
        E value;
        Node left;
        Node right;
        Node parent;


        public Node(int key, E value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getValue() {
            return value;
        }
    }


    public Node getRoot() {
        return root;
    }

    //// ADD
    public boolean add(int key, E value) {
        ask = 0;
        //Node t = root;
        if (root == null) {
            root = new Node(key, value, null, null, null);
            size++;
        } else if (root != null) {
            addTo(root, null, key, value);
            if (ask == -1) {
                return false;
            } else {
                size++;
            }
        }
        return true;
    }

    void addTo(Node t, Node p, int key, E value) {
        if (key == t.key) {
            ask = -1;
            System.out.println("Exist key " + key);
        }
        if (key < t.key) {
            if (t.left == null) {
                t.left = new Node(key, value, t, null, null);
            } else {
                addTo(t.left, t, key, value);
            }
        } else if (key > t.key) {
            if (t.right == null) {
                t.right = new Node(key, value, t, null, null);
            } else {
                addTo(t.right, t, key, value);
            }
        }
    }

    //// CONTAINS
    public boolean contains(Node node, E value) {

    if(containsL(node, value)) {
        return false;
    }else
   return containsR(node, value);


}

    boolean containsL(Node node, E value) {
        if (node.value == value) return true;
        if (node.left != null) return containsL(node.left, value);
        else return false;
    }

    boolean containsR(Node node, E value) {
        if (node.value == value) return true;
        if (node.right != null) return containsR(node.right, value);
        else return false;
    }

    //// ISEMPTY
    public boolean isEmpty() {
        return size == 0;
    }


    Node f(Node node, int key) {
        while (node != null) {
            if (node.key > key) {
                node = node.left;
            }
            if (node.key < key) {
                node = node.right;
            }
            else return node;
        }
        return null;
    }

    public boolean remove(int key) {
        Node found = f(root, key);
        if (found == null) {
            System.out.println("Объекта с таким ключом " + key + " не существует");
            return false;
        }
        if (found.left == null && found.right == null) {
            Node par = found.parent;
            if(found.key >par.key) par.right = null;
            else par.left = null;
            --size;
            return true;
        } else if (found.left != null && found.right == null) {
            found.left.parent = found.parent;
            Node par = found.parent;
            par.left = found.left;
            --size;
            return true;
        } else if (found.right != null && found.right.left == null) {
            found.right.parent = found.parent;
            Node par = found.parent;
            par.right = found.right;
            --size;
            return true;
        } else if (found.right != null && found.right.left != null) {
            Node leaf = found.right.left;
            if(leaf.left != null) {
                leaf = leaf.left;
            }else {
                Node leafParentNull = leaf.parent;
                leafParentNull.left = null;
                leaf.parent = found.parent;
                leaf.right = found.right;
                leaf.left = found.left;
                Node par = found.parent;
                par.right = leaf;
                --size;
                return true;
            }
        }

        return false;
    }

    /// THE BIGGEST && THE LESS KEY

    public int findRightLeaf(Node node) {
        if (node.right != null) {
            return findRightLeaf(node.right);
        }
        return node.key;
    }

    public int findLeftLeaf(Node node) {
        if (node.left != null) {
            return findLeftLeaf(node.left);
        }
        return node.key;
    }

    //// PRINT
    void print(Node t) {
        if (t != null) {
            print(t.left);
            System.out.print("key: " + t.key + " value: " + t.value + " " + "\n");
            print(t.right);
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

    //// SIZE
    public int size() {
        return size;
    }

}

