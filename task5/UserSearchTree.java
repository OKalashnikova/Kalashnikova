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

    // public UserSearchTree() {
    //   this.root = root;
    // }

    public Node getRoot() {
        return root;
    }

    //// ADD
    public boolean add(int key, E value) {
        ask = 0;
        if (size == 0) {
            root = new Node(key, value, null, null, null);
            size++;
        } else if (size != 0) {
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
//    Node containsL(Node node, E value) {
//        if (node == null) return null;
//        if (node.value == value) return node;
//        if (node.left != null) {
//            if (node.left.value == value) {
//                return node.left;
//            }
//        }
//        return null;
//    }
//
//    Node containsR(Node node, E value) {
//        if (node == null) return null;
//        if (node.value == value) return node;
//        if (node.right != null) {
//            if (node.right.value == value) {
//                return node.right;
//            }
//        }
//        return null;
//    }
//
//    public boolean contains(E value) {
//        Node nL = containsL(root, value);
//        Node nR = containsR(root, value);
//        if (nL == null && nR == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }


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


//    /// REMOVE
//    Node leftKey(Node node, int findKey) {
//        if (node.key == findKey) return node;
//        if (node.key < findKey && node.left != null)
//        {
//            return leftKey(node.right, findKey);
//        }
//        else return null;
//    }
//
//
//    Node rightKey(Node node, int findKey) {
//        if (node.key == findKey) return node;
//        if (node.key < findKey && node.right != null)
//{
//                return rightKey(node.right, findKey);
//            }
//        else return null;
//    }
//
//
//    Node f(Node node, int key) {
//        if (node.key == key) return node;
//        Node fnode = leftKey(node, key);
//        if (fnode!= null) {
//                return fnode;
//            }
//            return rightKey(node, key);
//    }

    Node f(Node node, int key) {
        while (node != null) {
            if (node.key > key) {
               node = node.left;
            }
            if (node.key < key) {
               node = node.right;
            }
            else break;
        }
        return node;
    }

    public boolean remove(int key) {
        Node found = f(root, key);
        if (found == null) {
            System.out.println("Объекта с таким ключом " + key + " не существует");
            return false;
        }
        if (found.left == null && found.right == null) {
            found = null;
            --size;
            return true;
        } else if (found.left != null && found.right == null) {
            found.left.parent = found.parent;
            found = null;
            --size;
            return true;
        } else if (found.right != null && found.right.left == null) {
            found.right.parent = found.parent;
            found = null;
            --size;
            return true;
        } else if (found.right != null && found.right.left != null) {
            Node leaf = found.right.left;
            if(leaf.left != null) {
                leaf = leaf.left;
            }else {
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

