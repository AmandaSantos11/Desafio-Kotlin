import kotlin.system.exitProcess

class Menus {
    private val compra = Compra()
    private val exibirProduto = ExibirProdutos()
    private val editarProduto = EditarProduto()

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
        exibirProduto.exibirLanches()
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Deseja comprar:\n1-X-burger | 2-X-salada")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarXBurguer()
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarXSalada()
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
        exibirProduto.exibirBebidas()
        var continuar=true
        var opcao:Int=0
        do {
            try {
                println("Deseja comprar:\n1-Refrigerante | 2-Suco")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarRefrigerante()
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarSuco()
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
        exibirProduto.exibirSobremesa()
        var continuar=true
        var opcao:Int=0
        do {
            try {
                println("Deseja comprar:\n1-Sorvete | 2-Banana Split")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { Compra.comprarSorvete()
                        Compra.exibirCarrinho()
                        menuPosCompra()}

                    2 -> { Compra.comprarBananaSplit()
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
                    2 -> { menuEditarProduto() }
                    3 -> { editarProduto.removerUmProdutoDoCarrinho() }
                    4 -> { menuPagamento()}
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuEditarProduto() {
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Você deseja:\n1-Adicionar quantidade | 2-Comprar extra")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { editarProduto.adicionarNovaQuantidadeEmUmProdutoDoCarrinho() }
                    2 -> { compra.comprarUmExtraParaUmProduto() }
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuPagamento(){
        Compra.exibirCarrinho()
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Formas de pagamento - digite a opção que deseja:\n1-Cartão de crédito | 2-Cartão de débito | 3-Vale-refeição | 4-Dinheiro")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        menuEncerrar() }
                    2 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        menuEncerrar() }
                    3 -> { println("Compra finalizada com sucesso! Boa refeição.")
                        menuEncerrar() }
                    4 -> { menuPagamentoEmDinheiro()
                        menuEncerrar()}
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuPagamentoEmDinheiro(){
        var continuar=true
        do {
            try {
                println("Digite a quantidade que deseja pagar em dinheiro:")
                var dinheiro = readln().toDouble()
                while (dinheiro<compra.getValorTotal()){
                    println("Quantidade de dinheiro inválida, digite novamente:")
                    dinheiro = readln().toDouble()
                }
                if (dinheiro>compra.getValorTotal()){
                    val troco = dinheiro-compra.getValorTotal()
                    println("Seu troco é de:R$$troco\nCompra finalizada com sucesso! Boa refeição.")
                    continuar=true
                }
            }catch (exeception:NumberFormatException){
                println("Mensagem: Para dinheiro, digite apenas numeros e ponto")
                continuar=false
            }
        }while (!continuar)
    }

    fun menuEncerrar(){
        var continuar = true
        do {
            try {
                println("\nVocê deseja:\n1-Nova compra | 2-Sair")
                val opcao = readln().toInt()
                when(opcao){
                    1 -> {
                        Compra.limparCarrinho()
                        Thread.sleep(1000)
                        Menus().menuPrincipal()}
                    2 -> {
                        println("Obrigado(a) por frequentar a Fazbear Lanchos!!")
                        exitProcess(0) }
                    else -> {
                        println("Opção inválida")
                        continuar=false
                    }
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher digite o número do item:")
                continuar=false
            }
        }while (!continuar)
    }
}