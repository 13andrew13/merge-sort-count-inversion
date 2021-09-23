/*
 * Complete the 'countInversions' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun countInversionsInsertion(arr: Array<Int>): Long {
    // Write your code here
    var count = 0L
    for (i in arr.indices) {
        val arrValue = arr[i]
        var j = i - 1
        while (j >= 0 && arrValue < arr[j]) {
            arr[j + 1] = arr[j]
            j--
            count++
        }
        arr[j + 1] = arrValue
    }
    return count
}

fun countInversionsMerge(arr: Array<Int>): Long {
    val count = countWithMerge(arr)
    return count

}

fun countWithMerge(arr: Array<Int>): Long {

    if (arr.size == 1) return 0
    var k = 0
    var i = 0
    var j = 0

    val m = arr.size / 2
    val left = arr.copyOfRange(0, m)
    val right = arr.copyOfRange(m, arr.size)
    var count = countWithMerge(left) + countWithMerge(right)

    while (i < left.size && j < right.size) {
        if (left[i] > right[j]) {
            arr[k++] = right[j++]
            count += m - i
        } else {
            arr[k++] = left[i++]
        }
    }

    while (i < left.size) {
        arr[k++] = left[i++]
    }

    while (j < right.size) {
        arr[k++] = right[j++]
    }

    return count
}

fun main(args: Array<String>) {
    val testArray1 = arrayOf(7, 5, 3, 1)
    val count1 = countInversionsMerge(testArray1)
    val expectedCount1 = 6
    println(
        """
            Inversion count for array ${testArray1.joinToString(", ")}, is $count1 expected $expectedCount1 
        """.trimIndent()
    )

    val testArray2 = arrayOf(1, 20, 6, 4, 5)
    val count2 = countInversionsMerge(testArray2)
    val expectedCount2 = 5

    println(
        """
            Inversion count for array ${testArray2.joinToString(", ")}, is $count2 expected $expectedCount2 
        """.trimIndent()
    )
    val testArray3 = arrayOf(2, 1, 3, 1, 2)
    val count3 = countInversionsMerge(testArray3)
    val expectedCount3 = 4
    println(
        """
            Inversion count for array ${testArray3.joinToString(", ")}, is $count3 expected $expectedCount3 
        """.trimIndent()
    )


}
