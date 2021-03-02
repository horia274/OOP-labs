package dataprocessing;

import main.Utils;
import storage.DataRepository;

public class StepCountStrategyFactory {
    private static StepCountStrategyFactory instance = null;

    private StepCountStrategyFactory() { }

    public static StepCountStrategyFactory getInstance() {
        if (instance == null) {
            instance = new StepCountStrategyFactory();
        }
        return instance;
    }

    public StepCountStrategy createStrategy(String strategyType, DataRepository dataRepository) {
        switch (strategyType) {
            case Utils.BASIC_STRATEGY: return new BasicStepCountStrategy(dataRepository);
            case Utils.FILTERED_STRATEGY: return new FilteredStepCountStrategy(dataRepository);
        }
        throw new IllegalArgumentException("Strategy type " + strategyType + " is not recognized");
    }
}
