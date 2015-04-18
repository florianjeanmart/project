
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
object home extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],be.flo.project.dto.InterfaceDataDTO,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(languages:be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],data:be.flo.project.dto.InterfaceDataDTO):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import com.fasterxml.jackson.databind.ObjectMapper


Seq[Any](format.raw/*1.109*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/template(languages,data)/*5.26*/ {_display_(Seq[Any](format.raw/*5.28*/("""

    <div ng-controller="HomeCtrl">

    <button type="button" class="btn btn-primary" ng-click="downloadModal()">TEST DOWNLOAD</button>


    </div>
""")))})))}
    }
    
    def render(languages:be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],data:be.flo.project.dto.InterfaceDataDTO): play.api.templates.HtmlFormat.Appendable = apply(languages,data)
    
    def f:((be.flo.project.dto.ListDTO[be.flo.project.dto.LangDTO],be.flo.project.dto.InterfaceDataDTO) => play.api.templates.HtmlFormat.Appendable) = (languages,data) => apply(languages,data)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 18 14:11:14 CEST 2015
                    SOURCE: /home/florian/idea/project/app/be/flo/project/views/home.scala.html
                    HASH: 57b592c63e489fcb08dcb65c7b5346d5fed62d8d
                    MATRIX: 872->1|1125->108|1153->162|1189->164|1221->188|1260->190
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5
                    -- GENERATED --
                */
            