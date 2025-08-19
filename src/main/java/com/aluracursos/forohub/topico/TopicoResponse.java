package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.topico.StatusTopico;
import java.time.LocalDateTime;

public record TopicoResponse(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autor,
        String curso
) {}

