package edu.jabs.mrPotatoHead.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Extension Pane
 */
public class ExtensionPane extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command Option 1
     */
    private static final String OPTION_1 = "OPTION_1";

    /**
     * Command Option 2
     */
    private static final String OPTION_2 = "OPTION_2";

    /**
     * Command Sell
     */
    private static final String SELL = "Sell";

    /**
     * Command Summarize
     */
    private static final String SUMMARIZE = "Summarize";

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Main window application
     */
    private MrPotatoHeadGUI principal;

    // -----------------------------------------------------------------
    // GUI Fields
    // -----------------------------------------------------------------

    /**
     * Button Option 1
     */
    private JButton btnOption1;

    /**
     * Button Option 2
     */
    private JButton btnOption2;

    /**
     * Button Sell Design
     */
    private JButton btnSell;

    /**
     * Button Summarize price design
     */
    private JButton btnSummarize;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructor of the Pane
     * @param window Main window
     */
    public ExtensionPane( MrPotatoHeadGUI window )
    {
        principal = window;

        setBorder( new TitledBorder( "Options" ) );
        setLayout( new GridLayout( 1, 4, 5, 5 ) );

        // Button Summarize
        btnSummarize = new JButton( SUMMARIZE );
        btnSummarize.setActionCommand( SUMMARIZE );
        btnSummarize.addActionListener( this );
        add( btnSummarize );

        // Button Sell
        btnSell = new JButton( SELL );
        btnSell.setActionCommand( SELL );
        btnSell.addActionListener( this );
        add( btnSell );

        // Button option 1
        btnOption1 = new JButton( "Option 1" );
        btnOption1.setActionCommand( OPTION_1 );
        btnOption1.addActionListener( this );
        add( btnOption1 );

        // Button option 2
        btnOption2 = new JButton( "Option 2" );
        btnOption2.setActionCommand( OPTION_2 );
        btnOption2.addActionListener( this );
        add( btnOption2 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     *
     * Handling button events
     * @param e Action generated by the button.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( SUMMARIZE.equals( e.getActionCommand( ) ) )
        {
            principal.calculateTotalDesignMrPotatoHead( );
        }
        else if( SELL.equals( e.getActionCommand( ) ) )
        {
            principal.sellDesignMrPotatoHead( );
        }
        else if( OPTION_1.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOption1( );
        }
        else if( OPTION_2.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOption2( );
        }
    }

}