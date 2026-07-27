package com.sgpaf;

import com.sgpaf.dao.SeguimientoRequisitosDAO;
import com.sgpaf.modelo.SeguimientoRequisitos;
import com.sgpaf.util.CrearTabla;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CrearTabla.crearTablaSeguimientoRequisitos();

        SeguimientoRequisitosDAO dao = new SeguimientoRequisitosDAO();

        String documentoPrueba = "1000000099";

        dao.eliminarRegistroPorDocumento(documentoPrueba);

        SeguimientoRequisitos registro = new SeguimientoRequisitos();

        registro.setTipoDocumento("CC");
        registro.setNumeroDocumento(documentoPrueba);
        registro.setNombresApellidos("Registro de Prueba Eliminación");
        registro.setSemestre(8);
        registro.setCorreoInstitucional("prueba.eliminacion@correo.edu.co");
        registro.setCursoAcademico("Farmacia Hospitalaria y Comunitaria");
        registro.setGrupo("1");
        registro.setSitioPracticas("Hospital de prueba");

        dao.insertarRegistro(registro);

        System.out.println("REGISTROS ANTES DE ELIMINAR");
        System.out.println("--------------------------------------");
        mostrarRegistros(dao.consultarRegistros());

        dao.eliminarRegistroPorDocumento(documentoPrueba);

        System.out.println("REGISTROS DESPUÉS DE ELIMINAR");
        System.out.println("--------------------------------------");
        mostrarRegistros(dao.consultarRegistros());
    }

    private static void mostrarRegistros(List<SeguimientoRequisitos> registros) {
        for (SeguimientoRequisitos item : registros) {
            System.out.println("ID: " + item.getId());
            System.out.println("Documento: " + item.getTipoDocumento() + " " + item.getNumeroDocumento());
            System.out.println("Nombre: " + item.getNombresApellidos());
            System.out.println("Semestre: " + item.getSemestre());
            System.out.println("Correo: " + item.getCorreoInstitucional());
            System.out.println("Curso académico: " + item.getCursoAcademico());
            System.out.println("Grupo: " + item.getGrupo());
            System.out.println("Sitio de prácticas: " + item.getSitioPracticas());
            System.out.println("Estado ARL: " + item.getEstadoArl());
            System.out.println("Revisión monitor: " + item.getRevisionMonitor());
            System.out.println("Revisión docente: " + item.getRevisionDocente());
            System.out.println("Observaciones: " + item.getObservaciones());
            System.out.println("--------------------------------------");
        }
    }
}