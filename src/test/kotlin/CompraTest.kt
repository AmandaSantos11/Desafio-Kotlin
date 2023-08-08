import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CompraTest {

    var carrinho = mutableMapOf<Int,MutableList<Produto>>()

    @Test
    fun verificaSeAdicionaNoCarrinho(){
        val listaXburger = mutableListOf(Produto(101,"X-burger",10.00,1,extra = Extra()))
        carrinho[101] = listaXburger

        assertEquals(true,carrinho.containsKey(101))
    }

    @Test
    fun verificaSeRemoveItemDoNoCarrinho(){
        val listaXburger = mutableListOf(Produto(102,"X-burger",10.00,1,extra = Extra()))
        carrinho[102] = listaXburger
        val listaXsalada = mutableListOf(Produto(201,"X-salada",12.00,1,extra = Extra()))
        carrinho[201] = listaXsalada

        carrinho.remove(102)
        assertEquals(false,carrinho.containsKey(102))
    }
}