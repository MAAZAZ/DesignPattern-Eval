package figure;

import aspects.MyLog;
import aspects.SecuredByAspect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import observable.IParametrage;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Groupe extends Figure {
    private List<Figure> figures=new ArrayList<Figure>();

    @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public void addFigure(Figure figure){
        figures.add(figure);
    }

    @SecuredByAspect(roles = {"ADMIN","USER"})
    public void removeFigure(Figure figure){
        figures.remove(figure);
    }

    public void update(IParametrage Parametrage) {
        for(Figure f : figures){
            f.update(Parametrage);
        }
    }

    public double surface() {
        double s=0;
        for(Figure figure: figures)
            s+=figure.surface();
        return s;
    }

    public double perimetre() {
        double s=0;
        for(Figure figure: figures)
            s+=figure.perimetre();
        return s;
    }

    public void draw() {
        for (Figure f: figures){
            f.draw();
        }
    }
}
