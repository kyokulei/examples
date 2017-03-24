package com.qulei.dataStructure.Tree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<String> bt = new BinaryTree<String>();

		BinaryTree.TreeNode<String> root = new BinaryTree.TreeNode<String>(1, "rootNode(A)");
		BinaryTree.TreeNode<String> newNodeB = new BinaryTree.TreeNode<String>(2, "B");
		BinaryTree.TreeNode<String> newNodeC = new BinaryTree.TreeNode<String>(3, "C");
		BinaryTree.TreeNode<String> newNodeD = new BinaryTree.TreeNode<String>(4, "D");
		BinaryTree.TreeNode<String> newNodeE = new BinaryTree.TreeNode<String>(5, "E");
		BinaryTree.TreeNode<String> newNodeF = new BinaryTree.TreeNode<String>(6, "F");
		root.setLeftChild(newNodeB);
		root.setRightChild(newNodeC);

		newNodeB.setLeftChild(newNodeD);
		newNodeB.setRightChild(newNodeE);
		newNodeC.setLeftChild(newNodeF);

		bt.setRoot(root);

		System.out.println("the size of the tree is " + bt.size());
		System.out.println("the height of the tree is " + bt.height());

		System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
		bt.preOrder(bt.getRoot());

		System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
		bt.inOrder(bt.getRoot());

		System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
		bt.postOrder(bt.getRoot());

		System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
		bt.nonRecPreOrder(bt.getRoot());
	}
}
