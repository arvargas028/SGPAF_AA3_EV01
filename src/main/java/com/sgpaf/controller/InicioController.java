package com.sgpaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgpaf.dao.SeguimientoRequisitosDAO;
import com.sgpaf.modelo.SeguimientoRequisitos;
import com.sgpaf.util.CrearTabla;


/**
 * Controlador inicial del módulo web SGPAF.
 * 
 * Esta clase permite verificar que Spring Boot está funcionando
 * y que el navegador puede comunicarse con la aplicación.
 */

@Controller
public class InicioController {

    @GetMapping("/")
    public String mostrarInicio() {
        return "index";
    }

    @GetMapping ("/formulario")
    public String mostrarFormulario(){
        return "formulario";
    }

    /**
     * Recibe los datos enviados desde el formulario web
     * y los guarda en la base de datos mediante el DAO.
     */

    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute SeguimientoRequisitos registro) {
        CrearTabla.crearTablaSeguimientoRequisitos();

        SeguimientoRequisitosDAO dao = new SeguimientoRequisitosDAO();
        dao.insertarRegistro(registro);

        return "redirect:/listado";
    }

    /**
     * Consulta los registros guardados en la base de datos
     * y los envía a la página listado.html para mostrarlos.
     */
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        CrearTabla.crearTablaSeguimientoRequisitos();

        SeguimientoRequisitosDAO dao = new SeguimientoRequisitosDAO();
        List<SeguimientoRequisitos> registros = dao.consultarRegistros();

        model.addAttribute("registros", registros);

        return "listado";
    }
}