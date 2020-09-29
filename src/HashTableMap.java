// --== CS400 File Header Information ==--
// Name: <Hari Iyer>
// Email: <hiyer4@wisc.edu>
// Team: <BF>
// TA: <Brianna Cochran>
// Lecturer: <Gary Dahl>
// Notes to Grader: <Stay Safe!!!>
import java.util.LinkedList; //imports LinkedList
import java.util.NoSuchElementException; //imports NoSuchElementException

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * 
 * @author Hari Iyer
 *
 * Creates a HashTable
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    
  private int capacity; //max capacity of table 
  private int size; //positions filled
  private LinkedList<Node>[] table; 
  
  /**
   * 
   * @author Hari Iyer
   * 
   * Creates a Node object to be used as a part of a LinkedList for the HashTable
   *
   */
  public class Node {
    
    private KeyType key;
    private ValueType value;
    
    /**
     * constructs Node object with a key and value reference
     * @param key
     * @param value
     */
    public Node(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }
    
    /**
     * retreives key
     * @returns key of type KeyType
     */
    public KeyType getKey() {
        return this.key;
    }
    
    /**
     * changes value of key
     * @param key of type KeyType
     */
    public void setKey(KeyType key) {
      this.key = key;
  }
    /**
     * retreives value of value
     * @return value of type ValueType
     */
    public ValueType getValue() {
      return this.value;
  }
    /**
     * changes value of value
     * @param value of type ValueType
     */
    public void setValue(ValueType value) {
      this.value = value;
  }

}
    /**
     * overloaded constructor initializes HashTableMap object
     * @param capacity - initial capacity
     **/
    public HashTableMap(int capacity) { //constructor with capacity as parameter
        this.capacity = capacity;
        table = new LinkedList[this.capacity]; 
    }

    /**
     * default constructor
     * initializes HashTableMap object with initial capacity of 10
     */
    public HashTableMap() { 
        this.capacity = 10; //default capacity
        table = new LinkedList[this.capacity];
    }

    @Override
   /**
   * puts the key-value pair into hashtable and returns if operation was successful
   * 
   * @param key - key of type KeyType
   * @param value - value of type ValueType
   * @return true if key value pair is added successfully, false elsewise
   */
    public boolean put(KeyType key, ValueType value) {
      //fraction of capacity that is full
      //increments size and returns true as put operation is successful
      this.size++;
        double fracCapacity = (double) (1.0 * this.size / this.capacity); 
        if (fracCapacity >= 0.8) { //double capacity and rehash values if 80% or more full
            rehash(); //calls helper method to double capacity and rehash values
        }      
        for (int x = 0; x < capacity; x++) {
            if (table[x] != null) { //if linkedlist exists
                for (int y = 0; y < table[x].size(); ++y) {
                    if (key.equals(table[x].get(y).getKey())) { //if key exists already
                        return false;
                    }
                }
            }
        }
        int hashCode = 0;
        //finds hashcode for specific key
        hashCode = Math.abs(key.hashCode() % this.capacity);
        Node node = new Node(key, value); //node to be added to table
        if (table[hashCode] == null) {
          //creates LinkedList for an index that has no LinkedList 
            table[hashCode] = new LinkedList<Node>();
            table[hashCode].add(node);

        } else {
          //adds key-value pair node to index if LinkedList already exists
            table[hashCode].add(node);
        }
       
        return true;
    }
    
    /**
     * helper method with the purpose of doubling the capacity
     * of the table and rehashing the values
     */
    private void rehash() {
      LinkedList<Node>[] singleTable = this.table; //prior table with half capacity
      //new hashtable with double the capacity
      LinkedList<Node>[] doubleTable = new LinkedList[this.capacity * 2]; 
      this.size=0; //sets the size to 0 before rehashing
      this.capacity *= 2; //doubling capacity of new table
      this.table = doubleTable; //original table reference changed
      for (int x = 0; x < singleTable.length; ++x) { //traverse prior table
          if (singleTable[x] != null) {
              for (int y = 0; y < singleTable[x].size(); ++y) {
                  if (singleTable[x].get(y) != null) {
                      KeyType key = singleTable[x].get(y).getKey();
                      ValueType value = singleTable[x].get(y).getValue();
                      put(key, value); //puts the value from prior table into new table
                  }
              }
          }
      }
  }


    @Override
    /**
     * retrieves Value for the input key
     * 
     * @returns value of type ValueType
     * @param key - of type KeyType to be removed
     * @throws NoSuchElementException if key does not exist in hashtable
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
        if (!containsKey(key)) {
          //throws NoSuchElementException if key is not found in table
            throw new NoSuchElementException(); 
        }
        ValueType value=null; //value will be updated to the value of the key later
        for (int x = 0; x < capacity; ++x) { //traverse the table 
            if (this.table[x] != null) {
                for (int y = 0; y < table[x].size(); ++y) {
                    Node node = (Node) table[x].get(y); //create a node for each key
                    if (node.getKey() == key) { //compare node's key with given key
                        if (node.getValue() != null) {
                            value = node.getValue(); //value is set to node's value
                        }
                    }
                }
            }
        }
        return value; //return value for the given key
    }

    @Override
    /**
     * @return size of the hashtable (number of key-value pairs)
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * checks if table contains key
     * 
     * @param key - key of type KeyType that is compared
     * @returns true if table contains key, false elsewise
     */
    public boolean containsKey(KeyType key) {
        boolean containsKey = false; //if the key is found in the table
        for (int x = 0; x < capacity; ++x) {
            if (table[x] != null) { //checks if LinkedList exists
                for (int y = 0; y < table[x].size(); ++y) { //traverses LinkedList
                    Node node = (Node) table[x].get(y); //creates node 
                    if (node.getKey() == key) {
                        containsKey = true; //if KeyType objects are equal then return true
                    }
                }
            }
        }
        return containsKey;
    }

    @Override
    /**
     * removes key from hashtable 
     * 
     * @param key -key to be removed of type KeyType
     * @returns value of removed key
     */
    public ValueType remove(KeyType key) {
        if (!containsKey(key)) { //if key does not exist in the table null must be returned
            return null;
        }
        ValueType value = null;
        for (int x = 0; x < capacity; ++x) {
            if (table[x] != null) {
                for (int y = 0; y < table[x].size(); ++y) { //traverse table to find key
                    Node node = (Node) table[x].get(y);
                    if (node.getKey() == key) {
                        if (node.getValue() != null) {
                            value = node.getValue(); //stores value of node in variable value
                            node.setValue(null); 
                            node.setKey(null);
                        }
                    }
                }
            }
        }
        return value; //removed value is returned
    }

    @Override
    /**
     * removes all key-value pairs from hashtable
     */
    public void clear() {
        for (int x = 0; x < capacity;x++ ) {
            if (table[x] != null) { //all indexes with values will be set to null
                table[x] = null;
                
            }
        }
            this.size=0;
        

    }
    
    
    /**
     * capacity of the hashtable
     * @returns capacity of hashtable
     */
    public int capacity() {
        return this.capacity;
        
    }
    
}




