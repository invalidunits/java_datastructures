import java.util.LinkedList;

public class Lecture9A1 {
    static public class TernaryTree
    {
        static public class Node 
        {
            public int value;
            public Node left;
            public Node middle;
            public Node right;
            Node(int value)
            {
                this.value = value;
                this.left = null;
                this.middle = null;
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

                if (this.middle != null)
                {
                    result += "\n|-- ";
                    result += this.middle.toString().replace("\n", "\n    ");
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
        public TernaryTree()
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


    static public class NAryTree
    {
        static public class Node 
        {
            public int value;
            public LinkedList<Node> nodes;
            Node(int value)
            {
                this.value = value;
                nodes = new LinkedList<>();
            }
            @Override
            public String toString()
            {
                String result = String.valueOf(this.value);
                for (Node n : nodes)
                {
                    if (n != null)
                    {
                        result += "\n|-- ";
                        result += n.toString().replace("\n", "\n    ");
                    }
                }
                return result;
            }
        }

        public Node root;
        public NAryTree()
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
        TernaryTree t = new TernaryTree();
        t.root = new TernaryTree.Node(0);
        t.root.left = new TernaryTree.Node(1);
        t.root.left.left = new TernaryTree.Node(10);
        t.root.left.middle = new TernaryTree.Node(20);
        t.root.left.right = new TernaryTree.Node(30);
        t.root.middle = new TernaryTree.Node(2);
        t.root.middle.left = new TernaryTree.Node(100);
        t.root.middle.middle = new TernaryTree.Node(200);
        t.root.middle.right = new TernaryTree.Node(300);
        t.root.right = new TernaryTree.Node(3);
        t.root.right.left = new TernaryTree.Node(1000);
        t.root.right.middle = new TernaryTree.Node(2000);
        t.root.right.right = new TernaryTree.Node(3000);
        t.print();

        NAryTree t2 = new NAryTree();
        t2.root = new NAryTree.Node(0);

        NAryTree.Node tens = new NAryTree.Node(1);
        t2.root.nodes.add(tens);

        tens.nodes.add(new NAryTree.Node(10));
        tens.nodes.add(new NAryTree.Node(20));
        tens.nodes.add(new NAryTree.Node(30));
        tens.nodes.add(new NAryTree.Node(40));
        
        NAryTree.Node hundreds = new NAryTree.Node(2);
        t2.root.nodes.add(hundreds);
        hundreds.nodes.add(new NAryTree.Node(100));
        hundreds.nodes.add(new NAryTree.Node(200));
        hundreds.nodes.add(new NAryTree.Node(300));
        hundreds.nodes.add(new NAryTree.Node(400));

        NAryTree.Node thousands = new NAryTree.Node(3);
        t2.root.nodes.add(thousands);
        thousands.nodes.add(new NAryTree.Node(1000));
        thousands.nodes.add(new NAryTree.Node(2000));
        thousands.nodes.add(new NAryTree.Node(3000));
        thousands.nodes.add(new NAryTree.Node(4000));

        NAryTree.Node tenthousands = new NAryTree.Node(4);
        t2.root.nodes.add(tenthousands);
        tenthousands.nodes.add(new NAryTree.Node(10000));
        tenthousands.nodes.add(new NAryTree.Node(20000));
        tenthousands.nodes.add(new NAryTree.Node(30000));
        tenthousands.nodes.add(new NAryTree.Node(40000));
        t2.print();
    }
}
