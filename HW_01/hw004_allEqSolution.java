import java.util.ArrayList;
import java.util.List;

public class EquationSolver {
    public static void main(String[] args) {
        List<String> solutions = solveEquation();
        if (solutions.isEmpty()) {
            System.out.println("Решения не найдены");
        } else {
            System.out.println("Найдены следующие решения:");
            for (String solution : solutions) {
                System.out.println(solution);
            }
        }
    }

    public static List<String> solveEquation() {
        List<String> solutions = new ArrayList<>();
        for (int q = 0; q <= 9; q++) {
            for (int w = 0; w <= 9; w++) {
                for (int e = 0; e <= 9; e++) {
                    String equation = replaceQuestionMarks(q, w, e);
                    if (isValidEquation(equation)) {
                        solutions.add(equation);
                    }
                }
            }
        }
        return solutions;
    }

    public static String replaceQuestionMarks(int q, int w, int e) {
        String equation = "q + w = e";
        equation = equation.replace("q", String.valueOf(q));
        equation = equation.replace("w", String.valueOf(w));
        equation = equation.replace("e", String.valueOf(e));
        return equation;
    }

    public static boolean isValidEquation(String equation) {
        String[] parts = equation.split("=");
        int leftSide = evaluateExpression(parts[0]);
        int rightSide = evaluateExpression(parts[1]);
        return leftSide == rightSide;
    }

    public static int evaluateExpression(String expression) {
        expression = expression.replace(" ", "");
        String[] terms = expression.split("\\+");

        int sum = 0;
        for (String term : terms) {
            sum += Integer.parseInt(term);
        }

        return sum;
    }
}
