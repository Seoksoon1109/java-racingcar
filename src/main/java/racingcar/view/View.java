package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class View {

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public int getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(Console.readLine());
        if (times <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
        return times;
    }

    public void printProgress(String name, int position) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append("-");
        }
        System.out.println(name + " : " + progress);
    }

    public void printResults(Car[] cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            printProgress(car.getName(), car.getPosition());
        }
    }

    public void printFinalResult(String[] winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
