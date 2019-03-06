package com.company.fatkruskal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListAdjacence
{
    private Map<Integer, List<Integer>> ListAdjacence;

    public ListAdjacence (int s)
    {
        ListAdjacence = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= s; i++)
            ListAdjacence.put(i, new LinkedList<Integer>());
    }



    public List<Integer> getArcs(int s1)
    {
        return ListAdjacence.get(s1);
    }


    public void Arcs(int s1, int s2)
    {
        List<Integer> l1 = ListAdjacence.get(s1);
        l1.add(s2);
        List<Integer> l2 = ListAdjacence.get(s2);
        l2.add(s1);
    }

    public static void main(String args[])
    {
        int s, a, cp = 1, s1, s2;



        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.println("Entrer le nombre de sommets: ");
            s = sc.nextInt();
            System.out.println("Entrer le nombre d'arcs: ");
            a = sc.nextInt();

            ListAdjacence list = new ListAdjacence(s);

            System.out.println("Entrer les arcs sous forme s1 s2 :");
            while (cp <= a)
            {
                s1 = sc.nextInt();
                s2= sc.nextInt();

                list.Arcs(s1, s2);
                cp++;
            }

            System.out.println("Votre List Adjacence est : ");

            for (int i = 1; i <= s; i++)
            {
                System.out.print(i + "->");
                List<Integer> la = list.getArcs(i);
                for (int j = 1;; j++)
                {
                    if (j != la.size())
                        System.out.print(la.get(j-1) + " -> ");
                    else
                    {
                        System.out.print(la.get(j-1));
                        break;
                    }
                }
                System.out.println();
            }
        }
        catch (Exception E)
        {
            System.out.println("Erreur");
        }

    }
}
