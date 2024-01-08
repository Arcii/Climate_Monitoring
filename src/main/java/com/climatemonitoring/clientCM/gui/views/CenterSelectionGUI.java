package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.CenterSelectionGUIController;
import com.climatemonitoring.shared.models.MonitoringCenter;
import com.climatemonitoring.shared.models.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The <code>CenterSelectionGUI</code> class represents the view where the user selects or chooses to create
 * their climate monitoring center. It displays a list of available monitoring centers and provides
 * options for the user to complete the registration process or register a new center.
 *
 * <p>
 * Note: A user cannot register to the Climate Monitoring application as an Operator
 * without selecting or creating a climate Monitoring Center to which he/she refers.
 * </p>
 *
 * @author Lorenzo Cattapan 726459  (Varese)
 * @version 0.9.0
 * @see CenterSelectionGUIController
 */
public class CenterSelectionGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * The main panel for center registration.
     */
    private JPanel centerRegistrationPanel;
    /**
     * Label displaying the application name.
     */
    private JLabel climatemonitoringLabel;
    /**
     * Label providing information about center registration.
     */
    private JLabel centerRegistrationLabel;
    /**
     * Additional label for center registration information.
     */
    private JLabel centerRegistrationLabel2;
    /**
     * Button for completing the registration process.
     */
    private JButton completeRegistrationButton;
    /**
     * Label providing additional instructions for center registration.
     */
    private JLabel centerRegisrationLabel3;
    /**
     * Table displaying available monitoring centers.
     */
    private JTable centersTable;
    /**
     * Panel for displaying and scrolling through monitoring centers.
     */
    private JPanel centersSelectionPanel;
    /**
     * Button for registering a new monitoring center.
     */
    private JButton centerRegistrationButton;
    /**
     * Button for navigating back to the previous step.
     */
    private JButton backButton;
    /**
     * Scroll pane for the monitoring centers table.
     */
    private JScrollPane centersScroll;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of the `CenterSelectionGUI`.
     *
     * @param user        The user associated with the registration process.
     * @param centersList The list of available monitoring centers.
     */
    public CenterSelectionGUI(User user, ArrayList<MonitoringCenter> centersList) {
        setTitle("Climate Monitoring");
        setContentPane(centerRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new CenterSelectionGUIController(this, user, centersList);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the main panel for center registration.
     *
     * @return The center registration panel.
     */
    public JPanel getCenterRegistrationPanel() {
        return centerRegistrationPanel;
    }

    /**
     * Sets the center registration panel.
     *
     * @param centerRegistrationPanel The center registration panel to set.
     */
    public void setCenterRegistrationPanel(JPanel centerRegistrationPanel) {
        this.centerRegistrationPanel = centerRegistrationPanel;
    }

    /**
     * Gets the label displaying the application name.
     *
     * @return The label displaying the application name.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Sets the label displaying the application name.
     *
     * @param climatemonitoringLabel The label to set.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Gets the label providing information about center registration.
     *
     * @return The label providing information about center registration.
     */
    public JLabel getCenterRegistrationLabel() {
        return centerRegistrationLabel;
    }

    /**
     * Sets the label providing information about center registration.
     *
     * @param centerRegistrationLabel The label to set.
     */
    public void setCenterRegistrationLabel(JLabel centerRegistrationLabel) {
        this.centerRegistrationLabel = centerRegistrationLabel;
    }

    /**
     * Gets the additional label for center registration information.
     *
     * @return The additional label for center registration information.
     */
    public JLabel getCenterRegistrationLabel2() {
        return centerRegistrationLabel2;
    }

    /**
     * Sets the additional label for center registration information.
     *
     * @param centerRegistrationLabel2 The additional label to set.
     */
    public void setCenterRegistrationLabel2(JLabel centerRegistrationLabel2) {
        this.centerRegistrationLabel2 = centerRegistrationLabel2;
    }

    /**
     * Gets the button for completing the registration process.
     *
     * @return The button for completing the registration process.
     */
    public JButton getCompleteRegistrationButton() {
        return completeRegistrationButton;
    }

    /**
     * Sets the button for completing the registration process.
     *
     * @param completeRegistrationButton The button to set.
     */
    public void setCompleteRegistrationButton(JButton completeRegistrationButton) {
        this.completeRegistrationButton = completeRegistrationButton;
    }

    /**
     * Gets the label providing additional instructions for center registration.
     *
     * @return The label providing additional instructions for center registration.
     */
    public JLabel getCenterRegisrationLabel3() {
        return centerRegisrationLabel3;
    }

    /**
     * Sets the label providing additional instructions for center registration.
     *
     * @param centerRegisrationLabel3 The label to set.
     */
    public void setCenterRegisrationLabel3(JLabel centerRegisrationLabel3) {
        this.centerRegisrationLabel3 = centerRegisrationLabel3;
    }

    /**
     * Gets the table displaying available monitoring centers.
     *
     * @return The table displaying available monitoring centers.
     */
    public JTable getCentersTable() {
        return centersTable;
    }

    /**
     * Sets the table displaying available monitoring centers.
     *
     * @param centersTable The table to set.
     */
    public void setCentersTable(JTable centersTable) {
        this.centersTable = centersTable;
    }

    /**
     * Gets the panel for displaying and scrolling through monitoring centers.
     *
     * @return The panel for displaying and scrolling through monitoring centers.
     */
    public JPanel getCentersSelectionPanel() {
        return centersSelectionPanel;
    }

    /**
     * Sets the panel for displaying and scrolling through monitoring centers.
     *
     * @param centersSelectionPanel The panel to set.
     */
    public void setCentersSelectionPanel(JPanel centersSelectionPanel) {
        this.centersSelectionPanel = centersSelectionPanel;
    }

    /**
     * Gets the button for registering a new monitoring center.
     *
     * @return The button for registering a new monitoring center.
     */
    public JButton getCenterRegistrationButton() {
        return centerRegistrationButton;
    }

    /**
     * Sets the button for registering a new monitoring center.
     *
     * @param centerRegistrationButton The button to set.
     */
    public void setCenterRegistrationButton(JButton centerRegistrationButton) {
        this.centerRegistrationButton = centerRegistrationButton;
    }

    /**
     * Gets the button for navigating back to the previous step.
     *
     * @return The button for navigating back to the previous step.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Sets the button for navigating back to the previous step.
     *
     * @param backButton The button to set.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Gets the scroll pane for the monitoring centers table.
     *
     * @return The scroll pane for the monitoring centers table.
     */
    public JScrollPane getCentersScroll() {
        return centersScroll;
    }

    /**
     * Sets the scroll pane for the monitoring centers table.
     *
     * @param centersScroll The scroll pane to set.
     */
    public void setCentersScroll(JScrollPane centersScroll) {
        this.centersScroll = centersScroll;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        centerRegistrationPanel = new JPanel();
        centerRegistrationPanel.setLayout(new GridLayoutManager(7, 5, new Insets(0, 0, 0, 0), -1, -1));
        centerRegistrationPanel.setBackground(new Color(-9473675));
        centerRegistrationPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        centerRegistrationPanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centersSelectionPanel = new JPanel();
        centersSelectionPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        centersSelectionPanel.setBackground(new Color(-9473675));
        centersSelectionPanel.setForeground(new Color(-9473675));
        centerRegistrationPanel.add(centersSelectionPanel, new GridConstraints(4, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        centersScroll = new JScrollPane();
        centersSelectionPanel.add(centersScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        centersTable = new JTable();
        centersScroll.setViewportView(centersTable);
        centerRegistrationLabel = new JLabel();
        centerRegistrationLabel.setBackground(new Color(-1));
        Font centerRegistrationLabelFont = this.$$$getFont$$$(null, -1, 16, centerRegistrationLabel.getFont());
        if (centerRegistrationLabelFont != null) centerRegistrationLabel.setFont(centerRegistrationLabelFont);
        centerRegistrationLabel.setForeground(new Color(-1));
        centerRegistrationLabel.setText("Per completare la registrazione è necessario indicare il Centro di Monitaraggio di afferenza : ");
        centerRegistrationPanel.add(centerRegistrationLabel, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centerRegistrationLabel2 = new JLabel();
        centerRegistrationLabel2.setBackground(new Color(-1));
        Font centerRegistrationLabel2Font = this.$$$getFont$$$(null, -1, 16, centerRegistrationLabel2.getFont());
        if (centerRegistrationLabel2Font != null) centerRegistrationLabel2.setFont(centerRegistrationLabel2Font);
        centerRegistrationLabel2.setForeground(new Color(-1));
        centerRegistrationLabel2.setText(" - Se il Centro di Monitoraggio di tua afferenza è nella lista sottostante selezionalo e clicca su \"Completa Registrazione\"");
        centerRegistrationPanel.add(centerRegistrationLabel2, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        completeRegistrationButton = new JButton();
        completeRegistrationButton.setBackground(new Color(-13947600));
        completeRegistrationButton.setForeground(new Color(-1));
        completeRegistrationButton.setText("Completa Registrazione");
        centerRegistrationPanel.add(completeRegistrationButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centerRegisrationLabel3 = new JLabel();
        centerRegisrationLabel3.setBackground(new Color(-1));
        Font centerRegisrationLabel3Font = this.$$$getFont$$$(null, -1, 16, centerRegisrationLabel3.getFont());
        if (centerRegisrationLabel3Font != null) centerRegisrationLabel3.setFont(centerRegisrationLabel3Font);
        centerRegisrationLabel3.setForeground(new Color(-1));
        centerRegisrationLabel3.setText(" - Se il tuo centro di afferenza non è già registrato clicca su \"Registra Centro\" per procedere con la registrazione del centro");
        centerRegistrationPanel.add(centerRegisrationLabel3, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centerRegistrationButton = new JButton();
        centerRegistrationButton.setBackground(new Color(-13947600));
        centerRegistrationButton.setForeground(new Color(-1));
        centerRegistrationButton.setText("Registra Centro");
        centerRegistrationPanel.add(centerRegistrationButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        centerRegistrationPanel.add(backButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        centerRegistrationPanel.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        centerRegistrationPanel.add(spacer2, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        centerRegistrationPanel.add(spacer3, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return centerRegistrationPanel;
    }

}
