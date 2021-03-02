package main;

import commands.*;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {
    private Deque<DrawCommand> executedCommands;
    private Deque<DrawCommand> undoCommands;
    private boolean wasUndo;
    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
      // TODO
        executedCommands = new LinkedList<>();
        undoCommands = new LinkedList<>();
        wasUndo = false;
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        command.execute();
        wasUndo = false;
        executedCommands.addLast(command);
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html
        if (executedCommands.size() == 0) {
            System.out.println("No executed commands");
            return;
        }
        wasUndo = true;
        DrawCommand command = executedCommands.removeLast();
        undoCommands.addLast(command);
        command.undo();
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        if (!wasUndo) {
            System.out.println("Previous command was not an undo");
            return;
        }
        if (undoCommands.size() == 0) {
            System.out.println("No undo commands");
            return;
        }
        DrawCommand command = undoCommands.removeLast();
        executedCommands.addLast(command);
        command.execute();
    }
}
