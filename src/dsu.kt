val dsu: MutableMap<String, String> = mutableMapOf()

fun find(v: String): String {
    if (dsu[v] != v) {
        dsu[v] = find(dsu[v]!!)
    }
    return dsu[v]!!
}

fun union(a: String, b: String) {
    var a = a
    var b = b

    a = find(a)
    b = find(b)

    if (a != b) dsu[b] = a
}
