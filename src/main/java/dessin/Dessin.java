package dessin;

import aspects.MyLog;
import aspects.SecuredByAspect;
import figure.Figure;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Data
public class Dessin {
    @Autowired
    private ITraitement traitement;
    private List<Figure> figures=new ArrayList<Figure>();

    public void traiter(){
        for(Figure figure: figures)
            traitement.traiter(figure);
    }

    @SecuredByAspect(roles = {"ADMIN"})
    public void ajouter(Figure figure){
        figures.add(figure);
    }

    @SecuredByAspect(roles = {"ADMIN"})
    public void supprimer(Figure figure){
        figures.remove(figure);
    }

    @SecuredByAspect(roles = {"ADMIN","USER"})
    public void afficher(){
        for(Figure figure: figures)
            System.out.println(figure);
    }

    @SecuredByAspect(roles = {"ADMIN"})
    public void serialiser() throws Exception{
        File file=new File("dessin.txt");

        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            for(Figure f : figures){
                objectOutputStream.writeObject(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
