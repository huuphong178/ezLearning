/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.config.AppConfig;
import handler.CartHandler;
import handler.CategoryHandler;
import handler.ChapterHandler;
import handler.CommentHandler;
import handler.CourseHandler;
import handler.LectureHandler;
import handler.MethodHandler;
import handler.RatingHandler;
import handler.ReceiptDetailHandler;
import handler.ReceiptHandler;
import handler.UserHandler;
import handler.VoucherHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
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
        Server server = new Server();
        // HTTP connector
        ServerConnector http = new ServerConnector(server);
        http.setHost(AppConfig.HOST);
        http.setPort(AppConfig.PORT);
        http.setIdleTimeout(30000);
        // Set the connector
        server.addConnector(http);
        //  server.setHandler(new Application());
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(UserHandler.class, "/user/*");
        handler.addServlet(CartHandler.class, "/cart/*");
        handler.addServlet(CategoryHandler.class, "/category/*");
        handler.addServlet(ChapterHandler.class, "/chapter/*");
        handler.addServlet(CommentHandler.class, "/comment/*");
        handler.addServlet(CourseHandler.class, "/course/*");
        handler.addServlet(LectureHandler.class, "/lecture/*");
        handler.addServlet(VoucherHandler.class, "/voucher/*");
        handler.addServlet(ReceiptDetailHandler.class, "/receiptdetail/*");
        handler.addServlet(ReceiptHandler.class, "/receipt/*");
        handler.addServlet(RatingHandler.class, "/rating/*");
        handler.addServlet(MethodHandler.class, "/method/*");
        try {
            server.start();
            System.out.print("Service run at port: " + AppConfig.PORT);
            server.join();
        } catch (Exception ex) {
            //   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
