package crc;

/** Classe dédiée à la vérification d'un code CRC
 * @author Yann REIBEL L3 INFO
 */
public class VerificationCRC {

    private String message;
    private Polynome polynome;

    /**
     * Constructeur VerificationCRC
     * @param message
     * @param polynome
     */
    public VerificationCRC(String message, Polynome polynome){
        this.message = message;
        this.polynome = polynome;
    }

    /**
     * Méthode permettant la division du message par le polynome générateur
     * @param nA
     * @param nB
     * @return String
     */
    public String diviser(String nA, String nB)
    {
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
     * Vérifie la validité du CRC (Détection correcte si reste = 0)
     * @return boolean
     */
    public boolean estValideCRC(){
        String resultat = this.diviser(this.message, this.polynome.toString());
        System.out.println(resultat);
        if(!resultat.contains("1") && resultat.contains("0"))
            return true;

        return false;

    }

    /**
     * Main de Test
     * @param args
     */
    public static void main(String[] args){
        VerificationCRC verifcrc = new VerificationCRC("111001111110",new Polynome("10110"));
        System.out.println(verifcrc.estValideCRC());

    }
}
