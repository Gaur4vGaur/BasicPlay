package forms

import models.UserData
import play.api.data._
import play.api.data.Forms._

/**
  * Created by gaurav on 01/07/17.
  */

object UserForm {

  val userForm = Form(
    mapping(
      "name" -> text,
      "age" -> number
    )(UserData.apply)(UserData.unapply)
  )

}
