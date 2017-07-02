package controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.ws._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

/**
  * Created by gaurav on 02/07/17.
  */
@Singleton
class GoogleApiController @Inject()(ws: WSClient, cc: ControllerComponents) extends AbstractController(cc) {

  def fetchLocation = Action.async { implicit request: Request[AnyContent] =>
    val url = """https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=food&name=cruise&key=AIzaSyCf65R4G4H4vrg9lAEck-xy2YKaty8_F5w"""

    ws.url(url).get().map {
      response =>
        response.status match {
          case OK => Ok(response.body)
          case e => println("error occured" + e + "\n" + response)

            Ok(response.body)

        }

    }
  }

}
