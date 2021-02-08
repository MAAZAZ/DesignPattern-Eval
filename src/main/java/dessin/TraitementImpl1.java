package dessin;

import entities.Point;
import figure.Figure;

public class TraitementImpl1 implements ITraitement {
    public void traiter(Figure figure) {
        figure.setPoint(new Point(3,3));
        System.out.println("traitement 1 sur "+figure);
    }
}
