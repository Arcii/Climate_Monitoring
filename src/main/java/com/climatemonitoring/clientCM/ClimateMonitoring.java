package com.climatemonitoring.clientCM;

import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.network.ClientManager;

/**
 * The <code>ClimateMonitoring</code> class serves as the entry point and main class for
 * the client side of the Climate Monitoring application. It initializes the
 * necessary components, such as the singleton <code>ClientManager</code> for network communication
 * and the main graphical user interface (GUI) represented by the <code>ClientHomeGUI</code>.
 *
 * <p>
 * The main method creates an instance of the singleton <code>ClientManager</code> using the
 * static method <code>GetClientManager()</code> to manage the client-side networking
 * operations. It also initializes and displays the main GUI window (<code>ClientHomeGUI</code>)
 * for the Climate Monitoring application.
 * </p>
 *
 * <p>
 * This class is responsible for starting the client application and providing
 * the user interface to interact with the Climate Monitoring system.
 * </p>
 *
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see ClientManager
 * @see ClientHomeGUI
 */
public class ClimateMonitoring {

    /**
     * The main method that serves as the entry point for the Climate Monitoring
     * client application. It initializes the  singleton <code>ClientManager</code> for network
     * communication and the main graphical user interface (<code>ClientHomeGUI</code>).
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize the singleton ClientManager for network communication
        ClientManager.GetClientManager();
        // Initialize the main home graphical user interface
        ClientHomeGUI form = new ClientHomeGUI();
        // Make the GUI visible to the user
        form.setVisible(true);
    }

}
