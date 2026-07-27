package com.sgpaf.modelo;

public class SeguimientoRequisitos {

    private int id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombresApellidos;
    private int semestre;
    private String correoInstitucional;
    private String cursoAcademico;
    private String grupo;
    private String sitioPracticas;
    private String estadoArl;
    private String revisionMonitor;
    private String revisionDocente;
    private String observaciones;

    public SeguimientoRequisitos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSitioPracticas() {
        return sitioPracticas;
    }

    public void setSitioPracticas(String sitioPracticas) {
        this.sitioPracticas = sitioPracticas;
    }

    public String getEstadoArl() {
        return estadoArl;
    }

    public void setEstadoArl(String estadoArl) {
        this.estadoArl = estadoArl;
    }

    public String getRevisionMonitor() {
        return revisionMonitor;
    }

    public void setRevisionMonitor(String revisionMonitor) {
        this.revisionMonitor = revisionMonitor;
    }

    public String getRevisionDocente() {
        return revisionDocente;
    }

    public void setRevisionDocente(String revisionDocente) {
        this.revisionDocente = revisionDocente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}