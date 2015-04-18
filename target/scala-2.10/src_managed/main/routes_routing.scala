// @SOURCE:/home/florian/idea/project/conf/routes
// @HASH:28645451949e8bad1efaf5efaa61720645b7477f
// @DATE:Sat Apr 18 14:11:13 CEST 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:13
private[this] lazy val be_flo_project_controller_rest_LoginRestController_login1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/login"))))
        

// @LINE:14
private[this] lazy val be_flo_project_controller_rest_LoginRestController_registration2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/registration"))))
        

// @LINE:15
private[this] lazy val be_flo_project_controller_rest_LoginRestController_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/logout"))))
        

// @LINE:18
private[this] lazy val be_flo_project_controller_rest_AccountRestController_editAccount4 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/account/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:19
private[this] lazy val be_flo_project_controller_rest_AccountRestController_changeEmail5 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/account/email/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val be_flo_project_controller_rest_AccountRestController_changePassword6 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/account/password/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:23
private[this] lazy val be_flo_project_controller_rest_FilesController_upload7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/file/"))))
        

// @LINE:24
private[this] lazy val be_flo_project_controller_rest_FilesController_download8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rest/file/"),DynamicPart("storedFileId", """[^/]+""",true))))
        

// @LINE:27
private[this] lazy val be_flo_project_controller_MainController_mainPage9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/login""","""@be.flo.project.controller.rest.LoginRestController@.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/registration""","""@be.flo.project.controller.rest.LoginRestController@.registration()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/logout""","""@be.flo.project.controller.rest.LoginRestController@.logout()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/account/$id<[^/]+>""","""@be.flo.project.controller.rest.AccountRestController@.editAccount(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/account/email/$id<[^/]+>""","""@be.flo.project.controller.rest.AccountRestController@.changeEmail(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/account/password/$id<[^/]+>""","""@be.flo.project.controller.rest.AccountRestController@.changePassword(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/file/""","""@be.flo.project.controller.rest.FilesController@.upload()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rest/file/$storedFileId<[^/]+>""","""@be.flo.project.controller.rest.FilesController@.download(storedFileId:Long)"""),("""GET""", prefix,"""@be.flo.project.controller.MainController@.mainPage()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:13
case be_flo_project_controller_rest_LoginRestController_login1(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).login(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "login", Nil,"POST", """# account""", Routes.prefix + """rest/login"""))
   }
}
        

// @LINE:14
case be_flo_project_controller_rest_LoginRestController_registration2(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).registration(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "registration", Nil,"POST", """""", Routes.prefix + """rest/registration"""))
   }
}
        

// @LINE:15
case be_flo_project_controller_rest_LoginRestController_logout3(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).logout(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "logout", Nil,"GET", """""", Routes.prefix + """rest/logout"""))
   }
}
        

// @LINE:18
case be_flo_project_controller_rest_AccountRestController_editAccount4(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).editAccount(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "editAccount", Seq(classOf[Long]),"PUT", """#account""", Routes.prefix + """rest/account/$id<[^/]+>"""))
   }
}
        

// @LINE:19
case be_flo_project_controller_rest_AccountRestController_changeEmail5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).changeEmail(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "changeEmail", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """rest/account/email/$id<[^/]+>"""))
   }
}
        

// @LINE:20
case be_flo_project_controller_rest_AccountRestController_changePassword6(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).changePassword(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "changePassword", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """rest/account/password/$id<[^/]+>"""))
   }
}
        

// @LINE:23
case be_flo_project_controller_rest_FilesController_upload7(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.FilesController]).upload(), HandlerDef(this, "be.flo.project.controller.rest.FilesController", "upload", Nil,"POST", """file""", Routes.prefix + """rest/file/"""))
   }
}
        

// @LINE:24
case be_flo_project_controller_rest_FilesController_download8(params) => {
   call(params.fromPath[Long]("storedFileId", None)) { (storedFileId) =>
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.FilesController]).download(storedFileId), HandlerDef(this, "be.flo.project.controller.rest.FilesController", "download", Seq(classOf[Long]),"GET", """""", Routes.prefix + """rest/file/$storedFileId<[^/]+>"""))
   }
}
        

// @LINE:27
case be_flo_project_controller_MainController_mainPage9(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.MainController]).mainPage(), HandlerDef(this, "be.flo.project.controller.MainController", "mainPage", Nil,"GET", """#welcome""", Routes.prefix + """"""))
   }
}
        
}

}
     