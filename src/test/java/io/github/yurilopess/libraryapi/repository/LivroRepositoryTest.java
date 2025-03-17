package io.github.yurilopess.libraryapi.repository;

import io.github.yurilopess.libraryapi.model.Autor;
import io.github.yurilopess.libraryapi.model.GeneroLivro;
import io.github.yurilopess.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void saveTest() {
        Livro livro = new Livro();

        livro.setIsbn("90887-84874");
        livro.setPreco(100);
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));
        Autor autor = autorRepository
                .findById(UUID.fromString("92195c39-6e55-4e41-8842-53bbd2561876"))
                .orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }
}