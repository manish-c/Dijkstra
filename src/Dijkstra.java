import java.util.Scanner;

public class Dijkstra
{
    static Scanner scan;
 
    public static void main(String[] args)
    {
    	scan = new Scanner(System.in);
    	
    	System.out.println("Enter no of Nodes");
    	int N = scan.nextInt();
    	
    	System.out.println("Enter the Undirected distance");
    	int N_1d = ((N*N)-N)/2;
    	int[] matrix1 = new int[N_1d];
    	int count = 0;
    	for (int i = 0; i < N_1d; i++)
    	{
    		matrix1[i] = scan.nextInt();
    	}
    	    	
    	int[] matrixpath = new int[N];
        int min = 100;
        int next = 0;
        int[] dist = new int[N];
        int[] visited_array = new int[N];
        
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N-1; i++)
        {
        	for (int j = i+1; j < N; j++)
        	{
        		matrix[i][j] = matrix1[count];
        		matrix[j][i] = matrix1[count];
        		count++;
        	}
        }
        
        for (int i = 0; i < N; i++)
        {
            visited_array[i] = 0;
            matrixpath[i] = 0;
 
            for (int j = 0; j < N; j++)
            {
            	if (i==j)
                    matrix[i][j] = 0; 
            	
                if (matrix[i][j]==0)
                    matrix[i][j] = 1000;
            }
        }
        
    	System.out.println("Enter Source");
    	int S = scan.nextInt();
    	
    	System.out.println("Enter Destination");
    	int D = scan.nextInt();
    	
        for (int i = 0; i < N; i++)		// replacing with 0
        {
        	int[]temp = new int[N];
        	temp[i] = matrix[0][i];
        	matrix[0][i] = matrix[S][i];
        	matrix[S][i] = temp[i];
        }
        
        for (int i = 0; i < N; i++)		// replacing with N-1
        {
        	int[]temp = new int[N];
        	temp[i] = matrix[N-1][i];
        	matrix[N-1][i] = matrix[D][i];
        	matrix[D][i] = temp[i];
        }

        
        
        dist = matrix[0];
        visited_array[0] = 1;
        dist[0] = 0;
 
        for (int counter = 0; counter < N; counter++)
        {
            min = 999;
            for (int i = 0; i < N; i++)
            {
                if (min > dist[i] && visited_array[i]!=1)
                {
                    min = dist[i];
                    next = i;
                }
            }
 
            visited_array[next] = 1;
            for (int i = 0; i < N; i++)
            {
                if (visited_array[i]!=1)
                {
                    if (min+matrix[next][i] < dist[i])
                    {
                        dist[i] = min+matrix[next][i];
                        matrixpath[i] = next;
                    }
                }
            }
        }

        System.out.println("\nShortest distance = "  + dist[D]);
        
        for (int i = N-1; i > 0; i--) 
        {
        	if(matrixpath[i]==0) {
        		matrixpath[i] = S;
        	}
        }
        
        System.out.println("\nShortest Path :");
        int i = D,j;
        
        	switch (i) {
        	case 0:	System.out.print("A");
        	         break;
        	case 1:	System.out.print("B");
        	         break;
        	case 2:	System.out.print("C");
        	         break;
        	case 3:	System.out.print("D");
        	         break;
        	case 4:	System.out.print("E");
        	         break;
        	case 5:	System.out.print("F");
        			  break;
        	case 6:	System.out.print("G");
        			  break;
        	case 7:	System.out.print("H");
			  		  break;
        	case 8:	System.out.print("I");
			  		  break;
        	case 9:	System.out.print("J");
			  		  break;
        	}
        	
        j = i;
        do
        {
        	j = matrixpath[j];
        	
        	switch (j) {
        	case 0:	System.out.print(" <== A");
        	         break;
        	case 1:	System.out.print(" <== B");
        	         break;
        	case 2:	System.out.print(" <== C");
        	         break;
        	case 3:	System.out.print(" <== D");
        	         break;
        	case 4:	System.out.print(" <== E");
        	         break;
        	case 5:	System.out.print(" <== F");
        			  break;
        	case 6:	System.out.print(" <== G");
        			  break;
        	case 7:	System.out.print(" <== H");
			  		  break;
        	case 8:	System.out.print(" <== I");
			  		  break;
        	case 9:	System.out.print(" <== J");
			  		  break;
        	}
        }
        while(j != S);
	}
}