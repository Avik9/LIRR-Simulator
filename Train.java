/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>Train</code> which enques the passengers from the station.
 * 
 **/
public class Train
{
    public int trainID;
    public int nextStation = 0;
    private int firstCapacity; // Capacity of passengers in the first class
    private int secondCapacity; // Capacity of passengers in the second class
    private int timeUntilNextArrival; // Time until the next train arrival.
    private GlobalVariables vars;
    private PassengerQueue firstClass = new PassengerQueue(); // first class passenger queue
    private PassengerQueue secondClass = new PassengerQueue(); // second class passenger queue

    /**
     * Constructor for the Train class.
     *
     * @param newFirstCapacity
     *      Capacity for the First class queue.
     *
     * @param newSecondCapacity
     *      Capacity for the First class queue.
     *
     * @param vars
     *      Global variables
     */
    public Train(int trainID, int newFirstCapacity, int newSecondCapacity, GlobalVariables vars)
    {
        this.trainID = trainID;
        firstCapacity = newFirstCapacity;
        secondCapacity = newSecondCapacity;
        timeUntilNextArrival = (trainID - 1) * 5;
        this.vars = vars;

    }

    /**
     * Returns the time until the next arrival.
     *
     * @return
     *      Returns the time until the next arrival.
     */
    public int getTimeUntilNextArrival()
    {
        return timeUntilNextArrival;
    }

    /**
     * Sets the time until the next arrival.
     *
     * @param newTimeUntilNextArrival
     *      Sets the time until the next arrival.
     */
    public void setTimeUntilNextArrival(int newTimeUntilNextArrival)
    {
        timeUntilNextArrival = newTimeUntilNextArrival;
    }

    /**
     * Simulates the change in time as it advances.
     *
     * @param s1
     *      Enters the station at which the train is currently.
     *
     * @throws EmptyQueueException
     *      Throws an exception if the queue is empty.
     */
    public void simulateTimeStep(Station s1) throws EmptyQueueException
    {

        if(timeUntilNextArrival == 0){
            timeUntilNextArrival = 5;
            if(nextStation + 1 == 4){

            }else{
                nextStation++;
            }

        }

        while(!s1.getFirstClass().isEmpty())
        {
            firstClass.enqueue(s1.getFirstClass().dequeue());
        }

        while(!s1.getSecondClass().isEmpty())
        {
            secondClass.enqueue(s1.getSecondClass().dequeue());
        }

        timeUntilNextArrival--;
    }

    /**
     * Returns the list of  passenger in the queue.
     *
     * @return
     *      Returns the list of  passenger in the queue.
     */
    public String toString()
    {
        String ans = "";
        
        if(!firstClass.isEmpty())
        {
            ans += "First Class: \n";
            ans += firstClass.toString();
        }
        if(!secondClass.isEmpty())
        {
            ans += "Second Class: \n";
            ans += secondClass.toString();
        }
        
        return ans;
    }
}
