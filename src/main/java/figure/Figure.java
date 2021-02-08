package figure;

import aspects.MyLog;
import entities.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import observable.IParametrage;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Figure implements Serializable {
    protected Point point;
    public abstract void update(IParametrage Parametrage);
    public abstract double surface();
    public abstract double perimetre();
    public abstract void draw();
}
