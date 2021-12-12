// Не использовалось в реализации алгоритма Крускала, но требуется по заданию:

// хранение графов (списки смежности, матрицы смежности, инцидентности);
// обход графов (в глубину и в ширину).


// Обход графа в глубину
var nodes: List<List<Int>> = listOf()

fun dfs(v: Int) {
    val visited = BooleanArray(nodes.size) { false }
    visited[v] = true // Помечаем текущую вершину, как пройденную

    for (next in nodes[v]) {
        if (!visited[next]) { // Находим непройденную вершину, к которой ведёт текущая вершина
            dfs(next) // Начинаем обход в глубину с найденной вершины
        }
    }
}

// Обход графа в ширину
fun bfs(v: Int) {
    val visited = BooleanArray(nodes.size) { false }
    val queue: MutableList<Int> = mutableListOf()

    queue.add(v) // Добавляем стартовую вершину в очередь

    while (queue.isNotEmpty()) {
        val node = queue.removeAt(0) // Извлекаем из начала очереди вершину
        if (!visited[node]) {
            nodes[node].forEach {
                queue.add(it) // Добавляем все непройденные вершины, к которым ведёт текущая, в очередь
            }
        }
        visited[node] = true // Помечаем текущую вершину как пройденную
    }
}

// Матрица смежности
fun matrixAdj(graph: List<Pair<Int, Int>>, matrix: Array<BooleanArray>) {
    for(i in graph.indices) {
        matrix[graph[i].first - 1][graph[i].second - 1] = true
        matrix[graph[i].second - 1][graph[i].first - 1] = true
    }
}

// Матрица инцидентности
fun matrixIn(edge: List<Pair<Int, Int>>, vertex: Array<BooleanArray>) {
    for (i in edge.indices) {
        vertex[i][edge[i].first - 1] = true
        vertex[i][edge[i].second - 1] = true
    }
}

// Список смежности
fun listCon(graph: ArrayList<Pair<Int, Int>>, list: ArrayList<ArrayList<Int>>, v: Int) { // v - количество вершин
    val temp: ArrayList<Int> = arrayListOf()
    for (i in 0 until v) list.add(temp)
    for (i in 0 until graph.size) {
        list[graph[i].first - 1].add(graph[i].second)
        list[graph[i].second - 1].add(graph[i].first)
    }
}
