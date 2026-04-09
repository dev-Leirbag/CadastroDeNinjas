package dev.java10x.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //? Anotação para indicar que esta classe é um serviço, responsável pela lógica de negócios da aplicação
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Lista ninja por ID
    public NinjaModel listarNinjasPorId(Long id) {
         Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja (NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar o ninja - tem que ser um metodo VOID
    public void deletarNinjaPorId (Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if(ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
