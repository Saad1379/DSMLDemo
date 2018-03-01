package dsml.tree.reader;

import dsml.tree.Node;
import dsml.tree.Tree;
import dsml.tree.TreeFactory;


public class DSMLDynamicIns {
	public static void main(String[] args)
	{
		TreeFactory treeFactory= TreeFactory.eINSTANCE;
		Tree myTree=treeFactory.createTree();
		myTree.setName("My Tree");
		Node myroot= treeFactory.createNode();
		myroot.setData("10");
		myroot.setLabel("myroot");
		Node childNode= treeFactory.createNode();
		childNode.setLabel("rootChild1");
		childNode.setData("11");
		myroot.getChildren().add(childNode);
		Node tempNode1= treeFactory.createNode();
		tempNode1.setLabel("rootChild2");
		tempNode1.setData("13");
		myroot.getChildren().add(tempNode1);
		myTree.setRoot(myroot);
		printTreeNodesRec(myTree.getRoot());
	}
	public static void printTreeNodesRec(Node r)
	{
		System.out.println("Node: "+r.getLabel()+" Data: "+r.getData());
		for(Node n:r.getChildren())
		{
			if(n.getChildren().isEmpty())
				System.out.println("Node: "+n.getLabel()+" Data: "+n.getData());
			else
			{
				System.out.println("Node: "+n.getLabel()+" Data: "+n.getData());
				for(Node sub_n:n.getChildren())
					printTreeNodesRec(sub_n);
			}
		}
	}
}
