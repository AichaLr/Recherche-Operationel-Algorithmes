package com.company.fatkruskal;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class DijkstraAlgorithm {

    private int distances[];
    private Queue<Integer>atteints;//les atteints
    private Set<Integer> visit;///les visités
    private int nbr_Sommet;
    private int Ponderation[][];

    public DijkstraAlgorithm(int nbr_Sommet)
    {
        this.nbr_Sommet =nbr_Sommet;
        distances = new int[nbr_Sommet ];
        visit = new HashSet<Integer>();
        atteints = new LinkedList<Integer>();
        Ponderation = new int[nbr_Sommet ][nbr_Sommet ]; //kanat+1
    }
    public void dijkstra_algorithme(int pond[][], int source)
    {
        int evaluationSommet;
        for (int i = 0; i < nbr_Sommet; i++)
            for (int j = 0; j < nbr_Sommet; j++)
                Ponderation[i][j] = pond[i][j];

        for (int i = 0; i <nbr_Sommet; i++)
        {
            distances[i] =  1000;//Integer.MAX_VALUE;
        }

        atteints.add(source);
        distances[source] = 0;

        while (!atteints.isEmpty())
        {
            evaluationSommet = getMin();//node qui a le min
            visit.add(evaluationSommet);//on va ajouter leS nodes ds visités
            CalculSucc(evaluationSommet);
            //pr manipuler les succeseurs
        }
    }
    private int getMin()
    { int min ;
        int sommet = 0;
        Iterator<Integer> iterator = atteints.iterator();//pr parcourir
        sommet = iterator.next();//parcourir la fille
        min = distances[sommet];//dsitances contient le node 1 à linitialisation
        //au début le min c'es
        for (int i = 0; i < distances.length; i++)
        { if (atteints.contains(i))
        { if (distances[i] <= min)
        { min = distances[i];
            sommet= i;
        }}}
        atteints.remove(sommet);///retirer le node de la fille pr passer voir les autres
        //exemple : on coche la case de min
        return sommet;//la méthode va retourner le node qui a le min des distances
    }
    private void CalculSucc(int evaluationSommet)
    {
        int ArcDistance = -1;//Intialisation
        int NouvelleDistance = -1;

        for (int sommetDistination = 0; sommetDistination < nbr_Sommet; sommetDistination++)
        {
            if (!visit.contains(sommetDistination))
            {
                if (  Ponderation[evaluationSommet][sommetDistination]     !=1000/*Integer.MAX_VALUE*/)
                //si il existe un arc entre le node qui a le min et les autres nodes
                {
                    ArcDistance = Ponderation[evaluationSommet][sommetDistination];
                    //ds ce cas le poids représente la distance entre le sommet min et les autres
                    NouvelleDistance = distances[evaluationSommet] +ArcDistance;
                    // d(2)=d(1)+edgedistance déja calculé
                    if (NouvelleDistance < distances[sommetDistination])
                    //comparer le newdistance avc la distance de node
                    //si le newdistance est le min, la nouvelle distance de
                    //ditanceNode est la newdistance
                    //else il va garder son ancienne valeur,
                    {
                        distances[sommetDistination] = NouvelleDistance;

                    }
                    atteints.add(sommetDistination);//on ajoute ds les atteints
                }
            }
        }
    }
    public static void main(String... arg) throws FileNotFoundException {
        int matrice_ponderation[][];
        int nbr_sommet;
        int source = 0;
        Scanner scan = new Scanner(new File("C:\\Users\\aicha\\Desktop\\fich2.txt"));

        try
        {

            nbr_sommet = scan.nextInt();
            matrice_ponderation= new int[nbr_sommet + 1][nbr_sommet+ 1];


            for (int i = 0; i <nbr_sommet; i++)
            {
                for (int j = 0; j < nbr_sommet; j++)
                {
                    matrice_ponderation[i][j] = Integer.parseInt(scan.next());
                    if (i == j)
                    {
                        matrice_ponderation[i][j] = 0;
                        continue;
                    }
                    if (matrice_ponderation[i][j] == 0)
                    {
                        matrice_ponderation[i][j] = 1000;//Integer.MAX_VALUE;
                    }
                }
            }


            source = scan.nextInt();
            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(nbr_sommet);
            dijkstra.dijkstra_algorithme(matrice_ponderation, source);

            System.out.println("les plus courts chemins sont ");
            for (int i = 1; i <= dijkstra.distances.length - 1; i++)
            {
                System.out.println(source + " de " + i + " c'est " + dijkstra.distances[i]);
            }
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Erreur");
        }
        scan.close();
    }



}
