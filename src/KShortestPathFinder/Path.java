package KShortestPathFinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import static java.lang.String.format;


public class Path<V>
{

    private final V node;
    private final double totalCost;

    public Path(V source) 
    {
        Objects.requireNonNull(source, "Source node is null.");
        node = source;
        totalCost = 0.0;
    }

    private Path(V node, double totalCost)
    {
        this.node = node;
        this.totalCost = totalCost;
    }


    public Path<V> append(Edge<V> edge) 
    {
        if (!node.equals(edge.source)) 
        {
            throw new IllegalArgumentException(format("The edge %s doesn't extend the path %s", edge, this.getNodeList()));
        }

        return new NonEmptyPath<>(this, edge);
    }

    public V getEndNode() 
    {
        return node;
    }

    public List<V> getNodeList() 
    {
        return new ArrayList<>();
    }

    public double pathCost() 
    {
        return totalCost;
    }

    private static class NonEmptyPath<V> extends Path<V>
    {
        private final Path<V> predecessor;

        public NonEmptyPath(Path<V> path, Edge<V> edge)
        {
            super(edge.destination, path.totalCost + edge.weight);
            predecessor = path;

        }

        @Override
        public List<V> getNodeList() 
        {
            LinkedList<V> result = new LinkedList<>();
            Path<V> path = this;
            while(path instanceof NonEmptyPath)
            {
                result.addFirst(path.node);
                path = ((NonEmptyPath<V>) path).predecessor;
            }
            result.addFirst(path.node);
            return result;
        }
    }

}
