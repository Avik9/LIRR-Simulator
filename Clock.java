/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>Clock</code> that keeps a note of time.
 * 
 **/

public class Clock
{
    private static int currentTime = 0; // current time
    public int endTime; // time it ends

    /**
     * Changes the end time
     * @param newEndTime
     *      Changes the end time to this.
     */
    public Clock(int newEndTime)
    {
        this.endTime = newEndTime;
    }

    /**
     * Returns the current time.
     *
     * @return
     *      Returns the time.
     */
    public static int getTime()
    {
        return currentTime;
    }

    /**
     * Changes the time to the given value.
     *
     * @param newTime
     *      Sets the time as this given value.
     */
    public void setTime(int newTime)
    {
        currentTime = newTime;
    }

    /**
     * Adds 1 to the current time.
     */
    public static void addTime()
    {
        currentTime++;
    }
}
