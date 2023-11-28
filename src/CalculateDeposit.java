import java.util.Scanner;


public class CalculateDeposit {

    int action;

    double calculateComplexPercent(double money, double yearRate, int depositPeriod) {
        double pay = money * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundToQuantitySings(pay, 2);
    }

    double calculateSimplePercent(double money, double yearRate, int depositPeriod) {
        return roundToQuantitySings(money + money * yearRate * depositPeriod, 2);
    }

    double roundToQuantitySings(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }


    void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountMoney = 0;
        if (action == 1) {
            amountMoney = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountMoney = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountMoney);
    }

    public static void main(String[] args) {

        CalculateDeposit calculateDeposit = new CalculateDeposit();
        calculateDeposit.calculate();
    }


}
