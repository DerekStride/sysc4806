package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class BoxLayoutPanel extends JPanel {
    private List panelComponents;
    private int axis;

    public void setAxis(int axis) {
        this.axis = axis;
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {
        setLayout(new BoxLayout(this, axis));

        for (Iterator it = panelComponents.iterator(); it.hasNext();) {
            Component component = (Component) it.next();
            add(component);
        }
    }
}
