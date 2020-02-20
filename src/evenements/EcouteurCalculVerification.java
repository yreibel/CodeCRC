package evenements;

import crc.CalculCRC;
import crc.Polynome;
import crc.VerificationCRC;
import gui.FenetrePrincipale;
import gui.PanelCRC;
import gui.PanelParametrage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant d'effectuer les actions suite aux évènements associés
 * @author Yann REIBEL L3 INFO
 */
public class EcouteurCalculVerification implements ActionListener {

    private FenetrePrincipale fenetrePrincipale;
    private PanelParametrage panelParametrage;
    private PanelCRC panelCRC;

    private Polynome polynomeUtilise;
    private CalculCRC calculCRC;
    private VerificationCRC verificationCRC;

    /**
     * Constructeur de EcouteurCalculVerification
     * @param fenetrePrincipale
     * @param panelCRC
     */
    public EcouteurCalculVerification(FenetrePrincipale fenetrePrincipale, PanelCRC panelCRC){
        this.fenetrePrincipale = fenetrePrincipale;
        this.panelParametrage = this.fenetrePrincipale.getPanelParametrage();
        //this.panelCRC = this.fenetrePrincipale.getPanelCRC();
        this.panelCRC = panelCRC;

        this.polynomeUtilise = null;
        this.calculCRC = null;
        this.verificationCRC = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            // Si bouton de codage activé :
            if(e.getSource() == this.fenetrePrincipale.getPanelCRC().getBtnCodage()){

                if (this.panelParametrage.getBtnGroupe().getSelection() != null)
                {
                    if(panelParametrage.getBtnCRC_12().isSelected()) this.polynomeUtilise = Polynome.CRC_12;
                    if(panelParametrage.getBtnCRC_16().isSelected()) this.polynomeUtilise = Polynome.CRC_16;
                    if(panelParametrage.getBtnCRC_32().isSelected()) this.polynomeUtilise = Polynome.CRC_32;
                    if(panelParametrage.getBtnCRC_CCITT().isSelected()) this.polynomeUtilise = Polynome.CRC_CCITT;

                }
                else if(this.panelParametrage.getTxtPolynome().getText() != null){
                    try{
                        int valeur = Integer.parseInt(this.panelParametrage.getTxtPolynome().getText(), 2);

                        this.polynomeUtilise = new Polynome(this.panelParametrage.getTxtPolynome().getText());
                    }catch (NumberFormatException nfex){
                        System.out.println("Il faut une chaine binaire");
                    }
                }
                else{
                    System.out.println("Il faut saisir un polynome");
                }


                if(this.polynomeUtilise != null){
                    if(this.panelCRC.getTxtMessageACoder().getText() != null){
                        try{

                            int valeur = Integer.parseInt(this.panelCRC.getTxtMessageACoder().getText(), 2);

                            String message = this.panelCRC.getTxtMessageACoder().getText();
                            this.calculCRC = new CalculCRC(message, this.polynomeUtilise);
                            this.panelCRC.setLabelMessageACoder(this.calculCRC.calculerMessageATransmettre());


                        }catch (NumberFormatException nfex){
                            System.out.println("Il faut une chaine binaire");
                        }
                    }
                }

            }
            else if(e.getSource() == this.fenetrePrincipale.getPanelCRC().getBtnVerification()){

                if (this.panelParametrage.getBtnGroupe().getSelection() != null)
                {
                    if(panelParametrage.getBtnCRC_12().isSelected()) this.polynomeUtilise = Polynome.CRC_12;
                    if(panelParametrage.getBtnCRC_16().isSelected()) this.polynomeUtilise = Polynome.CRC_16;
                    if(panelParametrage.getBtnCRC_32().isSelected()) this.polynomeUtilise = Polynome.CRC_32;
                    if(panelParametrage.getBtnCRC_CCITT().isSelected()) this.polynomeUtilise = Polynome.CRC_CCITT;

                }
                else if(this.panelParametrage.getTxtPolynome().getText() != null){
                    try{
                        int valeur = Integer.parseInt(this.panelParametrage.getTxtPolynome().getText(), 2);

                        this.polynomeUtilise = new Polynome(this.panelParametrage.getTxtPolynome().getText());
                    }catch (NumberFormatException nfex){
                        System.out.println("Il faut une chaine binaire");
                    }
                }
                else{
                    System.out.println("Il faut saisir un polynome");
                }


                if(this.polynomeUtilise != null){
                    if(this.panelCRC.getTxtMessageAVerifier().getText() != "") {
                        try {
                            System.out.println("" + this.panelCRC.getTxtMessageAVerifier().getText());
                            int valeur = Integer.parseInt(this.panelCRC.getTxtMessageAVerifier().getText(), 2);

                            String message = this.panelCRC.getTxtMessageAVerifier().getText();
                            this.verificationCRC = new VerificationCRC(message, this.polynomeUtilise);
                            this.panelCRC.setLabelMessageAVerifier("Résultat : " + this.verificationCRC.estValideCRC());


                        } catch (NumberFormatException nfex) {
                            System.out.println("Il faut une chaine binaire");
                        }
                    }
                }
            }
        }

}
