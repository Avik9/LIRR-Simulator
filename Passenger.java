/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>Passenger</code> class.
 * 
 **/
public class Passenger
{
    private int id; // id of the passenger
    private static int arrivalTime; // time the passenger arrives
    private boolean isFirstClass; // class of the passenger
    GlobalVariables clock; // time
    
    
    /**
     * Constructor that creates a passenger with the entered values.
     * 
     * @param idNew
     *      States the id of the passenger.
     * 
     * @param arrivalTime
     *      States the time the passenger arrives at the station.
     * 
     * @param isFirstClassNew 
     *      States whether the passenger belongs in first or second class.
     */
    public Passenger(int idNew, int arrivalTime, boolean isFirstClassNew)
    {
        id = idNew;
        arrivalTime = arrivalTime;
        isFirstClass = isFirstClassNew;
    }
    
    /**
     * Changes the current id to the new id.
     * 
     * @param idNew
     *      The new id set to be assigned to the passenger.
     */
    public void setId(int idNew)
    {
        id = idNew;
    }
    
    /**
     * Returns the id of the passenger.
     * 
     * @return
     *      Returns the id of the current passenger.
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Changes the current arrival time to the new arrival time.
     * 
     * @param arrivalTimeNew
     *      The new arrival time set to be assigned to the passenger.
     */
    public void setArrivalTime(int arrivalTimeNew)
    {
        arrivalTime = arrivalTimeNew;
    }
    
    /**
     * Returns the Arrival Time.
     * 
     * @return 
     *      Returns the arrival time of the current passenger.
     * 
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }
    
    /**
     * Changes the current arrival time to the new arrival time.
     * 
     * @param isFirstClassNew
     *      The new arrival time set to be assigned to the passenger.
     */
    public void setIsFirstClass(boolean isFirstClassNew)
    {
        isFirstClass = isFirstClassNew;
    }
    
    /**
     * Returns a boolean stating whether the passenger belongs in the first class or not.
     * 
     * @return 
     *      Returns a boolean answering if the person belongs in first class.
     */
    public boolean getIsFirstClass()
    {
        return isFirstClass;
    }

    /**
     * Returns the passenger information.
     *
     * @return
     *      Returns a string with the passenger's id and arrival time.
     */
    public String toString()
    {
        return "P" + this.getId() + "@T" + this.getArrivalTime();
    }
}