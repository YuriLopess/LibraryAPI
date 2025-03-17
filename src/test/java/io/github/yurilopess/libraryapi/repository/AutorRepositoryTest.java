package io.github.yurilopess.libraryapi.repository;

import io.github.yurilopess.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void saveTest() {
        Autor autor = new Autor();

        autor.setNome("Yuri Lopes");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2006, 4, 23));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);

    }

    @Test
    public void updateTest() {
        var id = UUID.fromString("92195c39-6e55-4e41-8842-53bbd2561876");

        Optional<Autor> possibleAutor = repository.findById(id);

        if (possibleAutor.isPresent()) {
            Autor autorEncontrado = possibleAutor.get();

            System.out.println("Dados do Autor");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));
        }
    }

    @Test
    public void listTest() {

        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);

    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores" + repository.count());

    }

    @Test
    public void deleteByIdTest() {
        var id = UUID.fromString("92195c39-6e55-4e41-8842-53bbd2561876");
        repository.deleteById(id);
    }
}
