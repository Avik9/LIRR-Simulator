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
 * The class creates a <code>PassengerQueue</code> queue add passengers in there.
 * 
 **/

public class PassengerQueue extends ArrayList
{
    private ArrayList<Passenger> pQueue = new ArrayList<Passenger>(); // creates a new queue.
    private int queueSize = 0; // a variable of how many passengers in the queue.
    
    /**
     * Adds a passenger to the queue.
     * 
     * @param p
     *      Adds this passenger to the queue.
     */
    public void enqueue(Passenger p)
    {
        pQueue.add(p);
        queueSize++;
    }
    
    /**
     * Removes the next passenger from the queue and returns it.
     * 
     * @return
     *      Returns the next passenger in the queue after removing it.
     * 
     * @throws EmptyQueueException 
     *      Throws an exception when the queue is empty.
     */
    public Passenger dequeue() throws EmptyQueueException
    {
        if(pQueue.isEmpty() || queueSize == 0)
        {
            throw new EmptyQueueException();
        }
        
        else
        {
            Passenger temp = pQueue.get(queueSize - 1);
            
            pQueue.remove(queueSize - 1);
            queueSize--;
            
            return temp;
        }
    }
     /**
      * Returns the next passenger in the queue without removing it.
      * 
      * @return
      *     Returns the next passenger in the queue.
      * 
      * @throws EmptyQueueException 
      *     Throws an exception when the queue is empty.
      * 
      */
    public Passenger peek() throws EmptyQueueException
    {

        
        if(pQueue.isEmpty() || queueSize < 1)
        {
            throw new EmptyQueueException();
        }
        
        else
        {
            return pQueue.get(queueSize - 1);
        }
    }
    
    /**
     * Returns whether the queue is empty.
     * 
     * @return
     *      Returns a boolean stating whether the queue is empty.
     */
    @Override
    public boolean isEmpty()
    {
        //System.out.println("Size: " + pQueue.size());
        return pQueue.size() == 0;
    }
    
    /**
     * Returns the queue of the passengers.
     * 
     * @return
     *      Returns a String with a list of passengers.
     */
    @Override
    public String toString()
    {
        String ans = "";

        if(pQueue.isEmpty())
        {
            return ans;
        }
        else
        {
            for(int i = 0; i < pQueue.size(); i++) {
                ans +=((pQueue.get(i)).toString()) + "," ;
            }
        }

        return ans;
    }
}