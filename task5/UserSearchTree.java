package task5;

public class UserSearchTree<E> {

    Node root;
    public int size;

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

    public UserSearchTree() {
        this.root = root;
    }

    //// ADD
    public boolean add(int key, E value) {
        if (size == 0) {
            root = new Node(key, value, null, null, null);
            size++;
        } else {
            addTo(root, null, key, value);
            size++;
        }
        return true;
    }

    void addTo(Node t, Node p, int key, E value) {
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

        } else {
            System.out.println("Exist key " + key);
            --size;
        }
    }

    //// CONTAINS
    Node containsL(Node node, E value) {
        if (node == null) return null;
        if (node.value == value) return node;
        if (node.left != null) {
            if (node.left.value == value) {
                return node.left;
//            } else {
//                contains(node.left, value);
//            }
//        } else if (node.right != null) {
//            if (node.right.value == value) return node.right;
//            else contains(node.right, value);
            }
        }return null;
    }

    Node containsR(Node node, E value) {
        if (node == null) return null;
        if (node.value == value) return node;
        if (node.right != null) {
            if (node.right.value == value) {
                return node.right;
            }
        }return null;
    }

    public boolean contains(E value) {
        Node nL = containsL(root, value);
        Node nR = containsR(root, value);
        if (nL == null && nR == null) {
            return false;
        } else {
            return true;
        }
    }

    //// ISEMPTY
    public boolean isEmpty() {
        if (size() == 0) return true;
        else return false;
    }

    /// REMOVE

    Node leftKey(Node node, int findKey) {
        if (node.key > findKey)
            return leftKey(node.left, findKey);
        if (node.key == findKey) return node;
        else return null;
    }

    Node rightKey(Node node, int findKey) {
        if (node.key > findKey)
            return rightKey(node.right, findKey);
        else return node;
    }

    Node removeFind(int key) {
        Node find = root;
        if (find.key > key) {
            leftKey(find, key);
            if (find.key == key) return find;
            if (find.key < key) {
                rightKey(find, key);
                if (find.key == key) return find;
            }
        }
        return find;
    }

    public boolean remove(int key) {
        Node found = removeFind(key);
        if (found.left == null && found.right == null) {
            found = null;
            --size;
            return true;
        } else if (found.left != null && found.right == null) {
            found.left.parent = found.parent;
            found = null;
        } else if (found.left == null && found.right != null) {
            if (found.right.left == null) {
                found.right.parent = found.parent;
                found = null;
                --size;
            } else {
                Node leaf = findRightLeaf(found.right.left);
                leaf.parent = found.parent;
                leaf.right = found.right;
                leaf.left = found.left;
                found = null;
                --size;
                return true;
            }
        }

        return false;
    }

    Node findRightLeaf(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return findRightLeaf(node.right);
        }
    }


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


