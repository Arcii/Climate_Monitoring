package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.OperatorRegistrationGUIController;
import com.climatemonitoring.shared.models.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

/**
 * OperatorRegistrationGUI class represents the graphical user interface for the Operator registration process.
 * It allows new operators to register by providing necessary information such as name, surname, fiscal code, email, username, and password.
 * The class includes fields for user input, labels, buttons, and a controller to handle user interactions.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see OperatorRegistrationGUIController
 */
public class OperatorRegistrationGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * The main panel for the Operator Registration GUI.
     */
    private JPanel operatorRegistrationPanel;
    /**
     * Label displaying the application name.
     */
    private JLabel climatemonitoringLabel;
    /**
     * Information label guiding the user through the registration process.
     */
    private JLabel registrationFormInfoLabel;
    /**
     * Panel containing the registration form fields.
     */
    private JPanel registrationFormPanel;
    /**
     * Text field for entering the operator's name.
     */
    private JTextField nameField;
    /**
     * Text field for entering the operator's surname.
     */
    private JTextField surnameField;
    /**
     * Text field for entering the operator's fiscal code.
     */
    private JTextField fiscalCodeField;
    /**
     * Text field for entering the operator's email address.
     */
    private JTextField emailField;
    /**
     * Text field for entering the desired username.
     */
    private JTextField userIdField;
    /**
     * Password field for entering the desired password.
     */
    private JPasswordField passwordField;
    /**
     * Password field for confirming the entered password.
     */
    private JPasswordField confirmPasswordField;
    /**
     * Label indicating the purpose of the name field.
     */
    private JLabel nameLabel;
    /**
     * Label indicating the purpose of the surname field.
     */
    private JLabel surnameLabel;
    /**
     * Label indicating the purpose of the fiscal code field.
     */
    private JLabel fiscalCodeLabel;
    /**
     * Label indicating the purpose of the email field.
     */
    private JLabel emailLabel;
    /**
     * Label indicating the purpose of the username field.
     */
    private JLabel userIdLabel;
    /**
     * Label indicating the purpose of the password field.
     */
    private JLabel passwordLabel;
    /**
     * Label indicating the purpose of the confirmPassword field.
     */
    private JLabel confirmPasswordLabel;
    /**
     * Button to proceed with the registration process.
     */
    private JButton continueRegistrationButton;
    /**
     * Button to go back to the previous screen.
     */
    private JButton backButton;

    //*****************CONSTRUCTORS*****************//

    /**
     * Default constructor for OperatorRegistrationGUI.
     * Initializes the GUI components and sets up the basic layout.
     */
    public OperatorRegistrationGUI() {
        setTitle("Climate Monitoring");
        setContentPane(operatorRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new OperatorRegistrationGUIController(this);
    }

    /**
     * Constructor for OperatorRegistrationGUI pre-filled with user data.
     * Used when the registration process is initiated from an existing user.
     *
     * @param user The user object with pre-filled information.
     */
    public OperatorRegistrationGUI(User user) {
        setTitle("Climate Monitoring");
        setContentPane(operatorRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        this.nameField.setText(user.getName());
        this.surnameField.setText(user.getSurname());
        this.fiscalCodeField.setText(user.getFiscalCode());
        this.emailField.setText(user.getEmail());
        this.userIdField.setText(user.getUserid());
        new OperatorRegistrationGUIController(this);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the main panel for the Operator Registration GUI.
     *
     * @return The JPanel representing the Operator Registration panel.
     */
    public JPanel getOperatorRegistrationPanel() {
        return operatorRegistrationPanel;
    }

    /**
     * Sets the main panel for the Operator Registration GUI.
     *
     * @param operatorRegistrationPanel The JPanel to set as the Operator Registration panel.
     */
    public void setOperatorRegistrationPanel(JPanel operatorRegistrationPanel) {
        this.operatorRegistrationPanel = operatorRegistrationPanel;
    }

    /**
     * Gets the label displaying the application name.
     *
     * @return The JLabel representing the climatemonitoringLabel.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Sets the label displaying the application name.
     *
     * @param climatemonitoringLabel The JLabel to set as climatemonitoringLabel.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Gets the information label guiding the user through the registration process.
     *
     * @return The JLabel representing the registrationFormInfoLabel.
     */
    public JLabel getRegistrationFormInfoLabel() {
        return registrationFormInfoLabel;
    }

    /**
     * Sets the information label guiding the user through the registration process.
     *
     * @param registrationFormInfoLabel The JLabel to set as registrationFormInfoLabel.
     */
    public void setRegistrationFormInfoLabel(JLabel registrationFormInfoLabel) {
        this.registrationFormInfoLabel = registrationFormInfoLabel;
    }

    /**
     * Gets the panel containing the registration form fields.
     *
     * @return The JPanel representing the registrationFormPanel.
     */
    public JPanel getRegistrationFormPanel() {
        return registrationFormPanel;
    }

    /**
     * Sets the panel containing the registration form fields.
     *
     * @param registrationFormPanel The JPanel to set as registrationFormPanel.
     */
    public void setRegistrationFormPanel(JPanel registrationFormPanel) {
        this.registrationFormPanel = registrationFormPanel;
    }

    /**
     * Gets the text field for entering the operator's name.
     *
     * @return The JTextField representing the nameField.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Sets the text field for entering the operator's name.
     *
     * @param nameField The JTextField to set as nameField.
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Gets the text field for entering the operator's surname.
     *
     * @return The JTextField representing the surnameField.
     */
    public JTextField getSurnameField() {
        return surnameField;
    }

    /**
     * Sets the text field for entering the operator's surname.
     *
     * @param surnameField The JTextField to set as surnameField.
     */
    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    /**
     * Gets the text field for entering the operator's fiscal code.
     *
     * @return The JTextField representing the fiscalCodeField.
     */
    public JTextField getFiscalCodeField() {
        return fiscalCodeField;
    }

    /**
     * Sets the text field for entering the operator's fiscal code.
     *
     * @param fiscalCodeField The JTextField to set as fiscalCodeField.
     */
    public void setFiscalCodeField(JTextField fiscalCodeField) {
        this.fiscalCodeField = fiscalCodeField;
    }

    /**
     * Gets the text field for entering the operator's email.
     *
     * @return The JTextField representing the emailField.
     */
    public JTextField getEmailField() {
        return emailField;
    }

    /**
     * Sets the text field for entering the operator's email.
     *
     * @param emailField The JTextField to set as emailField.
     */
    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    /**
     * Gets the text field for entering the operator's userid.
     *
     * @return The JTextField representing the userIdField.
     */
    public JTextField getUserIdField() {
        return userIdField;
    }

    /**
     * Sets the text field for entering the operator's username.
     *
     * @param userIdField The JTextField to set as userIdField.
     */
    public void setUserIdField(JTextField userIdField) {
        this.userIdField = userIdField;
    }

    /**
     * Gets the password field for entering the operator's password.
     *
     * @return The JPasswordField representing the passwordField.
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Sets the password field for entering the operator's password.
     *
     * @param passwordField The JPasswordField to set as passwordField.
     */
    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Gets the password field for confirming the operator's password.
     *
     * @return The JPasswordField representing the confirmPasswordField.
     */
    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    /**
     * Sets the password field for confirming the operator's password.
     *
     * @param confirmPasswordField The JPasswordField to set as confirmPasswordField.
     */
    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    /**
     * Gets the label for displaying the "Name" field.
     *
     * @return The JLabel representing the nameLabel.
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Sets the label for displaying the "Name" field.
     *
     * @param nameLabel The JLabel to set as nameLabel.
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Gets the label for displaying the "Surname" field.
     *
     * @return The JLabel representing the surnameLabel.
     */
    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    /**
     * Sets the label for displaying the "Surname" field.
     *
     * @param surnameLabel The JLabel to set as surnameLabel.
     */
    public void setSurnameLabel(JLabel surnameLabel) {
        this.surnameLabel = surnameLabel;
    }

    /**
     * Gets the label for displaying the "Fiscal Code" field.
     *
     * @return The JLabel representing the fiscalCodeLabel.
     */
    public JLabel getFiscalCodeLabel() {
        return fiscalCodeLabel;
    }

    /**
     * Sets the label for displaying the "Fiscal Code" field.
     *
     * @param fiscalCodeLabel The JLabel to set as fiscalCodeLabel.
     */
    public void setFiscalCodeLabel(JLabel fiscalCodeLabel) {
        this.fiscalCodeLabel = fiscalCodeLabel;
    }

    /**
     * Gets the label for displaying the "Email" field.
     *
     * @return The JLabel representing the emailLabel.
     */
    public JLabel getEmailLabel() {
        return emailLabel;
    }

    /**
     * Sets the label for displaying the "Email" field.
     *
     * @param emailLabel The JLabel to set as emailLabel.
     */
    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * Gets the label for displaying the "Username" field.
     *
     * @return The JLabel representing the userIdLabel.
     */
    public JLabel getUserIdLabel() {
        return userIdLabel;
    }

    /**
     * Sets the label for displaying the "Username" field.
     *
     * @param userIdLabel The JLabel to set as userIdLabel.
     */
    public void setUserIdLabel(JLabel userIdLabel) {
        this.userIdLabel = userIdLabel;
    }

    /**
     * Gets the label for displaying the "Password" field.
     *
     * @return The JLabel representing the passwordLabel.
     */
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    /**
     * Sets the label for displaying the "Password" field.
     *
     * @param passwordLabel The JLabel to set as passwordLabel.
     */
    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    /**
     * Gets the label for displaying the "Confirm Password" field.
     *
     * @return The JLabel representing the confirmPasswordLabel.
     */
    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    /**
     * Sets the label for displaying the "Confirm Password" field.
     *
     * @param confirmPasswordLabel The JLabel to set as confirmPasswordLabel.
     */
    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }

    /**
     * Gets the button for continuing the registration process.
     *
     * @return The JButton representing the continueRegistrationButton.
     */
    public JButton getContinueRegistrationButton() {
        return continueRegistrationButton;
    }

    /**
     * Sets the button for continuing the registration process.
     *
     * @param continueRegistrationButton The JButton to set as continueRegistrationButton.
     */
    public void setContinueRegistrationButton(JButton continueRegistrationButton) {
        this.continueRegistrationButton = continueRegistrationButton;
    }

    /**
     * Gets the button for navigating back in the registration process.
     *
     * @return The JButton representing the backButton.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Sets the button for navigating back in the registration process.
     *
     * @param backButton The JButton to set as backButton.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
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
        operatorRegistrationPanel = new JPanel();
        operatorRegistrationPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        operatorRegistrationPanel.setBackground(new Color(-10131605));
        operatorRegistrationPanel.setForeground(new Color(-10131605));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        operatorRegistrationPanel.add(climatemonitoringLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrationFormInfoLabel = new JLabel();
        Font registrationFormInfoLabelFont = this.$$$getFont$$$(null, -1, 18, registrationFormInfoLabel.getFont());
        if (registrationFormInfoLabelFont != null) registrationFormInfoLabel.setFont(registrationFormInfoLabelFont);
        registrationFormInfoLabel.setForeground(new Color(-1));
        registrationFormInfoLabel.setText("Se non sei ancora registrato inserisci i dati necessari alla registrazione qui sotto e clicca su \"Continua\" per procedere");
        operatorRegistrationPanel.add(registrationFormInfoLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrationFormPanel = new JPanel();
        registrationFormPanel.setLayout(new GridLayoutManager(4, 6, new Insets(0, 0, 0, 0), -1, -1));
        registrationFormPanel.setBackground(new Color(-10131605));
        registrationFormPanel.setForeground(new Color(-10131605));
        operatorRegistrationPanel.add(registrationFormPanel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome : ");
        registrationFormPanel.add(nameLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        registrationFormPanel.add(nameField, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        surnameLabel = new JLabel();
        surnameLabel.setForeground(new Color(-1));
        surnameLabel.setText("Cognome : ");
        registrationFormPanel.add(surnameLabel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        surnameField = new JTextField();
        registrationFormPanel.add(surnameField, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        fiscalCodeLabel = new JLabel();
        fiscalCodeLabel.setForeground(new Color(-1));
        fiscalCodeLabel.setText("Codice Fiscale : ");
        registrationFormPanel.add(fiscalCodeLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emailLabel = new JLabel();
        emailLabel.setForeground(new Color(-1));
        emailLabel.setText("Email : ");
        registrationFormPanel.add(emailLabel, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fiscalCodeField = new JTextField();
        registrationFormPanel.add(fiscalCodeField, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        emailField = new JTextField();
        registrationFormPanel.add(emailField, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userIdLabel = new JLabel();
        userIdLabel.setForeground(new Color(-1));
        userIdLabel.setText("Username : ");
        registrationFormPanel.add(userIdLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userIdField = new JTextField();
        registrationFormPanel.add(userIdField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setForeground(new Color(-1));
        passwordLabel.setText("Password : ");
        registrationFormPanel.add(passwordLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        registrationFormPanel.add(passwordField, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        confirmPasswordLabel = new JLabel();
        confirmPasswordLabel.setForeground(new Color(-1));
        confirmPasswordLabel.setText("Conferma password : ");
        registrationFormPanel.add(confirmPasswordLabel, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        confirmPasswordField = new JPasswordField();
        registrationFormPanel.add(confirmPasswordField, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        registrationFormPanel.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        registrationFormPanel.add(spacer2, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        continueRegistrationButton = new JButton();
        continueRegistrationButton.setBackground(new Color(-13947600));
        continueRegistrationButton.setForeground(new Color(-1));
        continueRegistrationButton.setText("Continua");
        operatorRegistrationPanel.add(continueRegistrationButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        operatorRegistrationPanel.add(spacer3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        operatorRegistrationPanel.add(spacer4, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        operatorRegistrationPanel.add(spacer5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        operatorRegistrationPanel.add(backButton, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        operatorRegistrationPanel.add(spacer6, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fiscalCodeLabel.setLabelFor(fiscalCodeField);
        emailLabel.setLabelFor(emailField);
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
        return operatorRegistrationPanel;
    }

}
