package KShortestPathFinder;

import static java.lang.String.format;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Graph<V> 
{

    
    private Map<V,Map<V,Edge<V>>> vertexEdgeMap = new HashMap<>();

    @SafeVarargs
    public Graph(Edge<V> ... edges) 
    {
        for (Edge<V> edge : edges) 
        {
            addEdge(edge);
        }
    }

    private void addEdge(Edge<V> edge) 
    {
        vertexEdgeMap.putIfAbsent(edge.source, new HashMap<>());
        Map<V, Edge<V>> fromMap = vertexEdgeMap.get(edge.source);
        if(fromMap.containsKey(edge.destination)) 
        {
            throw new IllegalArgumentException(format("Edge between %s and %s are added twice", edge.source, edge.destination));
        }
        fromMap.put(edge.destination, edge);
    }

    public Edge<V> get(V source, V destination) 
    {
        return vertexEdgeMap.get(source).get(destination);
    }

    public Collection<Edge<V>> get(V source) 
    {
        return vertexEdgeMap.getOrDefault(source, Collections.emptyMap()).values();
    }

}
