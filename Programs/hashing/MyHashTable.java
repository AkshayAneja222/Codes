package Programs.hashing;


class MyEntry{
	Integer key;
	Integer value;
	MyEntry next;
	public MyEntry(Integer key, Integer Value, MyEntry next){
		this.key=key;
		this.value=Value;
		this.next = next;
	}
}

public class MyHashTable {
	private MyEntry bucket[];
	private static final int INITIAL_CAPACITY = 10000007;
	
	private int size=0;
	
	MyHashTable(){
		this(INITIAL_CAPACITY);
	}
	MyHashTable(int capacity){
		bucket = new MyEntry[capacity];
	}
	
	public void put(Integer key, Integer value) {
		//System.out.println("hash code iof string is "+key.hashCode());
		int buckt  = hashValue(key, bucket.length);
		MyEntry existing = bucket[key];
		
		if(existing == null)
		{
			existing = new MyEntry(key, value, null);
			size++;
			return;
		}
		else
		{
			while(existing.next!=null)
			{
				if(existing.key.equals(key))
				{
					existing.value = value;
					return;
				}
				existing.next = existing;
			}
			if(existing.key.equals(key))
				existing.value=value;
			else {
				existing.next = new MyEntry(key, value, null);
				size++;
			}
		}
	}
	
	public boolean contains(Integer key) {
		int buckt = hashValue(key, bucket.length);
		MyEntry existing = bucket[key];
		
		if(existing == null) return false;
		else
		{
			while(existing.next!=null && !existing.key.equals(key)) {
				existing = existing.next;
			}
			return existing.key.equals(key);
		}
	}
	
	
	public Integer get(Integer key) {
		if(contains(key))
		{
			int bckt = hashValue(key, bucket.length);
			return bucket[key].value;
		}
		else
		{
			return null;
		}
	}
	
	public int hashValue(Integer key, int limit) {
		int hashVal = 0;
		hashVal=(key)%limit;
		return hashVal;
	}
	
	public static void main(String[] args) {
		MyHashTable table = new MyHashTable();
		table.put(1, 110);
		table.put(2, 20);
		table.put(3, 3);
		
		System.out.println(table.size+" "+table.bucket.length);
		System.out.println(table.contains(3));
	}
}
