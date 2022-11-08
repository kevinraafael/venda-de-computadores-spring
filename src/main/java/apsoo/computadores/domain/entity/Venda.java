package apsoo.computadores.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)

//    @OneToOne
//    @JoinColumn(name = "forma_pagamento")
//    private Pagamento formaPagemnto;
//
//    @OneToOne
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;
//
//    @OneToOne
//    @JoinColumn(name = "funcionario_id")
//    private Funcionario funcionario;
    private int codigo;


    private Double valor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

//    public Pagamento getFormaPagemnto() {
//        return formaPagemnto;
//    }

//    public void setFormaPagemnto(Pagamento formaPagemnto) {
//        this.formaPagemnto = formaPagemnto;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Funcionario getFuncionario() {
//        return funcionario;
//    }
//
//    public void setFuncionario(Funcionario funcionario) {
//        this.funcionario = funcionario;
//    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
