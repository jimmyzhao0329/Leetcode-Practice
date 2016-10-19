// http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

public class print_binary_tree_boundry{

	public static void printLeaves( TreeNode root ){

		if(root.left != null){

			printLeaves(root.left);

			if(root.left == null || root.right == null){
				System.out.print(root.val + " ");
			}

			printLeaves(root.right);
		}
	}

	public static void printLeftBoundry ( TreeNode root ){

		if(root != null){

			if(root.left != null){

				System.out.print(root.val + " ");

				printLeftBoundry(root.left);
			}
			else if(root.right != null)【

				System.out.print(root.val + " ");

				printLeftBoundry(root.right);
		}
	}

	public static void printRightBoundry( TreeNode root ){

		if(root != null){

			if(root.right != null){

				printRightBoundry(root.right);

				System.out.printRightBoundry(root.val + " ");
			}
			else if(root.left != null){

				printRightBoundry(root.left);

				System.out.print(root.val + " ");
			}
		}
	}

	public static void printBoundry(TreeNode root){

		if(root != null){

			System.out.print(root.val);

			printLeftBoundry(root.left);

			printLeaves(root.left);

			printLeaves(root.right);

			printRightBoundry(root.right);
		}
	}
}