package dessin;

import aspects.MyLog;
import aspects.SecuredByAspect;
import figure.Figure;
import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Data

public class Dessin {
    private ITraitement traitement;
    private List<Figure> figures=new ArrayList<Figure>();

    @MyLog
    public void traiter(){
        for(Figure figure: figures)
            traitement.traiter(figure);
    }

    @SecuredByAspect(roles = {"ADMIN"})
    @MyLog
    public void ajouter(Figure figure){
        figures.add(figure);
    }

    @SecuredByAspect(roles = {"ADMIN"})
    @MyLog
    public void supprimer(Figure figure){
        figures.remove(figure);
    }

    @MyLog
    public void afficher(){
        for(Figure figure: figures)
            System.out.println(figure);
    }
    @MyLog
    public void serialiser() throws Exception{
        System.out.println("serialisation of data");
        File file =new File("Path");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        for(Figure figure : figures)
            objectOutputStream.writeObject(figure);
    }
}
