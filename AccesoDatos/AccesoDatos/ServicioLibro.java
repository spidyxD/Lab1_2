package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import logicaNegocio.libro;
import oracle.jdbc.driver.OracleTypes;
/**
 *
 * @author Estudiante
 */
public class ServicioLibro extends Servicio
{

	private static final String insertarLibro = "{call insertarLibro (?,?,?,?,?,?,?,?,?)}";
	private static final String LISTAR = "{?=call listarlibro()}";
	private static final String BUSCARID = "{?=call buscarlibro(?)}";
	private static final String modificarLibro = "{call modificarLibro (?,?,?,?,?,?,?,?,?)}";
	private static final String eliminarLibro = "{call eliminarLibro(?)}";

	/** Creates a new instance of ServicioLibro */
	public ServicioLibro()
	{
	}

	public Collection listarLibro() throws GlobalException, NoDataException
	{
		try
		{
			conectar();
		}
		catch (ClassNotFoundException ex)
		{
			throw new GlobalException("No se ha localizado el Driver");
		}

		catch (SQLException e)
		{
			throw new NoDataException("La base de datos no se encuentra disponible");
		}

		ResultSet rs = null;
		ArrayList coleccion = new ArrayList();
		libro elLibro = null;
		CallableStatement pstmt = null;
		try
		{
			pstmt = conexion.prepareCall(LISTAR);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next())
			{
				elLibro = new libro(rs.getString("id"),
									   rs.getString("entrega"),
									   rs.getString("recibe"),
									   rs.getString("nombre"),
									   rs.getString("caracteristicas"),
									   rs.getInt("condicionEntrega"),
									   rs.getInt("condicionRecibido"),
									   rs.getString("fechaEntrega"),
									   rs.getInt("horaEntrega"));
				coleccion.add(elLibro);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			throw new GlobalException("Sentencia no valida");
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (pstmt != null)
				{
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e)
			{
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
		if (coleccion == null || coleccion.size() == 0)
		{
			throw new NoDataException("No hay datos");
		}
		return coleccion;
	}
	public void insertarLibro(libro elLibro) throws GlobalException, NoDataException
	{
		try
		{
			conectar();
		}
		catch (ClassNotFoundException e)
		{
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e)
		{
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		CallableStatement pstmt = null;

		try
		{
			 
			pstmt = conexion.prepareCall(insertarLibro);
			pstmt.setString(1, elLibro.getId());
			pstmt.setString(2, elLibro.getEntrega());
			pstmt.setString(3, elLibro.getRecibe());
			pstmt.setString(4, elLibro.getNombre());
			pstmt.setString(5, elLibro.getCaracteristicas());
			if (elLibro.isCondicionEntrega())
				pstmt.setInt(6, 1);
			else
				pstmt.setInt(6, 0);
			if (elLibro.isCondicionRecibo())
				pstmt.setInt(7, 1);
			else
				pstmt.setInt(7, 0);
			pstmt.setString(8, elLibro.getFechaEntrega());
			pstmt.setInt(9, elLibro.getHoraEntrega());
			boolean resultado = pstmt.execute();
			if (resultado == true)
			{
				throw new NoDataException("No se realizo la inserción");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new GlobalException("Llave duplicada");
		}
		finally
		{
			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e)
			{
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
	}

	public void modificarLibro(libro elLibro) throws GlobalException, NoDataException
	{
		try
		{
			conectar();
		}
		catch (ClassNotFoundException e)
		{
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e)
		{
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conexion.prepareStatement(modificarLibro);
			pstmt.setString(1, elLibro.getId());
			pstmt.setString(2, elLibro.getEntrega());
			pstmt.setString(3, elLibro.getRecibe());
			pstmt.setString(4, elLibro.getNombre());
			pstmt.setString(5, elLibro.getCaracteristicas());
			if (elLibro.isCondicionEntrega())
				pstmt.setInt(6, 1);
			else
				pstmt.setInt(6, 0);
			if (elLibro.isCondicionRecibo())
				pstmt.setInt(7, 1);
			else
				pstmt.setInt(7, 0);
			pstmt.setString(8, elLibro.getFechaEntrega());
			pstmt.setInt(9, elLibro.getHoraEntrega());
			int resultado = pstmt.executeUpdate();

			//si es diferente de 0 es porq si afecto un registro o mas
			if (resultado != 0)
			{
				throw new NoDataException("No se realizo la actualización");
			}
			else
			{
				System.out.println("\nModificación Satisfactoria!");
			}
		}
		catch (SQLException e)
		{
			throw new GlobalException("Sentencia no valida");
		}
		finally
		{
			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e)
			{
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
	}

	public void eliminarLibros(String id) throws GlobalException, NoDataException
	{
		try
		{
			conectar();
		}
		catch (ClassNotFoundException e)
		{
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e)
		{
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conexion.prepareStatement(eliminarLibro);
			pstmt.setString(1, id);

			int resultado = pstmt.executeUpdate();

			if (resultado != 0)
			{
				throw new NoDataException("No se realizo el borrado");
			}
			else
			{
				System.out.println("\nEliminación Satisfactoria!");
			}
		}
		catch (SQLException e)
		{
			throw new GlobalException("Sentencia no valida");
		}
		finally
		{
			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e)
			{
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
	}
	public libro buscarLibro(String id) throws GlobalException, NoDataException
	{

		try
		{
			conectar();
		}
		catch (ClassNotFoundException e)
		{
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e)
		{
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		ResultSet rs = null;
		ArrayList coleccion = new ArrayList();
		libro elLibro = null;
		CallableStatement pstmt = null;
		try
		{
			pstmt = conexion.prepareCall(BUSCARID);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.setString(2, id);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next())
			{
				elLibro = new libro(rs.getString("id"),
									   rs.getString("entrega"),
									   rs.getString("recibe"),
									   rs.getString("nombre"),
									   rs.getString("caracteristicas"),
									   rs.getInt("condicionEntrega"),
									   rs.getInt("condicionRecibido"),
									   rs.getString("fechaEntrega"),
									   rs.getInt("horaEntrega"));
				coleccion.add(elLibro);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();

			throw new GlobalException("Sentencia no valida");
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (pstmt != null)
				{
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e)
			{
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
		if (coleccion == null || coleccion.size() == 0)
		{
			throw new NoDataException("No hay datos");
		}
		return elLibro;
	}

}