package observable;


import figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parametrage implements IParametrage {

    private List<Figure> figures = new ArrayList<Figure>();
    private double epaisseur;
    private int couleurconteur;
    private int couleur_rempl;

    public void notifyAllFigures() {
        for(Figure figure : figures)
            figure.update(this);
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
    }
}
