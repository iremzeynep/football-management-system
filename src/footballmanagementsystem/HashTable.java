package footballmanagementsystem;

public class HashTable {
    
    int[] table;
    int prime;
    int size;
    
    public HashTable(int capacity){
        
        prime = 17;
        
        table = new int [capacity];
        
        for(int i = 0; i < capacity; i++){
            table[i] = -1;
        }
        
        size = 0;
    }

    public void putLinear(int key){
        int index = hash(key);
        int originalIndex = index;
        
        while(table[index] != -1){
            if(table[index] == key){
                System.out.println("Key already exists: " + key);
                return;
            }
            index = (index + 1) % table.length;
            if(index == originalIndex){
                System.out.println("Hash table is full");
                return;
            }
        }
        
        table[index] = key;
        size++;
    }
    
    public void putQuadratic(int key){
        int index = hash(key) % table.length;
        int originalIndex = index;
        int i = 1;
        
        while(table[index] != -1){
            if(table[index] == key){
                System.out.println("Key already exists: " + key);
                return;
            }
            
            index = (originalIndex + i * i) % table.length;
            i++;
            if(size == table.length){
                System.out.println("Hash table is full");
                return;
            }
        }
        table[index] = key;
        size++;
    }
    
    public void putDoubleHashing(int key){
        int index = hash(key);
        int stepSize = 11 - (key % 11);
        int originalIndex = index;
        
        while(table[index] != -1){
            if(table[index] == key){
                System.out.println("Key already exists: " + key);
                return;
            }   
            index = (index + stepSize) % table.length;
            if(index == originalIndex){
                System.out.println("Hash table is full");
                return;
            }
        }
        table[index] = key;
        size++;
    }
    
    public int hash(int key) {
        return ((key % prime) + prime) % prime;
    }

    public boolean searchLinear(int key) {
        int index = hash(key);
        int originalIndex = index;
        
        while(table[index] != -1){
            if(table[index] == key){
                return true;
            }
            index = (index + 1) % table.length;
            if(index == originalIndex){
                return false;
            }
        }
        return false;
    }
    
    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + (table[i] != -1 ? table[i] : "null"));
        }
    }
    
    public void delete(int key) {
        int index = hash(key);
        int originalIndex = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -1; // Mark as deleted
                size--;
                System.out.println("Key deleted: " + key);
                return;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                // If we circled back to the original index
                break;
            }
        }

        System.out.println("Key not found: " + key);
    }
}
    

