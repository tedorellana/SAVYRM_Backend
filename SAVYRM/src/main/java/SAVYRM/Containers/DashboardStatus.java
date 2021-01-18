/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAVYRM.Containers;

/**
 *
 * @author TORELLANA
 */
public class DashboardStatus {
    GraphicNode Current;
    GraphicNode Expected;

    public GraphicNode getCurrent() {
        return Current;
    }

    public void setCurrent(GraphicNode Current) {
        this.Current = Current;
    }

    public GraphicNode getExpected() {
        return Expected;
    }

    public void setExpected(GraphicNode Expected) {
        this.Expected = Expected;
    }
}
