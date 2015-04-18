// @SOURCE:/home/florian/idea/project/conf/routes
// @HASH:28645451949e8bad1efaf5efaa61720645b7477f
// @DATE:Sat Apr 18 14:11:13 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:27
package be.flo.project.controller {

// @LINE:27
class ReverseMainController {
    

// @LINE:27
def mainPage(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  

// @LINE:6
package controllers {

// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
package be.flo.project.controller.rest {

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseAccountRestController {
    

// @LINE:18
def editAccount(id:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "rest/account/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:20
def changePassword(id:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "rest/account/password/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:19
def changeEmail(id:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "rest/account/email/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
class ReverseFilesController {
    

// @LINE:23
def upload(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rest/file/")
}
                                                

// @LINE:24
def download(storedFileId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rest/file/" + implicitly[PathBindable[Long]].unbind("storedFileId", storedFileId))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginRestController {
    

// @LINE:15
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rest/logout")
}
                                                

// @LINE:14
def registration(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rest/registration")
}
                                                

// @LINE:13
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rest/login")
}
                                                
    
}
                          
}
                  


// @LINE:27
package be.flo.project.controller.javascript {

// @LINE:27
class ReverseMainController {
    

// @LINE:27
def mainPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.MainController.mainPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:6
package controllers.javascript {

// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
package be.flo.project.controller.rest.javascript {

// @LINE:20
// @LINE:19
// @LINE:18
class ReverseAccountRestController {
    

// @LINE:18
def editAccount : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.AccountRestController.editAccount",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/account/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:20
def changePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.AccountRestController.changePassword",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/account/password/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:19
def changeEmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.AccountRestController.changeEmail",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/account/email/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
class ReverseFilesController {
    

// @LINE:23
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.FilesController.upload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/file/"})
      }
   """
)
                        

// @LINE:24
def download : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.FilesController.download",
   """
      function(storedFileId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/file/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("storedFileId", storedFileId)})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginRestController {
    

// @LINE:15
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.LoginRestController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/logout"})
      }
   """
)
                        

// @LINE:14
def registration : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.LoginRestController.registration",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/registration"})
      }
   """
)
                        

// @LINE:13
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "be.flo.project.controller.rest.LoginRestController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rest/login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:27
package be.flo.project.controller.ref {


// @LINE:27
class ReverseMainController {
    

// @LINE:27
def mainPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.MainController]).mainPage(), HandlerDef(this, "be.flo.project.controller.MainController", "mainPage", Seq(), "GET", """#welcome""", _prefix + """""")
)
                      
    
}
                          
}
        

// @LINE:6
package controllers.ref {


// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
package be.flo.project.controller.rest.ref {


// @LINE:20
// @LINE:19
// @LINE:18
class ReverseAccountRestController {
    

// @LINE:18
def editAccount(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).editAccount(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "editAccount", Seq(classOf[Long]), "PUT", """#account""", _prefix + """rest/account/$id<[^/]+>""")
)
                      

// @LINE:20
def changePassword(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).changePassword(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "changePassword", Seq(classOf[Long]), "PUT", """""", _prefix + """rest/account/password/$id<[^/]+>""")
)
                      

// @LINE:19
def changeEmail(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.AccountRestController]).changeEmail(id), HandlerDef(this, "be.flo.project.controller.rest.AccountRestController", "changeEmail", Seq(classOf[Long]), "PUT", """""", _prefix + """rest/account/email/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
class ReverseFilesController {
    

// @LINE:23
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.FilesController]).upload(), HandlerDef(this, "be.flo.project.controller.rest.FilesController", "upload", Seq(), "POST", """file""", _prefix + """rest/file/""")
)
                      

// @LINE:24
def download(storedFileId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.FilesController]).download(storedFileId), HandlerDef(this, "be.flo.project.controller.rest.FilesController", "download", Seq(classOf[Long]), "GET", """""", _prefix + """rest/file/$storedFileId<[^/]+>""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
class ReverseLoginRestController {
    

// @LINE:15
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).logout(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "logout", Seq(), "GET", """""", _prefix + """rest/logout""")
)
                      

// @LINE:14
def registration(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).registration(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "registration", Seq(), "POST", """""", _prefix + """rest/registration""")
)
                      

// @LINE:13
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[be.flo.project.controller.rest.LoginRestController]).login(), HandlerDef(this, "be.flo.project.controller.rest.LoginRestController", "login", Seq(), "POST", """# account""", _prefix + """rest/login""")
)
                      
    
}
                          
}
        
    