package DSA_assignment_4;

class Hash_Table {

    private static final int TABLE_SIZE = 10;
    private Integer[] keys;
    private String[] values;

    public Hash_Table() {
        keys = new Integer[TABLE_SIZE];
        values = new String[TABLE_SIZE];
    }

    private int hash(int key) {

        return key % TABLE_SIZE;

    }
    public void put(int key, String value) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
           index = (index + 1) % TABLE_SIZE; 
        }
       keys[index] = key;
       values[index] = value;
    }
    
    public String get(int key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % TABLE_SIZE; 
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
               keys[index] = null;
                values[index] = null;
                rehash(index);
                return;
            }
            index = (index + 1) % TABLE_SIZE;
        }
    }
    private void rehash(int index) {
        int nextIndex = (index + 1) % TABLE_SIZE;
        while (keys[nextIndex] != null) {
            Integer keyToRehash = keys[nextIndex];
            String valueToRehash = values[nextIndex];
            keys[nextIndex] = null;
            values[nextIndex] = null;
            put(keyToRehash, valueToRehash);
            nextIndex = (nextIndex + 1) % TABLE_SIZE;
        }
    }

    public void display() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (keys[i] != null) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }

    public static void main(String[] args) {
        Hash_Table hashTable = new Hash_Table();
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(12, "Twelve"); 
        hashTable.put(22, "Twenty Two"); 
        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(12));
        System.out.println(hashTable.get(22)); 
        hashTable.remove(2);
        System.out.println(hashTable.get(2)); 
        hashTable.display(); 
    }

}


