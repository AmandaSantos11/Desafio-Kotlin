import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class ExibirProdutosTest {

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