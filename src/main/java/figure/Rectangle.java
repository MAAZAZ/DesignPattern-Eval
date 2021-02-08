package figure;

import aspects.Log;
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
public class Rectangle extends Figure {
    private double largeur, hauteur;

    public Rectangle(Point point, double largeur, double hauteur){
        super(point);
        this.hauteur=hauteur;
        this.largeur=largeur;
    }

    public void update(IParametrage parametrage) {
        int cc=((Parametrage) parametrage).getCouleurconteur();
        int cs=((Parametrage) parametrage).getCouleur_rempl();
        double ec=((Parametrage) parametrage).getEpaisseur();
        System.out.println("color de conteur : "+cc+" + color de remplissage : "+cs+" + Epaisseur : "+ec);
    }

    public double surface() {
        return largeur*hauteur;
    }

    public double perimetre() {
        return 2*(largeur+hauteur);
    }

    public void draw() {
        System.out.println(this.toString());
    }
}
