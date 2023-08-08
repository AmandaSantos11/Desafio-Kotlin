class Produto(){
    var codigo: Int = 0
    var nome: String =""
    var preco: Double =0.0
    var quantidade: Int =0
    lateinit var extra:Extra

    constructor(codigo:Int, nome:String="", preco:Double, quantidade:Int,extra: Extra):this(){
        this.codigo=codigo
        this.nome=nome
        this.preco=preco
        this.quantidade=quantidade
        this.extra=extra
    }
}

class Extra(){
    var tomate:String=""
    var cebola:String = ""
    var queijo:String = ""
    var picles:String = ""
    var gelo:String = ""
    var morango:String = ""
    var leiteNinho:String = ""

    constructor(tomate:String,cebola:String,queijo:String,picles:String,gelo:String,morango:String,leiteNinho:String):this(){
        this.tomate = "Tomate"
        this.cebola = "Cebola"
        this.queijo = "Queijo Cheddar"
        this.picles = "Picles"
        this.gelo = "Gelo"
        this.morango = "Morango"
        this.leiteNinho = "Leite ninho em pó"
    }

    override fun toString(): String {
        return "$tomate,$cebola,$queijo,$picles,$gelo,$morango,$leiteNinho"
    }
}