public class AVL_BST{
	public static boolean checkAVL(BST b){
		if(findHeight(b.getRoot())==1){
			return true;
		}else{
			return recAVL(b.getRoot());
		}
	}
	
	public static boolean recAVL(Node n){
		int lHeight;
		int rHeight;
		
		if(n==null){
			return true;
		}else{
			lHeight = findHeight(n.getLeft());
			rHeight = findHeight(n.getRight());
			int t = Math.abs(lHeight - rHeight);
			if(t<=1 && recAVL(n.getLeft()) && recAVL(n.getRight())){
				return true;				
			}	
		}
		return false;
	}
	
	public static int findHeight(Node n){
		int lHeight;
		int rHeight;
		
		if(n==null){
			return 0;
		}else{
			lHeight = findHeight(n.getLeft());
			rHeight = findHeight(n.getRight());
		}
		if(lHeight>rHeight){
			return lHeight+1;
		}else{
			return rHeight+1;
		}
	}
	
	public static BST createBST(int[] a){
		BST tempBST = new BST();
		for(int i=0; i<a.length; i++){
			tempBST.insert(a[i]);
		}
		return tempBST;
	}
	
	public static void main(String[] args){


		int[] A = {78};
		BST b = createBST(A);
		System.out.println(checkAVL(b));

	}	
}

class BST{
	private Node root;
	
	public BST(){
		root = null;
	}
	
	public BST(int key){
		Node r = new Node(key);	
		this.root = r;
	}
	
	public BST(Node n){	
		this.root = n;
	}

	public Node getRoot(){
		return this.root;
	}
	
	public void insert(int key){
		//if bst is empty insert in root
		if(this.root == null){
			Node r = new Node(key);
			this.root = r;	
		}else{
			//if not recursively insert the node
			recInsert(this.root, key);
		}
		return;
	}
	
	public void recInsert(Node n, int key){
		if(key>=n.getKey()){
			if(n.getRight()==null){
				Node n1 = new Node(key);
				n.setRight(n1);
				return;
			}else{
				recInsert(n.getRight(), key);
			}
		}else if(key<= n.getKey()){
			if(n.getLeft()==null){
				Node n2 = new Node(key);
				n.setLeft(n2);
				return;
			}else{
				recInsert(n.getLeft(), key);	
			}
		}	
	}
}

class Node{
	private int key;
	private Node left;
	private Node right;
	
	public Node(int key){
		this.key = key;
		left=null;
		right = null;
	}
	
	public int getKey(){
		return this.key;	
	}
	
	public Node getRight(){
		return this.right;	
	}
	
	public Node getLeft(){
		return this.left;	
	}
	
	public void setRight(Node n){
		this.right = n;
	}
	
	public void setLeft(Node n){
		this.left = n;
	}
}
