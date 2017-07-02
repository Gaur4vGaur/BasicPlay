package controllers

import javax.inject.{Inject, Singleton}

import forms.UserForm._
import play.api.mvc._

@Singleton
class DynamoController @Inject()(messagesAction: MessagesActionBuilder, cc: ControllerComponents) extends AbstractController(cc) {

  def index() = messagesAction { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.sampledynamo(userForm))
  }

  def fetchdata() = messagesAction { implicit request: MessagesRequest[AnyContent] =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.sampledynamo(userForm))
      },
      contact => {
        println(contact.name + "   " + contact.age)
        Ok(views.html.index())
      }
    )
  }
}
