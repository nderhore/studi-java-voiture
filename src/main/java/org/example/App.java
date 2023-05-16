package org.example;

import org.example.connector.ConnectDB;
import org.example.customExceptions.IllegalNumberChoice;
import org.example.dao.impl.VoitureDAOImpl;
import org.example.pojo.Energie;
import org.example.pojo.Garage;
import org.example.pojo.Voiture;
import org.example.pojo.VoitureElectrique;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws SQLException {


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
        VoitureDAOImpl voitureDAO = new VoitureDAOImpl();
        Voiture maVoiture = new Voiture(monEnergie, nom, stateVoiture);
        voitureDAO.add(maVoiture);

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
