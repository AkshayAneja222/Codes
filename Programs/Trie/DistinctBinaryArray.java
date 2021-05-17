package Programs.Trie;


public class DistinctBinaryArray {

	private static class TrieNode {
		TrieNode left=null, right=null;
	}
	
	private static class Trie{
		
		TrieNode root = new TrieNode();

		boolean insert(int[] array)
		{
			TrieNode node = root;
			int res = 0;
			for(int i=0; i<array.length; i++) {
				if(array[i]==1) {
					if(node.right==null){
						node.right = new TrieNode();
						res++;
					}
					node = node.right;
				}else {
					if(node.left==null) {
						node.left = new TrieNode();
						res++;
					}
					node = node.left;
				}
			}
			return res>0;
		}

		private void distinctCount(int[][] array)
		{
			int res = 0;

			for(int i=0; i<array.length; i++) {
				if(insert(array[i]))
					res=res+1;
			}

			System.out.println("Distinct count of array is "+res);
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		int[][] array = 
			{{1, 0, 1, 0},
			 {0, 0, 0, 0},
			 {1, 0, 1, 0},
			 {0, 0, 0, 0}};

		trie.distinctCount(array);
	}
}
