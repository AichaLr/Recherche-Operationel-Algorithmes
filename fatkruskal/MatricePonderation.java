package com.company.fatkruskal;


import java.util.Scanner;

public class MatricePonderation
{
    private final int sommets;
    public static int[][] matrice;

    public static final int MAX_VALUE = 999;

    public MatricePonderation(int s)
    {
        sommets = s;
        matrice = new int[sommets+1][sommets+1];
    }
    public void inti(int s){
        for (int k =1;k <= s; k++) {
            for (int j = 1; j <= s; j++) {
                if (k==j){
                    matrice[k][j]=0;
                }
                else

                    matrice[k][j]=MAX_VALUE;

            }
        }

    }

    public void weight_matrice(int s1, int s2,int poids)
    {
        try
        {
            if ( s1 == s2) {
                        matrice[s1][s2] = 0;
                    }
                        else if (s1!=s2)
                        {
                            matrice[s1][s2]=poids;
                        }




        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("Erreur");
        }
    }



    public int getArcs(int s1, int s2)
    {


        return matrice[s1][s2];

    }
    public static void main(String args[])
    {
        int s, a, i = 1, s1 = 0, s2 = 0;
        int poids=0;

        Scanner sc = new Scanner(System.in);
        MatricePonderation m;
        try
        {
            System.out.println("Entrer le nombre de sommets: ");
            s= sc.nextInt();
            System.out.println("Entrer le nombre d'arcs : ");
            a= sc.nextInt();


            m = new MatricePonderation(s);

            System.out.println("Entrer les arcs sous forme s1 s2 poids :");
            m.inti(s);


                while (i <= a) {
                    s1 = sc.nextInt();
                    s2 = sc.nextInt();
                    poids=sc.nextInt();
                    m.weight_matrice(s1,s2,poids);


                    i++;
                }



            System.out.println("Votre Matrice De Ponderation est : ");
            System.out.print("    ");
            for (int k = 1; k <= s; k++)
                System.out.print(k + "      ");
            System.out.println();

            for (int k = 1; k <= s; k++)
            {
                System.out.print(k + "  ");
                for (int j = 1; j <= s; j++)
                {

                    System.out.print(m.getArcs(k,j) + "    ");}

                System.out.println();
            }


        }
        catch (Exception E)
        {
            System.out.println("Erreur");
        }


    }
}
