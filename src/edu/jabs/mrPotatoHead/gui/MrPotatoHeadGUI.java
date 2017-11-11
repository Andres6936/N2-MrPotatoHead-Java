package edu.jabs.mrPotatoHead.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.jabs.mrPotatoHead.domain.MrPotatoHead;


/**
 * This is the main application window
 */
public class MrPotatoHeadGUI extends JFrame
{
    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Main class of the world
     */
    private MrPotatoHead potatoHead;

    // -----------------------------------------------------------------
    // GUI Fileds
    // -----------------------------------------------------------------

    /**
     * Pane with the extensions
     */
    private ExtensionPane extensionPane;

    /**
     * Pane with the header image
     */
    private ImagePane imagenPane;

    /**
     * Pane with the design of Mr. Potato Head
     */
    private PotatoHeadPane mrPotatoHeadPane;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Description <br>
     * <b>post: </b> Description
     */
    public MrPotatoHeadGUI( )
    {
        // The main class is created
        potatoHead = new MrPotatoHead( );
        // The layout is created
        setLayout( new BorderLayout( ) );
        setSize( 500, 684 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Pane creation here
        imagenPane = new ImagePane( );
        add( imagenPane, BorderLayout.NORTH );

        mrPotatoHeadPane = new PotatoHeadPane( this );
        add( mrPotatoHeadPane, BorderLayout.CENTER );

        extensionPane = new ExtensionPane( this );
        add( extensionPane, BorderLayout.SOUTH );
        setTitle( "Mr. Potato Head Creator" );
        // The window is centered
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that modifies the accessory's head of the design of Mr. Potato Head
     * @param identifierPart Identifier of the part that wants to be selected
     */
    public void selectAccesoryHead( int identifierPart )
    {
        potatoHead.selectAccessoryHead( identifierPart );
    }

    /**
     * Method that modifies the facial expression of the design of Mr. Potato Head
     * @param identifierPart Identifier of the part that wants to be selected
     */
    public void selectFacialExpression( int identifierPart )
    {
        potatoHead.selectFacialExpression( identifierPart );
    }

    /**
     * Method that modifies the mouth of the design of Mr. Potato Head
     * @param identifierPart Identifier of the part that wants to be selected
     */
    public void selectMouth( int identifierPart )
    {
        potatoHead.selectMouth( identifierPart );
    }

    /**
     * Method that modifies the arms of the design of Mr. Potato Head
     * @param identifierPart Identifier of the part that wants to be selected
     */
    public void selectArms( int identifierPart )
    {
        potatoHead.selectArms( identifierPart );
    }

    /**
     * Method that modifies the feet of the design of Mr. Potato Head
     * @param identifierPart Identifier of the part that wants to be selected
     */
    public void selectFeet( int identifierPart )
    {
        potatoHead.selectFeet( identifierPart );
    }

    /**
     * Method that calculates and displays the total price of the design of Mr. Potato Head
     */
    public void calculateTotalDesignMrPotatoHead( )
    {
        mrPotatoHeadPane.showTotalPrice( potatoHead.calculateTotalCost( ) );
    }

    /**
     * Method that sells one unit of each part in the design of Mr. Potato Head. <br>
     * It also updates the view of the design to show no parts
     */
    public void sellDesignMrPotatoHead( )
    {
        if( mrPotatoHeadPane.everyPartIsSelected( ) )
        {
            calculateTotalDesignMrPotatoHead( );
            String stocks = potatoHead.getExistingDesign( );
            if( stocks.contains( ": 0" ) )
                JOptionPane.showMessageDialog( this, "There are not enough parts to sell the design of Mr. Potato Head: \n"+stocks, "Sell Design", JOptionPane.INFORMATION_MESSAGE );
            else
            {
                int option = JOptionPane.showConfirmDialog( this, "These are the available quantities of each selected part: \n" + stocks, "¿Are you sure you want to sale?", JOptionPane.YES_NO_OPTION );
                if( option == JOptionPane.YES_OPTION )
                {
                    potatoHead.sellDesign( );
                    mrPotatoHeadPane.inicializeParts( );
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "The design of Mr. Potato Head is not complete. \n Select every part and try again.", "Sell Design", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------------

    /**
     * Method for extension 1
     */
    public void reqFuncOption1( )
    {
        String result = potatoHead.method1( );
        JOptionPane.showMessageDialog( this, result, "Answer", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Method for extension 1
     */
    public void reqFuncOption2( )
    {
        String result = potatoHead.method2( );
        JOptionPane.showMessageDialog( this, result, "Answer", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * This method executes the application, creating a new graphical user interface
     * @param args Unused Arguments
     */
    public static void main( String[] args )
    {
        MrPotatoHeadGUI gui = new MrPotatoHeadGUI( );
        gui.setVisible( true );
    }

}