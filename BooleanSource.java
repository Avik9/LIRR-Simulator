/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>BooleanSource</code> which determines the probability.
 * 
 **/
public class BooleanSource
{
    private double probability = 0; // holds the probability.
    
    /**
     *
     * @throws IllegalArgumentException 
     *      Throws an exception if the probability not between 0.0 and 1.0
     */
    public BooleanSource(double p) throws IllegalArgumentException
    {
        if (p < 0.0 || p > 1.0)
        {
            throw new IllegalArgumentException();
        }
        
        probability = p;
    }
    
    /**
     * Returns true if the random number generated is below the probability.
     * 
     * @return
     *      Returns whether the random value generated is within the probability.
     */
    public boolean occurs() 
    {
        return (Math.random() <= probability);
    }
}