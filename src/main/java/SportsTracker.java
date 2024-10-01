import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsTracker {
    static class Activity {
        String name;
        int duration;

        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return name + ": " + duration + " minutes";
        }
    }

    private List<Activity> activities = new ArrayList<>();

    public void logActivity(String name, int duration) {
        activities.add(new Activity(name, duration));
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    public int calculateTotalTime() {
        int total = 0;
        for (Activity activity : activities) {
            total += activity.duration;
        }
        return total;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public static void main(String[] args) {
        SportsTracker logger = new SportsTracker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Log Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Calculate Total Time");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter activity name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter duration in minutes: ");
                    int duration = scanner.nextInt();
                    logger.logActivity(name, duration);
                    break;
                case 2:
                    logger.viewActivities();
                    break;
                case 3:
                    int totalTime = logger.calculateTotalTime();
                    System.out.println("Total time spent on sports: " + totalTime + " minutes");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}