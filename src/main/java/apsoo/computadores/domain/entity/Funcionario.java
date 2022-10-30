package apsoo.computadores.domain.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime data_contratacao;
    private Long comissao;
    private  boolean pf_gerencia;
    private UUID pessoaid;
}