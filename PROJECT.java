import java.util.*;
import java.nio.file.*;
import java.io.*;

class DeliveryPackage {
    private int weight;
    private int distance;
    private int trackingId;
    private String status;

    DeliveryPackage(int trackingId, int weight, int distance, String status) {
        this.trackingId = trackingId;
        this.weight = weight;
        this.distance = distance;
        this.status = status;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int calculateCharge() {
        return 50 + (10 * weight);
    }

    @Override
    public String toString() {
        return "Tracking ID: " + trackingId
                + ", Weight: " + weight
                + ", Distance: " + distance
                + ", Status: " + status;
    }
}

class ExpressPackage extends DeliveryPackage {
    ExpressPackage(int id, int weight, int distance, String status) {
        super(id, weight, distance, status);
    }

    @Override
    public int calculateCharge() {
        return super.calculateCharge() + 100;
    }
}

public class PROJECT {

    static String getStatus(int s) {
        switch (s) {
            case 1:
                return "Package Created";
            case 2:
                return "In Transit";
            case 3:
                return "Out for Delivery";
            case 4:
                return "Delivered";
            default:
                return "Invalid Status";
        }
    }

    static boolean searchId(ArrayList<Integer> ids, int search) {
        for (int id : ids) {
            if (id == search) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> trackingIds = new ArrayList<>();
        HashSet<Integer> uniqueStatuses = new HashSet<>();
        HashMap<Integer, String> courierStatus = new HashMap<>();
        ArrayList<DeliveryPackage> packages = new ArrayList<>();

        System.out.println("===== DELIVERY MANAGEMENT SYSTEM =====");

        System.out.print("Enter number of packages: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter tracking ID: ");
            int id = sc.nextInt();

            System.out.print("Enter package weight: ");
            int weight = sc.nextInt();

            System.out.print("Enter delivery distance: ");
            int distance = sc.nextInt();

            System.out.print("Enter status (1-4): ");
            int s = sc.nextInt();

            if (weight < 0 || distance < 0 || s < 1 || s > 4) {
                System.out.println("Invalid package details.");
                continue;
            }

            DeliveryPackage p;

            if (distance > 100) {
                p = new ExpressPackage(id, weight, distance, getStatus(s));
            } else {
                p = new DeliveryPackage(id, weight, distance, getStatus(s));
            }

            packages.add(p);
            trackingIds.add(id);
            uniqueStatuses.add(s);

            System.out.println("Delivery Charge = " + p.calculateCharge());
        }

        System.out.println("\n===== PACKAGE DETAILS =====");

        for (DeliveryPackage p : packages) {
            System.out.println(p);
        }

        System.out.print("\nEnter tracking ID to search: ");
        int search = sc.nextInt();

        if (searchId(trackingIds, search)) {
            System.out.println("Tracking ID Found");
        } else {
            System.out.println("Tracking ID Not Found");
        }

        Collections.sort(trackingIds);

        System.out.println("Sorted Tracking IDs: " + trackingIds);

        int index = Collections.binarySearch(trackingIds, search);

        if (index >= 0) {
            System.out.println("ID found at sorted index: " + index);
        } else {
            System.out.println("ID not found in sorted list");
        }

        System.out.print("\nEnter number of couriers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter status number for courier " + i + ": ");
            int s = sc.nextInt();

            String status = getStatus(s);

            if (!status.equals("Invalid Status")) {
                courierStatus.put(i, status);
                uniqueStatuses.add(s);
            } else {
                System.out.println("Invalid Status");
            }
        }

        System.out.print("Enter courier position to update: ");
        int position = sc.nextInt();

        if (courierStatus.containsKey(position)) {
            System.out.print("Enter new status number: ");
            int s = sc.nextInt();

            String newStatus = getStatus(s);

            if (!newStatus.equals("Invalid Status")) {
                courierStatus.put(position, newStatus);
                uniqueStatuses.add(s);
                System.out.println("Status Updated");
            } else {
                System.out.println("Invalid Status");
            }
        } else {
            System.out.println("Courier not found");
        }

        System.out.println("Courier Statuses: " + courierStatus);
        System.out.println("Unique Status Codes: " + uniqueStatuses);

        Iterator<Map.Entry<Integer, String>> it =
                courierStatus.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();

            if (entry.getValue().equals("Delivered")) {
                System.out.println(
                        "Courier " + entry.getKey() + " has delivered the package."
                );
            }
        }

        System.out.print("\nEnter number of deliveries for analysis: ");
        int n3 = sc.nextInt();

        if (n3 > 0) {
            int[] distances = new int[n3];
            int total = 0;
            int count = 0;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n3; i++) {
                System.out.print("Enter delivery distance: ");
                distances[i] = sc.nextInt();

                total += distances[i];

                if (distances[i] > 100) {
                    count++;
                }

                if (distances[i] > max) {
                    max = distances[i];
                }
            }

            double average = (double) total / n3;

            System.out.printf("Total Distance = %d%n", total);
            System.out.printf("Average Distance = %.2f%n", average);
            System.out.println("Deliveries above 100 = " + count);
            System.out.println("Maximum Distance = " + max);

            Arrays.sort(distances);
            System.out.println("Sorted Distances: "
                    + Arrays.toString(distances));
        } else {
            System.out.println("No deliveries to analyse.");
        }

        System.out.print("\nEnter number of locations: ");
        int locations = sc.nextInt();

        if (locations > 0) {
            int[][] route = new int[locations][locations];

            for (int i = 0; i < locations; i++) {
                for (int j = 0; j < locations; j++) {
                    System.out.print("Distance from Location "
                            + (i + 1) + " to Location " + (j + 1) + ": ");
                    route[i][j] = sc.nextInt();
                }
            }

            System.out.println("Route Matrix:");

            for (int[] row : route) {
                for (int value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        }

        System.out.println("\n===== STRING OPERATIONS =====");

        System.out.print("Enter a delivery note: ");
        sc.nextLine(); // consume leftover newline after nextInt()
        String note = sc.nextLine().trim();

        System.out.println("Note Length: " + note.length());
        System.out.println("Uppercase Note: " + note.toUpperCase());

        StringBuilder report = new StringBuilder();
        report.append("DELIVERY REPORT\n");

        for (DeliveryPackage p : packages) {
            report.append(p).append("\n");
        }

        Path file = Path.of("delivery_report.txt");

        try {
            Files.writeString(file, report.toString());

            System.out.println("\nReport saved successfully.");
            System.out.println("Reading saved report:");

            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error handling delivery report: "
                    + e.getMessage());
        }

        sc.close();
    }
}