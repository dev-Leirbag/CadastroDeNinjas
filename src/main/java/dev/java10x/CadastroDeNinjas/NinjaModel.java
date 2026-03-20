package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;

//? Entity ele transforma a classe em uma entidade do banco de dados.
@Entity
//? Table ele mapeia a classe para uma tabela no banco de dados, e o nome da tabela é "ninjas".
@Table(name = "tb_cadastro")
public class NinjaModel {

    //? Id ele indica que o campo id é a chave primária da tabela.
    @Id
    //? GeneratedValue ele indica que o valor do campo id será gerado automaticamente pelo banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
