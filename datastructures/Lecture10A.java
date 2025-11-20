public class Lecture10A {
    public class BST
    {
        public class Node {
            int value;
            Node left;
            Node right;
            public Node(int value)
            {
                this.value = value;
            }
        }   

        Node root;
        BST()
        {
            this.root = null;
        }

        public void insert(int value)
        {
            if (this.root == null) this.root = new Node(value);
            else
            {
                insertRecursive(value, root);
            }
        }


        private Node insertRecursive(int value, Node n)
        {
            if (n == null)
            {
                n = new Node(value);
            }

            if (value > n.value)
            {
                n.right = insertRecursive(value, n.right);
            }
            else if (value < n.value)
            {
                n.left = insertRecursive(value, n.left);
            }
            return n;
        }
    }
    
}
