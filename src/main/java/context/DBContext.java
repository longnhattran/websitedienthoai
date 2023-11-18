package context;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * create object which connect to database
 * @author LE PHONG LAM
 *
 */
public class DBContext {
	
	/**
	 * create object which connect to database
	 * @return Connection object
	 * @throws NamingException
	 * @throws SQLException
	 */
	public Connection getConnection() throws NamingException, SQLException {
		
		InitialContext initContext = new InitialContext();
		
		Context env = (Context) initContext.lookup("java:comp/env");
		
		DataSource ds = (DataSource) env.lookup("jdbc/shoppingdb");
		
		return ds.getConnection();
	}
	
}
