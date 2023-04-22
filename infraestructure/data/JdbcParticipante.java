package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import portsout.InfraestructuraException;
import portsout.Registro;

public class JdbcParticipante implements Registro {

	private Connection dbConn;
	private String url;
	private String user;
	private String password;

	public JdbcParticipante() {
		this.url = "jdbc:mysql://localhost:3306/participantes";
		this.user = "root";
		this.password = "";
	}

	@Override
	public void registrar(String nombre, String numeroTelefono, String region) throws InfraestructuraException {

		try {
			this.dbConn = DriverManager.getConnection(url, user, password);

			PreparedStatement st = dbConn
					.prepareStatement("insert into participante(nombre, telefono, region) values(?,?,?)");
			try {
				st.setString(1, nombre);
				st.setString(2, numeroTelefono);
				st.setString(3, region);
				st.executeUpdate();
			} finally {
				st.close();
			}

		} catch (SQLException e) {

			throw new InfraestructuraException("No se pudo agregar participante");
		}

	}

}
