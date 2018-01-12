import com.kotlinBinaryHandler.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Created by SuperRainbowNinja on 8/01/2018.
 */

class Tmp : ByteArrayOutputStream(50) {
    fun tmp() : ByteArray = buf
}

fun main(args: Array<String>) {
    val x = Tmp()
    //x.write(ByteArray(20, { intArrayOf(3,0,0,0,7,0,0,0,100,0,0,0,44,1,0,0,144,1,0,0).get(it).toByte() }))
    val y = ByteArrayInputStream(x.tmp())
    val z = Array<Any>(3, {it + 5})
    z[0] = 3
    z[2] = Array(3, {it * 4})

//    //Compiler(Lex()).compile("struct test {\nint x;\nint y;\nint z[x];}").serialize(x, z)
//
//    Compiler(Lex()).compile("struct test {\nint x;\nint y = 7;\nint z[x];}").deserialize(y).forEach {
//        println(it)
//        if (it is Array<*>) {
//            for (value in it) {
//                println(value)
//            }
//        }
//    }

//    for (tmp in getSerializer(Compiler(Lex()).compile("struct test {\nint x;\nint y;\nint z[x];}"), z)) {
//        tmp.deserialize(y)
//        println(tmp.value)
//        val array = tmp.value
//        if (array is Array<*>) {
//            for (value in array) {
//                println(value)
//            }
//        }
//    }

    println(getConstantProperty("{1,2,{{{4, 4, 5, 6.6}}}}"))


    val str = Compiler(Lex()).compile("struct test {\nint x;\nint y = 3;\nint z[3];}")
    str.serialize(x, z)

    str.deserialize(y)
    for(it in str.array) {
        println(it)
        if (it is Array<*>) {
            for (value in it) {
                println(value)
            }
        }
    }

}