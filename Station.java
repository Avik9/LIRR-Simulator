/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>Station</code> which holds the passenger and allows them to get on the train.
 * 
 **/

public class Station
{
    private static PassengerQueue firstClass; // the first class queue
    private static PassengerQueue secondClass; // the second class queue
    private int numFirstClass = 0; // number of passengers in the first class.
    private int numSecondClass = 0;// number of passengers in the second class.
    private String stationName = ""; // name of the station
    private BooleanSource firstArrival; // whether the passenger for the first class arrives
    private BooleanSource secondArrival; // whether the passenger for the second class arrives
    private GlobalVariables vars; // keeps a count of the variables

    /**
     * Constructor for the Station class.
     *
     * @param newStationName
     *      Changes the station name to the given name.
     *
     * @param pFirstClass
     *      Sets the probability of the first class to the given amount.
     *
     * @param pSecondClass
     *      Sets the probability of the second class to the given amount.
     *
     * @param vars
     *      Keeps a count of the varaibles
     *
     * @throws IllegalArgumentException
     *      Throws an exception if the value is incorrect.
     */
    public Station(String newStationName, double pFirstClass, double pSecondClass, GlobalVariables vars) throws IllegalArgumentException
    {
        stationName = newStationName;
        firstClass = new PassengerQueue();
        secondClass = new PassengerQueue();
        firstArrival = new BooleanSource(pFirstClass);
        secondArrival = new BooleanSource(pSecondClass);
        this.vars = vars;

    }

    /**
     *Simulates the change in time as it advances.
     */
    public void simulateTimestep()
    {
        if(firstArrival.occurs())
        {
            Passenger p = new Passenger(vars.totalPassengersArrived, Clock.getTime(),true);
            
            p.toString();
            
            firstClass.enqueue(p);

            vars.totalPassengersArrived++;
            numFirstClass++;
        }
        
        if (secondArrival.occurs())
        {
            Passenger p = new Passenger(vars.totalPassengersArrived, Clock.getTime(),false);
            
            p.toString();
            
            secondClass.enqueue(p);

            vars.totalPassengersArrived++;
            numSecondClass++;
        }
    }

    /**
     * Returns the name of the station.
     *
     * @return
     *      Returns the name of the station.
     */
    public String getStationName()
    {
        return this.stationName;
    }

    /**
     * Returns the first class queue.
     *
     * @return
     *  Returns the first class queue.
     */
    public PassengerQueue getFirstClass()
    {
        return firstClass;
    }

    /**
     * Returns the second class queue.
     *
     * @return
     *      Returns the second class queue.
     */
    public PassengerQueue getSecondClass()
    {
        return secondClass;
    }

    /**
     * Returns the list of passengers in both queues.
     *
     * @return
     *      Returns the queue of passengers waiting on thw station.
     */
    public String toString()
    {
        String ans = "";
        
        if(!(firstClass.isEmpty()))
        {
            for(int i = 0; i < firstClass.size(); i++)
            {
                ans += "First Class: \n";
                ans += firstClass.get(i).toString();
            }
        }
        
        if(!(secondClass.isEmpty()))
        {
            for(int i = 0; i < secondClass.size(); i++)
            {
                ans += "Second Class: \n";
                ans += secondClass.get(i).toString();
            }
        }

        return ans;
    }
}