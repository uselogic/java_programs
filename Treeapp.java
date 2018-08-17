import java.util.*;
public class Treeapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Tree thetree=new Tree();
		
		while(true)
		{
			System.out.println("enter below choices to do what you want to do");
			System.out.println("press 'i' for insert\npress 'f' for find \npress'd' for delete \npress't' for traverse \npress'm' for minimum value");
			char choice=getchar();
			switch(choice)
			{
			case 'i':
				System.out.println("enter  how many values you want to insert");
				int n=sc.nextInt();
				for (int i=0;i<n;i++)
				{
					System.out.println("enter the "+i+"th value of num and"+i+"th value of data ");
					int num=sc.nextInt();
					double data=sc.nextDouble();
					thetree.insert(num, data);
		            
				}
				break;
			case 'f':
				    System.out.println("enter number to find the number");
				    int value=sc.nextInt();
				    Node found=thetree.find(value);
				    if (found!=null)
				    {
				    	System.out.println("found :");
				    	found.displayNode();
				    	System.out.println("\n");
				    }
				    else
				    {
				    	System.out.println("could not find");
				    	System.out.println(value +"\n");
				    }
				   break;
			case 'd':
				   System.out.println("enter value to delete");
				   int value1=sc.nextInt();
				   boolean diddelete=thetree.delete(value1);
				   if (diddelete)
				   {
					   System.out.println("deleted value"+value1);
					   
				   }
				   else
				   {
					   System.out.println("could not delete");
				   }
				   break;
			case 't':
				   System.out.println("enter from 1 to 3 to traverse");
				   int value3=sc.nextInt();
				   thetree.traverse(value3);
				   break;
			case 'm':
				   System.out.println("the minimum value is");
				   int min=thetree.minvalue(thetree.root);
				   System.out.println(min);
				   break;
			default:
				   System.out.println("invalid entry");
			}
		
			
			
		}
     
     
	}

	
	

	public static char getchar() {
		// TODO Auto-generated method stub
		String s=getstring();
		return s.charAt(0);
		}
	public static String getstring()
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine()	;
		return s;
		}

}
class Node 
{
	public int idata;
	public double dData;
	public Node leftchild;
	public Node rightchild;
	public void displayNode()
	{
		System.out.println("{");
		System.out.println(idata);
		System.out.println(",");
		System.out.println(dData);
        System.out.println("}");
	}
	
}
class Tree
{
	public Node root ;
	public Tree()
	{
		root=null;
	}
	public Node find(int key)///////////////////find key method starts
	{
		Node current=root;
		while(current.idata!=key)
		{
			if (key<current.idata)
			{
				current=current.leftchild;
			}
			else
			{
				current=current.rightchild;
				
			}
			if (current==null)
			{
				return null;
			}
		}
		return current;
	}////////////////////////////////////////find method ends

    public void insert(int id,double dd)///////////////////start insert node method
   {
	Node newNode=new Node();
	newNode.idata=id;
	newNode.dData=dd;
	if (root==null)
	{
		root=newNode;
		
	}
	else
	{
		Node current=root;
		Node parent;
		while(true)
		{
			parent=current;
			if (id<current.idata)
			{
				current=current.leftchild;
				if (current==null)
				{
					parent.leftchild=newNode;
					return;
				}
				
			}
			else
			{
				current=current.rightchild;
				if (current==null)
				{
					parent.rightchild=newNode;
					return;
				}
			}
		 }
	  }
	
   }////////////////////////////////insert method ends here
    public boolean  delete(int key)
    {
    	Node current=root;
    	Node parent=root;
    	boolean isLeftchild=false;
    	while(key!=current.idata)//ist we find the key then delete it
    	{
    		parent=current;
    		if(key<current.idata)
    		{
    			isLeftchild=true;
    			current=current.leftchild;
    		}
    		else
    		{
    			isLeftchild=false;
    			current=current.rightchild;
    		}
    		if(current==null)
    		{
    			return false;
    		}	
    	}//end while
    	if (current.leftchild==null && current.rightchild==null)//when no child
    	   {
    		 if (current==root)
    		 {
    			 root=null;
    		 }
    		 else if(isLeftchild)
    		 {
    			 parent.leftchild=null;
    		 }
    		 else
    		 {
    			 parent.rightchild=null;
    		 }
    	   }
    	else if (current.rightchild==null)//when one leftchild is present
    	     {
    		    if(current==root)
    		    {
    		    	root=current.leftchild;
    		    }
    		    else if(isLeftchild)
    		    {
    		    	parent.leftchild=current.leftchild;
    		    }
    		    else
    		    {
    		    	parent.rightchild=current.leftchild;
    		    }
    	     }
    	else if (current.leftchild==null)//when one right child is present
    	  { 
    		if(current==root)
		    {
		    	root=current.rightchild;
		    }
		    else if(isLeftchild)
		    {
		    	parent.leftchild=current.rightchild;
		    }
		    else
		    {
		    	parent.rightchild=current.rightchild;
		    }
           }
    	else//when both childs are present
    	{
    		Node successor=getsuccessor(current);
    		if (current==root)
    		{
    			root=successor;
    		}
    		else if(isLeftchild)
    		{
    			parent.leftchild=successor;
    			
    		}
    		else
    		{
    			parent.rightchild=successor;
    		}
    		successor.leftchild=current.leftchild;
    	}
    	return true;
    }///////end of delete function
    public Node getsuccessor(Node delNode)/////get successor method
    {
    	Node successorParent=root;
    	Node successor=root;
    	Node current=delNode.rightchild;
    	while(current!=null)
    	{
    		successorParent=successor;
    		successor=current;
    		current=current.leftchild;
    	}
    	if(successor!=delNode.rightchild)
    	{
    		successorParent.leftchild=successor.leftchild;
    		successor.rightchild=delNode.rightchild;
    	}
    	return successor;
    }//end of get successor method
    public void traverse(int traverseType)
    {
    	switch(traverseType)
    	{
    	case 1:System.out.println("preorder traversal");
    	       preorder(root);
    	       break;
    	case 2:System.out.println("inorder traversal");
	       inorder(root);
	       break; 
    	case 3:System.out.println("preorder traversal");
	       postorder(root);
	       break;   
    	}
    }
    public void preorder(Node localroot) {
    	if(localroot!=null)
    	{
    		System.out.println(localroot.idata + " ");
    		preorder(localroot.leftchild);
    		preorder(localroot.rightchild);
    		
    	}
    }
    public void inorder(Node localroot) 
    {
    	if(localroot!=null)
    	{
    		System.out.println(localroot.idata + " ");
    		inorder(localroot.leftchild);
    		inorder(localroot.rightchild);
         }
     }
    public void postorder(Node localroot) 
    {
    	if(localroot!=null)
    	{
    		System.out.println(localroot.idata + " ");
    		postorder(localroot.leftchild);
    		postorder(localroot.rightchild);
         }
     }
    public int minvalue(Node node) {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.leftchild != null) {
            current = current.leftchild;
        }
        return (current.idata);
    }
    
	}
