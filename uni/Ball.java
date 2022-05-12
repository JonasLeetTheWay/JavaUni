import Prog1Tools.Screen;
import Prog1Tools.TextScreen;

public class Ball {

    static final String BALL = "O";
    static final int PAUSE_TIME = 100;
    static final int MAX_ROW = 24;
    static final int MAX_COLUMN = 79;

    public static int numberOfStepsToTake = 175;
    public static int step = 0;

    private int row = 0;
    private int column = 0;
    public boolean rowDescending = true;     // boolean TRUE = going down / right
    public boolean columnDescending = true;  // boolean FALSE = going up / left

    public Ball(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static void main(String[] args) {
        TextScreen screen = TextScreen.getInstance();

        Ball ball1 = new Ball(0, 0);
        Ball ball2 = new Ball(0, MAX_COLUMN);
        Ball ball3 = new Ball(MAX_ROW, 0);
        Ball ball4 = new Ball(MAX_ROW, MAX_COLUMN);

        for (step = 1; step <= numberOfStepsToTake; step++) {
            //track timesteps into floating window title
            screen.setTitle("JumpingBalls on step "+step);

            //simulating game physics of each ball
            ball1.calculateNewPosition();
            ball2.calculateNewPosition();
            ball3.calculateNewPosition();
            ball4.calculateNewPosition();

            //printing the current position
            screen.write(ball1.row, ball1.column, BALL);
            screen.write(ball2.row, ball2.column, BALL);
            screen.write(ball3.row, ball3.column, BALL);
            screen.write(ball4.row, ball4.column, BALL);
            //pausing the screen for humans
            Screen.pause(PAUSE_TIME);
        }
        screen.write(MAX_ROW/2, MAX_COLUMN/2, "GAME ENDED");
    }

    public void calculateNewPosition() {
        //Checking for direction change
        rowDescending = directionRow(row, rowDescending);
        columnDescending = directionColumn(column, columnDescending);
        //updating row and column
        row = rowChange(row, rowDescending);
        column = columnChange(column, columnDescending);
    }

    public void setRow(int y) {
        IndexOutOfBoundsException error = new IndexOutOfBoundsException();
        if (y == 0 || y == 24) throw error;

        row = y;
    }

    public void setColumn(int x) {
        IndexOutOfBoundsException error = new IndexOutOfBoundsException();
        if (x == 0 || x == 79) throw error;
        column = x;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * method that will return a new vertical (row) direction
     * if the maximum or minimum row (0 - 24) has been reached
     * will return the original value if no extrem has been reeched
     *
     * @param row
     * @param currentDirection
     * @return
     */
    public static boolean directionRow(int row, boolean currentDirection) {
        if (row == 0) {
            return true;
        } else if (row == MAX_ROW) {
            return false;
        }
        return currentDirection;
    }

    /**
     * method that will return a new vertical (row) direction
     * if the maximum or minimum column (0 - 79) has been reached
     * will return the original value if no extrem has been reeched
     *
     * @param column
     * @param currentDirection
     * @return
     */
    public static boolean directionColumn(int column, boolean currentDirection) {
        if (column == 0) {
            return true;
        } else if (column == MAX_COLUMN) {
            return false;
        }
        return currentDirection;
    }

    /**
     * method that will calculate and return the new row
     * depending on the current direction of a ball
     *
     * @param row
     * @param descending
     * @return
     */
    public static int rowChange(int row, boolean descending) {
        if (descending) {
            row++;
        } else {
            row--;
        }
        return row;
    }

    /**
     * method that will calculate and return the new column
     * depending on the current direction of a ball
     *
     * @param column
     * @param descending
     * @return
     */
    public static int columnChange(int column, boolean descending) {
        if (descending) {
            column++;
        } else {
            column--;
        }
        return column;
    }
}
