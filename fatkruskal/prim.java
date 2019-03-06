package com.company.fatkruskal;

import java.util.Scanner;
 
class prim {

    private static final int S = 5;


    int min(int key[], Boolean mstSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < S; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }


    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("arc   ponderation");
        for (int i = 1; i < S; i++)
            System.out.println(parent[i] + " - " + i + "    " +
                    graph[i][parent[i]]);
    }


    void primMST(int graph[][]) {

        int parent[] = new int[S];//contient tout les Arc


        int key[] = new int[S];//min


        Boolean mstSet[] = new Boolean[S];

        // Initializer tt les valeurs  inf
        for (int i = 0; i < S; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }


        key[0] = 0;
        parent[0] = -1;


        for (int count = 0; count < S - 1; count++) {

            int u = min(key, mstSet);


            mstSet[u] = true;


            for (int v = 0; v < S; v++)


                if (graph[u][v] != 0 && mstSet[v] == false &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }


        printMST(parent, S, graph);
    }


    public static void main (String[] args)
    {
        
        Scanner n=new Scanner(System.in);   
        prim t = new prim();
        
       
        int graph[][] = new int[][] { {0,1,0,0,0,5},
        	                          {1,0,0,3,14,0},
                                      {8,0,0,0,0,11},
                                      {0,3,0,0,12,2},
                                      {0,14,0,12,0,0},
                                      {5,0,11,2,0,0 }
        	
           };
        
 
        
        t.primMST(graph);
    }

}
