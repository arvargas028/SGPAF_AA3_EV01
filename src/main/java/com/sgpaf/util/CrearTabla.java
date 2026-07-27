package com.sgpaf.util;

import com.sgpaf.config.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

    private static final String SQL_CREAR_TABLA =
            "CREATE TABLE IF NOT EXISTS seguimiento_requisitos_practica (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "tipo_documento TEXT NOT NULL, " +
            "numero_documento TEXT NOT NULL UNIQUE, " +
            "nombres_apellidos TEXT NOT NULL, " +
            "semestre INTEGER NOT NULL, " +
            "correo_institucional TEXT NOT NULL, " +
            "curso_academico TEXT NOT NULL, " +
            "grupo TEXT NOT NULL, " +
            "sitio_practicas TEXT NOT NULL, " +
            "tetano_primera_dosis TEXT, " +
            "tetano_segunda_dosis TEXT, " +
            "tetano_tercera_dosis TEXT, " +
            "tetano_cuarta_dosis TEXT, " +
            "hepatitis_b_primera_dosis TEXT, " +
            "hepatitis_b_segunda_dosis TEXT, " +
            "hepatitis_b_tercera_dosis TEXT, " +
            "meningococo_primera_dosis TEXT, " +
            "meningococo_segunda_dosis TEXT, " +
            "menactra_dosis_unica TEXT, " +
            "fiebre_amarilla TEXT, " +
            "triple_viral TEXT, " +
            "influenza TEXT, " +
            "varicela_primera_dosis TEXT, " +
            "varicela_segunda_dosis TEXT, " +
            "prueba_antigenos TEXT, " +
            "covid_primera_dosis TEXT, " +
            "covid_segunda_dosis TEXT, " +
            "covid_tercera_dosis TEXT, " +
            "hepatitis_a_primera_dosis TEXT, " +
            "hepatitis_a_segunda_dosis TEXT, " +
            "tetano_difteria_tosferina TEXT, " +
            "hoja_vida TEXT, " +
            "estado_arl TEXT, " +
            "revision_monitor TEXT, " +
            "revision_docente TEXT, " +
            "observaciones TEXT" +
            ");";

    private CrearTabla() {
    }

    public static void crearTablaSeguimientoRequisitos() {
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement()) {

            statement.execute(SQL_CREAR_TABLA);
            System.out.println("Tabla seguimiento_requisitos_practica creada o verificada correctamente.");

        } catch (SQLException error) {
            System.out.println("Error al crear la tabla seguimiento_requisitos_practica: " + error.getMessage());
        }
    }
}