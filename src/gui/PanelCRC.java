package gui;

import evenements.EcouteurCalculVerification;

import javax.swing.*;
import java.awt.*;

/**
 * Panel dédié au codage et à la vérification d'un message
 * @author Yann REIBEL L3 INFO
 */
public class PanelCRC extends JPanel {

    private FenetrePrincipale fenetrePrincipale;

    private JPanel panelCodage;
    private JPanel panelVerification;

    private JLabel labelIndicMessageACoder;
    private JLabel labelIndicMessageAVerifier;

    private JLabel labelMessageACoder;
    private JLabel labelMessageAVerifier;

    private JTextField txtMessageACoder;
    private JTextField txtMessageAVerifier;

    private JButton btnCodage;
    private JButton btnVerification;


    /**
     * Constructeur PanelCRC
     * @param fenetrePrincipale
     */
    public PanelCRC(FenetrePrincipale fenetrePrincipale){
        this.fenetrePrincipale = fenetrePrincipale;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.initialisationComposants();


    }

    /**
     * Fait appel aux méthodes d'initialisation dans les panels Codage et Verification
     */
    public void initialisationComposants(){
        this.initialisationComposantsPanelCodage();
        this.initialisationComposantsPanelVerification();

        this.ajoutActions();

        this.ajoutComposants();

    }

    /**
     * Initialise les composants dans le PanelCodage
     */
    public void initialisationComposantsPanelCodage(){
        this.panelCodage = new JPanel();
        this.panelCodage.setLayout(new BorderLayout());

        this.labelIndicMessageACoder = new JLabel("Saisissez un message à coder");
        this.txtMessageACoder = new JTextField();
        this.labelMessageACoder = new JLabel("");
        this.btnCodage = new JButton("Coder");


        this.ajoutComposantsPanelCodage();
    }

    /**
     * Initialise les composants dans le PanelVerification
     */
    public void initialisationComposantsPanelVerification(){
        this.panelVerification = new JPanel();
        this.panelVerification.setLayout(new BorderLayout());

        this.labelIndicMessageAVerifier = new JLabel("Saisissez un message à vérifier");
        this.txtMessageAVerifier = new JTextField();
        this.labelMessageAVerifier = new JLabel("");
        this.btnVerification = new JButton("Vérification");

        this.ajoutComposantsPanelVerification();
    }


    /**
     * Ajoute les deux panels au panel CRC
     */
    public void ajoutComposants(){
        this.add(this.panelCodage);
        this.add(this.panelVerification);
    }

    /**
     * Ajoute les composants au PanelCodage
     */
    public void ajoutComposantsPanelCodage(){
        this.panelCodage.add(this.labelIndicMessageACoder, BorderLayout.NORTH);
        this.panelCodage.add(this.txtMessageACoder, BorderLayout.CENTER);
        this.panelCodage.add(this.labelMessageACoder, BorderLayout.SOUTH);
        this.panelCodage.add(this.btnCodage, BorderLayout.EAST);
    }

    /**
     * Ajoute les composants au PanelVerification
     */
    public void ajoutComposantsPanelVerification(){
        this.panelVerification.add(this.labelIndicMessageAVerifier, BorderLayout.NORTH);
        this.panelVerification.add(this.txtMessageAVerifier, BorderLayout.CENTER);
        this.panelVerification.add(this.labelMessageAVerifier, BorderLayout.SOUTH);
        this.panelVerification.add(this.btnVerification, BorderLayout.EAST);
    }

    /**
     * Ajoute un écouteur pour les boutons de codage et de vérification
     */
    public void ajoutActions(){
       this.btnCodage.addActionListener(new EcouteurCalculVerification(this.fenetrePrincipale, this));
       this.btnVerification.addActionListener(new EcouteurCalculVerification(this.fenetrePrincipale, this));
    }


    /**
     * Retourne le bouton pour coder le message
     * @return JButton
     */
    public JButton getBtnCodage(){
        return this.btnCodage;
    }

    /**
     * Retourne le bouton permettant de lancer la vérification du message
     * @return JButton
     */
    public JButton getBtnVerification(){
        return this.btnVerification;
    }

    /**
     * Retourne le textfield où saisir le message à coder
     * @return JTextField
     */
    public JTextField getTxtMessageACoder(){
        return this.txtMessageACoder;
    }

    /**
     * Retourne le textfield où saisir le message à vérifier
     * @return JTextField
     */
    public JTextField getTxtMessageAVerifier(){
        return this.txtMessageAVerifier;
    }

    /**
     * Retourne le label où sera affiché le message codé
     * @return JLabel
     */
    public JLabel getLabelMessageACoder(){
        return this.labelMessageACoder;
    }

    /**
     * Retourne le label où sera affiché le résultat de la vérification
     * @return JLabel
     */
    public JLabel getLabelMessageAVerifier(){
        return this.labelMessageAVerifier;
    }

    /**
     * Méthode permettant d'appliquer un texte au label où est affiché le message codé
     * @param message
     */
    public void setLabelMessageACoder(String message){
        this.labelMessageACoder.setText(message);
    }

    /**
     * Méthode permettant d'appliquer un texte au label où est affiché le résultat de la vérification
     * @param message
     */
    public void setLabelMessageAVerifier(String message) { this.labelMessageAVerifier.setText(message);}

}
