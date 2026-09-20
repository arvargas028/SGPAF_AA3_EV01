package com.sgpaf.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InicioControllerTest {

    @Test
    void mostrarInicioDebeRetornarIndex() {

        InicioController controller =
                new InicioController();

        String resultado =
                controller.mostrarInicio();

        assertEquals(
                "index",
                resultado
        );
    }

    @Test
void mostrarFormularioDebeRetornarFormulario() {

    InicioController controller =
            new InicioController();

    org.springframework.ui.Model model =
            new org.springframework.ui.ConcurrentModel();

    String resultado =
            controller.mostrarFormulario(model);

    assertEquals(
            "formulario",
            resultado
    );
}
}