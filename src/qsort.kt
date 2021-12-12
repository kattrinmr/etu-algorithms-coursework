// Реализация сортировки qsort

fun qsort(list: MutableList<Triple<String, String, Int>>, left_: Int, right_: Int) {

    var left = left_
    var right = right_
    var mid = list[(left + right) / 2].third
    var tmp: Triple<String, String, Int>

    while (left <= right) {

        while (list[left].third < mid) left++
        while (list[right].third > mid) right--

        if (left <= right) {
            tmp = list[left]
            list[left] = list[right]
            list[right] = tmp
            left++
            right--
        }
    }

    if (right > left_) qsort(list, left_, right)
    if (left < right_) qsort(list, left, right_)
}