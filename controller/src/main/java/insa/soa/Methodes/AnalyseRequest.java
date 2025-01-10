package insa.soa.Methodes;

public class AnalyseRequest {
    private double Tint; // Température intérieure
    private double Text; // Température extérieure
    private boolean ClimActive;
    private boolean ChauffageActive;

    public double getTint() {
        return Tint;
    }

    public void setTint(double Tint) {
        this.Tint = Tint;
    }

    public double getText() {
        return Text;
    }

    public void setText(double Text) {
        this.Text = Text;
    }

    public boolean isClimActive() {
        return ClimActive;
    }

    public void setClimActive(boolean ClimActive) {
        this.ClimActive = ClimActive;
    }

    public boolean isChauffageActive() {
        return ChauffageActive;
    }

    public void setChauffageActive(boolean ChauffageActive) {
        this.ChauffageActive = ChauffageActive;
    }
}
