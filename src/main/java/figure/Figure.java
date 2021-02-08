package figure;

import aspects.Log;
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
    @Log
    public abstract void update(IParametrage Parametrage);
    @Log
    public abstract double surface();
    @Log
    public abstract double perimetre();
    @Log
    public abstract void draw();
}
