# Desafio - Kotlin

*Nesse desafio o objetivo era desenvolver um totem de auto-atendimento de uma lanchonete.*

<hr>

**A regra de negócio era:**

+ **Ter um sistema que:**
  + Ter um menu que mostre as opções que o cliente pode comprar;
  + Quando o cliente escolher uma opção que não existe ou digitar algo diferente do esperado, deve ser mostrado uma mensagem de aviso e permitir que o cliente digite novamente;
  + Após o cliente escolher o pedido, deve ser mostrado a informação do mesmo junto com o valor total da compra;
  + Quando o cliente decidir finalizar a compra, deve mostrar as formas de pagamento e encerrar o programa.

<hr>

+ Iniciei o desafio desenvolvendo uma classe nomeada ‘Produtos’ com os atributos 'codigo:Int', 'nome:String', 'preco:Double' e 'quantidade:Int', no mesmo arquivo criei mais uma classe nomeada 'Extra' que é responsável por sete variáveis que representam um ingrediente adicional que o cliente pode escolher comprar.


+  Em seguida desenvolvi a classe 'Menus', que é resposável por todos os menus que interagem com o cliente.


+ Após isso, desenvolvi uma classe ‘Compra’ que contém os seguintes métodos:

  + ‘exibirLanches’ - serve para exibir todos os lanches disponíveis, juntando com o seu preço e descrição.

  + ‘exibirBebidas’ - faz o mesmo que o método anterior só que para bebidas.

  + ‘exibirSobremesas’ - faz o mesmo que o método anterior só que para sobremesas.

  + ‘comprarLanche’ - gera os objetos do tipo 'XBurger' ou 'XSalada' dependendo da escolha do cliente e adiciona no hashmap carrinho.

  + ‘comprarBebida’ - faz o mesmo que o método anterior só que com os objetos 'Refrigerante' e 'Suco'.

  + ‘comprarSobremesa’ - faz o mesmo que o método anterior só que com os objetos 'Sorvete' e 'Banana Split'.

  + ‘exibirCarrinho’ - exibe o carrinho com os itens que o cliente comprou.

  + ‘editarItem’ - permite o cliente editar os itens que tem no carrinho,seja alterando a quantidade ou adicionando um extra ao pedido.

  + ‘removerItem’ - permite o cliente remover um produto do carrinho digitando o código do mesmo.


+ Além disso, essa classe também conta com mais um método nomeado 'pagamentoEmDinheiro()', que serve para mostrar o troco ao cliente caso ele escolha pagar a compra com dinheiro e tenha digitado um valor maior que o valor total da compra.

<hr>

# Conclusão

Com este desafio pude exercitar e fixar com os conhecimentos adquiridos nas aulas sobre Kotlin. 