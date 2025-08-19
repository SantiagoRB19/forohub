package com.aluracursos.forohub.topico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository repository;

    // Crear tópico con validación de duplicados
    @Transactional
    public TopicoResponse crear(TopicoRequest req) {
        boolean existe = repository.existsByTituloAndMensaje(req.titulo(), req.mensaje());
        if (existe) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
        }

        Topico t = Topico.builder()
                .titulo(req.titulo())
                .mensaje(req.mensaje())
                .autor(req.autor())
                .curso(req.curso())
                .build();

        t = repository.save(t);
        return toResponse(t);
    }

    // Listar todos los tópicos
    @Transactional(readOnly = true)
    public List<TopicoResponse> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // Obtener un tópico por ID
    @Transactional(readOnly = true)
    public TopicoResponse obtener(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado: " + id));
    }

    // Actualizar un tópico existente
    @Transactional
    public TopicoResponse actualizar(Long id, TopicoUpdateRequest req) {
        Topico t = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado: " + id));

        if (req.mensaje() != null && !req.mensaje().isBlank()) t.setMensaje(req.mensaje());
        if (req.status() != null) t.setStatus(req.status());

        return toResponse(t);
    }

    // Eliminar un tópico
    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado: " + id);
        }
        repository.deleteById(id);
    }

    // Convertir entidad Topico a DTO TopicoResponse
    private TopicoResponse toResponse(Topico t) {
        return new TopicoResponse(
                t.getId(),
                t.getTitulo(),
                t.getMensaje(),
                t.getFechaCreacion(),
                t.getStatus(),
                t.getAutor(),
                t.getCurso()
        );
    }
}
