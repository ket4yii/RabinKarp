package rabinkarp

import org.scalatest._
import Matchers._

import rabinkarp.Matcher.indexOf

class MatcherSpec extends FlatSpec {
  "IndexOf" should "return -1 when there are no matches" in {
    indexOf("abcdef", "g") should be (-1)
  }

  "IndexOf" should "return -1 when pattern longer than string" in {
    indexOf("abc", "abcdef") should be (-1)
  }

  "IndexOf" should "return -1 when string is empty" in {
    indexOf("", "pattern") should be (-1)
  }

  "IndexOf" should "return 0 when pattern is empty" in {
    indexOf("str", "") should be (0)
  }

  "IndexOf" should "return 0 when pattern and string are empty" in {
    indexOf("", "") should be (0)
  }

  "IndexOf" should "return 0 when string is equal to pattern" in {
    indexOf("equal to pattern", "equal to pattern") should be (0)
  }

  "IndexOf" should "return correct position when pattern is a char" in {
    indexOf("abcdefg", "c") should be (2)
  }

  "IndexOf" should "return correct position" in {
    indexOf("abcdefg", "efg") should be (4)
  }

  "IndexOf" should "return correct position when string is long" in {
    val str = """
    Любви, надежды, тихой славы
    Недолго нежил нас обман,
    Исчезли юные забавы,
    Как сон, как утренний туман;
    Но в нас горит еще желанье,
    Под гнетом власти роковой
    Нетерпеливою душой
    Отчизны внемлем призыванье.
    Мы ждем с томленьем упованья
    Минуты вольности святой,
    Как ждет любовник молодой
    Минуты верного свиданья.
    Пока свободою горим,
    Пока сердца для чести живы,
    Мой друг, отчизне посвятим
    Души прекрасные порывы!
    Товарищ, верь: взойдет она,
    Звезда пленительного счастья,
    Россия вспрянет ото сна,
    И на обломках самовластья
    Напишут наши имена!
    """

    indexOf(str, "Товарищ") should be (478)
  }
  "IndexOf" should "return correct position when pattern is long" in {
    val str = """
    Любви, надежды, тихой славы
    Недолго нежил нас обман,
    Исчезли юные забавы,
    Как сон, как утренний туман;
    Но в нас горит еще желанье,
    Под гнетом власти роковой
    Нетерпеливою душой
    Отчизны внемлем призыванье.
    Мы ждем с томленьем упованья
    Минуты вольности святой,
    Как ждет любовник молодой
    Минуты верного свиданья.
    Пока свободою горим,
    Пока сердца для чести живы,
    Мой друг, отчизне посвятим
    Души прекрасные порывы!
    Товарищ, верь: взойдет она,
    Звезда пленительного счастья,
    Россия вспрянет ото сна,
    И на обломках самовластья
    Напишут наши имена!
    """

    indexOf(str, "Звезда пленительного счастья") should be (510)
  }
}

