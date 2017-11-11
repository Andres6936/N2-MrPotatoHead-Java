package edu.jabs.mrPotatoHead.domain;

/**
 * Information from one part of Mr. Potato Head
 */
public class MrPotatoHead
{

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Option 1 of the accessory part
     */
    private Part accesory1;

    /**
     * Option 2 of the accessory part
     */
    private Part accesory2;

    /**
     * Option 3 of the accessory part
     */
    private Part accesory3;

    /**
     * Option 1 of the expression part
     */
    private Part expression1;

    /**
     * Option 2 of the expression part
     */
    private Part expression2;

    /**
     * Option 3 of the expression part
     */
    private Part expression3;

    /**
     * Option 1 of the mouth part
     */
    private Part mouth1;

    /**
     * Option 2 of the mouth part
     */
    private Part mouth2;

    /**
     * Option 3 of the mouth part
     */
    private Part mouth3;

    /**
     * Option 1 of the arms part
     */
    private Part arms1;

    /**
     * Option 2 of the arms part
     */
    private Part arms2;

    /**
     * Option 3 of the arms part
     */
    private Part arms3;

    /**
     * Option 1 of the feet part
     */
    private Part feet1;

    /**
     * Option 2 of the feet part
     */
    private Part feet2;

    /**
     *  Option 3 of the feet part
     */
    private Part feet3;

    /**
     * Accessory's head of Mr. Potato Head designed
     */
    private Part actualAccessory;

    /**
     * Expression of Mr. Potato Head designed
     */
    private Part actualExpression;

    /**
     * Mouth of Mr. Potato Head designed
     */
    private Part actualMouth;

    /**
     * Arms of Mr. Potato Head designed
     */
    private Part actualArms;

    /**
     * Feet of Mr. Potato Head designed
     */
    private Part actualFeet;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * It creates the store to design Mr. Potato Head
     */
    public MrPotatoHead( )
    {
        accesory1 = new Part( Part.ACCESORY, 5, 22000.5 );
        accesory2 = new Part( Part.ACCESORY, 10, 12350 );
        accesory3 = new Part( Part.ACCESORY, 18, 10300 );

        expression1 = new Part( Part.EXPRESSION, 12, 35000 );
        expression2 = new Part( Part.EXPRESSION, 17, 12300 );
        expression3 = new Part( Part.EXPRESSION, 1, 17000.5 );

        mouth1 = new Part( Part.MOUTH, 1, 23500.5 );
        mouth2 = new Part( Part.MOUTH, 12, 22800.5 );
        mouth3 = new Part( Part.MOUTH, 7, 25000.5 );

        arms1 = new Part( Part.ARMS, 22, 21500.5 );
        arms2 = new Part( Part.ARMS, 1, 29300 );
        arms3 = new Part( Part.ARMS, 8, 27200 );

        feet1 = new Part( Part.FEET, 11, 66000.6 );
        feet2 = new Part( Part.FEET, 3, 52250 );
        feet3 = new Part( Part.FEET, 8, 47000.5 );

        actualAccessory = null;
        actualExpression = null;
        actualMouth = null;
        actualArms = null;
        actualFeet = null;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that modifies the accessory's head of Mr. Potato Head designed
     * @param identifierPart Identifier's part to assign
     */
    public void selectAccessoryHead( int identifierPart )
    {
        if( identifierPart == 1 )
            actualAccessory = accesory1;
        else if( identifierPart == 2 )
            actualAccessory = accesory2;
        else if( identifierPart == 3 )
            actualAccessory = accesory3;
    }

    /**
     * Method that modifies the facial expression of Mr. Potato Head designed
     * @param identifierPart Identifier's part to assign
     */
    public void selectFacialExpression( int identifierPart )
    {
        if( identifierPart == 1 )
            actualExpression = expression1;
        else if( identifierPart == 2 )
            actualExpression = expression2;
        else if( identifierPart == 3 )
            actualExpression = expression3;
    }

    /**
     * Method that modifies the mouth of Mr. Potato Head designed
     * @param identifierPart Identifier's part to assign
     */
    public void selectMouth( int identifierPart )
    {
        if( identifierPart == 1 )
            actualMouth = mouth1;
        else if( identifierPart == 2 )
            actualMouth = mouth2;
        else if( identifierPart == 3 )
            actualMouth = mouth3;
    }

    /**
     * Method that modifies the arms of Mr. Potato Head designed
     * @param identifierPart Identifier's part to assign
     */
    public void selectArms( int identifierPart )
    {
        if( identifierPart == 1 )
            actualArms = arms1;
        else if( identifierPart == 2 )
            actualArms = arms2;
        else if( identifierPart == 3 )
            actualArms = arms3;
    }

    /**
     * Method that modifies the feet of Mr. Potato Head designed
     * @param identifierPart Identifier's part to assign
     */
    public void selectFeet( int identifierPart )
    {
        if( identifierPart == 1 )
            actualFeet = feet1;
        else if( identifierPart == 2 )
            actualFeet = feet2;
        else if( identifierPart == 3 )
            actualFeet = feet3;
    }

    /**
     * Method that calculates Mr. Potato Head's price from its parts. <br>
     * The final price can be calculated even if some parts are null. <br>
     * The final price is calculated by accumulating the price with discount of each part.
     * Moreover, the policy of discounts on the total price is:
     * 10% discount on the total cost, if the total cost is greater than or equal to $50.0000 and less than $100.000 <br>
     * 15% discount on the total cost, if the total cost is greater than or equal to $100.000 and less than $150.000 <br>
     * 20% discount on the total cost, if the total cost is greater than or equal to $$150.000 <br>
     * @return The price of the design with the selected parts
     */
    public double calculateTotalCost( )
    {
        double totalCost = 0.0;
        if( actualAccessory != null )
            totalCost += actualAccessory.getPriceWithDiscount( );
        if( actualExpression != null )
            totalCost += actualExpression.getPriceWithDiscount( );
        if( actualMouth != null )
            totalCost += actualMouth.getPriceWithDiscount( );
        if( actualArms != null )
            totalCost += actualArms.getPriceWithDiscount( );
        if( actualFeet != null )
            totalCost += actualFeet.getPriceWithDiscount( );

        if( totalCost >= 50000 && totalCost < 100000 )
        {
            totalCost = totalCost - totalCost * 0.10;
        }
        else if( totalCost >= 100000 && totalCost < 150000 )
        {
            totalCost = totalCost - totalCost * 0.15;
        }
        else if( totalCost >= 150000 )
        {
            totalCost = totalCost - totalCost * 0.20;
        }
        return totalCost;
    }

    /**
     * Method that sells one unit of each part in the design of Mr. Potato Head
     */
    public void sellDesign( )
    {
        actualAccessory.setAvailableQuantity( actualAccessory.getAvailableQuantity( ) - 1 );
        actualAccessory = null;
        actualExpression.setAvailableQuantity( actualExpression.getAvailableQuantity( ) - 1 );
        actualExpression = null;
        actualMouth.setAvailableQuantity( actualMouth.getAvailableQuantity( ) - 1 );
        actualMouth = null;
        actualArms.setAvailableQuantity( actualArms.getAvailableQuantity( ) - 1 );
        actualArms = null;
        actualFeet.setAvailableQuantity( actualFeet.getAvailableQuantity( ) - 1 );
        actualFeet = null;
    }

    /**
     * Method that gives a message with the stocks of the parts of the design, the message form is as follows:<br>
     * <Type's part>:<available quantity> + <Type's part>:<available quantity>
     * @return Message with the available quantity of each existing part of the design
     */
    public String getExistingDesign( )
    {
        String existingMessage = "";
        existingMessage += Part.ACCESORY + ": " + actualAccessory.getAvailableQuantity( )+"\n";
        existingMessage += Part.EXPRESSION + ": " + actualExpression.getAvailableQuantity( )+"\n";
        existingMessage += Part.MOUTH + ": " + actualMouth.getAvailableQuantity( )+"\n";
        existingMessage += Part.ARMS + ": " + actualArms.getAvailableQuantity( )+"\n";
        existingMessage += Part.FEET + ": " + actualFeet.getAvailableQuantity( )+"\n";
        return existingMessage;
    }

    // -----------------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------------

    /**
     * Method for extension 1
     * @return answer1
     */
    public String method1( )
    {
        return "Answer 1";
    }

    /**
     * Method for extension 2
     * @return answer2
     */
    public String method2( )
    {
        return "Answer 2";
    }
}