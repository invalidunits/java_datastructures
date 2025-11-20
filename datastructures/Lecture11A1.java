import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Lecture11A1 {
    static public class Graph
    {
        private HashMap<String, ArrayList<String>> adjacencyList;
        
        public Graph()
        {
            adjacencyList = new HashMap<>();
        }

        public void addVertex(String vertex)
        {
            adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        }

        public void addEdge(String vertex1, String vertex2)
        {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
        }

        public void printGraph()
        {
            for (String vertex : adjacencyList.keySet())
            {
                System.out.println(vertex + " -> " + adjacencyList.get(vertex));
            }
        }
    }
    public static void main(String[] args) 
    {
        Graph schoolSubjectGraph = new Graph();

        schoolSubjectGraph.addVertex("Calculus");
        schoolSubjectGraph.addVertex("Linear Algebra");
        schoolSubjectGraph.addVertex("Discrete Math");

        schoolSubjectGraph.addVertex("Physics");
        schoolSubjectGraph.addVertex("Chemistry");
        schoolSubjectGraph.addVertex("Biology");

        schoolSubjectGraph.addVertex("Psychology");
        schoolSubjectGraph.addVertex("Geography");

        schoolSubjectGraph.addEdge("Calculus", "Linear Algebra"); 
        schoolSubjectGraph.addEdge("Linear Algebra", "Discrete Math");
        schoolSubjectGraph.addEdge("Discrete Math", "Calculus");

        schoolSubjectGraph.addEdge("Physics", "Calculus");
        schoolSubjectGraph.addEdge("Physics", "Linear Algebra");

        schoolSubjectGraph.addEdge("Physics", "Chemistry");
        schoolSubjectGraph.addEdge("Chemistry", "Biology");
        schoolSubjectGraph.addEdge("Biology", "Psychology");
        schoolSubjectGraph.addEdge("Chemistry", "Geography");
        schoolSubjectGraph.addEdge("Physics", "Geography");
        schoolSubjectGraph.printGraph();
    }
}
