import model.Direction;
import model.Point;
import model.Snake;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        Point start = new Point(5, 5);
        Snake snake = new Snake(start, Direction.RIGHT);
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Point current = new Point(x, y);
                if (current.equals(snake.getHead())) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }
}