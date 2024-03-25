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

        try {
            if (values.length != 6) {
                System.out.println("Invalid cron expression");
                throw  new Exception("Length is not matching");
            }
        } catch (Exception e) {
            System.out.println("Error is "+ e.getMessage());
            return;
        }

        String command = values[5];
        input = String.join(" ", Arrays.copyOfRange(values, 0, 5));

        try {
            CronExpression cp = new CronExpression(input, command);
        } catch (Exception e) {
            System.out.println("Error is "+ e.getMessage());
        }
    }}
