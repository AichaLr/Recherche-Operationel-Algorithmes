package com.company.fatkruskal;

import java.util.Scanner;

public class MatriceIncidence {
    private int [][] matrice ;
    private int nb_sommets;
    private int nb_arcs;

    public MatriceIncidence(int nbs,int nba) {
        this.nb_sommets=nbs;
        this.matrice = new int [nbs][nba];
        this.nb_arcs= nba;

    }
    public void putArcsplus(int s1,int s2)
    {
        try
        {
            matrice[s1-1][s2-1] = 1;
             }
        catch (ArrayIndexOutOfBoundsException index)
        { System.out.println("Erreur"); }
    }
    public void putArcsmoins(int s1,int s2)
    {
        try
        {
            matrice[s1-1][s2-1] = -1;
        }
        catch (ArrayIndexOutOfBoundsException index)
        { System.out.println("Erreur"); }
    }

    public void printMatrice(){


        for (int i = 0; i < matrice.length; i++)
        {
            for (int j = 0; j <matrice[i].length; j++)
                System.out.print(matrice [i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String args[])
    {   MatriceIncidence mat;
        int sommet,arc;  String rep;
        int i=1,m1,m2,ar;
        Scanner sc = new Scanner(System.in);

        try
        {    System.out.println("Création de la matrice d'incidence à partir d'un graphe : ");
            System.out.println("quel est le nombre de sommets ? ");
            sommet= sc.nextInt();
            System.out.println("quel est le nombre d'arcs ? ");
            arc= sc.nextInt();

            mat= new MatriceIncidence(sommet,arc);

            System.out.println("le graphe est-il orienté ? Oui/Non ");
            rep= sc.next();
            if (rep.equalsIgnoreCase("oui")){

                System.out.println("Entrer les arcs sous forme de paires source/destination:");
                while (i <= arc)
                {
                    m1 = sc.nextInt();    m2 = sc.nextInt();
                    mat.putArcsmoins(m1,i);
                    mat.putArcsplus(m2,i);
                    i++;
                }

                System.out.println("Votre Matrice D'incidence est : ");
                mat.printMatrice();
            }
            else if (rep.equalsIgnoreCase("non")){

                System.out.println("Entrer les arcs sous forme de paires source/destination:");
                while (i <= arc)
                {
                    m1= sc.nextInt();    m2 = sc.nextInt();
                    mat.putArcsplus(m1,i);
                    mat.putArcsplus(m2,i);
                    i++;
                }

                System.out.println("Votre Matrice D'incdence est : ");
                mat.printMatrice();
            }
            else {System.out.println("Erreur");}
        }
        catch (Exception E)
        { System.out.println("Erreur"); }


    }
}
