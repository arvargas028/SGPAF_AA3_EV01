package com.sgpaf.dao;

import com.sgpaf.config.ConexionBD;
import com.sgpaf.modelo.SeguimientoRequisitos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeguimientoRequisitosDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO seguimiento_requisitos_practica (" +
            "tipo_documento, " +
            "numero_documento, " +
            "nombres_apellidos, " +
            "semestre, " +
            "correo_institucional, " +
            "curso_academico, " +
            "grupo, " +
            "sitio_practicas" +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT id, tipo_documento, numero_documento, nombres_apellidos, " +
            "semestre, correo_institucional, curso_academico, grupo, sitio_practicas, " +
            "estado_arl, revision_monitor, revision_docente, observaciones " +
            "FROM seguimiento_requisitos_practica";

    private static final String SQL_ACTUALIZAR_REVISION =
            "UPDATE seguimiento_requisitos_practica SET " +
            "estado_arl = ?, " +
            "revision_monitor = ?, " +
            "revision_docente = ?, " +
            "observaciones = ? " +
            "WHERE numero_documento = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM seguimiento_requisitos_practica " +
            "WHERE numero_documento = ?";

    public void insertarRegistro(SeguimientoRequisitos registro) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERTAR)) {

            sentencia.setString(1, registro.getTipoDocumento());
            sentencia.setString(2, registro.getNumeroDocumento());
            sentencia.setString(3, registro.getNombresApellidos());
            sentencia.setInt(4, registro.getSemestre());
            sentencia.setString(5, registro.getCorreoInstitucional());
            sentencia.setString(6, registro.getCursoAcademico());
            sentencia.setString(7, registro.getGrupo());
            sentencia.setString(8, registro.getSitioPracticas());

            sentencia.executeUpdate();

            System.out.println("Registro insertado correctamente.");

        } catch (SQLException error) {
            System.out.println("Error al insertar el registro: " + error.getMessage());
        }
    }

    public List<SeguimientoRequisitos> consultarRegistros() {
        List<SeguimientoRequisitos> registros = new ArrayList<>();

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(SQL_CONSULTAR);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                SeguimientoRequisitos registro = new SeguimientoRequisitos();

                registro.setId(resultado.getInt("id"));
                registro.setTipoDocumento(resultado.getString("tipo_documento"));
                registro.setNumeroDocumento(resultado.getString("numero_documento"));
                registro.setNombresApellidos(resultado.getString("nombres_apellidos"));
                registro.setSemestre(resultado.getInt("semestre"));
                registro.setCorreoInstitucional(resultado.getString("correo_institucional"));
                registro.setCursoAcademico(resultado.getString("curso_academico"));
                registro.setGrupo(resultado.getString("grupo"));
                registro.setSitioPracticas(resultado.getString("sitio_practicas"));
                registro.setEstadoArl(resultado.getString("estado_arl"));
                registro.setRevisionMonitor(resultado.getString("revision_monitor"));
                registro.setRevisionDocente(resultado.getString("revision_docente"));
                registro.setObservaciones(resultado.getString("observaciones"));

                registros.add(registro);
            }

        } catch (SQLException error) {
            System.out.println("Error al consultar los registros: " + error.getMessage());
        }

        return registros;
    }

    public void actualizarRevisionRequisitos(SeguimientoRequisitos registro) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(SQL_ACTUALIZAR_REVISION)) {

            sentencia.setString(1, registro.getEstadoArl());
            sentencia.setString(2, registro.getRevisionMonitor());
            sentencia.setString(3, registro.getRevisionDocente());
            sentencia.setString(4, registro.getObservaciones());
            sentencia.setString(5, registro.getNumeroDocumento());

            int filasActualizadas = sentencia.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Registro actualizado correctamente.");
            } else {
                System.out.println("No se encontró un registro con ese número de documento.");
            }

        } catch (SQLException error) {
            System.out.println("Error al actualizar el registro: " + error.getMessage());
        }
    }

    public void eliminarRegistroPorDocumento(String numeroDocumento) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(SQL_ELIMINAR)) {

            sentencia.setString(1, numeroDocumento);

            int filasEliminadas = sentencia.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Registro eliminado correctamente.");
            } else {
                System.out.println("No se encontró un registro con ese número de documento.");
            }

        } catch (SQLException error) {
            System.out.println("Error al eliminar el registro: " + error.getMessage());
        }
    }
}