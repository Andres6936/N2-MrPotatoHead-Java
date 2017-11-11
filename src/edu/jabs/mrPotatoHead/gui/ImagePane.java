package edu.jabs.mrPotatoHead.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Class where the header image is placed
 */
public class ImagePane extends JPanel
{

    /**
     * Default constructor method.  It puts the header image of the application
     */
    public ImagePane( )
    {
        JLabel image = new JLabel( );
        ImageIcon icon = new ImageIcon( "data/images/title.png" );
        // It's added to the label
        image = new JLabel( "" );
        image.setIcon( icon );
        add( image );

        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.BLACK ) );
    }
}