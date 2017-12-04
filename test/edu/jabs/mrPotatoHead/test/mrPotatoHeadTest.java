package edu.jabs.mrPotatoHead.test;

import edu.jabs.mrPotatoHead.domain.MrPotatoHead;

import junit.framework.TestCase;


/**
 * This class is used to verify that the methods in the MrPotatoHead class are properly implemented
 */
public class mrPotatoHeadTest extends TestCase
{
    // -----------------------------------------------------------------
    // Test Fields
    // -----------------------------------------------------------------

    /**
     * The class where the test are going to be performed
     */
    private MrPotatoHead potatoHead;

    // -----------------------------------------------------------------
    // Scenarios
    // -----------------------------------------------------------------

    /**
     * It builds a new MrPotatoHead with 3 possibilities for the 5 types of parts
     */
    private void setupScenario1( )
    {
        potatoHead = new MrPotatoHead( );
    }

    /**
     * It builds a new PotatoHead with a design with the 5 parts
     */
    private void setupScenario2( )
    {
        potatoHead = new MrPotatoHead( );
        selectParts( 2, 1, 1, 2, 1 );
    }

    /**
     * Helper method that selects an accessory, mouth, arms and feet for the desgin of Mr. Potato Head
     * @param accessory Identifier of the accessory part to select
     * @param expression Identifier of the expression part to select
     * @param mouth Identifier of the mouth part to select
     * @param arms Identifier of the arms part to select
     * @param feet Identifier of the feet part to select
     */
    private void selectParts( int accessory, int expression, int mouth, int arms, int feet )
    {
        potatoHead.selectAccessoryHead( accessory );
        potatoHead.selectFacialExpression( expression );
        potatoHead.selectMouth( mouth );
        potatoHead.selectArms( arms );
        potatoHead.selectFeet( feet );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * When a accessory is selected, the change can be verified calculating the total value of design.<br>
     * <b> Methods to test:</b> calculateTotalCost( ), selectAccesoryHead()<br>
     * <b> Objective:</b>To test that the method selectAccesoryHead() is working properly <br>
     * <b> Expected Results: </b><br>
     * 1.When calculating the cost of design with one part(ACCESSORY) the expected value is obtained. <br>
     */
    public void testSelectAccessoryHead( )
    {
        setupScenario1( );
        try
        {
            potatoHead.selectAccessoryHead( 1 );
            double subtotal = potatoHead.calculateTotalCost( );
            assertEquals( "The final price was not calculated correctly on the only part of the design.", 18700.425, subtotal, subtotal - 18700.425 );
        }
        catch( NullPointerException npe )
        {
            fail( "There are no null checks." );
        }
    }
    /**
     * When a facial expression is selected, the change can be verified calculating the total value of design.<br>
     * <b> Methods to test:</b> calculateTotalCost( ), selectFacialExpression()<br>
     * <b> Objective:</b>To test that the method selectFacialExpression() is working properly <br>
     * <b> Expected Results: </b><br>
     * 1.When calculating the cost of design with one part(FACIAL EXPRESSION) the expected value is obtained. <br>
     */
    public void testSelectFacialExpression( )
    {
        setupScenario1( );
        try
        {
            potatoHead.selectFacialExpression( 2 );
            double subtotal = potatoHead.calculateTotalCost( );
            assertEquals( "The final price was not calculated correctly on the only part of the design.", 11070, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "There are no null checks." );
        }
    }

    /**
     * When a mouth is selected, the change can be verified calculating the total value of design.<br>
     * <b> Methods to test:</b> calculateTotalCost( ), selectMouth()<br>
     * <b> Objective:</b>To test that the method selectMouth() is working properly <br>
     * <b> Expected Results: </b><br>
     * 1.When calculating the cost of design with one part(MOUTH) the expected value is obtained. <br>
     */
    public void testSelectMouth( )
    {
        setupScenario1( );
        try
        {
            potatoHead.selectMouth( 1 );
            double subtotal = potatoHead.calculateTotalCost( );
            assertEquals( "The final price was not calculated correctly on the only part of the design.", 27025, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "There are no null checks." );
        }
    }

    /**
     * When arms are selected, the change can be verified calculating the total value of design.<br>
     * <b> Methods to test:</b> calculateTotalCost( ), selectArms()<br>
     * <b> Objective:</b>To test that the method selectArms() is working properly <br>
     * <b> Expected Results: </b><br>
     * 1.When calculating the cost of design with one part(ARMS) the expected value is obtained. <br>
     */
    public void testSelectArms( )
    {
        setupScenario1( );
        try
        {
            potatoHead.selectArms( 3 );
            double subtotal = potatoHead.calculateTotalCost( );
            assertEquals( "The final price was not calculated correctly on the only part of the design.", 31280, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "There are no null checks." );
        }
    }

    /**
     * When feet are selected, the change can be verified calculating the total value of design.<br>
     * <b> Methods to test:</b> calculateTotalCost( ), selectFeet()<br>
     * <b> Objective:</b>To test that the method selectFeet() is working properly <br>
     * <b> Expected Results: </b><br>
     * 1.When calculating the cost of design with one part(FEET) the expected value is obtained. <br>
     */
    public void testSelectFeet( )
    {
        setupScenario1( );
        try
        {
            potatoHead.selectFeet( 1 );
            double subtotal = potatoHead.calculateTotalCost( );
            assertEquals( "The final price was not calculated correctly on the only part of the design.", 53460, ( int )subtotal );
        }
        catch( NullPointerException npe )
        {
            fail( "There are no null checks." );
        }
    }

    /**
     * When the final price with 5 parts is calculated, it tests the appropriate result<br>
     * <b> Methods to test:</b> calculateTotalCost()<br>
     * <b> Objective:</b>To test that the method calculateTotalCost() is working properly <br>
     * <b> Expected Results: </b> <br>
     * 1. If there is not every part, the price is computed correctly. <br>
     * 2. If the final price is between 50000 and 100000, the discount is applied properly. <br>
     * 3. If the final price is between 100000 y 150000, the discount is applied properly.<br>
     * 4. If the final price is greater than 150000, the discount is applied properly. <br>
     */
    public void testCalculateTotalCost( )
    {
        setupScenario2( );
        assertEquals( "The price was not computed correctly.", 131176, ( int )potatoHead.calculateTotalCost( ) );

        selectParts( 2, 3, 1, 2, 1 );
        assertEquals( "The price was not computed correctly.", 121617, ( int )potatoHead.calculateTotalCost( ) );
        selectParts( 3, 2, 1, 1, 2 );
        assertEquals( "The price was not computed correctly.", 107782, ( int )potatoHead.calculateTotalCost( ) );
        selectParts( 1, 1, 3, 3, 3 );
        assertEquals( "The price was not computed correctly.", 136705, ( int )potatoHead.calculateTotalCost( ) );

    }

    /**
     * When a design is sold, its tests for the right parts to be in the selected design.<br>
     * <b> Methods to test:</b>selectFacialExpression(), selectAccessoryHead(), selectMouth(), selectArms(), selectFeet(), calculateTotalCost()<br>
     * <b> Objective:</b>To test that the method sellDesign() is working properly <br>
     * <b> Expected Results: </b> <br>
     * 1. After selling a design, the price with all its parts is calculated correctly.<br>
     */
    public void testSellDesign( )
    {
        setupScenario1( );

        selectParts( 2, 3, 1, 2, 1 );
        potatoHead.sellDesign( );

        selectParts( 2, 3, 1, 2, 1 );
        assertEquals( "The final price was not computed correctly.", 72182, ( int )potatoHead.calculateTotalCost( ) );
        potatoHead.sellDesign( );
    }
}