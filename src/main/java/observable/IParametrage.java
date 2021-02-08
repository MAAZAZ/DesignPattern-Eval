package observable;

import figure.Figure;

public interface IParametrage {
    void notifyAllFigures();
    void addFigure(Figure figure);
    void removeFigure(Figure figure);
}
