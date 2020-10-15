package dataStructures;

import java.util.HashMap;
import java.util.Map;

public class TrieUsingHashMap {
	
	private StringBuilder output = new StringBuilder("");
	private TrieNode root = new TrieNode();
	
	private static class TrieNode{
	
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean end = false;
	}
	
	private void setOutput(StringBuilder str){
		  output = new StringBuilder(str);
	}
		
	public StringBuilder getOutput(){
	  return output;
	}
		
	public void maintainOutput(StringBuilder str){
	  if(getOutput().length()<str.length()) {
		  //System.out.println("str before changing "+str+" output "+output);
		  setOutput(str);
	  }
	}
		
	
	void display()
	{
		if(root == null)
			return;
		display(root, "");
	}
	
	
	private void display(TrieNode root, String str)
	{
		if(root.end)
		{
			System.out.println(str);
		}
		
		for(Map.Entry<Character, TrieNode> entry : root.children.entrySet())
		{
			display(entry.getValue(), str+entry.getKey());
		}
	}
	
	
	void insert(String str)
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
	}
	
	public void plagiarism() {
		plagiarism(root, new StringBuilder(""));
		System.out.println(getOutput());
	}
	
	
	private void plagiarism(TrieNode root, StringBuilder str)
	{
	  if(root==null)
		  return;
	   
	  //System.out.println("count "+count+" string "+str);
	  for(Map.Entry<Character, TrieNode> entry: root.children.entrySet())
	  {
		if(root.children.get(entry.getKey()).end)
		{
			str.append(entry.getKey());
			maintainOutput(str);
			plagiarism(root.children.get(entry.getKey()), str);
			str.delete(str.length()-1, str.length());
		}
	    
	  }
	  
	  return;
	}
	
	
	boolean search(String str)
	{
		int strIndex, strLen = str.length();
		
		TrieNode node = root;
		
		for(strIndex = 0; strIndex < strLen; strIndex++)
		{
			char c = str.charAt(strIndex);
			if(!node.children.containsKey(c))
			return false;
			node = node.children.get(c);
		}
		return node.end;
	}
	
	public static void main(String[] args) {
		TrieUsingHashMap trie = new TrieUsingHashMap();
		
		trie.insert("a");
		trie.insert("ak");
		trie.insert("aks");
		//trie.insert("aksh");
		trie.insert("ab");
		trie.insert("abc");
		trie.insert("abc");
		trie.insert("w");
		trie.insert("we");
		trie.insert("wer");
		trie.insert("wert");
		
		
	//	System.out.println("did trie has zerif? :" + trie.search("zor"));
		
	//	trie.display();
		
		trie.plagiarism();
	}
	
	
}
