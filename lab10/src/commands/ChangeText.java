package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ChangeText implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private final int id;
    private String prevText;
    private final String newText;

    public ChangeText(DiagramCanvas diagramCanvas, int id, String newText) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.newText = newText;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        prevText = diagramComponent.getText();
        diagramComponent.setText(newText);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);
        diagramComponent.setText(prevText);
    }
}
