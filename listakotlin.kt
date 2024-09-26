/**
 * Compilação
 * kotlin -include-runtime -d listakotlin.jar listakotlin.kt
 * 
 * Execução
 * javar -jar listakotlin.jar
 */

var lista: MutableList<String> = mutableListOf()

fun solicitarItem(): String{
    print("Informe a descrição do item: ")
    val descricao = readln()
    return descricao
}

fun adicionarItemInfinito(){
    while(true){
        val descricao = solicitarItem()
        if (descricao == ""){
            return
        }
        lista.add(descricao)
    }
}

fun adicionarItem(){
    val descricao = solicitarItem()
    if (descricao != ""){
        lista.add(descricao)
        println("Item $descricao adicionado!")
    }else{
        println("Item inválido!")
    }
}

fun listarItens(){
    println("Items:")
    if (lista.size == 0){
        println("Lista vazia")
        return
    }

    lista.forEachIndexed {
        index, item -> println("${index + 1} - $item")
    }
}

fun removerItem(){
    print("Informe o indice do item: ")
    val texto = readln()
    try {
        val indice = texto.toInt()
        val item = lista[indice - 1]
        lista.removeAt(indice - 1)
        println("Item $item removido!")
    }
    catch(e: Exception) {
        println("Não existe item neste indice!")
        return
    }
}

fun showMenu(){
    while (true){
        println("Menu:")
        println("1. Adicionar item")
        println("2. Listar itens")
        println("3. Excluir itens")
        println("4. Adicionar itens infinitamente")
        println("0. Sair")
        print("Opção: ")
        var opcao = readln()
        when(opcao){
            "1" -> adicionarItem()
            "2" -> listarItens()
            "3" -> removerItem()
            "4" -> adicionarItemInfinito()
            "0" -> break
            else -> println("Opção inválida!")
        }
    }
}

fun main(){
    showMenu()
}