package io.github.yurilopess.libraryapi.repository;

import io.github.yurilopess.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

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

}
