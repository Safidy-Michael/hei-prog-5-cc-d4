import model.Direction;
import model.Point;
import model.Snake;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        Scanner scanner = new Scanner(System.in);
        Point start = new Point(5, 5);
        Snake snake = new Snake(start, Direction.RIGHT);
        while (true) {
            for (int y = 0; y < SIZE; y++) {
                for (int x = 0; x < SIZE; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(snake.getHead())) {
                        System.out.print("* ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }

            System.out.print("Direction (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();
            Direction newDir = switch (input) {
                case "W" -> Direction.UP;
                case "S" -> Direction.DOWN;
                case "A" -> Direction.LEFT;
                case "D" -> Direction.RIGHT;
                default -> snake.getDirection();
            };

            snake.setDirection(newDir);

            Point head = snake.getHead();
            int x = head.x;
            int y = head.y;

            switch (newDir) {
                case UP -> y--;
                case DOWN -> y++;
                case LEFT -> x--;
                case RIGHT -> x++;
            }

            Point next = new Point(x, y);

            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("XD You hit the wall! Game Over.");
                break;
            }

            snake.move(next);

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}