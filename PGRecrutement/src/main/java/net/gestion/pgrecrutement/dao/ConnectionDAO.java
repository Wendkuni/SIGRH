package net.gestion.pgrecrutement.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class ConnectionDAO{

	private static final String URL = "jdbc:mysql://51.77.150.78/general";

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USER = "okii";
	private static final String PASSWORD = "Sabourou@1";



	private static DataSource connexion;
	
	public static DataSource getInstance(){
		if(connexion == null){
            try {
                Class.forName(DRIVER);
				connexion=new DriverManagerDataSource(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
		return connexion;
	}
	
}