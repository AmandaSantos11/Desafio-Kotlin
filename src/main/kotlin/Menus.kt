class Menus {
    private val compra = Compra()

    fun menuPrincipal(){
        var opcao:Int=0
        do {
            try {
                println("\n====Bem-Vindo a Fazbear Lanchos====\nDeseja comprar:\n1-Lanche | 2-Bebida | 3-Sobremesa")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { menuLanche() }
                    2 -> { menuBebida() }
                    3 -> { menuSobremesa() }
                    else -> { println("Opção inválida, tente novamente") }
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher o item, você deve informar o número do item.")
            }
        }while (opcao != 3)
    }

    fun menuLanche(){
        compra.exibirLanches()
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Deseja comprar:\n1-X-burger | 2-X-salada")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarLanche(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarLanche(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher o item, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuBebida(){
        compra.exibirBebidas()
        var continuar=true
        var opcao:Int=0
        do {
            try {
                println("Deseja comprar:\n1-Refrigerante | 2-Suco")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarBebida(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarBebida(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher o item, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuSobremesa(){
        compra.exibirSobremesa()
        var continuar=true
        var opcao:Int=0
        do {
            try {
                println("Deseja comprar:\n1-Sorvete | 2-Banana Split")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarSobremesa(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarSobremesa(opcao)
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher o item, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuPosCompra(){
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Você deseja:\n1-Comprar mais itens | 2-Editar um item | 3-Remover um item | 4-Finalizar pedido")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { menuPrincipal() }
                    2 -> { compra.editarItem() }
                    3 -> { compra.removerItem() }
                    4 -> { formaDePagamento()}
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun formaDePagamento(){
        Compra.exibirCarrinho()
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Formas de pagamento - digite a opção que deseja:\n1-Cartão de crédito | 2-Cartão de débito | 3-Vale-refeição | 4-Dinheiro")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        compra.encerrar() }
                    2 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        compra.encerrar() }
                    3 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        compra.encerrar() }
                    4 -> { compra.pagamentoEmDinheiro()
                        compra.encerrar()}
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }
}