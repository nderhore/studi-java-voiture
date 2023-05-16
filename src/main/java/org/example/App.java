package org.example;

import org.example.customExceptions.IllegalNumberChoice;
import org.example.pojo.Energie;
import org.example.pojo.Garage;
import org.example.pojo.Voiture;
import org.example.pojo.VoitureElectrique;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        //Création d'une voiture
        // -> Energie , state, nom
        System.out.println("donnez moi le nom de votre voiture : ");
        String nom = sc.nextLine();

        String state = "";
        while (!state.equals("O") && !state.equals("N")) {
            System.out.println("est-ce que votre voiture est allumé ? O/N");
            state = sc.nextLine().toUpperCase();
        }
        boolean stateVoiture = state.equals("O");

        System.out.println("Voici les energies disponibles:");
        Energie[] values = Energie.values();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            stringBuilder.append(i).append(" - ").append(values[i]).append("\n"); //energiesPossible = energiesPossible +
        }
        System.out.println(stringBuilder);

        int nbEnergie = -1;

        try{
            nbEnergie = choiceEnergie(values);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        Energie monEnergie = null;

        try {
            monEnergie = values[nbEnergie];
        }catch (ArrayIndexOutOfBoundsException e){
            monEnergie = values[0];
        }
        System.out.println(new Voiture(monEnergie, nom, stateVoiture));

    }

    public static int choiceEnergie(Energie[] values) throws NumberFormatException{
        boolean verif = false;
        int nbEnergie = -1;
        while (!verif) {
            //Gestion d'erreur
            try {
                System.out.println("Entrez votre choix : ");
                String saisie = sc.nextLine();
                nbEnergie = Integer.parseInt(saisie);
                if (nbEnergie < 0 || nbEnergie >= values.length) {
                    throw new IllegalNumberChoice();
                }
                verif = true;
            }catch (IllegalNumberChoice e){
                System.out.println(e.getMessage());
            }
        }
        return nbEnergie;
    }
}
