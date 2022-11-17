# venda-de-computadores-spring

# Notes

## Spring

ajuda na injeção de dependências
ele traz muitos componentes inclusive o JPA
que nos ajuda a fazer o mapeamento das entidades e
permite que criamos os repositórios.

## JavaFx e Swing

JavaFx é perfeito pro padrão MVC e o objetivo dele é desacoplar design
das interfaces com os usuários dos códigos de resposta à eventos.

Swing - Smat widgets e voltado totalmente para desktop
AWT cria um padrão de interface e outras implementações suprem esse padrão
como o swing.
POM == project object model

# Estrutura do JavaFx

Stage -> representa uma janela
Stage seria como se fosse um palco.
Uma mesma janela pode conter diversas cenas que podem ser alternadas
É Recomendável ter uma stage e ir mudando os seus conteúdos(cenas).

Scene -> representa os conteúdos de uma Stage
Cena é a tela onde vou desenhar os componentes, cada stage pode ter mais de uma cena.
seguindo a ideia do palco de teatro,varias cenas mudam ao longe de uma apresentação.

## Hierarquia de Componentes

Node -> são os componentes visuais (botões, caixas de texto)
Esses componentes podem conter outros componentes, como os painéis
e layouts.
Layouts exemplos:

        -> Pane : caixa cinza para outros componentes
        - > Hbox: coloca os componentes na horizontal
        -> Vbox: coloca os componentes na vertical

    Controles exemplos:
        -> Button,Text Field,TextArea,PasswordField,Label

    Caixas de dialogo
    Compontens gráficos e de multimidia.

# FXML

Representa as views e são arquivos xml das definições das cenas.
Aceitam estilos e CSS s scripts JS para os eventos da própria interface.
O fxml é basicamente para tratar os componentes visuais (nodes) e seus layouts.
Todos os arquvios xmls tem que ser salvos dentro de resources

# Scene builder

é uma ferramenta visual para o desenho das ccenas
a edição é visual e o arquivo é salvo no formato .fxml

# Controladores

Classes java responsáveis por responder eventos gerados pelas views e
adicionar comportamentos dinamicos.
@fxml -> anotação que faz o mapeamento entre o controlador e a view.

# Componentização com javaFX
 por meio do comando abaixo podemos incluir um outro arquivo xml dentro de outro
 Isso é interessante para trabalhar com componentes.
 Um exemplo seria a header da página com o tipico menu 
 <fx:include source ="meuComponent.fxml"/>