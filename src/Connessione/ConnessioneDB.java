package Connessione;

import java.sql.*;

public class ConnessioneDB {

	// ATTRIBUTI
	private static ConnessioneDB instance;
	private Connection connection = null;
	private String nome = "postgres";
	private String password = "mamuccio";
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String driver = "org.postgresql.Driver";

	// COSTRUTTORE
	public ConnessioneDB() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, nome, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public Connection getConnection() {
			return connection;
	}
	
	public static ConnessioneDB getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDB();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDB();
		}
		return instance;
	}}