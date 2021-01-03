package contoller;

import static model.PropertyChangeEnabledMutableColor.PROPERTY_GREEN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ColorModel;
import model.PropertyChangeEnabledMutableColor;

/**
 * Represents a Panel with components used to change and display the Green value for the 
 * backing Color model.
 *
 * @author Charles Bryan
 * @author Bhavesh Joshi
 * @version Autumn 2020
 */
public class GreenRowPanel extends JPanel implements PropertyChangeListener {

    /**  
     * A generated serial version UID for object Serialization. 
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 2284116355218892348L;
    
    /** The size of the increase/decrease buttons. */
    private static final Dimension BUTTON_SIZE = new Dimension(26, 26);
    
    /** The size of the text label. */
    private static final Dimension LABEL_SIZE = new Dimension(45, 26);
    
    /** The number of columns in width of the TextField. */
    private static final int TEXT_FIELD_COLUMNS = 3;
    
    /** The amount of padding for the change panel. */
    private static final int HORIZONTAL_PADDING = 30;
    
    /** The backing model for the system. */
    private final PropertyChangeEnabledMutableColor myColor;

    /** The CheckBox that enables/disables editing of the TextField. */
    private final JCheckBox myEnableEditButton;
    
    /** The TextField that allows the user to type input for the color value. */
    private final JTextField myValueField;
    
    /** The Button that when clicked increases the color value. */
    private final JButton myIncreaseButton;
    
    /** The Button that when clicked decreases the color value. */
    private final JButton myDecreaseButton;
    
    /** The Slider that when adjusted, changes the color value. */
    private final JSlider myValueSlider;
    
    /** The panel that visually displays ONLY the GREEN value for the color. */
    private final JPanel myColorDisplayPanel;
    
    /**
     * int current value of the color.
     */
    private int myNumber;
    
    /**
     * Creates a Panel with components used to change and display the Green value for the 
     * backing Color model. 
     * @param theColor the backing model for the system
     */
    public GreenRowPanel(final PropertyChangeEnabledMutableColor theColor) {
        super();
        myColor = theColor;
        myEnableEditButton = new JCheckBox("Enable edit");
        myValueField = new JTextField();
        myIncreaseButton = new JButton();
        myDecreaseButton = new JButton();
        myValueSlider = new JSlider();
        myColorDisplayPanel = new JPanel();
        layoutComponents();
        addListeners();
    }
    
    /**
     * Setup and add the GUI components for this panel. 
     */
    private void layoutComponents() {
        myColorDisplayPanel.setPreferredSize(BUTTON_SIZE);
        myColorDisplayPanel.setBackground(new Color(0, myColor.getGreen(), 0));
        final JLabel rowLabel = new JLabel("Green: ");
        rowLabel.setPreferredSize(LABEL_SIZE);
        myValueField.setText(String.valueOf(myColor.getGreen()));
        myValueField.setEditable(false);
        myValueField.setColumns(TEXT_FIELD_COLUMNS);
        myValueField.setHorizontalAlignment(JTextField.RIGHT);
        
        final JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 
                                                             HORIZONTAL_PADDING, 
                                                             0, 
                                                             HORIZONTAL_PADDING));
        rightPanel.setBackground(rightPanel.getBackground().darker());
        myIncreaseButton.setIcon(new ImageIcon("./images/ic_increase_value.png"));
        myIncreaseButton.setPreferredSize(BUTTON_SIZE);
        myValueSlider.setMaximum(ColorModel.MAX_VALUE);
        myValueSlider.setMinimum(ColorModel.MIN_VALUE);
        myValueSlider.setValue(myColor.getGreen());
        myValueSlider.setBackground(rightPanel.getBackground());
        myDecreaseButton.setIcon(new ImageIcon("./images/ic_decrease_value.png"));
        myDecreaseButton.setPreferredSize(BUTTON_SIZE);
        myDecreaseButton.setEnabled(false);
        rightPanel.add(myDecreaseButton);
        rightPanel.add(myValueSlider);
        rightPanel.add(myIncreaseButton);
        
        add(myColorDisplayPanel);
        add(rowLabel);
        add(myValueField);
        add(myEnableEditButton);
        add(rightPanel);

        myNumber = myColor.getGreen();

        
    }
    
    /**
     * Add listeners (event handlers) to any GUI components that require handling.  
     */
    private void addListeners() {
        //DO not remove the following statement.
        myColor.addPropertyChangeListener(this);
        
        myEnableEditButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {

                if (myEnableEditButton.isSelected()) {
                    myValueField.setEditable(true);
                } else {
                    myValueField.setEditable(false);
                }
            }
        });

        myValueField.addActionListener(theEvent -> myValueField.transferFocus());
        myValueField.addFocusListener(new FocusAdapter() {
            
            @Override
            public void focusLost(final FocusEvent theEvent) {
                final int newNumber;
                final int maxlimit = 255;
                try {
                    newNumber = Integer.parseInt(myValueField.getText().trim());
                    if (newNumber < 0 || newNumber > maxlimit) {
                        // disallow negative numbers and number greater than 255.
                        throw new NumberFormatException();
                    }
                    myNumber = newNumber;
                } catch (final NumberFormatException e) {
                        myValueField.setText(String.valueOf(myNumber));
                }
                myValueSlider.setValue(myNumber);
                statusChange(myNumber);
            }
            });
        
        myDecreaseButton.addActionListener(this::decreaseHelper);
        
//        myDecreaseButton.addActionListener(new ActionListener() {
//            
//            @Override
//            public void actionPerformed(final ActionEvent theEvent) {
//                
////                    myNumber--;
////                    statusChange(myNumber);
////                    myValueField.setText(String.valueOf(myNumber));
//                decreaseHelper();
//                
//            }
//        });
        
        myIncreaseButton.addActionListener(
            theEvent -> {
                myNumber++;
                statusChange(myNumber);
                myValueField.setText(String.valueOf(myNumber));
            });
        
//        myIncreaseButton.addActionListener(new ActionListener() {
//            
//            @Override
//            public void actionPerformed(final ActionEvent theEvent) {
//
//                    myNumber++;
//                    statusChange(myNumber);
//                    myValueField.setText(String.valueOf(myNumber));
//            }
//        });
        
        myValueSlider.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                
                final JSlider slide = (JSlider) theEvent.getSource();
                if (slide.getValueIsAdjusting()) {
                    myValueField.setText(String.valueOf(slide.getValue()));
                    statusChange(slide.getValue());
                    myNumber = slide.getValue();
                } 
            }
        });
    }
    
    /**
     * A method to update the status of two buttons decrease and increase.
     * Makes Decrease enabled - false if theValue = 0
     * Makes Increase enabled if - false theValue = 255.
     * Otherwise both are enabled.
     * Also makes changes in the value of color blue.
     * @param theValue current value on textbox.
     * @author Bhavesh Joshi
     * @version Winter 2020
     */
    private void statusChange(final int theValue) {
        
        final int max = 255;
        if (theValue == 0) {
            myDecreaseButton.setEnabled(false);
            myIncreaseButton.setEnabled(true);
        } else if (theValue == max) {
            myIncreaseButton.setEnabled(false);
            myDecreaseButton.setEnabled(true);
        } else {
            myIncreaseButton.setEnabled(true);
            myDecreaseButton.setEnabled(true);
        }
        myColor.setGreen(theValue);
    }
    
    /**
     * A helper method to decrease myNumber and updating the jText box.
     * @author Bhavesh Joshi
     * @version Winter 2020
     * @param theEvent theAction event for decrease method.
     */
    private void decreaseHelper(final ActionEvent theEvent) {
        myNumber--;
        statusChange(myNumber);
        myValueField.setText(String.valueOf(myNumber));
    }
    
//    private void increaseHelper() {
//        myNumber++;
//        statusChange(myNumber);
//        myValueField.setText(String.valueOf(myNumber));
//    }
    

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_GREEN.equals(theEvent.getPropertyName())) {
            myValueField.setText(theEvent.getNewValue().toString());
            myValueSlider.setValue((Integer) theEvent.getNewValue());
            myColorDisplayPanel.
                setBackground(new Color(0, (Integer) theEvent.getNewValue(), 0));
        }
        
    }
}
