package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.topico.StatusTopico;
import jakarta.validation.constraints.NotBlank;

public record TopicoUpdateRequest(
        String mensaje,
        StatusTopico status
) {}

