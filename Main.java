import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Invalid cron expression");
            return;
        }

        String input = args[0];
        System.out.println("input "+input);
        String[] values = input.split(" ");

        if (values.length != 7) {
            System.out.println("Invalid cron expression");
            return;
        }

        String command = values[6];
        input = String.join(" ", Arrays.copyOfRange(values, 0, 6));

        try {
            CronExpression cp = new CronExpression(input, command);
        } catch (Exception e) {
            System.out.println("Error is "+ e.getMessage());
        }
    }
}
