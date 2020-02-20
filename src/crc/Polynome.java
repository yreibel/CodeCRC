package crc;

/**
 * Représente les différents polynômes utilisables au sein de l'application (variables static)
 * Et possibilité d'instancier des polynômes au choix
 * @author Yann REIBEL L3 INFO
 */
public class Polynome {
    
    public static Polynome CRC_12 = new Polynome("1100000001111", 12);
    public static Polynome CRC_16 = new Polynome("11000000000000111", 16);
    public static Polynome CRC_CCITT = new Polynome("10001000000100001", 16);
    public static Polynome CRC_32 = new Polynome("100000100110000010001110110110011", 32);


    private String polynome;
    private int degre;

    /**
     * Constructeur pour les variables statics des polynomes connus
     * @param polynome
     * @param degre
     */
    public Polynome(String polynome, int degre){
        this.polynome = polynome;
        this.degre = degre;
    }

    /**
     * Constructeur d'un Polynome
     * @param polynome
     */
    public Polynome(String polynome){
        this.polynome = polynome;
        this.degre = this.calculerDegrePolynome();
    }

    /**
     * Calcule le degré du polynome
     * @return int
     */
    public int calculerDegrePolynome(){
        String[] tabPolynome = this.polynome.split("");
        int degreMax = 0;

        int cpt = this.polynome.length()-1;
        int max = 0;
        while(cpt != max && tabPolynome[cpt] != "1"){
            degreMax++;
            cpt--;
        }

        return degreMax;
    }

    /**
     * Retourne le polynome sous forme de chaine binaire
     * @return String
     */
    public String getPolynome(){
        return this.polynome;
    }

    /**
     * Retourne le degré du polynome
     * @return int
     */
    public int getDegre(){
        return this.degre;
    }

    /**
     * Méthode toString
     * Retourne le polynôme sous forme de chaîne
     * @return String
     */
    public String toString(){
        return this.polynome;
    }


    /**
     * Main de Test
     * @param args
     */
    public static void main(String[] args){
        // Test calcul du degré
        Polynome p = new Polynome("1100000001111");
        System.out.println(p.getDegre());
    }
}
