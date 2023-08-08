import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
        val compra = Compra()
        var carrinho = compra.getCarrinho()
        val listaXburger = mutableListOf(Produto(101,"X-burger",10.00,1,extra = Extra()))
        carrinho[101] = listaXburger
        val listaXsalada = mutableListOf(Produto(201,"X-salada",12.00,1,extra = Extra()))
        carrinho[201] = listaXsalada

        Compra.limparCarrinho()

        assertTrue(carrinho.isEmpty())
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
}