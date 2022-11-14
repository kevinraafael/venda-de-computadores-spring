package apsoo.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="pessoa")
public class Pessoa {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;




}