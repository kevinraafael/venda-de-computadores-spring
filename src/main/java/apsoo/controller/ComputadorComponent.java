package apsoo.controller;


import apsoo.entity.Computador;
import apsoo.entity.ItemVenda;
import apsoo.entity.Venda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


public class ComputadorComponent extends VBox {

    private ImageView imageView;

    private Label titulo;

    private Label valor;

    private Image imagem;

    private Button adicionarCarrinho;

    private Computador computador;

    private List<ItemVenda> itemVendaList = new ArrayList<ItemVenda>();


    public ComputadorComponent(String imageUrl, String titulo, String valor, Label total, Label quantidade, Computador computador) {
        super();
        // Set image
        this.imagem = new Image(getClass().getResource(imageUrl).toExternalForm());
        this.imageView = new ImageView(this.imagem);

        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        // Set values
        this.titulo = new Label(titulo);
        this.valor = new Label(valor.toString());

        this.adicionarCarrinho = new Button("Adicionar no carrinho");
        this.adicionarCarrinho.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                adicionarNoCarrinho(total, quantidade);
            }
        });

        // Add nodes into VBox
        this.getChildren().add(this.imageView);
        this.getChildren().add(this.titulo);
        this.getChildren().add(this.valor);
        this.getChildren().add(this.adicionarCarrinho);

        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
        this.computador = computador;
    }

    public void adicionarNoCarrinho(Label total, Label quantidade) {
        float valor = Float.parseFloat(this.valor.getText());
        float valorTotalAtual = Float.parseFloat(total.getText());
        String novoTotal = Float.toString(valor + valorTotalAtual);
        total.setText(novoTotal);
        int valorItensCarrinho = Integer.parseInt(quantidade.getText()) + 1;
        quantidade.setText(Integer.toString(valorItensCarrinho));

        try {
            PagamentoController.pagamento.setTipoPagamento("pix");
            PagamentoController.pagamento.setValorTotal(Double.valueOf(novoTotal));
            PagamentoController.pagamento.setParcelamento(0);
            PagamentoController.pagamento.setDesconto(0.0);
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setQtdVendida(1);
            itemVenda.setValorVendido(valor);
            itemVenda.setComputador(computador);
            //Adicionando item Venda nalista
            if(itemVendaList!=null){

                VendaController.itemVendaList.add(itemVenda);
            }

            //Adicionando a lista de itens venda em venda
            VendaController.venda.setItemVendas(itemVendaList);

        } catch (Error e) {
            System.out.println(e);
        }


    }

}