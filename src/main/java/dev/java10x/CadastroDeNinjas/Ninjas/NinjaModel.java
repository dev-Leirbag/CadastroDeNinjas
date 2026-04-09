package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

//? Entity ele transforma a classe em uma entidade do banco de dados.
@Entity
//? Table ele mapeia a classe para uma tabela no banco de dados, e o nome da tabela é "ninjas".
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    //? Id ele indica que o campo id é a chave primária da tabela.
    @Id
    //? GeneratedValue ele indica que o valor do campo id será gerado automaticamente pelo banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //? @ManyToOne = um ninja pode ter uma unica missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // FK ou Chave Estrangeira
    private MissoesModel missoes;
}