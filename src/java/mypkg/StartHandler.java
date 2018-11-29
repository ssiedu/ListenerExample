package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartHandler implements ServletContextListener {

    Connection con;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdata", "root", "root");
          //storing connection to context object
          ServletContext context=sce.getServletContext();
          context.setAttribute("datacon", con);
          
      }catch(Exception e){
          e.printStackTrace();
      }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
