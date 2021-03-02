package communication;

import main.Utils;
import storage.SensorData;

import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        SensorData sensorData = (SensorData) arg;
        ServerMessage serverMessage = new ServerMessage(sensorData.getStepsCount(),
                                                        Utils.getClientId(),
                                                        sensorData.getTimestamp());

        System.out.println("Server communication: " + serverMessage);
    }
}
