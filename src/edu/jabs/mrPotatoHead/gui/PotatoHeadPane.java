package edu.jabs.mrPotatoHead.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.jabs.mrPotatoHead.domain.Part;


/**
 * Pane with the parts of the design of Mr Potato Head
 */
public class PotatoHeadPane extends JPanel
{

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------
    /**
     * Application window
     */
    private MrPotatoHeadGUI principal;

    /**
     * Pane for the accesory's head of Mr. Potato Head
     */
    private PartPane accesoryPane;

    /**
     * Pane for the expression of Mr. Potato Head
     */
    private PartPane expressionPane;

    /**
     * Pane for the mouth of Mr. Potato Head
     */
    private PartPane mouthPane;

    /**
     * Pane for the arms of Mr. Potato Head
     */
    private PartPane armsPane;

    /**
     * Pane for the feet of Mr. Potato Head
     */
    private PartPane feetPane;

    /**
     * Total price label
     */
    private JLabel labelTotalPrice;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * It creates the pane where the design of Mr. Potato Head is displayed
     * @param gui Graphical user interface of the application
     */
    public PotatoHeadPane( MrPotatoHeadGUI gui )
    {
        principal = gui;
        setPreferredSize( new Dimension( 540, 180 ) );
        setMinimumSize( new Dimension( 540, 180 ) );
        setSize( 540, 180 );
        // The layout is established
        setLayout( new GridBagLayout( ) );

        // The graphical fields are created
        labelTotalPrice = new JLabel( " ", JLabel.RIGHT );
        Font font = labelTotalPrice.getFont( ).deriveFont( 18.0f );
        font = labelTotalPrice.getFont( ).deriveFont( 20.0f );
        labelTotalPrice.setFont( font );

        accesoryPane = new PartPane( principal, Part.ACCESORY );
        expressionPane = new PartPane( principal, Part.EXPRESSION );
        mouthPane = new PartPane( principal, Part.MOUTH );
        armsPane = new PartPane( principal, Part.ARMS );
        feetPane = new PartPane( principal, Part.FEET );

        // The location coordinates of the graphic components are configured
        GridBagConstraints gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 15, 0, 15 ), 0, 0 );
        add( accesoryPane, gbc );
        gbc.gridy++;
        add( expressionPane, gbc );
        gbc.gridy++;
        add( mouthPane, gbc );
        gbc.gridy++;
        add( armsPane, gbc );
        gbc.gridy++;
        add( feetPane, gbc );
        gbc.gridy++;
        gbc.insets = new Insets( 3, 15, 5, 100 );
        add( labelTotalPrice, gbc );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that displays the total price of the design of Mr. Potato Head
     * @param total The price corresponding to the total cost after rebates
     */
    public void showTotalPrice( double total )
    {
        labelTotalPrice.setText( "TOTAL: " + formatearValor( total ) );
    }

    /**
     * Formats a numerical value to be displayed in the interface
     * @param value The numerical value to be formated
     * @return A string with formated value with points and signs.
     */
    private String formatearValor( double value )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( value );
    }

    /**
     * This method is invoked by the virtual machine when the pane must be repainted and it's overloaded to paint the graphic of Mr. Potato Head body
     * @param g It's the graphical component to draw which corresponds to the surface of the pane
     */
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2 = ( Graphics2D )g;
        Image body = Toolkit.getDefaultToolkit( ).getImage( "data/images/body.png" );
        g2.drawImage( body, 78, 5, null );
        validate( );
        principal.repaint( );
    }

    /**
     * Method that stops showing the images of Mr. Potato Head and the total price
     */
    public void inicializeParts( )
    {
        labelTotalPrice.setText( " " );
        accesoryPane.initializePart( );
        expressionPane.initializePart( );
        mouthPane.initializePart( );
        armsPane.initializePart( );
        feetPane.initializePart( );
    }

    /**
     * Method that verifies if every part of the design are selected
     * @return Returns true if every part are selected
     */
    public boolean everyPartIsSelected( )
    {
        return accesoryPane.isSelected() && expressionPane.isSelected() &&mouthPane.isSelected() &&armsPane.isSelected() &&feetPane.isSelected();
    }
}