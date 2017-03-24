package com.qulei.dataStructure.Tree;

import java.util.Stack;

public class BinaryTree<E> {

	private TreeNode<E> root;

	public BinaryTree() {
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	public int height() {

		return height(root);
	}

	public int size() {
		return size(root);
	}

	public TreeNode<E> parent(TreeNode<E> element) {
		return (root == null || root == element) ? null : parent(root, element);
	}

	// 在释放某个结点时，该结点的左右子树都已经释放，
	// 所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
	public void destroy(TreeNode<E> subTree) {
		// 删除根为subTree的子树
		if (subTree != null) {
			// 删除左子树
			destroy(subTree.leftChild);
			// 删除右子树
			destroy(subTree.rightChild);
			// 删除根结点
			subTree = null;
		}
	}

	public void traverse(TreeNode<E> subTree) {
		System.out.println("key:" + subTree.key + "--name:" + subTree.data);
		traverse(subTree.leftChild);
		traverse(subTree.rightChild);
	}

	// 前序遍历
	public void preOrder(TreeNode<E> subTree) {
		if (subTree != null) {
			visted(subTree);
			preOrder(subTree.leftChild);
			preOrder(subTree.rightChild);
		}
	}

	// 中序遍历
	public void inOrder(TreeNode<E> subTree) {
		if (subTree != null) {
			inOrder(subTree.leftChild);
			visted(subTree);
			inOrder(subTree.rightChild);
		}
	}

	// 后续遍历
	public void postOrder(TreeNode<E> subTree) {
		if (subTree != null) {
			postOrder(subTree.leftChild);
			postOrder(subTree.rightChild);
			visted(subTree);
		}
	}

	public void nonRecPreOrder(TreeNode<E> p) {
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		TreeNode<E> node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				visted(node);
				stack.push(node);
				node = node.leftChild;
			}
			while (stack.size() > 0) {
				node = stack.pop();
				node = node.rightChild;
				while (node != null) {
					visted(node);
					stack.push(node);
					node = node.leftChild;
				}
			}
		}
	}

	public void visted(TreeNode<E> subTree) {
		subTree.isVisted = true;
		System.out.println("key:" + subTree.key + "--name:" + subTree.data);
	}

	private int height(TreeNode<E> subTree) {

		if (subTree == null) {
			return 0;
		} else {
			int i = height(subTree.leftChild);
			int j = height(subTree.rightChild);
			return (i < j) ? (j + 1) : (i + 1);
		}

	}

	private int size(TreeNode<E> subTree) {
		if (subTree == null) {
			return 0;
		} else {
			return 1 + size(subTree.leftChild) + size(subTree.rightChild);
		}
	}

	private TreeNode<E> parent(TreeNode<E> subTree, TreeNode<E> element) {
		if (subTree == null)
			return null;
		if (subTree.leftChild == element || subTree.rightChild == element)
			return subTree;

		TreeNode<E> p = parent(subTree.leftChild, element);
		return p == null ? parent(subTree.rightChild, element) : p;
	}

	public static class TreeNode<T> {

		private int key;
		private T data;
		private boolean isVisted;
		private TreeNode<T> leftChild;
		private TreeNode<T> rightChild;

		public TreeNode() {
		}

		public TreeNode(int key, T data) {
			this.key = key;
			this.data = data;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public boolean isVisted() {
			return isVisted;
		}

		public void setVisted(boolean isVisted) {
			this.isVisted = isVisted;
		}

		public TreeNode<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}

	}

}
