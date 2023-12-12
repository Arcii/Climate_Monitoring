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

public class OperatorRegistrationGUI extends JFrame {

    //FIELDS

    private JPanel operatorRegistrationPanel;
    private JLabel climatemonitoringLabel;
    private JLabel registrationFormInfoLabel;
    private JPanel registrationFormPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField fiscalCodeField;
    private JTextField emailField;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel fiscalCodeLabel;
    private JLabel emailLabel;
    private JLabel userIdLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JButton continueRegistrationButton;
    private JButton backButton;

    //CONSTRUCTORS

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

    //GETTER AND SETTER

    public JPanel getOperatorRegistrationPanel() {
        return operatorRegistrationPanel;
    }

    public void setOperatorRegistrationPanel(JPanel operatorRegistrationPanel) {
        this.operatorRegistrationPanel = operatorRegistrationPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getRegistrationFormInfoLabel() {
        return registrationFormInfoLabel;
    }

    public void setRegistrationFormInfoLabel(JLabel registrationFormInfoLabel) {
        this.registrationFormInfoLabel = registrationFormInfoLabel;
    }

    public JPanel getRegistrationFormPanel() {
        return registrationFormPanel;
    }

    public void setRegistrationFormPanel(JPanel registrationFormPanel) {
        this.registrationFormPanel = registrationFormPanel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JTextField getFiscalCodeField() {
        return fiscalCodeField;
    }

    public void setFiscalCodeField(JTextField fiscalCodeField) {
        this.fiscalCodeField = fiscalCodeField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getUserIdField() {
        return userIdField;
    }

    public void setUserIdField(JTextField userIdField) {
        this.userIdField = userIdField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public void setSurnameLabel(JLabel surnameLabel) {
        this.surnameLabel = surnameLabel;
    }

    public JLabel getFiscalCodeLabel() {
        return fiscalCodeLabel;
    }

    public void setFiscalCodeLabel(JLabel fiscalCodeLabel) {
        this.fiscalCodeLabel = fiscalCodeLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getUserIdLabel() {
        return userIdLabel;
    }

    public void setUserIdLabel(JLabel userIdLabel) {
        this.userIdLabel = userIdLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }

    public JButton getContinueRegistrationButton() {
        return continueRegistrationButton;
    }

    public void setContinueRegistrationButton(JButton continueRegistrationButton) {
        this.continueRegistrationButton = continueRegistrationButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

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
