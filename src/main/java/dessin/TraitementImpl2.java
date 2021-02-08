package dessin;

import aspects.MyLog;
import entities.Point;
import figure.Figure;
import org.springframework.stereotype.Service;

@Service("TraitementImpl2")
public class TraitementImpl2 implements ITraitement{
    @MyLog
    public void traiter(Figure figure) {
        figure.setPoint(new Point(5,5));
        System.out.println("traitemnt 2 sur "+figure);
    }
}
