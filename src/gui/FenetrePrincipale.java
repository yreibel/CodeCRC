package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Classe représentant la fenêtre de lancement de l'application
 * @author Yann REIBEL L3 INFO
 */
public class FenetrePrincipale extends JFrame{

    private PanelParametrage panelParametrage;
    private PanelCRC panelCRC;

    /**
     * Constructeur FenetrePrincipale
     */
    public FenetrePrincipale(){
        super("Fenêtre principale");

        this.initialisationComposants();


        this.pack();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Initialisation des panels dans la fenêtre principale
     */
    public void initialisationComposants(){
        this.panelParametrage = new PanelParametrage(this);
        this.panelCRC = new PanelCRC(this);

        this.ajoutComposantsFenetre();
    }

    /**
     * Ajout des panels à la fenêtre principale
     */
    public void ajoutComposantsFenetre(){
        this.add(this.panelParametrage, BorderLayout.NORTH);
        this.add(this.panelCRC, BorderLayout.CENTER);
    }

    /**
     * Retourne le PanelParametrage
     * @return PanelParametrage
     */
    public PanelParametrage getPanelParametrage(){
        return this.panelParametrage;
    }

    /**
     * Retourne le PanelCRC
     * @return PanelCRC
     */
    public PanelCRC getPanelCRC(){
        return this.panelCRC;
    }

    /**
     * Main de lancement
     * @param args
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(FenetrePrincipale::new);
    }
}
