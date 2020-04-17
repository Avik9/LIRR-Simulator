import java.util.*;

/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class contains the main method.
 * 
 **/

public class LIRRSimulator
{
    public static GlobalVariables variables = new GlobalVariables();
    public static ArrayList<Station> q1 = new ArrayList();
    //public static Train t = new Train(25,25, variables);
    private static double p1;
    private static double p2;
    private static String[] a1 = {"Mineola", "Hicksville", "Syosset", "Huntington"};


    public static void main(String [] args)
    {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly.");

            for (int i = 0; i <= 3; i++) // adding stations to the station arraylist
            {
                System.out.print("\n" + a1[i] + ":\nPlease enter first class arrival probability: ");

                p1 = sc.nextDouble();

                System.out.print("Please enter second class arrival probability: ");

                p2 = sc.nextDouble();

                q1.add(new Station(a1[i], p1, p2, variables));
            }

            System.out.print("\nPlease enter first class capacity: ");
            p1 = sc.nextInt();

            System.out.print("Please enter second class capacity: ");
            p2 = sc.nextInt();

            System.out.print("\nPlease enter number of trains: ");
            int numTrains = sc.nextInt();

            Train[] trainArray = new Train[numTrains];

            for (int i = 0; i < numTrains; i++) // adding trains to the train array
            {
                trainArray[i] = new Train(i + 1, (int) p1, (int) p2, variables);
            }

            System.out.print("Please enter last arrival time of passengers: ");
            int time = sc.nextInt();

            System.out.println("Begin Simulation:\n---------------------------------------------------------------\n");

            for (Station s : q1) {
                s.simulateTimestep();
            }

            System.out.println("\nTime 0:");

            System.out.println("\nStation overview:\n");

            System.out.println(a1[0] + ":\n");

            if (q1.get(0).getFirstClass().isEmpty()) {
                System.out.println("No first class passenger arrives.");
            } else {
                System.out.println("First class passenger ID " + q1.get(0).getFirstClass().peek().getId() + " arrives.");
            }

            if (q1.get(0).getSecondClass().isEmpty()) {
                System.out.println("No second class passenger arrives.");
            } else {
                System.out.println("Second class passenger ID " + q1.get(0).getSecondClass().peek().getId() + " arrives.");
            }

            if (q1.get(0).getFirstClass().isEmpty()) {
                System.out.println("\nQueues: \nFirst [empty]");
            } else {
                System.out.println("Queues: \nFirst [" + q1.get(0).getFirstClass().peek().toString());
            }

            if (q1.get(0).getSecondClass().isEmpty()) {
                System.out.println("Second [empty]");
            } else {
                System.out.println("Second [" + q1.get(0).getSecondClass().peek().toString());
            }

            System.out.print("\nTrains: \nTrain 1 arrives at Huntington, There are " + q1.get(0).getFirstClass().size()
                    + " passengers in first class and " + q1.get(0).getSecondClass().size() + " in second class." +
                    "\n\nPassengers embarking in first class: ");

            if (q1.get(0).getFirstClass().isEmpty()) {
                System.out.println("none");
            } else {
                System.out.println("P" + q1.get(0).getFirstClass().peek().getId());
                ;
            }

            System.out.print("Passengers embarking in second class: ");
            if (q1.get(0).getSecondClass().isEmpty()) {
                System.out.println("none");
            } else {
                System.out.println("P" + q1.get(0).getSecondClass().peek().getId());
            }

            for (int i = 0; i < trainArray.length; i++) {

                System.out.println("\nTrain " + (i + 2) + " will arrive at " + q1.get(0).getStationName() + " in " + ((i + 1) * 5) + " minutes.");

            }

            for (int i = 0; i < numTrains; i++) // train simulateTimeStep
            {
                for (int j = 0; j < q1.size() - 1; j++) {
                    trainArray[i].simulateTimeStep(q1.get(j));
                }
            }

            System.out.println("\n-------------------------------------");

            Clock.addTime();


            for (int x = 1; x < time; x++) // time loop
            {

                for (Station s : q1) {
                    s.simulateTimestep();
                }

                System.out.println("\nTime " + x + ":");

                System.out.println("\nStation overview:\n");

                System.out.println(a1[0] + ":\n");

                if (q1.get(0).getFirstClass().isEmpty()) {
                    System.out.println("No first class passenger arrives.");
                } else {
                    System.out.println("First class passenger ID " + q1.get(0).getFirstClass().peek().getId() + " arrives.");
                }

                if (q1.get(0).getSecondClass().isEmpty()) {
                    System.out.println("No second class passenger arrives.");
                } else {
                    System.out.println("Second class passenger ID " + q1.get(0).getSecondClass().peek().getId() + " arrives.");
                }

                if (q1.get(0).getFirstClass().isEmpty()) {
                    System.out.println("\nQueues: \nFirst [empty]");
                } else {
                    System.out.println("Queues: \nFirst [" + q1.get(0).getFirstClass().toString());
                }

                if (q1.get(0).getSecondClass().isEmpty()) {
                    System.out.println("Second [empty]");
                } else {
                    System.out.println("Second [" + q1.get(0).getSecondClass().toString());
                }

                System.out.print("\nTrains: \nTrain 1 arrives at Huntington, There are " + q1.get(0).getFirstClass().size()
                        + " passengers in first class and " + q1.get(0).getSecondClass().size() + " in second class." +
                        "\n\nPassengers embarking in first class: ");

                if (q1.get(0).getFirstClass().isEmpty()) {
                    System.out.println("none");
                } else {
                    System.out.println("P" + q1.get(0).getFirstClass().peek().getId());
                    ;
                }

                System.out.print("Passengers embarking in second class: ");
                if (q1.get(0).getSecondClass().isEmpty()) {
                    System.out.println("none");
                } else {
                    System.out.println("P" + q1.get(0).getSecondClass().peek().getId());
                }

                for (int i = 0; i < trainArray.length; i++) {

                    int z = 0;

                    if (Clock.getTime() % 5 == 0) {
                        z += 1;
                    }

                    System.out.println("\nTrain " + trainArray[i].trainID + " will arrive at " +
                            q1.get(trainArray[i].nextStation).getStationName() + " in " +
                            trainArray[i].getTimeUntilNextArrival() + " minutes.");

                }

                for (int i = 0; i < numTrains; i++) // train simulateTimeStep
                {
                    for (int j = 0; j < q1.size() - 1; j++) {
                        trainArray[i].simulateTimeStep(q1.get(j));
                    }
                }

                System.out.println("\n-------------------------------------");
            }
        }
        catch(EmptyQueueException e)
        {
            System.out.println("The queue is empty. Please try again.");
        }
        catch (IllegalArgumentException i)
        {
            System.out.println("The value you entered is incorrect. Please try again.");
        }
    }
}
