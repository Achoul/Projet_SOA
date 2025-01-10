package insa.soa.methodes;

public class Fenetre {
    private boolean estOuverte;

    public Fenetre() {
        this.estOuverte = false; // Par défaut, la fenêtre est fermée.
    }

    public void ouvrirFenetre() {
        this.estOuverte = true;
        System.out.println("La fenêtre est maintenant ouverte.");
    }

    public void fermerFenetre() {
        this.estOuverte = false;
        System.out.println("La fenêtre est maintenant fermée.");
    }

    public boolean estOuverte() {
        return estOuverte;
    }
}