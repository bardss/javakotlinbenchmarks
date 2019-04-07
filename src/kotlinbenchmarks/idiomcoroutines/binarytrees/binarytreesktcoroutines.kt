package kotlinbenchmarks.idiomcoroutines.binarytrees

import kotlinbenchmarks.idiom.binarytrees.binarytreesktidiom
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    binarytreesktidiom.execute(args)
}

object binarytreesktcoroutines {

    private const val MIN_DEPTH = 4

    @JvmStatic
    fun execute(args: Array<String>) {
        var n = 0
        if (args.isNotEmpty()) {
            n = args[0].toInt()
        }

        val maxDepth = if (n < MIN_DEPTH + 2) MIN_DEPTH + 2 else n
        val stretchDepth = maxDepth + 1

        println("stretch tree of depth $stretchDepth \t check: ${bottomUpTree(stretchDepth).itemCheck()}")

        val longLivedTree = bottomUpTree(maxDepth)

        val results = arrayOfNulls<String>((maxDepth - MIN_DEPTH) / 2 + 1)

        var d = MIN_DEPTH
        runBlocking {
            while (d <= maxDepth) {
                val depth = d
                GlobalScope.launch {
                    var check = 0

                    val iterations = 1 shl maxDepth - depth + MIN_DEPTH
                    for (i in 1..iterations) {
                        val treeNode1 = bottomUpTree(depth)
                        check += treeNode1.itemCheck()
                    }
                    results[(depth - MIN_DEPTH) / 2] = "$iterations \t trees of depth $depth \t check: $check"
                }
                d += 2
            }
        }

        results.forEach {
            println(it)
        }

        println("long lived tree of depth $maxDepth \t check: ${longLivedTree.itemCheck()}")
    }

    private fun bottomUpTree(depth: Int): TreeNode {
        return if (0 < depth) {
            TreeNode(bottomUpTree(depth - 1), bottomUpTree(depth - 1))
        } else TreeNode()
    }

    private data class TreeNode(
            val left: TreeNode? = null,
            val right: TreeNode? = null
    ) {
        fun itemCheck(): Int = if (null == left) 1 else 1 + left.itemCheck() + right!!.itemCheck()
    }

}
