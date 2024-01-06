package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.CenterRegistrationGUIController;
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
 * The `CenterRegistrationGUI` class represents the graphical user interface (GUI) view
 * for registering a new Monitoring Center. Users can input information such as the name,
 * address, and geographical coordinates for the new center. Additionally, users can
 * select and add points of interest (POI) associated with the center.
 *
 * @author Lorenzo Cattapan 726459  (Varese)
 * @version 1.0
 * @see CenterRegistrationGUIController
 */
public class CenterRegistrationGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * Label displaying the title "Climate Monitoring."
     */
    private JLabel climatemonitoringLabel;
    /**
     * Label displaying "Center Registration."
     */
    private JLabel centerRegistrationLabel;
    /**
     * Text field for entering the name of the Monitoring Center.
     */
    private JTextField nameField;
    /**
     * Text field for entering the address of the Monitoring Center.
     */
    private JTextField addressField;
    /**
     * Text field for entering the address number of the Monitoring Center.
     */
    private JTextField addressNumberFIeld;
    /**
     * Text field for entering the postal code (CAP) of the Monitoring Center.
     */
    private JTextField capField;
    /**
     * Text field for entering the province of the Monitoring Center.
     */
    private JTextField provinceField;
    /**
     * Text field for entering the city of the Monitoring Center.
     */
    private JTextField cityField;
    /**
     * Label indicating the selection of points of interest (POI).
     */
    private JLabel poiSelectionLabel;
    /**
     * Panel for searching and selecting geographical coordinates.
     */
    private JPanel coordinatesSearchPanel;
    /**
     * Label for the geographical coordinates search section.
     */
    private JLabel coordinatesSearchLabel;
    /**
     * Label for the latitude value.
     */
    private JLabel latitudeLabel;
    /**
     * Text field for entering the latitude value.
     */
    private JTextField latitudeField;
    /**
     * Label for the longitude value.
     */
    private JLabel longitudeLabel;
    /**
     * Text field for entering the longitude value.
     */
    private JTextField longitudeField;
    /**
     * Button for initiating the coordinates search.
     */
    private JButton coordinatesSearchButton;
    /**
     * Table displaying the added points of interest (POI).
     */
    private JTable addedPoiTable;
    /**
     * Label indicating the added points of interest (POI).
     */
    private JLabel addedPoiLabel;
    /**
     * Panel for selecting points of interest (POI).
     */
    private JPanel poiSelectionPanel;
    /**
     * Panel displaying the added points of interest (POI).
     */
    private JPanel addedPoiPanel;
    /**
     * Scroll pane for the added points of interest (POI) table.
     */
    private JScrollPane addedPoiScroll;
    /**
     * Label for the name field.
     */
    private JLabel nameLabel;
    /**
     * Label for the address field.
     */
    private JLabel addressLabel;
    /**
     * Label for the address number field.
     */
    private JLabel addressNumberLabel;
    /**
     * Label for the postal code (CAP) field.
     */
    private JLabel capLabel;
    /**
     * Label for the city field.
     */
    private JLabel cityLabel;
    /**
     * Label for the province field.
     */
    private JLabel provinceLabel;
    /**
     * Panel containing the form for entering Monitoring Center details.
     */
    private JPanel centerFormPanel;
    /**
     * Label indicating the completion of center registration.
     */
    private JLabel completeCenterRegistrationLabel;
    /**
     * Button for navigating back to the previous view.
     */
    private JButton backButton;
    /**
     * Button for completing the center registration process.
     */
    private JButton completeCenterRegistrationButton;
    /**
     * Panel containing the entire center registration GUI.
     */
    private JPanel centerRegistrationPanel;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of the `CenterRegistrationGUI` class.
     *
     * @param user        The user associated with the center registration.
     * @param centersList The list of existing monitoring centers.
     */
    public CenterRegistrationGUI(User user, ArrayList<MonitoringCenter> centersList) {
        // Set the title, content pane, and other properties of the JFrame
        setTitle("Climate Monitoring");
        setContentPane(centerRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Create an instance of the CenterRegistrationGUIController to handle interactions
        new CenterRegistrationGUIController(this, user, centersList);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Getter for the climatemonitoringLabel.
     *
     * @return The JLabel representing the title "Climate Monitoring."
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Setter for the climatemonitoringLabel.
     *
     * @param climatemonitoringLabel The JLabel to set as the title "Climate Monitoring."
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Getter for the centerRegistrationLabel.
     *
     * @return The JLabel representing "Center Registration."
     */
    public JLabel getCenterRegistrationLabel() {
        return centerRegistrationLabel;
    }

    /**
     * Setter for the centerRegistrationLabel.
     *
     * @param centerRegistrationLabel The JLabel to set as "Center Registration."
     */
    public void setCenterRegistrationLabel(JLabel centerRegistrationLabel) {
        this.centerRegistrationLabel = centerRegistrationLabel;
    }

    /**
     * Getter for the nameField.
     *
     * @return The JTextField for entering the center's name.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Setter for the nameField.
     *
     * @param nameField The JTextField to set for entering the center's name.
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Getter for the addressField.
     *
     * @return The JTextField for entering the center's address.
     */
    public JTextField getAddressField() {
        return addressField;
    }

    /**
     * Setter for the addressField.
     *
     * @param addressField The JTextField to set for entering the center's address.
     */
    public void setAddressField(JTextField addressField) {
        this.addressField = addressField;
    }

    /**
     * Getter for the addressNumberFIeld.
     *
     * @return The JTextField for entering the center's address number.
     */
    public JTextField getAddressNumberFIeld() {
        return addressNumberFIeld;
    }

    /**
     * Setter for the addressNumberFIeld.
     *
     * @param addressNumberFIeld The JTextField to set for entering the center's address number.
     */
    public void setAddressNumberFIeld(JTextField addressNumberFIeld) {
        this.addressNumberFIeld = addressNumberFIeld;
    }

    /**
     * Getter for the capField.
     *
     * @return The JTextField for entering the center's CAP (postal code).
     */
    public JTextField getCapField() {
        return capField;
    }

    /**
     * Setter for the capField.
     *
     * @param capField The JTextField to set for entering the center's CAP (postal code).
     */
    public void setCapField(JTextField capField) {
        this.capField = capField;
    }

    /**
     * Getter for the provinceField.
     *
     * @return The JTextField for entering the center's province.
     */
    public JTextField getProvinceField() {
        return provinceField;
    }

    /**
     * Setter for the provinceField.
     *
     * @param provinceField The JTextField to set for entering the center's province.
     */
    public void setProvinceField(JTextField provinceField) {
        this.provinceField = provinceField;
    }

    /**
     * Getter for the cityField.
     *
     * @return The JTextField for entering the center's city.
     */
    public JTextField getCityField() {
        return cityField;
    }

    /**
     * Setter for the cityField.
     *
     * @param cityField The JTextField to set for entering the center's city.
     */
    public void setCityField(JTextField cityField) {
        this.cityField = cityField;
    }

    /**
     * Getter for the poiSelectionLabel.
     *
     * @return The JLabel representing "POI Selection."
     */
    public JLabel getPoiSelectionLabel() {
        return poiSelectionLabel;
    }

    /**
     * Setter for the poiSelectionLabel.
     *
     * @param poiSelectionLabel The JLabel to set as "POI Selection."
     */
    public void setPoiSelectionLabel(JLabel poiSelectionLabel) {
        this.poiSelectionLabel = poiSelectionLabel;
    }

    /**
     * Getter for the coordinatesSearchPanel.
     *
     * @return The JPanel representing the panel for coordinates search.
     */
    public JPanel getCoordinatesSearchPanel() {
        return coordinatesSearchPanel;
    }

    /**
     * Setter for the coordinatesSearchPanel.
     *
     * @param coordinatesSearchPanel The JPanel to set as the panel for coordinates search.
     */
    public void setCoordinatesSearchPanel(JPanel coordinatesSearchPanel) {
        this.coordinatesSearchPanel = coordinatesSearchPanel;
    }

    /**
     * Getter for the coordinatesSearchLabel.
     *
     * @return The JLabel representing "Coordinates Search."
     */
    public JLabel getCoordinatesSearchLabel() {
        return coordinatesSearchLabel;
    }

    /**
     * Setter for the coordinatesSearchLabel.
     *
     * @param coordinatesSearchLabel The JLabel to set as "Coordinates Search."
     */
    public void setCoordinatesSearchLabel(JLabel coordinatesSearchLabel) {
        this.coordinatesSearchLabel = coordinatesSearchLabel;
    }

    /**
     * Getter for the latitudeLabel.
     *
     * @return The JLabel representing "Latitude."
     */
    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    /**
     * Setter for the latitudeLabel.
     *
     * @param latitudeLabel The JLabel to set as "Latitude."
     */
    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    /**
     * Getter for the latitudeField.
     *
     * @return The JTextField for entering latitude.
     */
    public JTextField getLatitudeField() {
        return latitudeField;
    }

    /**
     * Setter for the latitudeField.
     *
     * @param latitudeField The JTextField to set for entering latitude.
     */
    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    /**
     * Getter for the longitudeLabel.
     *
     * @return The JLabel representing "Longitude."
     */
    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

    /**
     * Setter for the longitudeLabel.
     *
     * @param longitudeLabel The JLabel to set as "Longitude."
     */
    public void setLongitudeLabel(JLabel longitudeLabel) {
        this.longitudeLabel = longitudeLabel;
    }

    /**
     * Getter for the longitudeField.
     *
     * @return The JTextField for entering longitude.
     */
    public JTextField getLongitudeField() {
        return longitudeField;
    }

    /**
     * Setter for the longitudeField.
     *
     * @param longitudeField The JTextField to set for entering longitude.
     */
    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    /**
     * Getter for the coordinatesSearchButton.
     *
     * @return The JButton for initiating coordinates search.
     */
    public JButton getCoordinatesSearchButton() {
        return coordinatesSearchButton;
    }

    /**
     * Setter for the coordinatesSearchButton.
     *
     * @param coordinatesSearchButton The JButton to set for initiating coordinates search.
     */
    public void setCoordinatesSearchButton(JButton coordinatesSearchButton) {
        this.coordinatesSearchButton = coordinatesSearchButton;
    }

    /**
     * Getter for the addedPoiTable.
     *
     * @return The JTable displaying added Points of Interest.
     */
    public JTable getAddedPoiTable() {
        return addedPoiTable;
    }

    /**
     * Setter for the addedPoiTable.
     *
     * @param addedPoiTable The JTable to set for displaying added Points of Interest.
     */
    public void setAddedPoiTable(JTable addedPoiTable) {
        this.addedPoiTable = addedPoiTable;
    }

    /**
     * Getter for the addedPoiLabel.
     *
     * @return The JLabel representing "Added Points of Interest."
     */
    public JLabel getAddedPoiLabel() {
        return addedPoiLabel;
    }

    /**
     * Setter for the addedPoiLabel.
     *
     * @param addedPoiLabel The JLabel to set as "Added Points of Interest."
     */
    public void setAddedPoiLabel(JLabel addedPoiLabel) {
        this.addedPoiLabel = addedPoiLabel;
    }

    /**
     * Getter for the poiSelectionPanel.
     *
     * @return The JPanel representing the panel for POI selection.
     */
    public JPanel getPoiSelectionPanel() {
        return poiSelectionPanel;
    }

    /**
     * Setter for the poiSelectionPanel.
     *
     * @param poiSelectionPanel The JPanel to set as the panel for POI selection.
     */
    public void setPoiSelectionPanel(JPanel poiSelectionPanel) {
        this.poiSelectionPanel = poiSelectionPanel;
    }

    /**
     * Getter for the addedPoiPanel.
     *
     * @return The JPanel representing the panel for added POIs.
     */
    public JPanel getAddedPoiPanel() {
        return addedPoiPanel;
    }

    /**
     * Setter for the addedPoiPanel.
     *
     * @param addedPoiPanel The JPanel to set as the panel for added POIs.
     */
    public void setAddedPoiPanel(JPanel addedPoiPanel) {
        this.addedPoiPanel = addedPoiPanel;
    }

    /**
     * Getter for the addedPoiScroll.
     *
     * @return The JScrollPane for added POIs.
     */
    public JScrollPane getAddedPoiScroll() {
        return addedPoiScroll;
    }

    /**
     * Setter for the addedPoiScroll.
     *
     * @param addedPoiScroll The JScrollPane to set for added POIs.
     */
    public void setAddedPoiScroll(JScrollPane addedPoiScroll) {
        this.addedPoiScroll = addedPoiScroll;
    }

    /**
     * Getter for the nameLabel.
     *
     * @return The JLabel representing "Name."
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Setter for the nameLabel.
     *
     * @param nameLabel The JLabel to set as "Name."
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Getter for the addressLabel.
     *
     * @return The JLabel representing "Address."
     */
    public JLabel getAddressLabel() {
        return addressLabel;
    }

    /**
     * Setter for the addressLabel.
     *
     * @param addressLabel The JLabel to set as "Address."
     */
    public void setAddressLabel(JLabel addressLabel) {
        this.addressLabel = addressLabel;
    }

    /**
     * Getter for the addressNumberLabel.
     *
     * @return The JLabel representing "Address Number."
     */
    public JLabel getAddressNumberLabel() {
        return addressNumberLabel;
    }

    /**
     * Setter for the addressNumberLabel.
     *
     * @param addressNumberLabel The JLabel to set as "Address Number."
     */
    public void setAddressNumberLabel(JLabel addressNumberLabel) {
        this.addressNumberLabel = addressNumberLabel;
    }

    /**
     * Getter for the capLabel.
     *
     * @return The JLabel representing "CAP."
     */
    public JLabel getCapLabel() {
        return capLabel;
    }

    /**
     * Setter for the capLabel.
     *
     * @param capLabel The JLabel to set as "CAP."
     */
    public void setCapLabel(JLabel capLabel) {
        this.capLabel = capLabel;
    }

    /**
     * Getter for the cityLabel.
     *
     * @return The JLabel representing "City."
     */
    public JLabel getCityLabel() {
        return cityLabel;
    }

    /**
     * Setter for the cityLabel.
     *
     * @param cityLabel The JLabel to set as "City."
     */
    public void setCityLabel(JLabel cityLabel) {
        this.cityLabel = cityLabel;
    }

    /**
     * Getter for the provinceLabel.
     *
     * @return The JLabel representing "Province."
     */
    public JLabel getProvinceLabel() {
        return provinceLabel;
    }

    /**
     * Setter for the provinceLabel.
     *
     * @param provinceLabel The JLabel to set as "Province."
     */
    public void setProvinceLabel(JLabel provinceLabel) {
        this.provinceLabel = provinceLabel;
    }

    /**
     * Getter for the centerFormPanel.
     *
     * @return The JPanel representing the main form panel for center registration.
     */
    public JPanel getCenterFormPanel() {
        return centerFormPanel;
    }

    /**
     * Setter for the centerFormPanel.
     *
     * @param centerFormPanel The JPanel to set as the main form panel for center registration.
     */
    public void setCenterFormPanel(JPanel centerFormPanel) {
        this.centerFormPanel = centerFormPanel;
    }

    /**
     * Getter for the completeCenterRegistrationLabel.
     *
     * @return The JLabel representing "Complete Center Registration."
     */
    public JLabel getCompleteCenterRegistrationLabel() {
        return completeCenterRegistrationLabel;
    }

    /**
     * Setter for the completeCenterRegistrationLabel.
     *
     * @param completeCenterRegistrationLabel The JLabel to set as "Complete Center Registration."
     */
    public void setCompleteCenterRegistrationLabel(JLabel completeCenterRegistrationLabel) {
        this.completeCenterRegistrationLabel = completeCenterRegistrationLabel;
    }

    /**
     * Getter for the backButton.
     *
     * @return The JButton for navigating back.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Setter for the backButton.
     *
     * @param backButton The JButton to set for navigating back.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Getter for the completeCenterRegistrationButton.
     *
     * @return The JButton for completing the center registration.
     */
    public JButton getCompleteCenterRegistrationButton() {
        return completeCenterRegistrationButton;
    }

    /**
     * Setter for the completeCenterRegistrationButton.
     *
     * @param completeCenterRegistrationButton The JButton to set for completing the center registration.
     */
    public void setCompleteCenterRegistrationButton(JButton completeCenterRegistrationButton) {
        this.completeCenterRegistrationButton = completeCenterRegistrationButton;
    }

    /**
     * Getter for the centerRegistrationPanel.
     *
     * @return The JPanel representing the main registration panel.
     */
    public JPanel getCenterRegistrationPanel() {
        return centerRegistrationPanel;
    }

    /**
     * Setter for the centerRegistrationPanel.
     *
     * @param centerRegistrationPanel The JPanel to set as the main registration panel.
     */
    public void setCenterRegistrationPanel(JPanel centerRegistrationPanel) {
        this.centerRegistrationPanel = centerRegistrationPanel;
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
        centerRegistrationPanel.setLayout(new GridLayoutManager(13, 4, new Insets(0, 0, 0, 0), -1, -1));
        centerRegistrationPanel.setBackground(new Color(-9473675));
        centerRegistrationPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        centerRegistrationPanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        centerRegistrationPanel.add(spacer1, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        centerRegistrationLabel = new JLabel();
        centerRegistrationLabel.setBackground(new Color(-1));
        Font centerRegistrationLabelFont = this.$$$getFont$$$(null, -1, 16, centerRegistrationLabel.getFont());
        if (centerRegistrationLabelFont != null) centerRegistrationLabel.setFont(centerRegistrationLabelFont);
        centerRegistrationLabel.setForeground(new Color(-1));
        centerRegistrationLabel.setText("Inserisci qui sotto i dati necessari per la registrazione del centro di monitoraggio");
        centerRegistrationPanel.add(centerRegistrationLabel, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centerFormPanel = new JPanel();
        centerFormPanel.setLayout(new GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1));
        centerFormPanel.setBackground(new Color(-9473675));
        centerFormPanel.setForeground(new Color(-9473675));
        centerRegistrationPanel.add(centerFormPanel, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome Centro : ");
        centerFormPanel.add(nameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        centerFormPanel.add(nameField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addressLabel = new JLabel();
        addressLabel.setBackground(new Color(-1));
        addressLabel.setForeground(new Color(-1));
        addressLabel.setText("Indirizzo : ");
        centerFormPanel.add(addressLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressField = new JTextField();
        centerFormPanel.add(addressField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addressNumberLabel = new JLabel();
        addressNumberLabel.setBackground(new Color(-1));
        addressNumberLabel.setForeground(new Color(-1));
        addressNumberLabel.setText("Numero Civico : ");
        centerFormPanel.add(addressNumberLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        capLabel = new JLabel();
        capLabel.setBackground(new Color(-1));
        capLabel.setForeground(new Color(-1));
        capLabel.setText("CAP : ");
        centerFormPanel.add(capLabel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressNumberFIeld = new JTextField();
        centerFormPanel.add(addressNumberFIeld, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        capField = new JTextField();
        centerFormPanel.add(capField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityLabel = new JLabel();
        cityLabel.setBackground(new Color(-1));
        cityLabel.setForeground(new Color(-1));
        cityLabel.setText("Città : ");
        centerFormPanel.add(cityLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        provinceLabel = new JLabel();
        provinceLabel.setBackground(new Color(-1));
        provinceLabel.setForeground(new Color(-1));
        provinceLabel.setText("Provincia : ");
        centerFormPanel.add(provinceLabel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        provinceField = new JTextField();
        centerFormPanel.add(provinceField, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityField = new JTextField();
        centerFormPanel.add(cityField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        poiSelectionLabel = new JLabel();
        poiSelectionLabel.setBackground(new Color(-1));
        Font poiSelectionLabelFont = this.$$$getFont$$$(null, -1, 16, poiSelectionLabel.getFont());
        if (poiSelectionLabelFont != null) poiSelectionLabel.setFont(poiSelectionLabelFont);
        poiSelectionLabel.setForeground(new Color(-1));
        poiSelectionLabel.setText("Cerca le aree di interesse che il tuo Centro di Monitoraggio monitora, se non presenti sarà possibile crearle");
        centerRegistrationPanel.add(poiSelectionLabel, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poiSelectionPanel = new JPanel();
        poiSelectionPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        poiSelectionPanel.setBackground(new Color(-9473675));
        poiSelectionPanel.setForeground(new Color(-9473675));
        centerRegistrationPanel.add(poiSelectionPanel, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchPanel = new JPanel();
        coordinatesSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        coordinatesSearchPanel.setBackground(new Color(-9473675));
        coordinatesSearchPanel.setForeground(new Color(-9473675));
        poiSelectionPanel.add(coordinatesSearchPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchLabel = new JLabel();
        coordinatesSearchLabel.setBackground(new Color(-1));
        coordinatesSearchLabel.setForeground(new Color(-1));
        coordinatesSearchLabel.setText("Ricerca area per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        latitudeLabel = new JLabel();
        latitudeLabel.setBackground(new Color(-1));
        latitudeLabel.setForeground(new Color(-1));
        latitudeLabel.setText("Latitudine");
        coordinatesSearchPanel.add(latitudeLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        coordinatesSearchPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        latitudeField = new JTextField();
        coordinatesSearchPanel.add(latitudeField, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        longitudeLabel = new JLabel();
        longitudeLabel.setBackground(new Color(-1));
        longitudeLabel.setForeground(new Color(-1));
        longitudeLabel.setText("Longitudine");
        coordinatesSearchPanel.add(longitudeLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        coordinatesSearchPanel.add(spacer3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        longitudeField = new JTextField();
        coordinatesSearchPanel.add(longitudeField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        coordinatesSearchButton = new JButton();
        coordinatesSearchButton.setBackground(new Color(-13947600));
        coordinatesSearchButton.setForeground(new Color(-1));
        coordinatesSearchButton.setText("Cerca per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        coordinatesSearchPanel.add(spacer4, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        addedPoiPanel = new JPanel();
        addedPoiPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        addedPoiPanel.setBackground(new Color(-9473675));
        addedPoiPanel.setForeground(new Color(-9473675));
        poiSelectionPanel.add(addedPoiPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addedPoiLabel = new JLabel();
        addedPoiLabel.setBackground(new Color(-1));
        addedPoiLabel.setForeground(new Color(-1));
        addedPoiLabel.setText("Aree aggiunte al Centro di Monitoraggio");
        addedPoiPanel.add(addedPoiLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addedPoiScroll = new JScrollPane();
        addedPoiPanel.add(addedPoiScroll, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        addedPoiTable = new JTable();
        addedPoiScroll.setViewportView(addedPoiTable);
        completeCenterRegistrationLabel = new JLabel();
        completeCenterRegistrationLabel.setBackground(new Color(-1));
        Font completeCenterRegistrationLabelFont = this.$$$getFont$$$(null, -1, 16, completeCenterRegistrationLabel.getFont());
        if (completeCenterRegistrationLabelFont != null)
            completeCenterRegistrationLabel.setFont(completeCenterRegistrationLabelFont);
        completeCenterRegistrationLabel.setForeground(new Color(-1));
        completeCenterRegistrationLabel.setText("Quando la lista visualizzata comprende tutte le aree necessarie clicca su \"Completa Registrazione\"");
        centerRegistrationPanel.add(completeCenterRegistrationLabel, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        centerRegistrationPanel.add(backButton, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        completeCenterRegistrationButton = new JButton();
        completeCenterRegistrationButton.setBackground(new Color(-13947600));
        completeCenterRegistrationButton.setForeground(new Color(-1));
        completeCenterRegistrationButton.setText("Completa Registrazione");
        centerRegistrationPanel.add(completeCenterRegistrationButton, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        centerRegistrationPanel.add(spacer5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        centerRegistrationPanel.add(spacer6, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        centerRegistrationPanel.add(spacer7, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        centerRegistrationPanel.add(spacer8, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        centerRegistrationPanel.add(spacer9, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        centerRegistrationPanel.add(spacer10, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        centerRegistrationPanel.add(spacer11, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
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
