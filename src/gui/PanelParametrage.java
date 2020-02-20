package gui;

import javax.swing.*;
import java.awt.event.*;

/**
 * Classe pour le paramétrage (choix du polynome à utiliser)
 * @author Yann REIBEL L3 INFO
 */
public class PanelParametrage extends JPanel {

    private FenetrePrincipale fenetrePrincipale;

    private JLabel labelIndicPolynome;

    private JTextField txtPolynome;

    private ButtonGroup btnGroupe;
    private JRadioButton btnCRC_12;
    private JRadioButton btnCRC_16;
    private JRadioButton btnCRC_CCITT;
    private JRadioButton btnCRC_32;


    /**
     * Constructeur PanelParametrage
     * @param fenetrePrincipale
     */
    public PanelParametrage(FenetrePrincipale fenetrePrincipale){
        this.fenetrePrincipale = fenetrePrincipale;
        this.initialisationComposants();

    }

    /**
     * Initialise les composants dans le panel paramétrage
     */
    public void initialisationComposants(){

        this.labelIndicPolynome = new JLabel("Polynome : ");

        this.txtPolynome = new JTextField();
        this.txtPolynome.setColumns(16);

        this.btnGroupe = new ButtonGroup();
        this.btnCRC_12 = new JRadioButton("CRC12");
        this.btnCRC_16 = new JRadioButton("CRC16");
        this.btnCRC_CCITT = new JRadioButton("CRCCCITT");
        this.btnCRC_32 = new JRadioButton("CRC32");

        this.btnGroupe.add(this.btnCRC_12);
        this.btnGroupe.add(this.btnCRC_16);
        this.btnGroupe.add(this.btnCRC_CCITT);
        this.btnGroupe.add(this.btnCRC_32);

        this.ajoutActions();

        this.ajoutComposants();

    }

    /**
     * Applique un listener aux composants
     */
    public void ajoutActions(){
        this.btnCRC_12.addActionListener((e)->{
            this.txtPolynome.setText("");
        });

        this.btnCRC_16.addActionListener((e)->{
            this.txtPolynome.setText("");
        });

        this.btnCRC_32.addActionListener((e)->{
            this.txtPolynome.setText("");
        });

        this.btnCRC_CCITT.addActionListener((e)->{
            this.txtPolynome.setText("");
        });


        this.txtPolynome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                viderBoutonsRadio(keyEvent);
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {}

            @Override
            public void keyReleased(KeyEvent keyEvent) {}

        });

    }

    /**
     * Désélectionne les boutons radios lorsque l'utilisateur commence à écrire dans le textfield
     * Méthode appelée dans les keylistener
     * @param e
     */
    public void viderBoutonsRadio(KeyEvent e){
        this.btnGroupe.clearSelection();
    }

    /**
     * Ajoute les composants au panel
     */
    public void ajoutComposants(){
        this.add(this.labelIndicPolynome);
        this.add(this.txtPolynome);
        this.add(this.btnCRC_12);
        this.add(this.btnCRC_16);
        this.add(this.btnCRC_CCITT);
        this.add(this.btnCRC_32);
    }

    /**
     * Retourne le ButtonGroup
     * @return ButtonGroup
     */
    public ButtonGroup getBtnGroupe(){
        return this.btnGroupe;
    }

    /**
     * Retourne le bouton correspondant au polynome CRC_12
     * @return JRadioButton
     */
    public JRadioButton getBtnCRC_12(){
        return this.btnCRC_12;
    }

    /**
     * Retourne le bouton radio correspondant au polynome CRC_16
     * @return JRadioButton
     */
    public JRadioButton getBtnCRC_16(){
        return this.btnCRC_16;
    }

    /**
     * Retourne le bouton radio correspondant au polynome CRC_32
     * @return JRadioButton
     */
    public JRadioButton getBtnCRC_32(){
        return this.btnCRC_32;
    }

    /**
     * Retourne le bouton radio correspondant au polynome CRC_CCITT
     * @return JRadioButton
     */
    public JRadioButton getBtnCRC_CCITT(){
        return this.btnCRC_CCITT;
    }

    /**
     * Retourne le textfield où saisir le polynome
     * @return JTextField
     */
    public JTextField getTxtPolynome(){
        return this.txtPolynome;
    }

}
