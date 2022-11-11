package apsoo.computadores.domain.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity

@Table(name="funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String matricula;
    private Date data_contratacao;
    private Double comissao;
    private  boolean pf_gerencia;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

}