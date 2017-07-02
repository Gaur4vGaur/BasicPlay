package models

import play.api.libs.json.{Format, Json}

case class UserData(name: String, age: Int)

object UserData {
  implicit val formats: Format[UserData] = Json.format[UserData]
}
