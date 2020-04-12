import java.util.Arrays;

public class Hashtable<k, v> {

    private HashNode<k, v>[] table;
    private int items;
    private final double LAMBDA = 0.75;

    public Hashtable() {
        table = new HashNode[50];
    }

    private int getSlot(String key) {
        int slot = key.hashCode();
        slot = Math.abs(slot % table.length); //to avoid negative hashes
        return slot;
    }

    boolean containsKey (String key) {
        for(int i = 0; i < table.length; i++) { // linear probing
            if(table[i] != null) {
                if(table[i].deleted = false && table[i].getKey() == key) {
                    return true;
                }
            }
        }
        return false;
    }

    String get (String key) {
        int slot = getSlot(key);
        HashNode node = table[slot];
        while(node != null && key != node.getKey()) {
            // node = node.getNext;
            slot = (slot + 1) % table.length;
            node = table[slot];
        }
        if(node != null) {
            return node.getValue();
        }
        else {
            return null;
        }
    }

    void put (String key, String value) {
        int slot = getSlot(key);
        while(table[slot] != null && table[slot].getKey() != key){ // avoid duplicate entries
            slot = (slot + 1) % table.length;
        }
        table[slot] = new HashNode(key, value);
        ++items;
        if(items/table.length >= LAMBDA) {
            growSize();
        }

    }

    String remove (String key) {
        int slot = getSlot(key);
        for(int i = 0; i < table.length; i++) { // probing
            int newSlot = (slot + (i * i)) % table.length; // quadratic
            HashNode node = table[newSlot];
            if(node.getKey() == key) {
                node.setDelete(true);
                items--;
                return node.getValue();
            }
        }
        return null;
    }

    private void growSize() {
        table = Arrays.copyOf(table, table.length * 2);
    }

}

class HashNode<k, v> {
    String key;
    String value;
    boolean deleted;

	public HashNode(String k, String v) {
	    key = k;
	    value = v;
    }

    //accessors
    public String getKey() {
	    return key;
    }

    public String getValue() {
	    return value;
    }


    //mutators
    public void setKey(String k) {
	    key = k;
    }

    public void setValue(String v) {
        value = v;
    }

    public void setDelete(boolean state) {
	    deleted = state;
    }
}
