import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Lecture11A3 {
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

        public void BFS(String start)
        {
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty())
            {
                String current = queue.poll();

                for (String neighbor : adjacencyList.get(current)) 
                {
                    if (!visited.contains(neighbor))
                    {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            System.out.println("Accessible from " + start + ": " + visited);
        }

        public LinkedList<String> BFSSearch(String start, String end)
        {
            Queue<String> queue = new LinkedList<>();
            HashMap<String, LinkedList<String>> visited = new HashMap<>();

            queue.add(start);
            visited.put(start, new LinkedList<>());
            if (start == end) return new LinkedList<>();

            while (!queue.isEmpty())
            {
                String current = queue.poll();

                for (String neighbor : adjacencyList.get(current)) 
                {
                    if (!visited.containsKey(neighbor))
                    {
                        queue.add(neighbor);
                        LinkedList<String> pathtoneighbor = new LinkedList<>();
                        pathtoneighbor.addAll(visited.get(current));
                        pathtoneighbor.add(current);
                        visited.put(neighbor, pathtoneighbor);
                        if (neighbor == end) 
                        {
                            LinkedList<String> ret = new LinkedList<>();
                            ret.addAll(pathtoneighbor);
                            ret.add(neighbor);
                            return ret;
                        }
                    }
                }
            }
            return null;
        }

        public LinkedList<LinkedList<String>> DFSSearch(String start, String end, HashSet<String> visited)
        {
            visited.add(start);
            LinkedList<LinkedList<String>> paths = new LinkedList<>();
            if (start == end) 
            {
                LinkedList<String> endpath = new LinkedList<>();
                endpath.add(end);
                paths.add(endpath);
                return paths;
            }

            for (String neighbor : adjacencyList.get(start)) 
            {
                if (!visited.contains(neighbor))
                {   
                    HashSet<String> newvisited = new HashSet<>();
                    newvisited.addAll(visited);
                    newvisited.add(start);
                    LinkedList<LinkedList<String>> newpaths = DFSSearch(neighbor, end, newvisited);
                    for (LinkedList<String> path : newpaths)
                    {
                        path.addFirst(start);
                        paths.add(path);
                    }
                }
            }

            return paths;
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

        schoolSubjectGraph.BFS("Calculus");

        System.out.println("(BFS) Shortest path from Psychology to Geography: " + schoolSubjectGraph.BFSSearch("Psychology", "Geography").toString()); 
        System.out.println("(DFS) All paths from Psychology to Geography: ");  
        for (LinkedList<String> path : schoolSubjectGraph.DFSSearch("Psychology", "Geography", new HashSet<>())) {
            System.out.println(path.toString());
        }

    }
}
