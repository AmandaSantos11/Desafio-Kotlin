class Compra {

    companion object{
        private var contadorXBurger = 100
        private var contadorXSalada = 200
        private var contadorRefrigerante = 300
        private var contadorSuco = 400
        private var contadorSorvete = 500
        private var contadorBanana = 600

        private var carrinho = mutableMapOf<Int,MutableList<Produto>>()
        private var valorTotal = 0.0

        fun comprarXBurguer(){
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
                for (i in 1..quantidade){
                    contadorXBurger += 1
                    val listaXBurger = mutableListOf(Produto(contadorXBurger,"X-burger",10.00,1,extra = Extra()))
                    carrinho[contadorXBurger] = listaXBurger
                }
                valorTotal += 10.00 * quantidade

            } while (quantidade == 0)
        }

        fun comprarXSalada(){
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
                for (i in 1..quantidade){
                    contadorXSalada += 1
                    val listaXSalada = mutableListOf(Produto(contadorXSalada,"X-salada",12.00,1,extra = Extra()))
                    carrinho[contadorXSalada] = listaXSalada
                }
                valorTotal += 12.00*quantidade

            } while (quantidade == 0)
        }

        fun comprarRefrigerante(){
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
                for (i in 1..quantidade){
                    contadorRefrigerante++
                    var listaRefrigerante = mutableListOf(Produto(contadorRefrigerante,"Refrigerante",8.00,1,extra = Extra()))
                    carrinho[contadorRefrigerante] = listaRefrigerante
                }
                valorTotal += 8.00 * quantidade

            } while (quantidade == 0)
        }

        fun comprarSuco(){
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
                for (i in 1..quantidade){
                    contadorSuco++
                    var listaSuco = mutableListOf(Produto(contadorSuco,"Suco",6.00,1,extra = Extra()))
                    carrinho[contadorSuco] = listaSuco
                }
                valorTotal += 6.00*quantidade

            } while (quantidade == 0)
        }

        fun comprarSorvete(){
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
                for (i in 1..quantidade){
                    contadorSorvete++
                    var listaSorvete = mutableListOf(Produto(contadorSorvete,"Sorvete",9.00,1,extra = Extra()))
                    carrinho[contadorSorvete] = listaSorvete
                }
                valorTotal += 9.00 * quantidade

            } while (quantidade == 0)
        }

        fun comprarBananaSplit(){
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
                for (i in 1..quantidade){
                    contadorBanana++
                    var listaBanana = mutableListOf(Produto(contadorBanana,"Banana Split",15.00,1,extra = Extra()))
                    carrinho[contadorBanana] = listaBanana
                }
                valorTotal += 15.00*quantidade

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

        fun setValorTotal(novoValor:Double){
            valorTotal = novoValor
        }
    }
    fun comprarUmExtraParaUmProduto(){
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

    fun getValorTotal():Double{
        return Companion.valorTotal
    }

    fun getCarrinho(): MutableMap<Int,MutableList<Produto>>{
        return Companion.carrinho
    }
}