package kotlinbenchmarks.converted

/*
   The Computer Language Benchmarks Game
   https://salsa.debian.org/benchmarksgame-team/benchmarksgame/

   contributed by Francois Green
*/

import java.io.*

import java.util.*
import java.util.concurrent.CompletableFuture
import kotlin.collections.Map.Entry
import java.util.function.*
import java.util.regex.*

import java.util.stream.Collectors.*

object RegexReduxConverted {

    @Throws(IOException::class)
    @JvmStatic
    fun main() {
        val baos = ByteArrayOutputStream()
        run {
            val buf = ByteArray(65536)
            var count: Int = System.`in`.read(buf)
            while (count > 0) {
                baos.write(buf, 0, count)
                count = System.`in`.read(buf)
            }
        }
        val input = baos.toString("US-ASCII")

        val initialLength = input.length

        val sequence = input.replace(">.*\n|\n".toRegex(), "")

        val replacements = CompletableFuture.supplyAsync {
            val iub = LinkedHashMap<String, String>()
            iub["tHa[Nt]"] = "<4>"
            iub["aND|caN|Ha[DS]|WaS"] = "<3>"
            iub["a[NSt]|BY"] = "<2>"
            iub["<[^>]*>"] = "|"
            iub["\\|[^|][^|]*\\|"] = "-"

            var buffer = sequence
            for ((key, value) in iub) {
                buffer = Pattern.compile(key).matcher(buffer).replaceAll(value)
            }
            buffer
        }

        val codeLength = sequence.length

        val variants = Arrays.asList("agggtaaa|tttaccct",
                "[cgt]gggtaaa|tttaccc[acg]",
                "a[act]ggtaaa|tttacc[agt]t",
                "ag[act]gtaaa|tttac[agt]ct",
                "agg[act]taaa|ttta[agt]cct",
                "aggg[acg]aaa|ttt[cgt]ccct",
                "agggt[cgt]aa|tt[acg]accct",
                "agggta[cgt]a|t[acg]taccct",
                "agggtaa[cgt]|[acg]ttaccct")

        val counts = BiFunction<String, String, Entry<String, Long>> { v, s ->
            val count = Pattern.compile(v).splitAsStream(s).count() - 1 //Off by one
            AbstractMap.SimpleEntry(v, count)
        }

        // TODO: Fix converted Java stream in Kotlin
//        val results = variants.parallelStream()
//                .map { variant -> counts.apply(variant, sequence) }
//                .collect<Map<String, Long>, Any>(
//                        toMap(
//                                Function<Entry<String, Long>, String> { it.key },
//                                *,
//                                Function<Entry<String, Long>, String> { it.value }
//                        ))
//
//        variants.forEach { variant -> println(variant + " " + results[variant]) }
//
//        println()
//        println(initialLength)
//        println(codeLength)
//        println(replacements.join().length)
    }
}