public class Lecture9ACodeAlong {
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

            public void addLeftChild(Node node)
            {
                this.left = node;
            }

            public void addRightChild(Node node)
            {
                this.right = node;
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

    }


    public static void main(String[] args)
    {
        BinaryTree t = new BinaryTree();
        t.root = new BinaryTree.Node(5);
        t.root.left = new BinaryTree.Node(3);
        t.root.left.left = new BinaryTree.Node(2);
        t.root.left.right = new BinaryTree.Node(4);
        t.root.right = new BinaryTree.Node(7);
        t.root.right.left = new BinaryTree.Node(6);
        t.root.right.right = new BinaryTree.Node(8);
        t.print();
    }
}
