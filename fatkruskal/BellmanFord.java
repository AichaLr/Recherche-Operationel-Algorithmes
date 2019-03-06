package com.company.fatkruskal;


import java.util.*;
	import java.lang.*; 
	import java.io.*; 

public class BellmanFord
	{ 
		class Arete2 { 
			int src, dest, ponderation; 
			Arete2() { 
				src = dest = ponderation = 0; 
			} 
		}

		int V, E; 
		Arete2 tab[]; 

public BellmanFord(int v, int e) 
		{ 
			V = v; 
			E = e; 
			tab = new Arete2[e]; 
			for (int i=0; i<e; ++i) 
				tab[i] = new Arete2(); 
		}
		void principal(BellmanFord graph,int src) 
		{ 
			int V = graph.V, E = graph.E; 
			int dist[] = new int[V]; 

		
			for (int i=0; i<V; ++i) 
				dist[i] = Integer.MAX_VALUE; 
			dist[src] = 0; 

		
			for (int i=1; i<V; ++i) 
				
			{ 
				for (int j=0; j<E; ++j) 
				{ 
					int u = graph.tab[j].src; 
					int v = graph.tab[j].dest; 
					int weight = graph.tab[j].ponderation; 
					if (dist[u]!=Integer.MAX_VALUE && 
						dist[u]+weight<dist[v] ) 
						dist[v]=dist[u]+weight; 
		               // mod=true;
				} 
			}
			/*if (mod) System.out.println("circuit ");
			else System.out.println(" non circuit ");*/
			
			for (int j=0; j<E; ++j) 
			{ 
				int u = graph.tab[j].src; 
				int v = graph.tab[j].dest; 
				int weight = graph.tab[j].ponderation; 
				if (dist[u] != Integer.MAX_VALUE && 
					dist[u]+weight < dist[v]) 
				System.out.println(" oups  ! Graphe contient  cycle negative ");
			} 
			afficher(dist, V); 
		} 

 
		void afficher(int dist[], int V) 
		{ 
			for (int i=0; i<V; ++i) 
				System.out.println(" la  distance de "+i+"depuis la source est :"+" "+dist[i]);
				
		} 

		public static void main(String[] args) throws IOException 
		{ int s,s1,s2,s3,b,V,E;
    	
    	Scanner sc=new Scanner(new File("C:\\Users\\aicha\\Desktop\\bellman.txt"));

    	V=sc.nextInt();
    	E=sc.nextInt();
    	BellmanFord g = new BellmanFord(V, E); 
    	
    	for(int i=0;i<E;i++) {
    		s1=Integer.parseInt(sc.next());
    		s2=Integer.parseInt(sc.next());
    		s3=Integer.parseInt(sc.next());
    	
    		g.tab[i].src = s1; 
			g.tab[i].dest = s2; 
			g.tab[i].ponderation = s3;
    	}
			
			

			
			g.principal(g, 0); 
		} 
	} 


