package dev.java10x.CadastroDeNinjas.Missoes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissoesService {

    private final MissoesRepository missoesRepository;

    // Lista todas as minhas missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Lista as missoes por ID
    public MissoesModel listarMissoesPorId(long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        return missoesModel.orElse(null);
    }

    // Cria uma nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }
}
