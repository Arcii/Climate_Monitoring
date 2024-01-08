package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.ClientHomeGUIController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

/**
 * The home graphical user interface (GUI) class for the Climate Monitoring application.
 * This class represents the home screen of the client-side application, providing user interaction
 * and displaying essential information related to climate monitoring.
 *
 * <p>
 * On this page a guest can search Points of Interest by name and country or by coordinates.
 * An Operator of a Monitoring Center can Log In or start the registration process.
 * </p>
 *
 * @author Lorenzo Cattapan 726459  (Varese)
 * @version 0.9.0
 * @see com.climatemonitoring.clientCM.network.ClientManager
 */
public class ClientHomeGUI extends JFrame {

    //*****************FIELDS*****************

    /**
     * Panel for guest user information
     */
    private JPanel guestUserPanel;
    /**
     * Application label
     */
    private JLabel climatemonitoringLabel;
    /**
     * Greeting label for user
     */
    private JLabel greetingLabel;
    /**
     * Panel for geographical coordinates search
     */
    private JPanel coordinatesSearchPanel;
    /**
     * Label for coordinates search
     */
    private JLabel coordinatesSearchLabel;
    /**
     * Panel for name-based search
     */
    private JPanel nameSearchPanel;
    /**
     * Label for name-based search
     */
    private JLabel nameSearchLabel;
    /**
     * Input field for latitude
     */
    private JTextField latitudeField;
    /**
     * Input field for longitude
     */
    private JTextField longitudeField;
    /**
     * Button for coordinates search
     */
    private JButton coordinatesSearchButton;
    /**
     * Input field for location name
     */
    private JTextField nameField;
    /**
     * Input field for state
     */
    private JTextField stateField;
    /**
     * Button for name-based search
     */
    private JButton namePoiSearchButton;
    /**
     * Label for latitude input
     */
    private JLabel latitudeLabel;
    /**
     * Label for longitude input
     */
    private JLabel longitudeLabel;
    /**
     * Label for location name input
     */
    private JLabel nameLabel;
    /**
     * Label for state input
     */
    private JLabel stateLabel;
    /**
     * Panel for user login form
     */
    private JPanel loginFormPanel;
    /**
     * Label for username input
     */
    private JLabel usernameLabel;
    /**
     * Input field for username
     */
    private JTextField usernameField;
    /**
     * Label for password input
     */
    private JLabel passwordLabel;
    /**
     * Input field for password
     */
    private JPasswordField passwordField;
    /**
     * Button for user login
     */
    private JButton loginButton;
    /**
     * Information label for login status
     */
    private JLabel loginInfoLabel;
    /**
     * Panel for user sign-up form
     */
    private JPanel signUpPanel;
    /**
     * Label for sign-up form
     */
    private JLabel signUpLabel;
    /**
     * Button for user sign-up
     */
    private JButton signUpButton;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructor for the main graphical user interface (GUI) of the Climate Monitoring application.
     * Initializes the GUI components, sets the title, size, and default close operation.
     * Also, configures the initial size, state, and associates a controller with the GUI.
     */
    public ClientHomeGUI() {

        // Set the title of the application window
        setTitle("Climate Monitoring");

        // Set the content pane to the guestUserPanel
        setContentPane(guestUserPanel);

        // Set the default close operation when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size and set the window size to cover the entire screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        // Set the minimum size of the window
        setMinimumSize(new Dimension(1000, 650));

        // Set the extended state to maximize the window
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Set the initial size of the search panels
        coordinatesSearchPanel.setSize(400, 400);
        nameSearchPanel.setSize(400, 400);

        // Create an instance of the ClientHomeGUIController and associate it with this GUI
        new ClientHomeGUIController(this);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Getter for the guestUserPanel.
     *
     * @return The JPanel representing the guest user panel.
     */
    public JPanel getGuestUserPanel() {
        return guestUserPanel;
    }

    /**
     * Setter for the guestUserPanel.
     *
     * @param guestUserPanel The JPanel to set as the guest user panel.
     */
    public void setGuestUserPanel(JPanel guestUserPanel) {
        this.guestUserPanel = guestUserPanel;
    }

    /**
     * Getter for the climatemonitoringLabel.
     *
     * @return The JLabel representing the climatemonitoring label.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Setter for the climatemonitoringLabel.
     *
     * @param climatemonitoringLabel The JLabel to set as the climatemonitoring label.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Getter for the greetingLabel.
     *
     * @return The JLabel representing the greeting label.
     */
    public JLabel getGreetingLabel() {
        return greetingLabel;
    }

    /**
     * Setter for the greetingLabel.
     *
     * @param greetingLabel The JLabel to set as the greeting label.
     */
    public void setGreetingLabel(JLabel greetingLabel) {
        this.greetingLabel = greetingLabel;
    }

    /**
     * Getter for the coordinatesSearchPanel.
     *
     * @return The JPanel representing the coordinates search panel.
     */
    public JPanel getCoordinatesSearchPanel() {
        return coordinatesSearchPanel;
    }

    /**
     * Setter for the coordinatesSearchPanel.
     *
     * @param coordinatesSearchPanel The JPanel to set as the coordinates search panel.
     */
    public void setCoordinatesSearchPanel(JPanel coordinatesSearchPanel) {
        this.coordinatesSearchPanel = coordinatesSearchPanel;
    }

    /**
     * Getter for the coordinatesSearchLabel.
     *
     * @return The JLabel representing the coordinates search label.
     */
    public JLabel getCoordinatesSearchLabel() {
        return coordinatesSearchLabel;
    }

    /**
     * Setter for the coordinatesSearchLabel.
     *
     * @param coordinatesSearchLabel The JLabel to set as the coordinates search label.
     */
    public void setCoordinatesSearchLabel(JLabel coordinatesSearchLabel) {
        this.coordinatesSearchLabel = coordinatesSearchLabel;
    }

    /**
     * Getter for the nameSearchPanel.
     *
     * @return The JPanel representing the name search panel.
     */
    public JPanel getNameSearchPanel() {
        return nameSearchPanel;
    }

    /**
     * Setter for the nameSearchPanel.
     *
     * @param nameSearchPanel The JPanel to set as the name search panel.
     */
    public void setNameSearchPanel(JPanel nameSearchPanel) {
        this.nameSearchPanel = nameSearchPanel;
    }

    /**
     * Getter for the nameSearchLabel.
     *
     * @return The JLabel representing the name search label.
     */
    public JLabel getNameSearchLabel() {
        return nameSearchLabel;
    }

    /**
     * Setter for the nameSearchLabel.
     *
     * @param nameSearchLabel The JLabel to set as the name search label.
     */
    public void setNameSearchLabel(JLabel nameSearchLabel) {
        this.nameSearchLabel = nameSearchLabel;
    }

    /**
     * Getter for the latitudeField.
     *
     * @return The JTextField representing the latitude input field.
     */
    public JTextField getLatitudeField() {
        return latitudeField;
    }

    /**
     * Setter for the latitudeField.
     *
     * @param latitudeField The JTextField to set as the latitude input field.
     */
    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    /**
     * Getter for the longitudeField.
     *
     * @return The JTextField representing the longitude input field.
     */
    public JTextField getLongitudeField() {
        return longitudeField;
    }

    /**
     * Setter for the longitudeField.
     *
     * @param longitudeField The JTextField to set as the longitude input field.
     */
    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    /**
     * Getter for the coordinatesSearchButton.
     *
     * @return The JButton representing the coordinates search button.
     */
    public JButton getCoordinatesSearchButton() {
        return coordinatesSearchButton;
    }

    /**
     * Setter for the coordinatesSearchButton.
     *
     * @param coordinatesSearchButton The JButton to set as the coordinates search button.
     */
    public void setCoordinatesSearchButton(JButton coordinatesSearchButton) {
        this.coordinatesSearchButton = coordinatesSearchButton;
    }

    /**
     * Getter for the nameField.
     *
     * @return The JTextField representing the name input field.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Setter for the nameField.
     *
     * @param nameField The JTextField to set as the name input field.
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Getter for the stateField.
     *
     * @return The JTextField representing the state input field.
     */
    public JTextField getStateField() {
        return stateField;
    }

    /**
     * Setter for the stateField.
     *
     * @param stateField The JTextField to set as the state input field.
     */
    public void setStateField(JTextField stateField) {
        this.stateField = stateField;
    }

    /**
     * Getter for the namePoiSearchButton.
     *
     * @return The JButton representing the name POI search button.
     */
    public JButton getNamePoiSearchButton() {
        return namePoiSearchButton;
    }

    /**
     * Setter for the namePoiSearchButton.
     *
     * @param namePoiSearchButton The JButton to set as the name POI search button.
     */
    public void setNamePoiSearchButton(JButton namePoiSearchButton) {
        this.namePoiSearchButton = namePoiSearchButton;
    }

    /**
     * Getter for the latitudeLabel.
     *
     * @return The JLabel representing the latitude label.
     */
    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    /**
     * Setter for the latitudeLabel.
     *
     * @param latitudeLabel The JLabel to set as the latitude label.
     */
    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    /**
     * Getter for the longitudeLabel.
     *
     * @return The JLabel representing the longitude label.
     */
    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

    /**
     * Setter for the longitudeLabel.
     *
     * @param longitudeLabel The JLabel to set as the longitude label.
     */
    public void setLongitudeLabel(JLabel longitudeLabel) {
        this.longitudeLabel = longitudeLabel;
    }

    /**
     * Getter for the nameLabel.
     *
     * @return The JLabel representing the name label.
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Setter for the nameLabel.
     *
     * @param nameLabel The JLabel to set as the name label.
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Getter for the stateLabel.
     *
     * @return The JLabel representing the state label.
     */
    public JLabel getStateLabel() {
        return stateLabel;
    }

    /**
     * Setter for the stateLabel.
     *
     * @param stateLabel The JLabel to set as the state label.
     */
    public void setStateLabel(JLabel stateLabel) {
        this.stateLabel = stateLabel;
    }

    /**
     * Getter for the loginFormPanel.
     *
     * @return The JPanel representing the login form panel.
     */
    public JPanel getLoginFormPanel() {
        return loginFormPanel;
    }

    /**
     * Setter for the loginFormPanel.
     *
     * @param loginFormPanel The JPanel to set as the login form panel.
     */
    public void setLoginFormPanel(JPanel loginFormPanel) {
        this.loginFormPanel = loginFormPanel;
    }

    /**
     * Getter for the usernameLabel.
     *
     * @return The JLabel representing the username label.
     */
    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    /**
     * Setter for the usernameLabel.
     *
     * @param usernameLabel The JLabel to set as the username label.
     */
    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    /**
     * Getter for the usernameField.
     *
     * @return The JTextField representing the username input field.
     */
    public JTextField getUsernameField() {
        return usernameField;
    }

    /**
     * Setter for the usernameField.
     *
     * @param usernameField The JTextField to set as the username input field.
     */
    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    /**
     * Getter for the passwordLabel.
     *
     * @return The JLabel representing the password label.
     */
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    /**
     * Setter for the passwordLabel.
     *
     * @param passwordLabel The JLabel to set as the password label.
     */
    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    /**
     * Getter for the passwordField.
     *
     * @return The JPasswordField representing the password input field.
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Setter for the passwordField.
     *
     * @param passwordField The JPasswordField to set as the password input field.
     */
    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Getter for the loginButton.
     *
     * @return The JButton representing the login button.
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * Setter for the loginButton.
     *
     * @param loginButton The JButton to set as the login button.
     */
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * Getter for the loginInfoLabel.
     *
     * @return The JLabel representing the login info label.
     */
    public JLabel getLoginInfoLabel() {
        return loginInfoLabel;
    }

    /**
     * Setter for the loginInfoLabel.
     *
     * @param loginInfoLabel The JLabel to set as the login info label.
     */
    public void setLoginInfoLabel(JLabel loginInfoLabel) {
        this.loginInfoLabel = loginInfoLabel;
    }

    /**
     * Getter for the signUpPanel.
     *
     * @return The JPanel representing the sign-up panel.
     */
    public JPanel getSignUpPanel() {
        return signUpPanel;
    }

    /**
     * Setter for the signUpPanel.
     *
     * @param signUpPanel The JPanel to set as the sign-up panel.
     */
    public void setSignUpPanel(JPanel signUpPanel) {
        this.signUpPanel = signUpPanel;
    }

    /**
     * Getter for the signUpLabel.
     *
     * @return The JLabel representing the sign-up label.
     */
    public JLabel getSignUpLabel() {
        return signUpLabel;
    }

    /**
     * Setter for the signUpLabel.
     *
     * @param signUpLabel The JLabel to set as the sign-up label.
     */
    public void setSignUpLabel(JLabel signUpLabel) {
        this.signUpLabel = signUpLabel;
    }

    /**
     * Getter for the signUpButton.
     *
     * @return The JButton representing the sign-up button.
     */
    public JButton getSignUpButton() {
        return signUpButton;
    }

    /**
     * Setter for the signUpButton.
     *
     * @param signUpButton The JButton to set as the sign-up button.
     */
    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
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
        guestUserPanel = new JPanel();
        guestUserPanel.setLayout(new GridLayoutManager(8, 2, new Insets(0, 0, 0, 0), -1, -1));
        guestUserPanel.setBackground(new Color(-9473675));
        guestUserPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        guestUserPanel.add(climatemonitoringLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        guestUserPanel.add(spacer1, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        greetingLabel = new JLabel();
        greetingLabel.setBackground(new Color(-1));
        Font greetingLabelFont = this.$$$getFont$$$(null, -1, 26, greetingLabel.getFont());
        if (greetingLabelFont != null) greetingLabel.setFont(greetingLabelFont);
        greetingLabel.setForeground(new Color(-1));
        greetingLabel.setText("Benvenuti in Climate Monitoring, inserite i dati dell'area geografica di cui volete visualizzare le rilevazioni :");
        guestUserPanel.add(greetingLabel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        coordinatesSearchPanel = new JPanel();
        coordinatesSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        coordinatesSearchPanel.setBackground(new Color(-9473675));
        coordinatesSearchPanel.setForeground(new Color(-9473675));
        guestUserPanel.add(coordinatesSearchPanel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
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
        nameSearchPanel = new JPanel();
        nameSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        nameSearchPanel.setBackground(new Color(-9473675));
        nameSearchPanel.setForeground(new Color(-9473675));
        guestUserPanel.add(nameSearchPanel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameSearchLabel = new JLabel();
        nameSearchLabel.setBackground(new Color(-1));
        nameSearchLabel.setForeground(new Color(-1));
        nameSearchLabel.setText("Ricerca per denominazione");
        nameSearchPanel.add(nameSearchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        nameSearchPanel.add(spacer5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome area");
        nameSearchPanel.add(nameLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        nameSearchPanel.add(nameField, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer6 = new Spacer();
        nameSearchPanel.add(spacer6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        stateLabel = new JLabel();
        stateLabel.setBackground(new Color(-1));
        stateLabel.setForeground(new Color(-1));
        stateLabel.setText("Stato");
        nameSearchPanel.add(stateLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stateField = new JTextField();
        nameSearchPanel.add(stateField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer7 = new Spacer();
        nameSearchPanel.add(spacer7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        namePoiSearchButton = new JButton();
        namePoiSearchButton.setBackground(new Color(-13947600));
        namePoiSearchButton.setForeground(new Color(-1));
        namePoiSearchButton.setText("Cerca per denominazione");
        nameSearchPanel.add(namePoiSearchButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        guestUserPanel.add(spacer8, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        guestUserPanel.add(spacer9, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        guestUserPanel.add(spacer10, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        loginFormPanel = new JPanel();
        loginFormPanel.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        loginFormPanel.setBackground(new Color(-9473675));
        loginFormPanel.setForeground(new Color(-9473675));
        guestUserPanel.add(loginFormPanel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        usernameLabel = new JLabel();
        usernameLabel.setForeground(new Color(-1));
        usernameLabel.setText("Username");
        loginFormPanel.add(usernameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usernameField = new JTextField();
        loginFormPanel.add(usernameField, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setForeground(new Color(-1));
        passwordLabel.setText("Password");
        loginFormPanel.add(passwordLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        loginFormPanel.add(passwordField, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        loginButton = new JButton();
        loginButton.setBackground(new Color(-13947600));
        loginButton.setForeground(new Color(-1));
        loginButton.setText("Accedi");
        loginFormPanel.add(loginButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginInfoLabel = new JLabel();
        Font loginInfoLabelFont = this.$$$getFont$$$(null, -1, 18, loginInfoLabel.getFont());
        if (loginInfoLabelFont != null) loginInfoLabel.setFont(loginInfoLabelFont);
        loginInfoLabel.setForeground(new Color(-1));
        loginInfoLabel.setText("Se sei un Operatore già registrato inserisci qui i tuoi dati per il Login");
        loginFormPanel.add(loginInfoLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(566, 23), null, 0, false));
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        signUpPanel.setBackground(new Color(-9473675));
        signUpPanel.setForeground(new Color(-9473675));
        guestUserPanel.add(signUpPanel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        signUpLabel = new JLabel();
        Font signUpLabelFont = this.$$$getFont$$$(null, -1, 18, signUpLabel.getFont());
        if (signUpLabelFont != null) signUpLabel.setFont(signUpLabelFont);
        signUpLabel.setForeground(new Color(-1));
        signUpLabel.setText("Se sei un Operatore non ancora registrato clicca qui sotto");
        signUpPanel.add(signUpLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        signUpButton = new JButton();
        signUpButton.setBackground(new Color(-13947600));
        signUpButton.setForeground(new Color(-1));
        signUpButton.setText("SignUp Operatore");
        signUpPanel.add(signUpButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return guestUserPanel;
    }

}
