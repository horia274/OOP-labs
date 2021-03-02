package storage;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable { // TODO make this an Observable
    List<SensorData> sensors;

    public DataRepository() {
        sensors = new ArrayList<>();
    }

    public void addData(SensorData dataRecord){
        // TODO
        // store data (e.g. in a List)
        // notify observers
        sensors.add(dataRecord);
        setChanged();
        notifyObservers(dataRecord);
        clearChanged();
    }

    // TODO implement a method to get the stored data (needed by the strategies)
    public List<SensorData> getSensors() {
        return sensors;
    }
}


