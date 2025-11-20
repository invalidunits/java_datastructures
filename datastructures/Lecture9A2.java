import java.util.LinkedList;
import java.util.Queue;

public class Lecture9A2 {
    static public class BinaryTree
    {
        static public class Node 
        {
            public int value;
            public Node left;
            public Node right;
            Node(int value)
            {
                this.value = value;
                this.left = null;
                this.right = null;
            }

            @Override
            public String toString()
            {
                String result = String.valueOf(this.value);
                if (this.left != null)
                {
                    result += "\n|-- ";
                    result += this.left.toString().replace("\n", "\n    ");
                }


                if (this.right != null)
                {
                    result += "\n|-- ";
                    result += this.right.toString().replaceAll("\n", "\n    ");
                }

                return result;
            }
        }


        public Node root;
        public BinaryTree()
        {
            root = null;
        }

        public void print()
        {
            if (root != null)
            {
                System.out.println(root.toString());
            }
        }

        public void addNode(int value)
        {
            if (root == null)
            {
                root = new Node(value);
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root); // Start with the root node
            Node newNode = new Node(value);

            while (!queue.isEmpty()) {
                Node current = queue.poll(); // Get and remove the current node from the queue
                if (current.left == null) 
                {
                    current.left = newNode;
                    return;
                } 
                else 
                {
                    queue.add(current.left); 
                }

                if (current.right == null) 
                {
                    current.right = newNode;
                    return;
                } 
                else 
                {
                    queue.add(current.right);
                }
            }

        }

        public Node removeNode(int value)
        {
            if (root == null) return null;
            if (root.value == value)
            {
                if (root.left != null && root.right != null) 
                {
                    Node newNode = root.left;
                    if (newNode.right == null) 
                    {
                        newNode.right = root.right;
                    } 
                    else 
                    {
                        Node rightmost = newNode;
                        while (rightmost.right != null) 
                        {
                            rightmost = rightmost.right;
                        }
                        rightmost.right = root.right;
                    }
                    root = newNode;
                    return newNode; 
                } 
                else 
                {
                    return (root.left != null) ? root.left : root.right;
                }
            }

            return removeRecursive(root, value);
        }

        private Node removeRecursive(Node node, int value) {
            if (node == null) 
            {
                return null; 
            }

            if (node.value == value) 
            {
                if (node.left != null && node.right != null) 
                {
                    Node newNode = node.left;
                    if (newNode.right == null) 
                    {
                        newNode.right = node.right;
                    } 
                    else 
                    {
                        Node rightmost = newNode;
                        while (rightmost.right != null) 
                        {
                            rightmost = rightmost.right;
                        }
                        rightmost.right = node.right;
                    }
                    return newNode; 
                } 
                else 
                {
                    return (node.left != null) ? node.left : node.right;
                }
            }

            // Recursively search for the node to remove in left and right subtrees
            node.left = removeRecursive(node.left, value);
            node.right = removeRecursive(node.right, value);
            return node; // Return the current node
        }


    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 10; i++)
        {
            tree.addNode(i);
        }

        
        tree.print();
        System.out.println("Removing 0");
        tree.removeNode(0);
        tree.print();
        System.out.println("Removing 4");
        tree.removeNode(4);
        tree.print();
    }
}
