
import java.util.Scanner;

class BinaryTree {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node value: ");
        int value = scanner.nextInt();

        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {

        System.out.println("Enter the left child of " + node.data +
                " (or -1 for no child): ");

        int leftValue = scanner.nextInt();

        if (leftValue != -1) {
            node.left = new Node(leftValue);
            populate(scanner, node.left);
        }

        System.out.println("Enter the right child of " + node.data +
                " (or -1 for no child): ");

        int rightValue = scanner.nextInt();

        if (rightValue != -1) {
            node.right = new Node(rightValue);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {

        if (node == null) {
            return;
        }

        System.out.println(indent + node.data);

        display(node.left, indent + "  ");
        display(node.right, indent + "  ");
    }
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node ,int level){
        if(node==null){
            return;
        }
        //print the right child first
        prettyDisplay(node.right, level+1);
        //print the current node
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+node.data);
        }else{
            System.out.println(node.data);
        }
        prettyDisplay(node.left,level+1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();

        tree.populate(scanner);

        System.out.println("The binary tree is: ");

        tree.prettyDisplay();

        scanner.close();
    }
}
