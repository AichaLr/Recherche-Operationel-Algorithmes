package com.company.fatkruskal;

import java.util.Scanner;

public class MatriceAdjacence
{
    private final int sommets;
    public static int[][] matrice;

    public MatriceAdjacence(int s)
    {
        sommets = s;
        matrice = new int[s+1][s+1];
    }


    public void ArcsNO(int s1, int s2)
    {
        try
        {
            matrice[s1][s2] =1;
            matrice[s2][s1]=1;
        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("Erreur");
        }
    }
    public void ArcsO(int s1,int s2){
        matrice [s1][s2]=1;
    }


    public int getArcs(int s1, int s2)
    {


        return matrice[s1][s2];

    }
    public static void main(String args[])
    {
        int s, a, i = 1, s1 = 0, s2 = 0;
        String g;

        Scanner sc = new Scanner(System.in);
        MatriceAdjacence m;
        //try
        //{
            System.out.println("Entrer le nombre de sommets: ");
            s= sc.nextInt();
            System.out.println("Entrer le nombre d'arcs : ");
            a= sc.nextInt();

            System.out.println("Entrer le type de graphe GNO ou GO ");
            g=sc.next();
            m = new MatriceAdjacence(s);

            System.out.println("Entrer les arcs sous forme s1 s2 :");
            if (g.equals("GNO")) {
                while (i <= a) {
                    s1 = sc.nextInt();
                    s2 = sc.nextInt();

                    m.ArcsNO(s1, s2);
                    i++;
                }
            }
            else if (g.equals("GO"))
            {
                while (i <= a) {
                    s1 = sc.nextInt();
                    s2 = sc.nextInt();

                    m.ArcsO(s1, s2);
                    i++;
                }

            }

            System.out.println("Votre Matrice D'adjacence est : ");
            System.out.print("  ");
            for (int k = 1; k <= s; k++)
                System.out.print(k + " ");
            System.out.println();

            for (int k = 1; k <= s; k++)
            {
                System.out.print(k + " ");
                for (int j = 1; j <= s; j++)
                    System.out.print(m.getArcs(k, j) + " ");
                System.out.println();
            }


        }
        /*catch (Exception E)
        {
            System.out.println("Erreur");
        }


    }*/
}
