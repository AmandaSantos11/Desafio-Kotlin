import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class CompraTest {

    @Test
    fun verificaSeAdicionaNoCarrinho(){
        var carrinho = mutableMapOf<Int,MutableList<Produto>>()
        val listaXburger = mutableListOf(Produto(101,"X-burger",10.00,1,extra = Extra()))
        carrinho[101] = listaXburger

        assertEquals(true,carrinho.containsKey(101))
    }

    @Test
    fun verificaSeRemoveItemDoNoCarrinho(){
        var carrinho = mutableMapOf<Int,MutableList<Produto>>()
        val listaXburger = mutableListOf(Produto(102,"X-burger",10.00,1,extra = Extra()))
        carrinho[102] = listaXburger
        val listaXsalada = mutableListOf(Produto(201,"X-salada",12.00,1,extra = Extra()))
        carrinho[201] = listaXsalada

        carrinho.remove(102)
        assertEquals(false,carrinho.containsKey(102))
    }

    @Test
    fun verificaSeLimpaOCarrinho(){
        var carrinho = mutableMapOf<Int,MutableList<Produto>>()

        val listaXburger = mutableListOf(Produto(101,"X-burger",10.00,1,extra = Extra()))
        carrinho[101] = listaXburger
        val listaXsalada = mutableListOf(Produto(201,"X-salada",12.00,1,extra = Extra()))
        carrinho[201] = listaXsalada

        Compra.limparCarrinho()
    }

    @Test
    fun verificaSeAFuncaoExibirCarrinhoEstaFuncionando(){
        val compra = Compra()
        var carrinho = compra.getCarrinho()

        val listaBanana = mutableListOf(Produto(601,"Banana Split",15.00,1,extra = Extra()))
        carrinho[601] = listaBanana
        val listaSuco = mutableListOf(Produto(401,"Suco",6.00,1,extra = Extra()))
        carrinho[401] = listaSuco

        val saidaEsperada = "===========Carrinho===========\nCodigo:601 | Nome:Banana Split | Quantidade:1 | Extras:,,,,,,\nCodigo:401 | Nome:Suco | Quantidade:1 | Extras:,,,,,,\n\nValor total: R$0.0\n--------------------------".trimIndent()

        val saidaOriginal = System.out

        val conteudoSaida = ByteArrayOutputStream()
        System.setOut(PrintStream(conteudoSaida))

        Compra.exibirCarrinho()

        System.setOut(saidaOriginal)

        val saidaAtual = conteudoSaida.toString().trimIndent()
        assertEquals(saidaEsperada, saidaAtual)
    }

    @Test
    fun verificaSeAFuncaoExibirLanchesEstaFuncionando(){

        val saidaEsperada = "====Nossos lanches===="+"\nLanche: X-burger\nDescrição: Hambúrguer bovino com queijo prato,tomate,alface e maionese.\nPreço: R$10.00\n"+
                "\n\nLanche: X-salada\nDescrição: Hambúrguer bovino com queijo prato,tomate,alface,maionese e ovo.\nPreço: R$12.00\n---------------------".trimIndent()

        val saidaOriginal = System.out

        val conteudoSaida = ByteArrayOutputStream()
        System.setOut(PrintStream(conteudoSaida))

        ExibirProdutos().exibirLanches()

        System.setOut(saidaOriginal)

        val saidaAtual = conteudoSaida.toString().trimIndent()
        assertEquals(saidaEsperada, saidaAtual)
    }

    @Test
    fun verificaSeAFuncaoExibirBebidasEstaFuncionando(){

        val saidaEsperada = "====Nossas Bebidas===="+"\nBebida: Refrigerante\n" +
                "Descrição: Coca-cola\n" + "Preço: R\$8.00\n"+
                "\nBebida: Suco\n" +
                "Descrição: Suco de laranja\n" +
                "Preço: R\$6.00\n" + "---------------------".trimIndent()

        val saidaOriginal = System.out

        val conteudoSaida = ByteArrayOutputStream()
        System.setOut(PrintStream(conteudoSaida))

        ExibirProdutos().exibirBebidas()

        System.setOut(saidaOriginal)

        val saidaAtual = conteudoSaida.toString().trimIndent()
        assertEquals(saidaEsperada, saidaAtual)
    }

    @Test
    fun verificaSeAFuncaoExibirSobremesaEstaFuncionando(){

        val saidaEsperada = "====Nossas Sobremesas===="+"\nSobremesa: Sorvete\n" +
                "Descrição: Soverte de chocolate no pote, 300ml.\n" + "Preço: R\$9.00\n\n"+
                "Sobremesa: Banana Split\n" +
                "Descrição: Banana com calda de chocolate,amendoim e uma bola de sorvete de baunilha.\n" +
                "Preço: R$15.00\n" + "---------------------".trimIndent()

        val saidaOriginal = System.out

        val conteudoSaida = ByteArrayOutputStream()
        System.setOut(PrintStream(conteudoSaida))

        ExibirProdutos().exibirSobremesa()

        System.setOut(saidaOriginal)

        val saidaAtual = conteudoSaida.toString().trimIndent()
        assertEquals(saidaEsperada, saidaAtual)
    }
}