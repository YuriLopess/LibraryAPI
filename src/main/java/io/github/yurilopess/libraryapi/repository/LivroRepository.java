package io.github.yurilopess.libraryapi.repository;

import io.github.yurilopess.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Autor, UUID> {

}
