package edu.jabs.mrPotatoHead.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.jabs.mrPotatoHead.domain.Part;


/**
 * Pane that represents one of the Mr. Potato Head designs with options for change
 */
public class PartPane extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command for the next part button
     */
    private final String NEXT = "Next";

    /**
     * Command for the previous part button
     */
    private final String PREVIOUS = "Previous";

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Application window
     */
    private MrPotatoHeadGUI principal;

    /**
     * Type's part that represents the pane
     */
    private String typePart;

    /**
     * Counter to identify the selected part
     */
    private int identifierPart;

    // -----------------------------------------------------------------
    // GUI Fields
    // -----------------------------------------------------------------

    /**
     * Button to change to the previous part of the same type
     */
    private JButton btnPreviousPart;

    /**
     * Button to change to the next part of the same type
     */
    private JButton btnNextPart;

    /**
     * Label to show the image of the part
     */
    private JLabel part;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * It creates the pane by type
     * @param gui application window
     * @param theTypePart The type of the part represented
     */
    public PartPane( MrPotatoHeadGUI gui, String theTypePart )
    {
        setOpaque( false );
        principal = gui;
        typePart = theTypePart;
        identifierPart = 0;

        // The layout is established
        setLayout( new GridBagLayout( ) );

        // The graphical fields are created
        ImageIcon icon = new ImageIcon( "data/images/previous.png" );
        btnPreviousPart = new JButton( "", icon );
        btnPreviousPart.setActionCommand( PREVIOUS );
        btnPreviousPart.setToolTipText( PREVIOUS + " option " + theTypePart );
        btnPreviousPart.addActionListener( this );

        icon = new ImageIcon( "data/images/next.png" );
        btnNextPart = new JButton( "", icon );
        btnNextPart.setActionCommand( NEXT );
        btnNextPart.setToolTipText( NEXT + " option " + theTypePart );
        btnNextPart.addActionListener( this );

        part = new JLabel( "" );
        initializePart( );

        // The location coordinates of the graphic components are configured
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 6, 0, 6 ), 0, 0 );
        add( btnPreviousPart, gbc );

        gbc.gridx = 2;
        gbc.insets = new Insets( 0, 3, 0, 6 );
        add( btnNextPart, gbc );

        gbc = new GridBagConstraints( 1, 0, 1, 1, 2, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 0, 0, 0 ), 0, 0 );
        add( part, gbc );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that initializes the display region of the part with a blank image
     */
    public void initializePart( )
    {
        identifierPart = 0;
        part.setIcon( new ImageIcon( "data/images/" + typePart + "0.png" ) );
    }

    /**
     * Method that react to the event in which a button of the pane is pressed
     * @param event The click event in the button. event!=null
     */
    public void actionPerformed( ActionEvent event )
    {
        String command = event.getActionCommand( );
        if( NEXT.equals( command ) )
        {
            if( identifierPart < 3 )
                identifierPart++;
            else
                identifierPart = 1;
        }
        else if( PREVIOUS.equals( command ) )
        {
            if( identifierPart > 1 )
                identifierPart--;
            else
                identifierPart = 3;
        }
        ImageIcon icon = new ImageIcon( "data/images/" + typePart + identifierPart + ".png" );
        part.setIcon( icon );

        if( typePart.equals( Part.ACCESORY ) )
            principal.selectAccesoryHead( identifierPart );
        else if( typePart.equals( Part.EXPRESSION ) )
            principal.selectFacialExpression( identifierPart );
        else if( typePart.equals( Part.MOUTH ) )
            principal.selectMouth( identifierPart );
        else if( typePart.equals( Part.ARMS ) )
            principal.selectArms( identifierPart );
        else if( typePart.equals( Part.FEET ) )
            principal.selectFeet( identifierPart );
    }

    /**
     * Method that verifies if an option of the part is selected
     * @return Returns true if an option of the part has been selected
     */
    public boolean isSelected( )
    {
        return identifierPart > 0;
    }
}