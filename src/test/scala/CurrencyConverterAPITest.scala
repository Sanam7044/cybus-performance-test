import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class CurrencyConverterAPITest extends Simulation {

  val conf = ConfigFactory.load()
  val baseUrl = conf.getString("baseUrl")
  val apiKey = conf.getString("apiKey")
  val apiHost = conf.getString("apiHost")
  val numberOfUser = conf.getInt("numberOfUser")
  val duration = conf.getInt("duration") second

  //Protocol
  val httpProtocol = http.baseUrl(baseUrl)
    .header("X-RapidAPI-Key", apiKey)
    .header("X-RapidAPI-Host", apiHost)

  //Scenario
  val feeder = csv("data/testdata.csv").random
  val sce = scenario("Test Currency Converter API")
    .feed(feeder)
    .exec(
      http("Get Currency Converter").get("format=${format}&from=${from}&to=${to}amount=${amount}")
        .check(status.is(200))
    )

  //Setup
  setUp(
    sce.inject(rampUsers(numberOfUser).during(duration))
      .protocols(httpProtocol)
  )
}
