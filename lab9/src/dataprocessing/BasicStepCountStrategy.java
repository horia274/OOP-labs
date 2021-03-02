package dataprocessing;

import storage.DataRepository;
import storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;

    public BasicStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        int totalSteps = 0;
        for (SensorData sensor : dataRepository.getSensors()) {
            totalSteps += sensor.getStepsCount();
        }
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        int totalSteps = getTotalSteps();
        return "Basic strategy -> " + totalSteps + " steps";
    }
}
