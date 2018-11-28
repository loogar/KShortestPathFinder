package KShortestPathFinder;

public class Edge<V> 
{

    public final V source;
    public final V destination;
    public final double weight;


    public Edge(V source, V destination, double weight)
    {
    	
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        
        
        //to check the weight condition
        
        //1. if the weight on edge between 2 nodes is not a number
        if (Double.isNaN(weight))
        {
            throw new IllegalArgumentException("The weight is Not a Number.");
        }
        
        //2. if the weight on edge between 2 nodes is negative
        if (weight < 0.0) 
        {
            throw new IllegalArgumentException("The weight is negative.");
        }
    }

}