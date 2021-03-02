package dataprocessing;

import storage.DataRepository;
import storage.SensorData;
import java.util.concurrent.TimeUnit;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;

    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    public FilteredStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        int totalSteps = 0;
        for (SensorData sensor : dataRepository.getSensors()) {
            if (sensor.getStepsCount() < 0) {
                continue;
            }
            if (sensor.getStepsCount() > MAX_DIFF_STEPS_CONSECUTIVE_RECORDS && sensor.getTimestamp() < TIME_FOR_MAX_DIFF) {
                continue;
            }
            totalSteps += sensor.getStepsCount();
        }
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        int totalSteps = getTotalSteps();
        return "Filtered strategy -> " + totalSteps + " steps";
    }
}
