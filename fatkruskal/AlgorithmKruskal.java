package com.company.fatkruskal;

import java.util.*;

public class AlgorithmKruskal{

    //	Disjoint Sets Data Structure
    int pere[] = new int[10];

    int find(int x){
        if(pere[x] == x){
            return x;
        }
        return find(pere[x]);
    }

    void unite(int x, int y){
        int fx = find(x);
        int fy = find(y);
        pere[fx] = fy;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        AlgorithmKruskal samp = new AlgorithmKruskal();
        //	initialiser fathers pour ensemble
        for(int i=0;i<10;i++){
            samp.pere[i]=i;
        }
        int n,m;
        int a,b,w;
        ArrayList<arc> edges = new ArrayList<arc>();


        System.out.println("enter the num of vertics");
        n = scanner.nextInt();
        System.out.println("enter the num of Arcs");

        m = scanner.nextInt();
        for(int i=0;i<m;i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            w = scanner.nextInt();
            edges.add(new arc(w,a,b));
        }

        System.out.println();





        int arbre_weight = 0, nb = 0;
        int	nbr_arc = 0;

        Collections.sort(edges, new Comparator<arc>() {
            @Override
            public int compare(arc p1, arc p2) {
                return p1.w - p2.w;
            }
        });

        while( ( nb <= n-1) || (nbr_arc < m) ){

            a = edges.get(nbr_arc).a;
            b = edges.get(nbr_arc).b;
            w = edges.get(nbr_arc).w;
            //	si a et b n'ont pas le mm pere
            if( samp.find(a) != samp.find(b) ) {
                //	on les connect
                samp.unite(a,b);

                arbre_weight += w;


                System.out.println(a + " " + b + " " + w);
                nb++;
            }


            nbr_arc++;
        }

        //System.out.println( "\nWeight of the arbre is " + arbre_weight);

    }

}