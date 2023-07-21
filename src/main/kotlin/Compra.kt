import kotlin.system.exitProcess

class Compra {
    fun exibirLanches() {
        println("====Nossos lanches====")
        println("Lanche: X-burger\nDescrição: Hambúrguer bovino com queijo prato,tomate,alface e maionese.\nPreço: R$10.00\n")
        println("Lanche: X-salada\nDescrição: Hambúrguer bovino com queijo prato,tomate,alface,maionese e ovo.\nPreço: R$12.00\n---------------------")
    }

    fun exibirBebidas() {
        println("====Nossas Bebidas====")
        println("Bebida: Refrigerante\nDescrição: Coca-cola\nPreço: R$8.00\n")
        println("Bebida: Suco\nDescrição: Suco de laranja\nPreço: R$6.00\n---------------------")
    }

    fun exibirSobremesa() {
        println("====Nossas Sobremesas====")
        println("Sobremesa: Sorvete\nDescrição: Soverte de chocolate no pote, 300ml.\nPreço: R$9.00\n")
        println("Sobremesa: Banana Split\nDescrição: Banana com calda de chocolate,amendoim e uma bola de sorvete de baunilha.\nPreço: R$15.00\n---------------------")
    }

    companion object{
        private var contadorXBurger = 100
        private var contadorXSalada = 200
        private var contadorRefrigerante = 300
        private var contadorSuco = 400
        private var contadorSorvete = 500
        private var contadorBanana = 600

        private var carrinho = mutableMapOf<Int,MutableList<Produto>>()
        private var valorTotal = 0.0

        fun comprarLanche(opcao: Int) {
            var quantidade: Int = 0
            println("Digite a quantidade que deseja comprar:")
            do {
                try {
                    quantidade = readln().toInt()
                    while (quantidade <= 0) {
                        println("Quantidade inválida, digite novamente:")
                        quantidade = readln().toInt()
                    }
                } catch (exception: NumberFormatException) {
                    println("Formato inválido, para quantidade digite um número inteiro:")
                }
                if (opcao == 1) {
                    for (i in 1..quantidade){
                        contadorXBurger += 1
                        val listaXBurger = mutableListOf(Produto(contadorXBurger,"X-burger",10.00,1,extra = Extra()))
                        carrinho[contadorXBurger] = listaXBurger
                    }
                    valorTotal += 10.00 * quantidade
                }
                else if (opcao==2){
                    for (i in 1..quantidade){
                        contadorXSalada += 1
                        val listaXSalada = mutableListOf(Produto(contadorXSalada,"X-salada",12.00,1,extra = Extra()))
                        carrinho[contadorXSalada] = listaXSalada
                    }
                    valorTotal += 12.00*quantidade
                }
            } while (quantidade == 0)
        }

        fun comprarBebida(opcao:Int){
            var quantidade: Int = 0
            println("Digite a quantidade que deseja comprar:")
            do {
                try {
                    quantidade = readln().toInt()
                    while (quantidade <= 0) {
                        println("Quantidade inválida, digite novamente:")
                        quantidade = readln().toInt()
                    }
                } catch (exception: NumberFormatException) {
                    println("Formato inválido, para quantidade digite um número inteiro:")
                }
                if (opcao == 1) {
                    for (i in 1..quantidade){
                        contadorRefrigerante++
                        var listaRefrigerante = mutableListOf(Produto(contadorRefrigerante,"Refrigerante",8.00,1,extra = Extra()))
                        carrinho[contadorRefrigerante] = listaRefrigerante
                    }
                    valorTotal += 8.00 * quantidade
                }
                else if (opcao==2){
                    for (i in 1..quantidade){
                        contadorSuco++
                        var listaSuco = mutableListOf(Produto(contadorSuco,"Suco",6.00,1,extra = Extra()))
                        carrinho[contadorSuco] = listaSuco
                    }
                    valorTotal += 6.00*quantidade
                }
            } while (quantidade == 0)
        }

        fun comprarSobremesa(opcao:Int){
            var quantidade: Int = 0
            println("Digite a quantidade que deseja comprar:")
            do {
                try {
                    quantidade = readln().toInt()
                    while (quantidade <= 0) {
                        println("Quantidade inválida, digite novamente:")
                        quantidade = readln().toInt()
                    }
                } catch (exception: NumberFormatException) {
                    println("Formato inválido, para quantidade digite um número inteiro:")
                }
                if (opcao == 1) {
                    for (i in 1..quantidade){
                        contadorSorvete++
                        var listaSorvete = mutableListOf(Produto(contadorSorvete,"Sorvete",9.00,1,extra = Extra()))
                        carrinho[contadorSorvete] = listaSorvete
                    }
                    valorTotal += 9.00 * quantidade
                }
                else if (opcao==2){
                    for (i in 1..quantidade){
                        contadorBanana++
                        var listaBanana = mutableListOf(Produto(contadorBanana,"Banana Split",15.00,1,extra = Extra()))
                        carrinho[contadorBanana] = listaBanana
                    }
                    valorTotal += 15.00*quantidade
                }
            } while (quantidade == 0)
        }

        fun exibirCarrinho() {
            println("===========Carrinho===========")
            for ((chave,valor) in carrinho){
                for (item in valor){
                    println("Codigo:$chave | Nome:${item.nome} | Quantidade:${item.quantidade} | Extras:${item.extra.toString()}")
                }
            }
            println("\nValor total: R$$valorTotal\n--------------------------")
        }

        fun limparCarrinho(){
            carrinho.clear()
            valorTotal = 0.0
        }
    }

    fun editarItem() {
        var opcao:Int=0
        var continuar = true
        do {
            try {
                println("Você deseja:\n1-Adicionar quantidade | 2-Comprar extra")
                opcao = readln().toInt()
                when(opcao){
                    1 -> { adicionarQuantidade() }
                    2 -> { extra() }
                    else -> { println("Opção inválida, tente novamente\n")
                        continuar=false}
                }
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, para escolher, você deve informar o número do item.\n")
                continuar=false
            }
        }while (!continuar)
    }

    fun adicionarQuantidade() {
        var continuar = true
        do {
            try {
                println("\nDigite o código do produto que deseja editar:")
                val codigo = readln().toIntOrNull()
                if (codigo!=null){
                    if (carrinho.containsKey(codigo)) {
                        val listaAlterada = carrinho[codigo]!!
                        println("Digite a quantidade que deseja alterar:")
                        val qntd = readln().toInt()
                        while (qntd<=0){
                            println("Quantidade inválida, digite novamente:")
                        }
                        val produto = listaAlterada.find { it.codigo == codigo }
                        if (produto != null) {
                            produto.quantidade += qntd
                            valorTotal += produto.preco*qntd
                            println("Carrinho atualizado!\n")
                            exibirCarrinho()
                            Menus().menuPosCompra()
                        }else{
                            println("Não existe produto com esse código!\n")
                            Menus().menuPosCompra()}
                    }else{
                        println("Não existe produto com esse código!\n")
                        Menus().menuPosCompra()}
                } else{
                    println("Código inválido")
                    continuar=false}

            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, digite apenas números")
                continuar=false
            }
        }while (!continuar)
    }

    fun removerItem(){
        var continuar = true
        do {
            try {
                println("\nDigite o código do produto que deseja remover:")
                val codigo = readln().toIntOrNull()
                if (codigo!=null){
                    if (carrinho.containsKey(codigo)) {
                        val listaAlterada = carrinho[codigo]!!
                        val produto = listaAlterada.find { it.codigo == codigo }
                        if (produto != null) {
                            valorTotal -= produto.preco
                        }
                        carrinho.remove(codigo)
                        println("Carrinho atualizado!\n")
                        exibirCarrinho()
                        Menus().menuPosCompra()
                    }
                    else{ println("Não existe produto com esse código!\n")
                        Menus().menuPosCompra() }
                } else{
                    println("Código inválido")
                    continuar=false}
            }catch (exception:NumberFormatException){
                println("Mensagem: Formato inválido, digite apenas números")
                continuar=false
            }
        }while (!continuar)
    }

    fun extra(){
        try {
            val valorExtra = 2.0
            println("\nDigite o código do produto que deseja editar:")
            var codigo = readln().toIntOrNull()
            if (codigo!=null){
                if (carrinho.containsKey(codigo)){
                    val listaAlterada = carrinho[codigo]!!
                    val produto = listaAlterada.find { it.codigo == codigo }

                    println("====EXTRAS====\nTodos os extras custam R$2.00\nDigite o extra que deseja:")
                    println("1-Tomate | 2-Cebola | 3-Queijo Cheddar | 4-Picles | 5-Gelo | 6-Morango | 7-Leite ninho em pó")

                    if (produto!=null){
                        val op = readln().toInt()
                        when(op){
                            1 -> {produto.extra.tomate+="Tomate"}
                            2 -> {produto.extra.cebola+="Cebola"}
                            3 -> {produto.extra.queijo+="Queijo Cheddar"}
                            4 -> {produto.extra.picles+="Picles"}
                            5 -> {produto.extra.gelo+="Gelo"}
                            6 -> {produto.extra.morango+="Morango"}
                            7 -> {produto.extra.leiteNinho+="Leite ninho em pó"}
                            else -> {
                                println("Opção inválida!")
                                Menus().menuPosCompra()}
                        }
                        valorTotal += valorExtra
                        println("Carrinho atualizado!\n")
                        exibirCarrinho()
                        Menus().menuPosCompra()
                    }else{
                        println("Não existe produto com esse código!")
                        Menus().menuPosCompra()}
                }else{
                    println("Não existe produto com esse código!")
                    Menus().menuPosCompra()}
            }
            else{
                println("Código inválido")
                Menus().menuPosCompra()}
        }catch (exception:NumberFormatException){
            println("Mensagem: Formato inválido, digite apenas números\n")
            Menus().menuPosCompra() }
    }

    fun pagamentoEmDinheiro(){
        var continuar=true
        do {
            try {
                println("Digite a quantidade que deseja pagar em dinheiro:")
                var dinheiro = readln().toDouble()
                while (dinheiro<valorTotal){
                    println("Quantidade de dinheiro inválida, digite novamente:")
                    dinheiro = readln().toDouble()
                }
                if (dinheiro>valorTotal){
                    val troco = dinheiro-valorTotal
                    println("Seu troco é de:R$$troco\nCompra finalizada com sucesso! Boa refeição.")
                    continuar=true
                }
            }catch (exeception:NumberFormatException){
                println("Mensagem: Para dinheiro, digite apenas numeros e ponto")
                continuar=false
            }
        }while (!continuar)
    }

    fun encerrar(){
        var continuar = true
        do {
            try {
                println("\nVocê deseja:\n1-Nova compra | 2-Sair")
                val opcao = readln().toInt()
                when(opcao){
                    1 -> {
                        limparCarrinho()
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