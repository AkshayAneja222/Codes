package dataStructures;

public class Trie {
	
	TrieNode root = new TrieNode();
	
	private static class TrieNode{
		int size = 26;
		TrieNode[] children = new TrieNode[size];
		boolean end;
		
		TrieNode(){
			end = false;
			for(int i=0;i<size;i++)
				children[i]=null;
		}
	}
	
	
	public void insert(String str)
	{
		int strIndex, nodeIndex;
		
		int strLength = str.length();
		TrieNode node = root;
		for(strIndex=0;strIndex<strLength;strIndex++)
		{
			nodeIndex = str.charAt(strIndex)-'a';
			if(node.children[nodeIndex]==null)
				node.children[nodeIndex]=new TrieNode();
			node = node.children[nodeIndex];
		}
		node.end=true;
	}
	
	
	public boolean search(String str)
	{
		TrieNode node = root;
		int strIndex, nodeIndex, strLength = str.length();
		
		for(strIndex = 0; strIndex<strLength; strIndex++)
		{
			nodeIndex = str.charAt(strIndex)-'a';
			if(node.children[nodeIndex]==null)
				return false;
			node = node.children[nodeIndex];
		}
		return node.end?true:false;
	}
	
	
	
	public void display()
	{
		display("", root);
	}
	
	
	private void display(String str, TrieNode root)
	{
		if(root.end)
			System.out.println(str);
		
		for(int i=0;i<26;i++)
		{
			if(root.children[i]!=null)
			{
				display(str+(char)(i+'a'), root.children[i]);
			}
		}
		return;
	}
	
	
	public void delete(String str)
	{
		if(str.length()!=0)
			root = delete(str, root, 0);
	}
	
	
	private boolean isEmpty(TrieNode node)
	{
		for(int i=0;i<node.children.length;i++)
			if(node.children[i]!=null) return false;
		return true;
	}
	
	
	
	private TrieNode delete(String str, TrieNode root, int length)
	{
		if(root==null) return root;
		
		if(length == str.length())
		{
			if(root.end) root.end=false;
			
			if(isEmpty(root))
				root=null;
			return root;
		}
		
		int trieIndex = str.charAt(length)-'a';
		if(root.children[trieIndex]==null) return null;
		
		root.children[trieIndex] = delete(str, root.children[trieIndex], length+1);
		
		if(isEmpty(root) && !root.end)
			root = null;
		
		return root;
	}
	
	
	
	public boolean autoComplete(String prefix){
		int strLength=prefix.length(), trieIndex, strIndex;
		boolean hasNoChild;
		TrieNode node = root;
		
		for(strIndex = 0; strIndex<strLength; strIndex++)
		{
			trieIndex = prefix.charAt(strIndex)-'a';
			if(node.children[trieIndex]==null) return false;
			node = node.children[trieIndex];
		}
		
		hasNoChild = isEmpty(node);
		
		if(node.end && hasNoChild) {
			System.out.println(prefix);
			return true;
		}
		
		if(!hasNoChild) {
			display(prefix, node);
			return true;
		}
			
		return false;
	}
	
	
	public boolean multipleChild(TrieNode node) {
		int count = 0;
		for(int i=0;i<26;i++)
		{
			if(node.children[i]!=null) count++;
			if(count>1) return true;
		}
		
		return false;
	}
	
	
	public String longetCommonPrefix(String[] strArr) {
		int strIndex=0;
		
		Trie trie = new Trie();
		for(int i=0; i<strArr.length; i++)
		{
			trie.insert(strArr[i]);
		}
		
		TrieNode node = trie.root;
		String answer = "";
		
		while(node!=null && !multipleChild(node) && !node.end)
		{
			answer+=strArr[0].charAt(strIndex);
			node = node.children[strArr[0].charAt(strIndex)-'a'];
			strIndex++;
		}	
		return answer;
	}
	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("a");
		trie.insert("aks");
		trie.insert("ak");
		trie.insert("zordan");
		trie.insert("zord");
		trie.insert("zerif");
		trie.insert("zordanies");
		trie.insert("zoreignh");
		
		trie.display();
		trie.delete("zord");
		trie.delete("ak");
		System.out.println("after deleting \"zord\" and \"ak\" ");
		trie.display();
		
		System.out.println("strings starting with \"zord\" are ");
		trie.autoComplete("zord");
		
		String[] input = {"akshayaneja", "akshay", "qakshat"};
		
		System.out.println(trie.longetCommonPrefix(input));
		
	}
	
}
