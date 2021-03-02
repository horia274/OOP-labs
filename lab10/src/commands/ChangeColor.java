package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ChangeColor implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private final int id;
    private String prevColor;
    private final String newColor;

    public ChangeColor(DiagramCanvas diagramCanvas, int id, String newColor) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        prevColor = diagramComponent.getColor();
        diagramComponent.setColor(newColor);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        diagramComponent.setColor(prevColor);
    }
}
