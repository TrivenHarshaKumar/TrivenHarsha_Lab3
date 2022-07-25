package lab3;

import java.util.HashSet;

class Node
{
	int NodeData;
	Node leftNode, rightNode;
}
public class FindSumPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node  root =null;
		FindSumPair findSP = new FindSumPair();
		root = findSP.Insert(root, 40);
		root = findSP.Insert(root, 20);
		root = findSP.Insert(root, 60);
		root = findSP.Insert(root, 10);
		root = findSP.Insert(root, 30);
		root = findSP.Insert(root, 50);
		root = findSP.Insert(root, 70);

		int sum=130;
		findSP.findPairWithGivenSum(root, sum);

	}
	static Node NewNode(int NodeData)
	{
		Node temp = new Node();
		temp.NodeData = NodeData;
		temp.leftNode =null;
		temp.rightNode = null;
		return temp;
		
	}
	
	
	public Node Insert(Node root,int  key)
	{
		if(root ==null)
			return NewNode(key);
		if(key<root.NodeData)
			root.leftNode=Insert(root.leftNode,key);
		else
			root.rightNode=Insert(root.rightNode,key);
		return root;
	}
	
	public boolean findpairUtil(Node root,int sum,HashSet<Integer> set)
	{
		if(root==null)
			return false;
		if(findpairUtil(root.leftNode,sum,set))
			return true;
		if(set.contains(sum-root.NodeData))
		{
			System.out.println("Pair is found ("+(sum-root.NodeData)+","+root.NodeData+")");
			return true;
		}
		else
			set.add(root.NodeData);
		
		return findpairUtil(root.rightNode,sum,set);
	}
	
	public void findPairWithGivenSum(Node root,int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findpairUtil(root,sum,set))
			System.out.println("nodes are not found");
	}
	

}
