fun example() {
    // instantiate object that implements interface
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a runnable!")
        }
    }
}