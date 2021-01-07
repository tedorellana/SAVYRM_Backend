package SAVYRM.Containers;

import java.util.List;

public class DataForComparedGraphic {
    List<SalesReport> BaseLine;
    
    List<SalesReport> CurrentLine;

    public List<SalesReport> getBaseLine() {
        return BaseLine;
    }

    public void setBaseLine(List<SalesReport> BaseLine) {
        this.BaseLine = BaseLine;
    }

    public List<SalesReport> getCurrentLine() {
        return CurrentLine;
    }

    public void setCurrentLine(List<SalesReport> CurrentLine) {
        this.CurrentLine = CurrentLine;
    }

}
