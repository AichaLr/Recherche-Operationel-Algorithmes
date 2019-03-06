package com.company.fatkruskal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloydAlgorithm
{
    private int distance[][];
    private int numSommet;
    public static final int INFINITY = 1000;

    public FloydAlgorithm(int numSommet)
    {
        distance = new int[numSommet + 1][numSommet + 1];
        this.numSommet = numSommet;
    }

    public void floyd(int Matrice_Adjacence[][])
    {
        for (int source = 1; source <= numSommet; source++)
        {
            for (int destination = 1; destination <= numSommet; destination++)
            {
                distance[source][destination] = Matrice_Adjacence[source][destination];
            }
        }
        for (int intermediaire = 1; intermediaire <= numSommet; intermediaire++)
        {
            for (int source = 1; source <= numSommet; source++)
            {
                for (int destination = 1; destination <= numSommet; destination++)
                {
                    if (distance[source][intermediaire] + distance[intermediaire][destination] < distance[source][destination])
                        distance[source][destination] = distance[source][intermediaire] + distance[intermediaire][destination];
                }
            }
        }

        for (int source = 1; source <= numSommet; source++)
            System.out.print("\t" + source);

        System.out.println();
        for (int source = 1; source <= numSommet; source++)
        {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= numSommet; destination++)
            {
                System.out.print(distance[source][destination] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String... arg) throws FileNotFoundException {
        int Matrice_Adjacence[][];
        int numSommet;

        Scanner scan = new Scanner(new File("C:\\Users\\aicha\\Desktop\\fich2.txt"));
        numSommet = scan.nextInt();

        Matrice_Adjacence = new int[numSommet + 1][numSommet + 1];
        for (int source = 1; source <= numSommet; source++)
        {
            for (int destination = 1; destination <= numSommet; destination++)
            {
                Matrice_Adjacence[source][destination] = scan.nextInt();
                if (source == destination)
                {
                    Matrice_Adjacence[source][destination] = 0;
                    continue;
                }
                if (Matrice_Adjacence[source][destination] == 0)
                {
                    Matrice_Adjacence[source][destination] = INFINITY;
                }
            }
        }

        System.out.println("les chemins obtenus : ");
        FloydAlgorithm floydwarshall = new FloydAlgorithm(numSommet);
        floydwarshall.floyd(Matrice_Adjacence);
        scan.close();
    }
}