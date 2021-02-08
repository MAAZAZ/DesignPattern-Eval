package dessin;

import aspects.MyLog;
import entities.Point;
import figure.Figure;
import org.springframework.stereotype.Service;

@Service("TraitementImpl1")
public class TraitementImpl1 implements ITraitement {
    @MyLog
    public void traiter(Figure figure) {
        figure.setPoint(new Point(3,3));
        System.out.println("traitement 1 sur "+figure);
    }
}
