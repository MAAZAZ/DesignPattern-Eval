import aspects.MyLog;
import dessin.Dessin;
import dessin.TraitementImpl1;
import entities.Point;
import figure.Cercle;
import figure.Figure;
import figure.Groupe;
import figure.Rectangle;
import observable.IParametrage;
import observable.Parametrage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        aspects.ApplicationContext.authenticateUser("root","1234",new String[]{"ADMIN"});
        new AnnotationConfigApplicationContext(AppConfig.class);
        Dessin dessin=new Dessin();
        Cercle cercle=new Cercle(new Point(1,1), 5.5);
        System.out.println("(Surface : "+cercle.surface()+" , Périmètre : "+cercle.perimetre()+")");
        Rectangle rectangle=new Rectangle(new Point(2,2),5.1,2);
        Groupe groupe1=new Groupe();
        groupe1.addFigure(cercle);
        groupe1.addFigure(rectangle);
        dessin.ajouter(groupe1);
        ArrayList<Figure> fs=new ArrayList<Figure>();
        fs.add(new Rectangle(new Point(2,2),5.1,2));
        System.out.println("(Surface : "+groupe1.surface()+" , Périmètre : "+groupe1.perimetre()+")");
        IParametrage parametrage=new Parametrage(fs,10, 20, 30);
        parametrage.notifyAllFigures();
        dessin.setTraitement(new TraitementImpl1());
        dessin.traiter();
    }
}
