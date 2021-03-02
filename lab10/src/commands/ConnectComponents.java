package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ConnectComponents implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private final int id1;
    private final int id2;

    public ConnectComponents(DiagramCanvas diagramCanvas, int id1, int id2) {
        this.diagramCanvas = diagramCanvas;
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent1 = diagramCanvas.getComponent(id1);
        DiagramComponent diagramComponent2 = diagramCanvas.getComponent(id2);

        diagramComponent1.connectTo(String.valueOf(id2));
        diagramComponent2.connectTo(String.valueOf(id1));
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent1 = diagramCanvas.getComponent(id1);
        DiagramComponent diagramComponent2 = diagramCanvas.getComponent(id2);

        diagramComponent1.removeConnection(String.valueOf(id2));
        diagramComponent2.removeConnection(String.valueOf(id1));
    }
}
