package crc;

/**
 * Classe pour le calcul du CRC à partir d'un message sous forme de bits et d'un polynome
 * @author Yann REIBEL L3 INFO
 */
public class CalculCRC {
        
    private String message;
    private Polynome polynome;

    private String zeros;

    /**
     * Constructeur CalculCRC
     * @param messageEnvoye
     * @param polynome
     */
    public CalculCRC(String messageEnvoye, Polynome polynome){
        this.message = messageEnvoye;
        this.polynome = polynome;
    }

    /**
     * Ajout de "0" à la fin du message de la taille du degré du polynome
     */
    public void ajouterZerosAuPolynome(){
        String s = "";
        for(int i=0;i<this.polynome.getDegre();i++)
            s+="0";
        this.zeros = s;
        this.message = this.message.concat(s);
    }

    /**
     * Méthode pour remplacer les zéros ajoutés par le reste calculé
     * @param reste
     */
    public void remplacerZerosParReste(String reste){
        String[] tabMessage = this.message.split("");
        String[] tabReste = reste.split("");

        int cptReste = tabReste.length-1;
        int cptMessage = tabMessage.length-1;
        while(cptReste != -1){
            tabMessage[cptMessage] = tabReste[cptReste];
            System.out.println(tabMessage[cptMessage]);
            cptReste--;
            cptMessage--;
        }

        this.message = String.join("", tabMessage);

    }

    /**
     * Méthode permettant la division du message par le polynome générateur
     * @param nA
     * @param nB
     * @return String
     */
    public String diviser(String nA, String nB) {
        int lCNb = nB.length();
        String resultat = nA.substring(0, lCNb);
        String reste = "";
        for(int i=0;i<nB.length();i++)
        {
            if(resultat.charAt(i) == nB.charAt(i))
                reste += "0";
            else
                reste += "1";
        }
        while(lCNb < nA.length())
        {
            if(reste.charAt(0) == '0')
            {
                reste = reste.substring(1, reste.length());
                reste = reste + String.valueOf(nA.charAt(lCNb));
                lCNb++;
            }
            resultat = reste;
            reste = "";
            for(int i=0; i<nB.length();i++)
            {
                if(resultat.charAt(i) == nB.charAt(i))
                    reste += "0";
                else
                    reste += "1";
            }
        }
        return reste.substring(1,reste.length());
    }

    /**
     * Calculer le message à transmettre
     * @return String
     */
    public String calculerMessageATransmettre(){
        String reste = "";
        this.ajouterZerosAuPolynome();
        reste = this.diviser(this.message, this.polynome.toString());
        this.remplacerZerosParReste(reste);
        return this.message;

    }

    /**
     * Retourne le message sous forme de chaine binaire
     * @return String
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Retourne le polynome utilisé pour le calcul du CRC
     * @return Polynome
     */
    public Polynome getPolynome(){
        return this.polynome;
    }


    /**
     * Main de Test
     * @param args
     */
    public static void main(String[] args){
        CalculCRC crc = new CalculCRC("11100110", new Polynome("10110", 4));
        System.out.println(crc.calculerMessageATransmettre());

    }


}
