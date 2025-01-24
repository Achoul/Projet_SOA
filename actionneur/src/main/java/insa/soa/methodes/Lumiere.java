package insa.soa.methodes;

public class Lumiere {
    private static boolean lumiere;

    public Lumiere() {
        lumiere = false;
    }

    public static void allumerLumière() {
    	lumiere = true;
        System.out.println("La lumière est allumée");
    }

    public void eteindreLumière() {
    	lumiere = false;
        System.out.println("La lumière est éteinte");
    }

}