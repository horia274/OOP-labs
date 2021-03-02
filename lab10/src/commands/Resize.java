package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class Resize implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private final int id;
    private int prevHeight;
    private int prevWeight;
    private final int percent;

    public Resize(DiagramCanvas diagramCanvas, int id, int percent) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.percent = percent;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        prevHeight = diagramComponent.getHeight();
        prevWeight = diagramComponent.getWeight();

        diagramComponent.setHeight(prevHeight * percent / 100);
        diagramComponent.setWeight(prevWeight * percent / 100);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        diagramComponent.setHeight(prevHeight);
        diagramComponent.setWeight(prevWeight);
    }
}
