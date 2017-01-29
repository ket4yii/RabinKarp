package rabinkarp

object Matcher {
  private def rollingHash(seed: Int)(modulo: Int)(str: String): Int = str
    .foldLeft(0)((hash, ch) => {
        (hash * seed + ch) % modulo
      }
    )

  def indexOf(str: String, substr: String, seed: Int = 101, modulo: Int = 2017): Int = {
    if (substr == "")
      return 0
    else if (str == "")
      return -1

    val power = (1 to substr.length).reduceLeft((pow, _) => (pow * seed) % modulo)
    val hash = rollingHash(seed)(modulo)(_)
    val subhash = hash(substr)

    val slidingWindow = str
      .sliding(substr.length)
    val beginingStr = slidingWindow.next
    val beginingHash = hash(beginingStr)

    if (beginingHash == subhash && beginingStr == substr)
      return 0

    slidingWindow
      .foldLeft((beginingHash - beginingStr.head * power, 1))((acc, str) => {
        val curHash = (((seed * acc._1) % modulo) + str.last % modulo) match {
          case hash if hash < 0 => hash + modulo
          case hash => hash
        }
        val index = acc._2

        if (curHash == subhash && str == substr)
          return index
        else 
          (curHash - str.head * power, index + 1)
      })

      -1
  }
}
