
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static  class Node{
		String data;
		Node left;
		Node right;
		
		Node(String data){
			this.data=data;
		}
	}
	static Node root;
//static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0 ;i < n; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			createNode(parent,left,right);
		}
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
	}
	static void createNode(String data, String leftData, String rightData) {
		if(root == null) {
			root = new Node(data);
			if(!leftData.equals(".")) {
				root.left= new Node(leftData);
			}
			if(!rightData.equals(".")) {
				root.right = new Node(rightData);
			}
		}else {
			searchNode(root, data, leftData, rightData);
		}
	}
	static void searchNode(Node node, String data, String leftData, String rightData) {
		if(node == null) {
			return;
		}else if(node.data.equals(data)) {
			if(!leftData.equals(".")) {
				node.left = new Node(leftData);
			}
			if(!rightData.equals(".")) {
				node.right= new Node(rightData);
			}
		}else {
			searchNode(node.left, data, leftData, rightData);
			searchNode(node.right, data, leftData, rightData);
		}
		
	}
	static void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data);
			if(node.left != null) {
				preorder(node.left);
			}
			if(node.right != null) {
				preorder(node.right);
			}
			
		}
	}
	static void inorder(Node node) {
		if(node != null) {
			if(node.left != null) {
				inorder(node.left);
			}
			System.out.print(node.data);
			if(node.right != null) {
				inorder(node.right);
			}
		}
	}
	static void postorder(Node node) {
		if(node != null) {
			if(node.left != null) {
				postorder(node.left);
			}
			if(node.right != null) {
				postorder(node.right);
			}
			System.out.print(node.data);
		}
	}
}
