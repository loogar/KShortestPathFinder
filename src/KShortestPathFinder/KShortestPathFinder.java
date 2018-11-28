package KShortestPathFinder;
import java.util.List;


public interface KShortestPathFinder<V> 
{

    List<Path<V>> findShortestPaths(V source, V target, Graph<V> graph, int k);

    default void checkvalueofK(int k)
    {
        if (k < 1) {
            throw new IllegalArgumentException(
                    String.format("The value of k is too small: %d, should be at least 1.", k));
        }
    }
}