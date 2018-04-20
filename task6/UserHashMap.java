package task6;


public class UserHashMap<K, V> {
    Node<K, V>[] table;
    public int countKeys;
    private int threshold;

    // На тот случай, если под одним ключом будет храниться несколько объектов
    //public LinkedList<Node> list = new LinkedList();


    public UserHashMap(int i) {
        int j = setThreshold(i);
        table = new Node[j];
    }


    public int getThreshold() {
        return threshold;
    }


    public int setThreshold(int threshold) {
        return this.threshold = threshold;
    }


    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public String toString() {
            return "key " + key + ", value " + value;
        }
    }

    private int hash(K key) {
        return key.hashCode() % getThreshold();
    }

    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }
        int hash = hash(key);
        Node<K, V> newNode = new Node<K, V>(key, value, null);
        if (table[hash] == null) {
            table[hash] = newNode;
            System.out.println("Объект " + newNode.toString() + " сохранился под таким индексом " + key.hashCode() % getThreshold());
            countKeys++;
        } else {
            Node node = table[hash];
            Node previous = null;
            if (node.key == newNode.key && node.value.equals(newNode.value)) {
                System.out.println("This object is exist");
                return false;
            } else {
                while (node != null) {
                    previous = node;
                    node = node.next;
                }
                node = newNode;
                previous.next = node;
                System.out.println("Объект " + newNode.toString() + " сохранился под таким индексом " + key.hashCode() % getThreshold());
                countKeys++;
                return true;
            }
        }
        return false;
    }

    // Использовала возвращение String, чтобы вывести на экран значения LinkedList
    public Node get(K key, V value) {
        if (key == null) return null;
        int hash = hash(key);
        if (table[hash] == null) {
            System.out.println("объекта под таким ключом не существует" + key);
            return null;
        } else {
            Node node = table[hash];
            if (node.key == key && node.next == null && node.value.equals(value)) {
                return node;
            } else {
                while (node != null) {
                    if (node.value.equals(value)) return node;
                    else node = node.next;
                }
            }

        }return null;
    }

    public Node get(K key) {
        if (key == null) return null;
        int hash = hash(key);
        if (table[hash] == null) {
            System.out.println("объекта под таким ключом не существует" + key);
            return null;
        } else {
            Node node = table[hash];
            return node;
         }
    }

    public int getCountKeys() {
        return countKeys;
    }

    public boolean isEmpty() {
        return countKeys == 0;
    }
}