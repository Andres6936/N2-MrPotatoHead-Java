package edu.jabs.mrPotatoHead.domain;

/**
 * Part of the design of Mr. Potato Head
 */
public class Part
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant that represents the type of attachment of the head part
     */
    final public static String ACCESORY = "Accesory";

    /**
     * Constant that represents the type of the expression part (eyes+nose+ears)
     */
    final public static String EXPRESSION = "Expression";

    /**
     * Constant that represents the type of arms part
     */
    final public static String ARMS = "Arms";

    /**
     * Constant that represents the type of mouth part
     */
    final public static String MOUTH = "Mouth";

    /**
     * Constant that represents the type of feet part
     */
    final public static String FEET = "Feet";

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * The type's part. It can be ACCESORY, EXPRESSION, ARMS, MOUTH or FEET.
     */
    private String typePart;

    /**
     * The available quantity of the part
     */
    private int availableQuantity;

    /**
     * The base price's part
     */
    private double basePrice;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * It creates Mr. Potato Head's part
     * @param nType The type's part
     * @param nQuantity The available quantity of the part
     * @param nBasePrice The base price of the part
     */
    public Part( String nType, int nQuantity, double nBasePrice )
    {
        typePart = nType;
        availableQuantity = nQuantity;
        basePrice = nBasePrice;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that returns the type's part
     * @return The type
     */
    public String getType( )
    {
        return typePart;
    }

    /**
     * Method that returns the available quantity of the part
     * @return The available quantity of the part
     */
    public int getAvailableQuantity( )
    {
        return availableQuantity;
    }

    /**
     * Method that sets the available quantity of the part if and only if it is greater than or equal to zero (0)
     * @param nAvailableQuantity The available quantity to assign
     */
    public void setAvailableQuantity( int nAvailableQuantity )
    {
        if( nAvailableQuantity >= 0 )
            availableQuantity = nAvailableQuantity;
    }

    /**
     * Method that returns the base price of the part
     * @return the base price
     */
    public double getBasePrice( )
    {
        return basePrice;
    }

    /**
     * Method that returns the price's part after rebates.
     * If the stock number of the part is greater than 10, then it'll have a 10 percent discount.
     * However, if the stock number of the part is less than 10, but greater than zero, then it'll have a 15 increase.
     * When the stock number is equal to 10, there is no discount.
     * @return The final price of the part according to the available units.
     */
    public double getPriceWithDiscount( )
    {
        double discount = 0.0;
        double finalPrice = 0.0;
        if( availableQuantity > 0 )
        {
            // The stock number of the part is greater than 10 --> 10% discount
            if( availableQuantity > 10 )
                discount += 0.1;
                // The stock number of the part is less than 10 --> 15% increase
            else if( availableQuantity < 10 )
                discount -= 0.15;
            finalPrice = ( basePrice - basePrice * discount );
        }
        return finalPrice;
    }

    /**
     * Method than sets the base price of the part if and only if it is greater tan zero
     * @param nBasePrice The base price to assign
     */
    public void setBasePrice( double nBasePrice )
    {
        if( nBasePrice > 0 )
            basePrice = nBasePrice;
    }
}