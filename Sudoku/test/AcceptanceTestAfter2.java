import junit.framework.Assert;
import org.junit.Test;

public class AcceptanceTestAfter2 {

    @Test
    public void easyProblem() {
        check(SudokuExamples.EASY_PROBLEM, SudokuExamples.EASY_SOLUTION);
    }

    @Test
    public void hardProblem() {
        check(SudokuExamples.HARD_PROBLEM, SudokuExamples.HARD_SOLUTION);
    }

    @Test
    public void impossible() {
        int[][] problemGrid = Sudoku.parseProblem(SudokuExamples.NOT_SOLVABLE_PROBLEM);
        int[][] actualSolution = Sudoku.solve(problemGrid);
        Assert.assertNull(actualSolution);
    }

    private void check(String problem, String solution) {
        int[][] solutionGrid = Sudoku.parseProblem(solution);
        int[][] problemGrid = Sudoku.parseProblem(problem);
        int[][] actualSolution = Sudoku.solve(problemGrid);
        Assert.assertEquals(new GridAfter2(solutionGrid).prettyPrint(), new GridAfter2(actualSolution).prettyPrint());
    }

}