package Programs.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TrieUsingHashMap {
	
	private TrieNode root = new TrieNode();
	private int answer = 0;
	
	private static class TrieNode{
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean end = false;
		int value = 0;
	}

	void insert(String str, int value)
	{
		int strLength = str.length(), strIndex;
		TrieNode node = root;
		
		for(strIndex=0;strIndex<strLength;strIndex++)
		{
			char c = str.charAt(strIndex);
			
			if(!node.children.containsKey(c))
			{
				node.children.put(c, new TrieNode());
			}
			node = node.children.get(c);
		}
		node.end=true;
		node.value = value;
	}
	
	long sumOfAllPrefixes(String str)
	{
		recurseTrie(search(str));
		long val = answer;
		answer=0;
		return val;
	}
	
	void recurseTrie(TrieNode root)
	{
		if(root==null) return;
		if(root.end)
		answer+=root.value;
		
		for(Map.Entry<Character, TrieNode> entry: root.children.entrySet())
		{
			recurseTrie(root.children.get(entry.getKey()));
		}
		return;
	}
	
	TrieNode search(String str)
	{
		int strIndex, strLen = str.length();
		TrieNode node = root;
		
		for(strIndex = 0; strIndex < strLen; strIndex++)
		{
			char c = str.charAt(strIndex);
			if(!node.children.containsKey(c))
			return null;
			node = node.children.get(c);
		}
		return node;
	}	
}


public class MapIntegerToString {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int num = Integer.parseInt(br.readLine());

			TrieUsingHashMap trie = new TrieUsingHashMap();
			while(num-->0)
			{
				String[] strArr = br.readLine().split(" ");
				if(Integer.parseInt(strArr[0])==1) 
				{
					trie.insert(strArr[1], Integer.parseInt(strArr[2]));
				}
				else
				{
					System.out.println(trie.sumOfAllPrefixes(strArr[1]));
				}
			}
		}
	}

}
