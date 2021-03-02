package main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("connect", "1", "2");
        client.executeAction("connect", "0", "3");
        client.executeAction("connect", "1", "0");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("resize", "0", "100");
        client.executeAction("resize", "1", "50");
        client.executeAction("resize", "4", "75");
        client.executeAction("resize", "2", "200");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("change color", "1", "GREEN");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("resize", "2", "50");
        client.executeAction("draw rectangle");
        client.executeAction("connect", "1", "5");
        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO
        client.newDiagram();
        client.undo();
        client.redo();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.undo();
        client.showDiagram();
        client.executeAction("draw rectangle");
        client.redo();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.showDiagram();

        client.executeAction("resize", "1", "50");
        client.undo();
        client.showDiagram();
        client.executeAction("resize", "2", "200");
        client.redo();
        client.showDiagram();

        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "2", "BLUE");
        client.undo();
        client.showDiagram();
        client.redo();

        client.executeAction("change text", "0", "Si daca bem bem bem toata noaptea bem");
        client.executeAction("change text", "1", "Si daca bem bem bem fiindca bani avem");
        client.executeAction("change text", "2", "Nu e o problema money, money pentru noi");
        client.executeAction("change text", "3", "Suntem plini de euroi");
        client.showDiagram();

        client.undo();
        client.undo();
        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
        client.redo();
        client.redo();
        client.redo();
        client.showDiagram();

        client.executeAction("connect", "1", "2");
        client.executeAction("connect", "0", "3");
        client.executeAction("connect", "1", "0");
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();
    }
}
