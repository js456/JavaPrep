package com.jitendrasaini.tree;
import java.util.*;
import java.lang.*;

class Node
{
    char data;
    NodeZigZag left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}


class DuplicateSubTree
{
  static  class Res
{
    int j;
}
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            Res r = new Res();
            r.j = 0;
            NodeZigZag root = null;
            root = insertString(root, str, r);
            
            GfG gfg = new GfG();
            boolean res = gfg.dupSub(root);
            if(res == true)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
    public static NodeZigZag insertString(NodeZigZag root, String str, Res r)
    {
        if(r.j > str.length())
         return null;
         
        if(str.charAt(r.j) == '(')
	          (r.j)++;
	          
	    if(str.charAt(r.j) != '(' && str.charAt(r.j) != ')')
	    {
	        char n=0;
	             n = str.charAt(r.j);
	             
	       (r.j)++;
	       
	       root = insert(root,n);
	       
	       if(str.charAt(r.j) == ')')
	       {
	           root.left = null;
	           root.right = null;
	           
	           return root;
	       }
	    }
	    
	        if(str.charAt(r.j) == '(')
	             (r.j)++;
	             
	       if(str.charAt(r.j) == ')')
	       {
	           root.left = null;
	       }
	       else
	       {
	            root.left = insertString(root.left, str, r);
	       }
	       
	       while(str.charAt(r.j) == ')')
	              (r.j)++;

	          if(str.charAt(r.j) == '(')
	               (r.j)++;
	               
	       if(str.charAt(r.j) == ')')
	       {
	           root.right = null;
	           (r.j)++;
	       }
	       else
	       {
	           root.right = insertString(root.right, str, r);
	       }
	       
        return root;
    }
    
    public static NodeZigZag insert(NodeZigZag root, char n)
    {
        if(root == null)
        {
            root = new NodeZigZag(n);
            return root;
        }
        else if(n < root.data)
              root = insert(root.left, n);
             
        else if(n > root.data)
             root = insert(root.right, n);
     
     return root;   
    }
    
    
}
// } Driver Code Ends

/*node class of the binary tree
class Node
{
    char data;
    Node left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}*/
class GfG
{
    static final char MARKER = '$';
    static Set<String> subtrees = new HashSet<String>();
    public static boolean dupSub(NodeZigZag root)
    {
        subtrees.clear();
        
        String res = dupSubUtil(root);
        if(res.compareTo("") == 0)
        return true;
        else
        return false;
    }
    
    public static String dupSubUtil(NodeZigZag root)
    {
        String s = "";
        
        if(root == null)
         return s + MARKER;
         
        String lStr = dupSubUtil(root.left);
        if (lStr.compareTo(s) == 0)
            return s;
            
        String rStr = dupSubUtil(root.right);
       if (rStr.compareTo(s) == 0)
           return s;
           
        s = s + root.data + lStr + rStr;
        
         if (s.length() > 3 && subtrees.contains(s) == true)
                return "";
                
        subtrees.add(s);
 
        return s;
    }
}
