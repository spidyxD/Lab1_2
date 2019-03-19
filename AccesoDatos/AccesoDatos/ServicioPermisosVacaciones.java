package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import logicaNegocio.permisosVacaciones;
import oracle.jdbc.driver.OracleTypes;
/**
 *
 * @author Estudiante
 */
public class ServicioPermisosVacaciones extends Servicio
{

	private static final String insertarPermisosVacaciones = "{call insertarPermisosVacaciones(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private static final String LISTAR = "{?=call listarpermisosVacaciones()}";
	private static final String BUSCARID = "{?=call buscarpermisosVacaciones(?)}";
	private static final String modificarPermisosVacaciones = "{call modificarpermisosVacaciones(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private static final String eliminarPermisosVacaciones = "{call eliminarpermisosVacaciones(?)}";

	/** Creates a new instance of ServicioLibro */
	public ServicioPermisosVacaciones()
	{
	}

	public Collection listarPermisosVacaciones() throws GlobalException, NoDataException
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
		int aux=0;boolean auxb=false;
		boolean auxc=false;
		ResultSet rs = null;
		ArrayList coleccion = new ArrayList();
		permisosVacaciones elPermiso = null;
		CallableStatement pstmt = null;
		try
		{
			pstmt = conexion.prepareCall(LISTAR);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next())
			{

				aux=rs.getInt("aprobadoLider");
				if(aux==1){auxb=true;}
				aux=rs.getInt("aprobadoGerencia");
				if(aux==1){auxc=true;}
				elPermiso = new permisosVacaciones(rs.getString("id"),
									   rs.getInt("boletaPermisos"),
									   rs.getInt("boletaVacaciones"),
									   rs.getString("funcionario"),
									   rs.getString("cedulaFuncionario"),
									   rs.getString("fechaSolicitud"),
									   rs.getString("diaSolicitado"),
									   rs.getInt("horasSolicitadas"),
									   rs.getString("motivo"),auxb,auxc,
									   rs.getString("fechaAprobacion"),
									   rs.getString("justNoAprob"));
				coleccion.add(elPermiso);
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
	public void insertarPermisosVacaciones(permisosVacaciones elPermiso) throws GlobalException, NoDataException
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
			 
			pstmt = conexion.prepareCall(insertarPermisosVacaciones);
			pstmt.setString(1, elPermiso.getId());
			pstmt.setInt(2, elPermiso.getBoletaPermisos());
			pstmt.setInt(3, elPermiso.getBoletaVacaciones());
			pstmt.setString(4, elPermiso.getFuncionario());
			pstmt.setString(5, elPermiso.getCedulaFuncionario());
			pstmt.setString(6, elPermiso.getFechaSolicitud());
			pstmt.setString(7, elPermiso.getCedulaFuncionario());
			pstmt.setString(8, elPermiso.getFechaSolicitud());
			pstmt.setString(9, elPermiso.getDiaSolicitado());
			pstmt.setInt(10, elPermiso.getHorasSolicitadas());
			pstmt.setString(11, elPermiso.getMotivo());
			if (elPermiso.isAprobadoLider())
				pstmt.setInt(12, 1);
			else
				pstmt.setInt(12, 0);
			if (elPermiso.isAprobadoGerencia())
				pstmt.setInt(13, 1);
			else
				pstmt.setInt(13, 0);
			pstmt.setString(14, elPermiso.getFechaAprobacion());
			pstmt.setString(15, elPermiso.getJustNoAprob());
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

	public void modificarPermisosVacaciones(permisosVacaciones elPermiso) throws GlobalException, NoDataException
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
			pstmt = conexion.prepareStatement(modificarPermisosVacaciones);
			pstmt.setString(1, elPermiso.getId());
			pstmt.setInt(2, elPermiso.getBoletaPermisos());
			pstmt.setInt(3, elPermiso.getBoletaVacaciones());
			pstmt.setString(4, elPermiso.getFuncionario());
			pstmt.setString(5, elPermiso.getCedulaFuncionario());
			pstmt.setString(6, elPermiso.getFechaSolicitud());
			pstmt.setString(7, elPermiso.getCedulaFuncionario());
			pstmt.setString(8, elPermiso.getFechaSolicitud());
			pstmt.setString(9, elPermiso.getDiaSolicitado());
			pstmt.setInt(10, elPermiso.getHorasSolicitadas());
			pstmt.setString(11, elPermiso.getMotivo());
			if (elPermiso.isAprobadoLider())
				pstmt.setInt(12, 1);
			else
				pstmt.setInt(12, 0);
			if (elPermiso.isAprobadoGerencia())
				pstmt.setInt(13, 1);
			else
				pstmt.setInt(13, 0);
			pstmt.setString(14, elPermiso.getFechaAprobacion());
			pstmt.setString(15, elPermiso.getJustNoAprob());
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

	public void eliminarPermisosVacaciones(String id) throws GlobalException, NoDataException
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
			pstmt = conexion.prepareStatement(eliminarPermisosVacaciones);
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
	public permisosVacaciones buscarPermisoVacaciones(String id) throws GlobalException, NoDataException
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
		permisosVacaciones elPermiso = null;
		CallableStatement pstmt = null;
		int aux=0;
		boolean auxb=false;
		boolean auxc=false;
		try
		{
			pstmt = conexion.prepareCall(BUSCARID);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.setString(2, id);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next())
			{aux=rs.getInt("aprobadoLider");
				if(aux==1){auxb=true;}
				aux=rs.getInt("aprobadoGerencia");
				if(aux==1){auxc=true;}
				elPermiso = new permisosVacaciones(rs.getString("id"),
									   rs.getInt("boletaPermisos"),
									   rs.getInt("boletaVacaciones"),
									   rs.getString("funcionario"),
									   rs.getString("cedulaFuncionario"),
									   rs.getString("fechaSolicitud"),
									   rs.getString("diaSolicitado"),
									   rs.getInt("horasSolicitadas"),
									   rs.getString("motivo"),auxb,auxc,
									   rs.getString("fechaAprobacion"),
									   rs.getString("justNoAprob"));
				coleccion.add(elPermiso);
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
		return elPermiso;
	}

}