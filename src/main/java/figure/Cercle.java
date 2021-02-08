package figure;

import aspects.MyLog;
import entities.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import observable.IParametrage;
import observable.Parametrage;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cercle extends Figure {
    private double rayon;

    public Cercle(Point point, double rayon){
        super(point);
        this.rayon=rayon;
    }

    public void update(IParametrage parametrage) {
        int cc=((Parametrage) parametrage).getCouleurconteur();
        int cs=((Parametrage) parametrage).getCouleur_rempl();
        double ec=((Parametrage) parametrage).getEpaisseur();
        System.out.println("color de conteur : "+cc+" + color de remplissage : "+cs+" + Epaisseur : "+ec);
    }

    @MyLog
    public double surface() {
        return Math.PI*rayon*rayon;
    }

    @MyLog
    public double perimetre() {
        return 2*Math.PI*rayon;
    }

    @MyLog
    public void draw(){
        System.out.println(this.toString());
    }
}
