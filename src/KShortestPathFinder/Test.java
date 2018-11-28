package KShortestPathFinder;

import java.util.List;
import java.util.Scanner;

public class Test
{
	  public static void main(String[] args) 
	    {
	        test();
	    }

	  private static void test() 
	    {
	        //    b    e   h
	        //  /  \  / \ /
	        // a    d    g
	        //  \  / \  /
	        //   c    f
            
		/*  M4 route
		  a- P port de clignancourt
		  b- M marcadet-Poissonniers
		  d- C Chateau Rouge
		  e- B Barbes-Rochechourt
		  g- N Gare du nord
		  h- E Gare de L'est

		  M12 route
		  c- J joules joffrin
		  f- P pigalle*/


	    // here a and b represent nodes and 2.5 represents the distance between them. Like wise for all nodes.

	        Graph<Character> graph = new Graph<>(
	                new Edge<>('a', 'b', 2.5),
	                new Edge<>('a', 'c', 1.8),
	                new Edge<>('b', 'd', 3.0),
	                new Edge<>('c', 'd', 1.6),

	                new Edge<>('d', 'e', 1.2),
	                new Edge<>('d', 'f', 1.1),
	                new Edge<>('e', 'g', 1.3),
	                new Edge<>('f', 'g', 1.0),
	                new Edge<>('g', 'h', 1.1)
	                
	        );
	        
	      
	        System.out.println("M4 route a-  port de clignancourt ,b-  marcadet-Poissonniers, d-  Chateau Rouge,e-  Barbes-Rochechourt,g-  Gare du nord,h- Gare de L'est");
	        System.out.println("M12 route c-  joules joffrin, f  pigalle");
	        Scanner scanner1 = new Scanner (System.in);// Character input
	        System.out.print("Enter Starting  Node");  

	        // Character input
	        char start = scanner1.next().charAt(0);
	        System.out.print("Enter End  Node"); 
	        Scanner scanner2 = new Scanner (System.in);// Character input
	        char end = scanner2.next().charAt(0);
	        
	        System.out.print("Enter the Number of Possible (K) PATH"); 
	        Scanner scanner3 = new Scanner (System.in);// Possible K path value input
	        int kpath  = scanner3.nextInt();

	        List<Path<Character>> paths = new AllPossibleKShortestPath<Character>()
	                .findShortestPaths(start, end, graph, kpath);
	        
	       // System.out.println(paths.size());
	        int possiblepath=paths.size();
	        if(possiblepath>kpath)
	        {
	        	System.out.println("there are more possible paths available");
	        }
	        else{
	        	System.out.println("The "+possiblepath+"  "+ "possible paths available are ");
	        }
	        
	        System.out.println("Available paths between " + start+" and "+ end+" in ascending order of cost(Here it is distance)");
	        for (Path<Character> path : paths) 
	        {	
	        	
	            System.out.println(path.getNodeList() + " " + path.pathCost());
	               
	        }
	        //System.out.println(paths.size());
	    }
	}

