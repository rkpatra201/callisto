import kotlinx.coroutines.*
import java.io.File
import java.io.RandomAccessFile
import kotlin.system.measureTimeMillis

const val CHUNK_SIZE = 40
const val THREAD_COUNT = 4  // Similar to Java's thread pool size

fun main() = runBlocking {
    val file = File("concurrent-read.txt")
    if (!file.exists()) {
        println("File does not exist!")
        return@runBlocking
    }

    val executionTime = measureTimeMillis {
        val fileSize = file.length()
        val totalChunks = (fileSize + CHUNK_SIZE - 1) / CHUNK_SIZE

        coroutineScope {
            (0 until totalChunks).map { i ->
                async(Dispatchers.IO) {  // Uses optimized thread pool
                    val start = i * CHUNK_SIZE
                    readChunk(file, start, CHUNK_SIZE)
                }
            }.awaitAll() // Ensure all coroutines finish before measuring time
        }
    }

    println("Total Execution Time (Optimized Kotlin Coroutines): $executionTime ms")
}

suspend fun readChunk(file: File, start: Long, chunkSize: Int) {
    withContext(Dispatchers.IO) {  // Optimized for I/O-bound tasks
        RandomAccessFile(file, "r").use { raf ->
            raf.seek(start)
            val buffer = ByteArray(chunkSize)

            val bytesRead = raf.read(buffer)
            if (bytesRead > 0) {
              //  println("${Thread.currentThread().name} - Read bytes $start to ${start + bytesRead}")
            }
        }
    }
}
