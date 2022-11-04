package com.xuexi.s1

const val PI = 3.1415926

// 编译常量为什么只能再函数啊外面定义？
// 因为编译常量是在编译期间就确定的，而函数是在运行期间才确定的

// TODO Kotlin中的基本数据类型
fun main() {
    println("Hello World!")

    // TODO Kotlin中的基本数据类型与可读可写和只读变量的声明

    /*
        var 变量名: 数据类型 = 值
        var -> 可读可改
        val -> 只读
     */
    var name: String = "张三"
    name = "李四"
    println(name)
    /*
        基本数据类型有:
            Byte -> 8位
            Short -> 16位
            Int -> 32位
            Long -> 64位
            // 以上为整形
            Float -> 32位
            Double -> 64位
            // 以上为浮点型
            Char -> 16位
            String -> 字符串
            // 以上为字符型
            Boolean -> 1位
            // 以上为布尔型
            List -> 数组
            Set -> 集合
            Map -> 字典
            // 以上为内置的数据结构
     */
    val age: Int = 18
    // Error: Kotlin: Val cannot be reassigned
    // age = 19 // val 不能修改
    println(age)

    // Kotlin会自动识别类型，即变量名称后的数据类型声明使多余的
    // 会提示可以移除显示变量声明
    val age2 = 18

    // val使只读的变量不是常量
    // 编译时常量只能是常用的基本数据类型:
    // (Byte, Short, Int, Long, Float, Double, Char, Boolean, String)
    // 不能是自定义的类

    // Error: Kotlin: Val cannot be reassigned
    // const val PI = 3.14
    // 以为const只能声明常量再类外的数值, goto line 3查看

    // TODO 利用工具能查看反编译结果

    // TODO 性能问题
    // 观看Kotlin的数据类型可以看出都是引用类型，那么是否会性能损耗呢？
    // 不会太多，编译器会再Java字节码中，修改为基本类型

    // TODO range表达式
    // 1..10 -> 1到10
    // 1 until 10 -> 1到9
    // 1..10 step 2 -> 1到10，步长为2
    // 10 downTo 1 -> 10到1
    // 10 downTo 1 step 2 -> 10到1，步长为2
    // e.g
    for (i in 1..10) {
        println(i)
    }
    for (i in 1 until 10) {
        println(i)
    }
    for (i in 1..10 step 2) {
        println(i)
    }
    for (i in 10 downTo 1) {
        println(i)
    }
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
    // util类似与Python中的range函数，不包括最后一个值
    // downTo类似与Python中的range函数，再倒序遍历时，包括最后一个值

    // TODO Kotlin中的when表达式
    val week = 5
    val info = when (week) {
        1 -> println("星期一")
        2 -> println("星期二")
        3 -> println("星期三")
        4 -> println("星期四")
        5 -> println("星期五")
        6 -> println("星期六")
        7 -> println("星期日")
        // else -> println("输入错误")
        else -> {
            println("输入错误")
        }
    }
    // when表达式类似于Python中的switch表达式,即有返回值,不是语句
    // 但是Kotlin中的when表达式可以不用break
    // 也可以不用default
    // 也可以不用case
    // 如果else也返回String类型如注释中的代码，那么when表达式的返回值就是String类型
    // 如果else如现在所写, 即为Any类型, 即为Java中的Object类型
    println(info)
    // Unit类型, 即为Java中的void类型

    // TODO Kotlin中的字符串模板
    val park = "Yellowstone"
    val year = 1872
    println("The $park National Park was established in $year.")
    // The Yellowstone National Park was established in 1872.
    // Kotlin中的字符串模板, 可以直接使用变量名, 也可以使用表达式
    // 但是表达式必须使用${}包裹（如果用的是中文的话, 用英文不用）
    //也可以使用java版本的方法
    println("The " + park + " National Park was established in " + year + ".")
    // The Yellowstone National Park was established in 1872.
    // 但是又丑又长, 不推荐使用

    // Kotlin的if是表达式，更加灵活，java实际语句，有局限性
    val isLoing = true
    println("Result: ${if (isLoing) "Success" else "Fail"}")
    // Result: Success

    val a = 1
    val b = 2
    println(sum(a, b))

    val name1 = "Kotlin"
    println(a1(name1))

    show(1000)
}

// TODO Kotlin函数头
// Kotlin中的函数头可以省略返回值类型
// 但是如果函数体中有return语句，那么就必须要写返回值类型
// public 是默认的和Java一样
private fun sum(a: Int, b: Int): Int {
    return a + b
}

// TODO Kotlin函数参数的默认参数
private fun a1(name: String, age: Int = 18) {
    println("name: $name, age: $age")
}

// TODO Kotlin具名参数即像python那样随意传参
// 比如调用函数a2(age= 20, name = "Kotlin")等效于a2("Kotlin", 20)
private fun a2(name: String, age: Int) {
    println("name: $name, age: $age")
}

// TODO Kotlin中Unit函数特点
// 1. Unit函数可以省略返回值类型
// 2. Unit函数可以省略return语句
// 3.虽然Unit类似与Java中的void，但是Unit是一个类，而不是像java的void是一个关键词
//private object Unit {
//    fun a3() {
//        println("Unit函数")
//    }
//}

// TODO Kotlin中的Nothing类型特点
// Nothing 相当于抛出异常
private fun show(number: Int) {
    when(number) {
        in 0 until 60 -> println("不及格")
        in 60 until 80 -> println("及格")
        in 80 until 90 -> println("良好")
        in 90 until 100 -> println("优秀")
        else -> throw IllegalArgumentException("参数错误")
    }
}

// TODO Kotlin中的反引号
// 反引号可以用来定义标识符，即变量名，函数名等
// 反引号中的内容可以包含空格，数字，特殊字符等
// 反引号中的内容可以是关键字, 但是不推荐使用
//e.g.
private fun `登陆功能 2022年11月2日测试环境下测试登陆功能，测试人zk`() {
    println("登陆功能")

}



















