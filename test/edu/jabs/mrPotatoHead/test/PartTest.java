package edu.jabs.mrPotatoHead.test;

import edu.jabs.mrPotatoHead.domain.Part;

import junit.framework.TestCase;


/**
 * This class is used to verify that the methods in the Part class are properly implemented
 */
public class PartTest extends TestCase
{
    // -----------------------------------------------------------------
    // Test Fields
    // -----------------------------------------------------------------

    /**
     * The class where the tests are going to be performed
     */
    private Part part;

    // -----------------------------------------------------------------
    // Scenarios
    // -----------------------------------------------------------------

    /**
     * It builds a new Part of accessory type with available units
     */
    private void setupScenario1( )
    {
        part = new Part( Part.ACCESORY, 78, 1234.56 );
    }

    /**
     * It builds a new Part of expression type with available units
     */
    private void setupScenario2( )
    {
        part = new Part( Part.EXPRESSION, 1, 30570.55 );
    }

    /**
     * It builds a new Part of accessory type without available units
     */
    private void setupScenario3( )
    {
        part = new Part( Part.ARMS, 0, 16490 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * When a Part is built, it tests all the values passed by parameter are assigned correctly.<br>
     * <b> Methods to test:</b>constructors, getType(), getAvailableQuantity(), getBasePrice()<br>
     * <b> Objective:</b>To test that the constructor method is working properly<br>
     * <b> Expected Results: </b> The fields of the part are not exchanged in the constructor nor in the getters methods<br>
     */
    public void testPart( )
    {
        setupScenario1( );
        assertEquals( "The type's part is not being assigned correctly.", Part.ACCESORY, part.getType( ) );
        assertEquals( "The available quantity of the part is not being assigned correctly.", 78, part.getAvailableQuantity( ) );
        assertEquals( "The base price of the part is not being assigned correctly.", 1234.56, part.getBasePrice( ), part.getBasePrice( ) - 1234.56 );

        setupScenario2( );
        assertEquals( "The type's part is not being assigned correctly.", Part.EXPRESSION, part.getType( ) );
        assertEquals( "The available quantity of the part is not being assigned correctly.", 1, part.getAvailableQuantity( ) );
        assertEquals( "The base price of the part is not being assigned correctly.", 30570.55, part.getBasePrice( ), part.getBasePrice( ) - 30570.55 );

        setupScenario3( );
        assertEquals( "The type's part is not being assigned correctly.", Part.ARMS, part.getType( ) );
        assertEquals( "The available quantity of the part is not being assigned correctly.", 0, part.getAvailableQuantity( ) );
        assertEquals( "The base price of the part is not being assigned correctly.", 16490, ( int )part.getBasePrice( ) );
    }

    /**
     * When changing the available quantity of a part, it tests that always a valid value is verified and only in these cases the value's field is modified.<br>
     * <b> Methods to test:</b>setAvailableQuantity(), getAvailableQuantity()<br>
     * <b> Objective:</b>To test that the method setAvailableQuantity() is working properly <br>
     * <b> Expected Results: </b> The value of available quantities of the part is changed each time that the new value is greater than or equal to zero<br>
     */
    public void testSetAvailableQuantity( )
    {
        setupScenario1( );
        part.setAvailableQuantity( 12 );
        assertEquals( "The available quantity of the part is not being changed correctly.", 12, part.getAvailableQuantity( ) );

        setupScenario2( );
        part.setAvailableQuantity( part.getAvailableQuantity( ) - 1 );
        assertEquals( "The available quantity of the part is not being changed correctly", 0, part.getAvailableQuantity( ) );

        setupScenario3( );
        part.setAvailableQuantity( part.getAvailableQuantity( ) - 1 );
        assertEquals( "The available quantity of the part should not allow negative values. No change has been due.", 0, part.getAvailableQuantity( ) );
    }

    /**
     * When changing the base price of a part, it tests that always a valid value is verified and only in these cases the value's field is modified.<br>
     * <b> Methods to test:</b>setBasePrice(), getBasePrice()<br>
     * <b> Objective:</b>To test that the method setBasePrice() is working properly <br>
     * <b> Expected Results: </b> The value of the base price is changed each time that the new value is greater than zero<br>
     */
    public void testSetBasePrice( )
    {
        setupScenario1( );
        part.setBasePrice( 17350 );
        assertEquals( "The base price of the part is not being changed correctly.", 17350, ( int )part.getBasePrice( ) );

        setupScenario2( );
        part.setBasePrice( 0 );
        assertEquals( "The base price of the part should not allow a value of zero. No change has been due.", 30570.55, part.getBasePrice( ), part.getBasePrice( ) - 30570.55 );

        setupScenario3( );
        part.setBasePrice( -part.getBasePrice( ) );
        assertEquals( "The base price of the part should not allow negative values. No change has been due.", 16490, ( int )part.getBasePrice( ) );
    }
}