import java.util.Scanner;


public class CalculateDeposit {

    int period;
    int action;

double calculateComplexPercentFunction(double a, double y,int d ) {
       double pay = a * Math.pow((1 + y/ 12), 12 *d);
          return rnd(pay, 2);
  }
  double calculateSimplePercentFunction(double doubleAmount,double doubleYearRate, int deposit_period) {
         return rnd(doubleAmount+doubleAmount * doubleYearRate *deposit_period, 2);
    }
    double rnd(double value ,int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }


    void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountMoney = 0;
        if (action == 1) {
            amountMoney = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            amountMoney = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountMoney);
    }

    public static void main(String[] args) {

    CalculateDeposit calculateDeposit = new CalculateDeposit();
    calculateDeposit.calculate();
    }




}
