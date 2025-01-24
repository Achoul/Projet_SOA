package insa.soa.Methodes;

import java.util.Random;

public class ActionActionneurs {

    private static final int TEMP_CIBLE = 19;

    public static String temperatureAction(double Tint, double Text, boolean ClimActive, boolean ChauffageActive) {
        // Température intérieure élevée
        if (Tint > 22) {
            if (Text < Tint) {
                return "OpenWindow";
            } else {
                if (ClimActive && Tint > TEMP_CIBLE) {
                    return "TurnDownAC";
                }
                return "TurnUpAC";
            }
        }
        // Température intérieure basse
        else if (Tint < 16) {
            if (Text > Tint) {
                return "OpenWindow";
            } else {
                if (ChauffageActive && Tint < TEMP_CIBLE) {
                    return "TurnUpHeater";
                }
                return "TurnDownHeater";
            }
        }
        // Température stable
        return "NoAction";
    }

    public static String luminositeAction(int luminositeInterne, int luminositeExterne) {
        if (luminositeInterne < 50 && luminositeInterne > luminositeExterne) {
            return "LightOn";  // Si la luminosité intérieure est inférieure à 50 et supérieure à la luminosité extérieure
        } else {
            return "LightOut"; // Sinon, éteindre la lumière
        }
    }

    public static String presenceAction(int presence) {
        // Génération d'une heure aléatoire entre 10 et 24
        Random rand = new Random();
        int heure = rand.nextInt(15) + 10; // Heure entre 10 et 24
        
        if (presence > 0 && heure > 20) {
            return "AlarmOn";  // Si la présence est supérieure à 0 et que l'heure est supérieure à 20
        } else {
            return "AlarmOut"; // Sinon, désactiver l'alarme
        }
    }
}
