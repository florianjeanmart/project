
package be.flo.project.views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object template extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],be.flo.project.dto.InterfaceDataDTO,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(languages:be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],data:be.flo.project.dto.InterfaceDataDTO)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import com.fasterxml.jackson.databind.ObjectMapper


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html>

<html>
    """),_display_(Seq[Any](/*8.6*/pageElement/*8.17*/.header())),format.raw/*8.26*/("""
    <body class="main-container"  ng-app="app" ng-controller="MainCtrl" >

        <div class="global-container" ng-controller="WelcomeCtrl">

                <!-- load data -->
            <script>
            var data = """),_display_(Seq[Any](/*15.25*/Html(new ObjectMapper().writeValueAsString(data)))),format.raw/*15.74*/(""";
            var languages = """),_display_(Seq[Any](/*16.30*/Html(new ObjectMapper().writeValueAsString(languages.getList)))),format.raw/*16.92*/(""";
            var lang = """"),_display_(Seq[Any](/*17.26*/ctx()/*17.31*/.lang().code)),format.raw/*17.43*/("""";
            </script>

                <!-- menu for little screen : display only when the screen is smaller then 760px -->
            <div id="sidebar" class="visible-sm-block visible-xs-block">
                <ul ng-controller="LateralMenuCtrl">

                        <!-- home -->
                    <li>
                        <a href="/">
                            <img src="/assets/images/menu/icon_home.png" class="icon"/>
                            """),_display_(Seq[Any](/*28.30*/Messages("menu.home"))),format.raw/*28.51*/("""
                        </a>
                    </li>
                </ul>
            </div>

                <!-- swipe area : used to display the menu with a swipe -->
            <div class="swipe-area hidden-md hidden-lg"></div>
            <div id="main-header-container" class="hidden-md hidden-lg">

                    <!-- header -->
                <header>

                        <!-- little screen menu button -->
                    <div class="sidebar-button">
                        <button type="button" data-toggle=".global-container" id="sidebar-toggle">
                            <span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>
                        </button>
                    </div>

                        <!-- title -->
                    <h1>"""),_display_(Seq[Any](/*49.26*/Messages("site.name"))),format.raw/*49.47*/("""</h1>


                        <!-- not connected menu -->
                    <div class="profile-buttons-container" ng-show="myself==null">
                        <button type="button" class="btn btn-primary" ng-click="login()">"""),_display_(Seq[Any](/*54.91*/Messages("welcome.login"))),format.raw/*54.116*/("""</button>
                        """),_display_(Seq[Any](/*55.26*/Messages("generic.or"))),format.raw/*55.48*/("""
                        <button type="button" class="btn btn-primary" ng-click="registration()">"""),_display_(Seq[Any](/*56.98*/Messages("welcome.signIn"))),format.raw/*56.124*/("""</button>
                    </div>

                        <!-- connected menu -->
                    <div class="profile-buttons-container" ng-show="myself!=null"  style="display: inline-block">
                        <span class="visible-sm-inline">"""),format.raw/*61.57*/("""{"""),format.raw/*61.58*/("""{"""),format.raw/*61.59*/("""myself.firstname"""),format.raw/*61.75*/("""}"""),format.raw/*61.76*/("""}"""),format.raw/*61.77*/(""" """),format.raw/*61.78*/("""{"""),format.raw/*61.79*/("""{"""),format.raw/*61.80*/("""myself.lastname"""),format.raw/*61.95*/("""}"""),format.raw/*61.96*/("""}"""),format.raw/*61.97*/("""</span>
                        <button type="button" class="btn btn-primary" ng-click="editProfile()">"""),_display_(Seq[Any](/*62.97*/Messages("welcome.myProfile"))),format.raw/*62.126*/("""</button>
                        <button type="button" class="btn btn-primary" ng-click="logout()">"""),_display_(Seq[Any](/*63.92*/Messages("generic.logout"))),format.raw/*63.118*/("""</button>
                    </div>

                </header>
            </div>

                <!-- main content -->
            <div class="main-body">
                <div class="global-content-container">

                    <div id="main-header-container" class="hidden-sm hidden-xs">

                            <!-- header -->
                        <header>

                                <!-- title -->
                            <div class="container">

                                <h1>"""),_display_(Seq[Any](/*81.38*/Messages("site.name"))),format.raw/*81.59*/("""</h1>

                                    <!-- not connected menu -->
                                <div class="profile-buttons-container" ng-show="myself==null">
                                    <button type="button" class="btn btn-primary" ng-click="login()">"""),_display_(Seq[Any](/*85.103*/Messages("welcome.login"))),format.raw/*85.128*/("""</button>
                                    """),_display_(Seq[Any](/*86.38*/Messages("generic.or"))),format.raw/*86.60*/("""
                                    <button type="button" class="btn btn-primary" ng-click="registration()">"""),_display_(Seq[Any](/*87.110*/Messages("welcome.signIn"))),format.raw/*87.136*/("""</button>
                                </div>

                                    <!-- connected menu -->
                                <div class="profile-buttons-container" ng-show="myself!=null"  style="display: inline-block">
                                    """),format.raw/*92.37*/("""{"""),format.raw/*92.38*/("""{"""),format.raw/*92.39*/("""myself.firstname"""),format.raw/*92.55*/("""}"""),format.raw/*92.56*/("""}"""),format.raw/*92.57*/(""" """),format.raw/*92.58*/("""{"""),format.raw/*92.59*/("""{"""),format.raw/*92.60*/("""myself.lastname"""),format.raw/*92.75*/("""}"""),format.raw/*92.76*/("""}"""),format.raw/*92.77*/("""
                                    <button type="button" class="btn btn-primary" ng-click="editProfile()">"""),_display_(Seq[Any](/*93.109*/Messages("welcome.myProfile"))),format.raw/*93.138*/("""</button>
                                        <button type="button" class="btn btn-primary" ng-click="logout()">"""),_display_(Seq[Any](/*94.108*/Messages("generic.logout"))),format.raw/*94.134*/("""</button>
                                </div>

                            </div>
                        </header>
                    </div>

                    <div class="container main-container">

                            <!-- big menu -->
                        <div class="row hidden-sm hidden-xs large-menu-container">

                            <nav class="navbar navbar-default large-menu">
                                <div class="container-fluid">

                                    <div class="collapse navbar-collapse">
                                        <ul class="nav navbar-nav navbar-lev-1">

                                            <!-- home -->
                                            <li><a href="/">"""),_display_(Seq[Any](/*113.62*/Messages("menu.home"))),format.raw/*113.83*/("""</a></li>


                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>

                        <!-- content -->
                        """),_display_(Seq[Any](/*123.26*/content)),format.raw/*123.33*/("""
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>"""))}
    }
    
    def render(languages:be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],data:be.flo.project.dto.InterfaceDataDTO,content:Html): play.api.templates.HtmlFormat.Appendable = apply(languages,data)(content)
    
    def f:((be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],be.flo.project.dto.InterfaceDataDTO) => (Html) => play.api.templates.HtmlFormat.Appendable) = (languages,data) => (content) => apply(languages,data)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 18 14:11:14 CEST 2015
                    SOURCE: /home/florian/idea/project/app/be/flo/project/views/template.scala.html
                    HASH: a36f6f4920da5a8ea5fc06b012f3121fa84bc752
                    MATRIX: 881->1|1149->123|1177->177|1241->207|1260->218|1290->227|1550->451|1621->500|1688->531|1772->593|1835->620|1849->625|1883->637|2390->1108|2433->1129|3278->1938|3321->1959|3590->2192|3638->2217|3709->2252|3753->2274|3887->2372|3936->2398|4220->2654|4249->2655|4278->2656|4322->2672|4351->2673|4380->2674|4409->2675|4438->2676|4467->2677|4510->2692|4539->2693|4568->2694|4708->2798|4760->2827|4897->2928|4946->2954|5493->3465|5536->3486|5841->3754|5889->3779|5972->3826|6016->3848|6163->3958|6212->3984|6512->4256|6541->4257|6570->4258|6614->4274|6643->4275|6672->4276|6701->4277|6730->4278|6759->4279|6802->4294|6831->4295|6860->4296|7006->4405|7058->4434|7212->4551|7261->4577|8049->5328|8093->5349|8403->5622|8433->5629
                    LINES: 26->1|30->1|32->4|36->8|36->8|36->8|43->15|43->15|44->16|44->16|45->17|45->17|45->17|56->28|56->28|77->49|77->49|82->54|82->54|83->55|83->55|84->56|84->56|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|91->63|91->63|109->81|109->81|113->85|113->85|114->86|114->86|115->87|115->87|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|121->93|121->93|122->94|122->94|141->113|141->113|151->123|151->123
                    -- GENERATED --
                */
            