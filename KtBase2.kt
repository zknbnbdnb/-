package com.xuexi.s1

fun main() {
    var name = "zknbnbdnb"
    var n = name.count()
    println(n)
    var n1 = name.count() {
        it == 'n'
        // it -> 表示当前遍历的元素, 是一个隐式参数
        // 如果匿名函数只有一个参数, 则可以省略参数, 直接使用it
    }
    println(n1)

    // TODO Kotlin中的函数类型和隐式返回

    // 第一步函数的声明
    val f1 : () -> String

    // 第二步函数的实现
    f1 = {
        "zknbnbdnb"
    }

    // 等价于
    /*
        val f1 : () -> String = {
            "zknbnbdnb"
        }
     */

    // 第三步函数的调用
    println(f1())
    // 匿名函数不要写return, 会自动返回最后一行的值

    val f2 : (Int, Int, Int) -> String = {
        a, b, c ->
        "参数为: $a, $b, $c"
    }
    // 等价于
    /*
        fun f2(a: Int, b: Int, c: Int): String {
            return "参数为: $a, $b, $c"
        }
     */

    //匿名函数自动推断返回值
    //即不用加冒号:
    val f3 = {
        a: Int, b: Int, c: Int ->
        "参数为: $a, $b, $c"
    }

    //TODO Kotlin的lambda表达式
    //lambda表达式是匿名函数的简写
    val method1 = {num1: Int, num2: Int ->
        num1 + num2
    }
    // 两种方法
    // 1.直接调用
    loginApi("zknbnbdnb", "123456") { msg: String, code: Int ->
        println("msg: $msg, code: $code")
    }
    // 2.赋值给变量
//    loginApi("zknbnbdnb", "123456", responseResult = { msg: String, code: Int ->
//        println("msg: $msg, code: $code")
//    })

}

// TODO Kotlin中的匿名函数

//TODO Kotlin中的传参为函数

// 模拟：数据库SQLServer
const val USER_NAME = "root"
const val PASSWORD = "123456"

// 此函数使用了lambda表达式，就需要声明成内联
// 如果不声明成内联，就会在调用端，生成多个对象来调用(性能低下)
// 如果声明成内联，相当于C++中的宏，会在调用端直接替换，调用除没有任何函数开辟，对象开辟的损耗
// 总结：如果函数中含lambda表达式，尽量使用isline关键字，这样内部会自动优化，减少函数开辟和对象开辟的损耗
private inline fun loginApi(userName: String, password: String, responseResult: (String, Int) -> Unit) {
    if (webServiceLoginAPI(userName, password)) {
        responseResult("登录成功", 200)
    } else {
        responseResult("登录失败", 400)
    }
}

// 此函数没有使用了lambda表达式，就不需要声明成内联
private fun webServiceLoginAPI(userName: String, password: String) : Boolean{
    return userName == USER_NAME && password == PASSWORD
}