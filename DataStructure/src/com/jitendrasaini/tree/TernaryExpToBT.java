package com.jitendrasaini.tree;

public class TernaryExpToBT {


	   
    public static NodeZigZag convertExp(String str)
    {
        
        if(str.length()<=0)
         return null;
         
       NodeZigZag root = new NodeZigZag(str.charAt(0));
        if(str.length()>1 && str.charAt(1) == '?')
         root.left = convertExp(str.substring(2));
        if(str.length()>1 && str.charAt(1) == ':')
         root.right = convertExp(str.substring(2));
      
      return root;  
    }
    public static void preorder(NodeZigZag node) {
    	if(node == null)
    		return;
    	System.out.print(node.data+" ");
    	preorder(node.left);
    	preorder(node.right);
    }
    public static void main(String[] args) {
    	NodeZigZag node = convertExp("a?b?c:d?e?f:g:h:i?j:k");
    	preorder(node);
	}
    
    
}
