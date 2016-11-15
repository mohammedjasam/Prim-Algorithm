package P;

//Program for transitive closure using Floyd Warshall Algorithm
import java.util.*;
import java.lang.*;
import java.io.*;

class TransitiveClosure
{
 final static int V = 4; //Number of vertices in a graph

 // Prints transitive closure of graph[][] using Floyd
 // Warshall algorithm
 void transitiveClosure(int graph[][])
 {
     /* reach[][] will be the output matrix that will finally
        have the shortest  distances between every pair of
        vertices */
     int reach[][] = new int[V][V];
     int  i, j, k;

     /* Initialize the solution matrix same as input graph
        matrix. Or  we can say the initial values of shortest
        distances are based  on shortest paths considering
        no intermediate vertex. */
     for (i = 0; i < V; i++)
         for (j = 0; j < V; j++)
             reach[i][j] = graph[i][j];

     /* Add all vertices one by one to the set of intermediate
        vertices.
       ---> Before start of a iteration, we have reachability
            values for all  pairs of vertices such that the
            reachability values consider only the vertices in
            set {0, 1, 2, .. k-1} as intermediate vertices.
       ----> After the end of a iteration, vertex no. k is
             added to the set of intermediate vertices and the
             set becomes {0, 1, 2, .. k} */
     for (k = 0; k < V; k++)
     {
         // Pick all vertices as source one by one
         for (i = 0; i < V; i++)
         {
             // Pick all vertices as destination for the
             // above picked source
             for (j = 0; j < V; j++)
             {
                 // If vertex k is on a path from i to j,
                 // then make sure that the value of reach[i][j] is 1
                 reach[i][j] = (reach[i][j]!=0) ||
                          ((reach[i][k]!=0) && (reach[k][j]!=0))?1:0;
             }
         }
     }

     // Print the shortest distance matrix
     printSolution(reach);
 }

 /* A utility function to print solution */
 void printSolution(int reach[][])
 {
     System.out.println("Following matrix is transitive closure"+
                        " of the given graph");
     for (int i = 0; i < V; i++)
     {
         for (int j = 0; j < V; j++)
             System.out.print(reach[i][j]+" ");
         System.out.println();
     }
 }

 // Driver program to test above function
 public static void main (String[] args)
 {
     /* Let us create the following weighted graph
        10
     (0)------->(3)
     |         /|\
   5 |          |
     |          | 1
     \|/        |
     (1)------->(2)
        3           */

     /* Let us create the following weighted graph

           10
      (0)------->(3)
       |         /|\
     5 |          |
       |          | 1
      \|/         |
      (1)------->(2)
         3           */
	 int graph[][] = new int[][] {
		 {0, 1, 0, 0, 0},
         {1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
        };
        //int a11 = 0; 
        int w= 0;
	for(int i=1;i<4;i++)
	{
		Random rand = new Random();

		int a11 = rand.nextInt(i)+1;
		w = rand.nextInt(5)+1;
		graph[i+1][a11] = w;
		graph[a11][i+1] = w;
		
	}
//	for (int i = 0; i < 5; i++) {
//	    for (int j = 0; j < 5; j++) {
//	        //System.out.print(graph[i][j] + " ");
//	    }
//	    System.out.println();
//	}
	System.out.println( " ");
	for(int i = 0; i<5; i++){
		for(int j = 0; j<5; j++)
		{
			if(graph[i][j] == 0 && i!=j)
			{
				Random rand = new Random();
				//graph[i][j] = ;
				graph[i][j] = graph[j][i]=rand.nextInt(100)+20;
			}
		}}
      // Print the solution
    TransitiveClosure g = new TransitiveClosure();
      g.transitiveClosure(graph);
 }
}
//This code is contributed by Aakash Hasija