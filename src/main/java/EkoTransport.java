import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EkoTransport {

    public static void main(String[] args) {
        int amountOfWork = 50;
        int minimumTonnage = 30;
        int maximumTonnage = 35;

        int totalTonnage = entryAlTotalTonnage();

        List<Integer> tonnageList = randomlyDistribute(totalTonnage, amountOfWork, minimumTonnage, maximumTonnage);

        for (int i = 0; i < tonnageList.size(); i++) {
            int tonnage = tonnageList.get(i);

            int vehicleNumber = i + 1;
            if (tonnage == 0) {
                System.out.println("Vehicle " + vehicleNumber + ": Job not given");
            } else {
                System.out.println("Vehicle " + vehicleNumber + " - Tonnage: " + tonnage + " Ton");
            }
        }

        int TotalDistributedTonnage = 0;
        int missingTonnage = totalTonnage - TotalDistributedTonnage;
        if (missingTonnage > 0) {
            int nextVehicle = tonnageList.size() + 1;
            System.out.println("Not meeting the total tonnage " + missingTonnage + " Failed to distribute tons of jobs to queued vehicles");
            System.out.println("Next vehicle: " + nextVehicle);
        }
    }

    public static int entryAlTotalTonnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total tonnage: ");
        int totalTonnage = scanner.nextInt();
        scanner.close();
        return totalTonnage;
    }

    public static List<Integer> randomlyDistribute(int totalTonnage, int amountOfWork, int minimumTonnage, int maximumTonnage) {
        List<Integer> tonnageList = new ArrayList<>();
        Random random = new Random();

        int remainingTonnage = totalTonnage;
        for (int i = 0; i < amountOfWork; i++) {
            int tonnage = 0;
            if (remainingTonnage >= minimumTonnage) {
                tonnage = random.nextInt(Math.min(remainingTonnage - (amountOfWork - i - 1) * minimumTonnage, maximumTonnage - minimumTonnage + 1)) + minimumTonnage;
                remainingTonnage -= tonnage;
            }
            tonnageList.add(tonnage);
        }



        return tonnageList;
    }
}
