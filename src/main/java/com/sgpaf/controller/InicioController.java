package com.sgpaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sgpaf.dao.SeguimientoRequisitosDAO;
import com.sgpaf.modelo.SeguimientoRequisitos;
import com.sgpaf.util.CrearTabla;

/**
 * Controlador inicial del módulo web SGPAF.
 *
 * Esta clase permite mostrar las vistas del sistema,
 * recibir la información del formulario, validar los datos
 * y consultar los registros almacenados en la base de datos.
 */
@Controller
public class InicioController {

    @GetMapping("/")
    public String mostrarInicio() {
        return "index";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {

        model.addAttribute(
                "registro",
                new SeguimientoRequisitos()
        );

        return "formulario";
    }

    /**
     * Recibe los datos enviados desde el formulario,
     * valida el correo institucional y verifica que
     * el número de documento no esté duplicado.
     */
    @PostMapping("/guardar")
    public String guardarRegistro(
            @ModelAttribute SeguimientoRequisitos registro,
            Model model) {

        String correo = registro.getCorreoInstitucional();

        if (correo == null
                || !correo.matches(
                        "^[A-Za-z0-9._%+-]+@mail[.]uniatlantico[.]edu[.]co$")) {

            model.addAttribute(
                    "mensajeError",
                    "El correo debe pertenecer al dominio institucional "
                    + "@mail.uniatlantico.edu.co"
            );

            model.addAttribute("registro", registro);

            return "formulario";
        }

        CrearTabla.crearTablaSeguimientoRequisitos();

        SeguimientoRequisitosDAO dao =
                new SeguimientoRequisitosDAO();

        if (dao.existeDocumento(
                registro.getNumeroDocumento())) {

            model.addAttribute(
                    "mensajeError",
                    "El número de documento ya se encuentra registrado."
            );

            model.addAttribute("registro", registro);

            return "formulario";
        }

        dao.insertarRegistro(registro);

        return "redirect:/listado";
    }

    /**
     * Consulta los registros almacenados y los envía
     * a la página listado.html.
     */
    @GetMapping("/listado")
    public String mostrarListado(Model model) {

        CrearTabla.crearTablaSeguimientoRequisitos();

        SeguimientoRequisitosDAO dao =
                new SeguimientoRequisitosDAO();

        List<SeguimientoRequisitos> registros =
                dao.consultarRegistros();

        model.addAttribute("registros", registros);

        return "listado";
    }

         @GetMapping("/eliminar/{documento}")
        public String eliminarRegistro(
        @PathVariable("documento") String documento) {

    SeguimientoRequisitosDAO dao =
            new SeguimientoRequisitosDAO();

    dao.eliminarRegistroPorDocumento(documento);

    return "redirect:/listado";
    }

    @GetMapping("/editar/{documento}")
public String mostrarFormularioEdicion(
        @PathVariable("documento") String documento,
        Model model) {

    SeguimientoRequisitosDAO dao =
            new SeguimientoRequisitosDAO();

    SeguimientoRequisitos registro =
            dao.buscarPorDocumento(documento);

    if (registro == null) {
        return "redirect:/listado";
    }

    model.addAttribute(
            "registro",
            registro
    );

    return "editar";
}

@PostMapping("/actualizar")
public String actualizarRegistro(
        @ModelAttribute SeguimientoRequisitos registro) {

    SeguimientoRequisitosDAO dao =
            new SeguimientoRequisitosDAO();

    dao.actualizarRevisionRequisitos(registro);

    return "redirect:/listado";
}

}