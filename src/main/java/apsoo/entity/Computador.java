package apsoo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "computador")
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;


    private String modelo;

    private String processador;

    private String memoria;

    private String armazenamento;

    private String so;

    private Double valor;

    @Override
    public String toString() {
        String computadorInfo = "Modelo: " + getModelo() + "/n" + "Processador: " + getProcessador() + "\n"
                + "Memória: " + getMemoria() + "Armazenamento: " + getArmazenamento() + " SO: " + getSo()+
                " Valor: R$ "+getValor() +"\n";
        return computadorInfo;
    }

}
