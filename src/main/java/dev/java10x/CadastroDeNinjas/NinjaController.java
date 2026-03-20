package dev.java10x.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //? Anotação para indicar que esta classe é um controlador REST
@RequestMapping //? Anotação para mapear as requisições HTTP para um caminho específico (neste caso, a raiz "/")
public class NinjaController {

    //TODO: Criar um metodo GET para retornar uma mensagem de boas-vindas

    @GetMapping("/boasvindas") //? Anotação para mapear as requisições GET para o caminho "/boasvindas"
    public String boasVindas() {
        return "Boas vindas, esse é o meu primeiro projeto em Java 10x, estou muito feliz por isso!";
    }
}
