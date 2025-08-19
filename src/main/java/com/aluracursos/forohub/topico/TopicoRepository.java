package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.topico.StatusTopico;
import com.aluracursos.forohub.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Verificar si ya existe un tópico con el mismo título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    // Opcionales: métodos para listar con criterios

    // Obtener los 10 primeros tópicos ordenados por fecha de creación
    List<Topico> findTop10ByOrderByFechaCreacionAsc();

    // Filtrar por curso y rango de fechas
    List<Topico> findByCursoAndFechaCreacionBetween(String curso, java.time.LocalDateTime inicio, java.time.LocalDateTime fin);
}