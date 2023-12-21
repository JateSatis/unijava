package pract22.CalculatorMVC;

public class ex2 {

    public static void main(String[] args) {
        PostfixCalculator model = new PostfixCalculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view, model);
    }
}

