package SAVYRM.Containers;

import java.util.List;

public class DataForComparedGraphic {
    List<GraphicNode> BaseLine;
    
    List<LabelAndNodeReport> CurrentLine;

    public List<GraphicNode> getBaseLine() {
        return BaseLine;
    }

    public void setBaseLine(List<GraphicNode> BaseLine) {
        this.BaseLine = BaseLine;
    }

    public List<LabelAndNodeReport> getCurrentLine() {
        return CurrentLine;
    }

    public void setCurrentLine(List<LabelAndNodeReport> CurrentLine) {
        this.CurrentLine = CurrentLine;
    }

}
