import java.io.File
import java.io.InputStream

fun stringToWords(s: String) = s.trim().splitToSequence(' ')
    .filter { it.isNotEmpty() } // or: .filter { it.isNotBlank() }
    .toMutableList()

fun checkVertex(list: MutableList<String>, vertex: String): Boolean {
    for (i in 0 until list.size)
        if (list[i] == vertex) return false
    return true
}

fun main() {
    // Чтение из файла
    val inputStream: InputStream = File("input.txt").inputStream()
    val lineList = mutableListOf<String>() // Строка файла
    var trimList: MutableList<String> // Массив из элементов строки файла


    val graph = mutableListOf<Triple<String, String, Int>>() // String - ребро А, String - ребро B, Int - вес
    val vertex = mutableListOf<String>() // Массив вершин графа
    val mst = mutableListOf<Pair<String, String>>() // Минимальное остовное дерево
    var cost = 0 // Вес остовного дерева

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    lineList.forEach{
        trimList = stringToWords(it)
        graph.add(Triple(trimList[0], trimList[1], trimList[2].toInt()))

        for (i in 0 until graph.size) {
            if (checkVertex(vertex, graph[i].first)) vertex.add(graph[i].first)
            if (checkVertex(vertex, graph[i].second)) vertex.add(graph[i].second)
        }
    }

    qsort(graph, 0, graph.size - 1)

    for (i in 0 until vertex.size) dsu[vertex[i]] = vertex[i]; // Сначала множества только из одного элемента

    // MST
    for (i in 0 until graph.size) {

        var a = graph[i].first
        var b = graph[i].second
        var c = graph[i].third

        if (find(a) != find(b)) {
            mst.add(Pair(a, b))
            union(a, b)
            cost += c
        }
    }

    for (i in 0 until mst.size) println("${mst[i].first} ${mst[i].second}")
    println(cost)
}
