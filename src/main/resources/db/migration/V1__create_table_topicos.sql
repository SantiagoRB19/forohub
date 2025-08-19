CREATE TABLE IF NOT EXISTS topicos (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo          VARCHAR(255) NOT NULL,
    mensaje         TEXT NOT NULL,
    fecha_creacion  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status          VARCHAR(50) NOT NULL,
    autor           VARCHAR(100) NOT NULL,
    curso           VARCHAR(100) NOT NULL
);

CREATE INDEX idx_topicos_status ON topicos(status);
CREATE INDEX idx_topicos_autor ON topicos(autor);
CREATE INDEX idx_topicos_curso ON topicos(curso);