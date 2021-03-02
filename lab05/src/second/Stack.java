package second;

import first.Task;
import java.util.ArrayList;

public class Stack implements Container{
    public ArrayList<Task> list = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return list;
    }

    public Task pop() {
        if (list.size() > 0) {
            return list.remove(list.size() - 1);
        }
        return null;
    }

    public void push(Task task) {
        list.add(task);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void transferFrom(Container container) {
        if (container != null && container.size() == 0) {
            return;
        }
        while(container.size() > 0) {
            this.push(container.pop());
        }
    }
}
