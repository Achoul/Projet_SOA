package insa.soa.methodes;

public class Alarme {
    private static boolean alarme;

    public Alarme() {
        alarme = false;
    }

    public static void allumerAlarme() {
    	alarme = true;
        System.out.println("L'alarme est opérationnelle !");
    }

    public void eteindreAlarme() {
    	alarme = false;
        System.out.println("L'alarme est désactivée");
    }

}