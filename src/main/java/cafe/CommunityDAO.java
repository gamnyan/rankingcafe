package cafe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryLoader;

public class CommunityDAO {
	final static String QUERY_PATH = "/cafe/cafe_queries.properties";
	final static Map<String, String> QM;
	
	private DataSource dataSource;
	
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
		}catch (IOException ioe) {
			ioe.printStackTrace();
			
			throw new ExceptionInInitializerError(ioe);
		}
	}
	
	public CommunityDAO() {
		 try {
	            Context initialContext = new InitialContext();
	            Context envContext = (Context) initialContext.lookup("java:/comp/env");
	            dataSource = (DataSource) envContext.lookup("jdbc/cafedb");
	        } catch (NamingException ne) {
	            ne.printStackTrace();
	        }
	}
	
	/*
	 * public int nextval() { try(Connection c =dataSource.getConnection();
	 * PreparedStatement ps = c.prepareStatement(QM.get("addingnewid")); ){
	 * 
	 * } }
	 */
	
	
	
	
	
}
