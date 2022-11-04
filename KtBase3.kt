package com.xuexi.s1

fun main() {
    // TODO 函数引用
    // lambda属于函数类型的对象，需要吧methodResponseRES普通函数转换成函数类型的对象即函数引用

//    login("zknbnbdnb", "123456", ::methodResponseRES)

    val obj = ::methodResponseRES
    login("zknbnbdnb", "123456", obj)

    // 调用show函数，并打印结果
    val res = show("info") // <- 这里的show函数就是一个函数引用
    println(res("zk", 18))

}

const val USER_NAME_SAVE_DB = "zknbnbdnb"
const val USER_PASSWORD_SAVE_DB = "123456"

private inline fun login(username: String, password: String, resposeRES: (String, Int) -> Unit) {
    if (username == USER_NAME_SAVE_DB && password == USER_PASSWORD_SAVE_DB) {
        resposeRES("登录成功", 200)
    } else {
        resposeRES("登录失败", 400)
    }
}

private fun methodResponseRES(msg: String, code: Int) {
    println("结果为：msg: $msg, code: $code")
}

// TODO 函数返回匿名函数

private fun show(info: String): (String, Int) -> String {
    println("$info")
    return { msg: String, code: Int ->
        "name: $msg, age: $code"
    }
}