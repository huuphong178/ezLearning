/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.config.AppConfig;
import handler.UserHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 *
 * @author Phong Nguyen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server(AppConfig.PORT);
      //  server.setHandler(new Application());
        ServletContextHandler handler = new ServletContextHandler(server, "/");
	handler.addServlet(UserHandler.class, "/user/*");
        
        try {
            server.start();
            System.out.print("Service run at port: "+ AppConfig.PORT);
            server.join();
        } catch (Exception ex) {
         //   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
