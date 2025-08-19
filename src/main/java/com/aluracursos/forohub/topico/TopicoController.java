package com.aluracursos.forohub.topico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService service;

    // Crear un nuevo tópico
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicoResponse crear(@RequestBody @Valid TopicoRequest request) {
        return service.crear(request);
    }

    // Listar todos los tópicos
    @GetMapping
    public List<TopicoResponse> listar() {
        return service.listar();
    }

    // Detalle de un tópico por ID
    @GetMapping("/{id}")
    public TopicoResponse detalle(@PathVariable Long id) {
        return service.obtener(id);
    }

    // Actualizar un tópico existente
    @PutMapping("/{id}")
    public TopicoResponse actualizar(
            @PathVariable Long id,
            @RequestBody @Valid TopicoUpdateRequest request
    ) {
        return service.actualizar(id, request);
    }

    // Eliminar un tópico específico
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }



}
