package com.sivapcu.ds.tree;

public class BinaryTree {
	Node root;
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(key < current.getKey()) {
					current = current.getLeftChild();
					if(current == null) {
						parent.setLeftChild(newNode);
						return;
					} 
				} else {
					current = current.getRightChild();
					if(current == null) {
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}
	
	public boolean remove(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		// find the node - starts
		while(current.getKey() != key) { // loop until the key is found. 
			parent = current;
			if(key < current.getKey()) {
				isLeftChild = true;
				current = current.getLeftChild();
			} else {
				isLeftChild = false;
				current = current.getRightChild();
			}
			if(current == null) { // key not found. exit
				return false;
			}
		}
		// find the node - ends
		
		// case 1 - if the node to be deleted is leaf node i.e., has no children - starts
		if(current.getLeftChild() == null && current.getRightChild() == null) { 
			if(current == root) { //if key is root
				root = null; // now tree is empty
			} else if(isLeftChild) { 
				parent.setLeftChild(null); // disconnect from parent
			} else {
				parent.setRightChild(null); // disconnect from parent
			}
		} else if (current.getRightChild() == null){ // case 2 (part 1)- if the node to be deleted has no right child - starts
			if(current == root) {
				root = current.getLeftChild();
			} else if(isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		} else if(current.getLeftChild() == null){ // case 2 (part 2)- if the node to be deleted has no left child - starts
			if(current == root) {
				root = current.getRightChild();
			} else if(isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else { // case 3 - if the node to be deleted has 2 children - starts
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
		return true;
	}
	
	/**
	 * Successor is calculated by finding the lowest element in the right
	 * subtree.
	 * <p>
	 * Algorithm:<br/>
	 * 1. For the inputNode, go to rightChild. This becomes the currentNode.<br/> 
	 * 2. Find lowest element in the currentNode subtree but traversing till the
	 * last leftchild.<br/>
	 * 3. There is a possibility that the successor may have a
	 * right child, that rightchild has to be mapped to the successorParent as
	 * leftchild. so keeping the track of successor parent is required.
	 * <p>
	 * The logic is similar to find the minimum element in the tree. just rename the parent variable as successor variable. add the statements 
	 * <code>successorParent = inputNode</code> and <code>successorParent = successor;</code>
	 */
	private Node getSuccessor(Node inputNode) {
		Node successor = inputNode;
		Node successorParent = inputNode;
		Node current = inputNode.getRightChild();
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		
		if(successor != inputNode.getRightChild()) {
			successorParent.setLeftChild(successor.getRightChild());
			successor.setRightChild(inputNode.getRightChild());
		}
		
		return successor;
	}

	public void inOrder(Node localRoot) {
		if(localRoot!=null) {
			inOrder(localRoot.getLeftChild());
			System.out.print(localRoot+"\t");
			inOrder(localRoot.getRightChild());
		}
	}
	
	public void preOrder(Node localRoot) {
		if(localRoot!=null) {
			System.out.print(localRoot+"\t");
			preOrder(localRoot.getLeftChild());
			preOrder(localRoot.getRightChild());
		}
	}
	
	public void postOrder(Node localRoot) {
		if(localRoot!=null) {
			postOrder(localRoot.getLeftChild());
			postOrder(localRoot.getRightChild());
			System.out.print(localRoot+"\t");
		}
	}
	
	public Node findNode(int key) {
		Node current = root;
		while(current.getKey() != key) {
			if(key < current.getKey()) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	public boolean isSameTree(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		} else if(root1 == null || root2 == null){
			return false;
		} else {
			return root1.getKey() == root2.getKey()
					&& isSameTree(root1.getLeftChild(), root2.getLeftChild())
					&& isSameTree(root1.getRightChild(), root2.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.addNode(50, "");
		tree1.addNode(25, "");
		tree1.addNode(20, "");
		tree1.addNode(70, "");
		tree1.addNode(60, "");
		BinaryTree tree2 = new BinaryTree();
		tree2.addNode(50, "");
		tree2.addNode(20, "");
		tree2.addNode(70, "");
		tree2.addNode(60, "");
		tree2.addNode(25, "");
		
		tree1.postOrder(tree1.root);
		System.out.println();
		tree2.postOrder(tree2.root);
		System.out.println();
		System.out.println(tree1.isSameTree(tree1.root, tree2.root));
	}
}

