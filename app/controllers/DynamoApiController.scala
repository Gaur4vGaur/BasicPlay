package controllers

import javax.inject.{Inject, Singleton}

import models.UserData
import play.api.libs.json.Json
import play.api.mvc._

/**
  * Created by gaurav on 02/07/17.
  */
@Singleton
class DynamoApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {




  def echo(id: Int) = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(UserData("MyName", id*100)))
  }

}
