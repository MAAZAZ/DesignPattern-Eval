package dessin;

import entities.Point;
import figure.Figure;

public class TraitementImpl2 implements ITraitement{
    public void traiter(Figure figure) {
        figure.setPoint(new Point(5,5));
        System.out.println("traitemnt 2 sur "+figure);
    }
}
