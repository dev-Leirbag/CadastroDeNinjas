package dev.java10x.CadastroDeNinjas.Missoes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissoesService {

    private final MissoesRepository missoesRepository;

    // Lista todas as minhas missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
}
