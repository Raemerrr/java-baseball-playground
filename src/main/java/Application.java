import calculator.Calculator;
import util.StringUtils;

public class Application {
    public static void main(String[] args) {
        System.out.println(Calculator.run(StringUtils.input()));
    }
}
