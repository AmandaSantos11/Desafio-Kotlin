class EditarProduto {

    private val compra = Compra()

    fun adicionarNovaQuantidadeEmUmProdutoDoCarrinho() {
        var continuar = true
        do {
            try {
                println("\nDigite o código do produto que deseja editar:")
                val codigo = readln().toIntOrNull()
                if (codigo!=null){
                    if (compra.getCarrinho().containsKey(codigo)) {
                        val listaAlterada = compra.getCarrinho()[codigo]!!
                        println("Digite a quantidade que deseja alterar:")
                        val quantidadeNova = readln().toInt()
                        while (quantidadeNova<=0){
                            println("Quantidade inválida, digite novamente:")
                        }
                        val produto = listaAlterada.find { it.codigo == codigo }
                        if (produto != null) {
                            produto.quantidade += quantidadeNova
                            val novoPreco = produto.preco*quantidadeNova
                            val novoValorTotal = compra.getValorTotal() + novoPreco
                            Compra.setValorTotal(novoValorTotal)
                            println("Carrinho atualizado!\n")
                            Compra.exibirCarrinho()
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

    fun removerUmProdutoDoCarrinho(){
        var continuar = true
        do {
            try {
                println("\nDigite o código do produto que deseja remover:")
                val codigo = readln().toIntOrNull()
                if (codigo!=null){
                    if (compra.getCarrinho().containsKey(codigo)) {
                        val listaAlterada = compra.getCarrinho()[codigo]!!
                        val produto = listaAlterada.find { it.codigo == codigo }
                        if (produto != null) {
                            val novoValorTotal = compra.getValorTotal() - produto.preco
                            Compra.setValorTotal(novoValorTotal)
                        }
                        compra.getCarrinho().remove(codigo)
                        println("Carrinho atualizado!\n")
                        Compra.exibirCarrinho()
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
}