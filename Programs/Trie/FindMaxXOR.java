package Programs.Trie;

public class FindMaxXOR {
    Node root = new Node();
    
    private static class Node
    {
        Node left=null, right=null;
    }
    
    public void insert(int value)
    {
        Node node = root;
        for(int i=30;i>=0;i--)
        {
            int val = (value>>i)&1;
            
            if(val==0)
            {
                if(node.left==null)
                    node.left = new Node();
                node=node.left;
            }
            else
            {
                if(node.right==null)
                    node.right = new Node();
                node=node.right;
            }
        }
    }
    
    public void display(Node root) {
    	
    	if(root.left!=null)
    	{
    		System.out.print(0+" ");
    		display(root.left);
    	}
    	if(root.right!=null)
    	{
    		System.out.print(1+" ");
    		display(root.right);
    	}
    }
    
    public int getValue(int value)
    {
        Node node = root;
        int ans = 0;
        int bitValue = (int)Math.pow(2,30);
        for(int i=30;i>=0;i--)
        {
            int val = (value>>i)&1;
            if(val==0)
            {	System.out.println("bit value : "+bitValue);
                if(node.right!=null)
                {
                	System.out.println("adding bit value ");
                    ans+=bitValue;
                    node=node.right;
                }
                else
                {
                    node=node.left;
                }
            }
            else
            {
                if(node.left!=null)
                {
                	System.out.println("adding bit value ");
                    ans+=bitValue;
                    node=node.left;
                }
                else
                {
                    node=node.right;
                }
            }
            bitValue/=2;
        }return ans;
    }
    
    public int findMaximumXOR(int[] nums) {
        for(int i=0;i<nums.length;i++)
            insert(nums[i]);
        int ans = 0;
        for(int i=0;i<nums.length;i++)
            ans = Math.max(ans, getValue(nums[i]));
        return ans;
    }
    
}