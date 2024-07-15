package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void startGame() {
        String[] carNames = view.getCarNames();
        Car[] cars = createCars(carNames);

        int times = view.getTimes();
        race(cars, times);

        List<String> winners = getWinners(cars);
        view.printFinalResult(winners.toArray(new String[0]));
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private void race(Car[] cars, int times) {
        for (int i = 0; i < times; i++) {
            moveCars(cars);
            view.printResults(cars);
        }
    }

    private void moveCars(Car[] cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> getWinners(Car[] cars) {
        int maxPosition = findMaxPosition(cars);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
