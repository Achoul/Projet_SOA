package insa.soa.Methodes;

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
}
