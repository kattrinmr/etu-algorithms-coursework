// Система непересекающихся множеств

val dsu: MutableMap<String, String> = mutableMapOf()

fun find(v: String): String { // Поиск лидера множества, в котором находится v
    if (dsu[v] != v) {
        dsu[v] = find(dsu[v]!!)
    }
    return dsu[v]!!
}

fun union(a: String, b: String) { // Объединение двух множеств
    var a = a
    var b = b

    a = find(a)
    b = find(b)

    if (a != b) dsu[b] = a
}
