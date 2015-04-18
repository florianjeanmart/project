
package be.flo.project.views.html.pageElement

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
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
<head>
    <title>"""),_display_(Seq[Any](/*3.13*/Messages("site.name"))),format.raw/*3.34*/("""</title>
    <meta charset="utf-8"/>
        <!-- change scale for mobile -->
    <meta name="viewport" content="width=device-width, initial-scale=0.6">

        <!-- icon
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png"))),format.raw/*9.93*/("""">
        -->

        <!-- javascript library -->
    <script src=""""),_display_(Seq[Any](/*13.19*/routes/*13.25*/.Assets.at("components/jquery/dist/jquery.min.js"))),format.raw/*13.75*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*14.19*/routes/*14.25*/.Assets.at("components/angular/angular.min.js"))),format.raw/*14.72*/("""" type="text/javascript"></script>

    <!-- javascript -->

    <!-- components -->
    <script src=""""),_display_(Seq[Any](/*19.19*/routes/*19.25*/.Assets.at("components/bootstrap/dist/js/bootstrap.min.js"))),format.raw/*19.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*20.19*/routes/*20.25*/.Assets.at("components/messenger/build/js/messenger.min.js"))),format.raw/*20.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*21.19*/routes/*21.25*/.Assets.at("components/moment/min/moment.min.js"))),format.raw/*21.74*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*22.19*/routes/*22.25*/.Assets.at("components/angular-bootstrap/ui-bootstrap.min.js"))),format.raw/*22.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*23.19*/routes/*23.25*/.Assets.at("components/angular-bootstrap/ui-bootstrap-tpls.min.js"))),format.raw/*23.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*24.19*/routes/*24.25*/.Assets.at("components/angucomplete/angucomplete.js"))),format.raw/*24.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Assets.at("components/underscore/underscore-min.js"))),format.raw/*25.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*26.19*/routes/*26.25*/.Assets.at("components/mathjs/dist/math.min.js"))),format.raw/*26.73*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.Assets.at("components/angular-bootstrap-datetimepicker/src/js/datetimepicker.js"))),format.raw/*27.107*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*28.19*/routes/*28.25*/.Assets.at("components/angular-i18n/angular-locale_fr-fr.js"))),format.raw/*28.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*29.19*/routes/*29.25*/.Assets.at("components/angular-dynamic-locale/src/tmhDynamicLocale.js"))),format.raw/*29.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*30.19*/routes/*30.25*/.Assets.at("components/bootstrap/js/transition.js"))),format.raw/*30.76*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*31.19*/routes/*31.25*/.Assets.at("components/bootstrap/js/collapse.js"))),format.raw/*31.74*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*32.19*/routes/*32.25*/.Assets.at("components/ng-file-upload/angular-file-upload-all.min.js"))),format.raw/*32.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*33.19*/routes/*33.25*/.Assets.at("components/ng-file-upload/angular-file-upload-shim.min.js"))),format.raw/*33.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*34.19*/routes/*34.25*/.Assets.at("javascripts/menu-animation.js"))),format.raw/*34.68*/("""" type="text/javascript"></script>

    <!-- controllers -->
    <script src=""""),_display_(Seq[Any](/*37.19*/routes/*37.25*/.Assets.at("javascripts/controller/MainCtrl.js"))),format.raw/*37.73*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*38.19*/routes/*38.25*/.Assets.at("javascripts/controller/WelcomeCtrl.js"))),format.raw/*38.76*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*39.19*/routes/*39.25*/.Assets.at("javascripts/controller/LateralMenuCtrl.js"))),format.raw/*39.80*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*40.19*/routes/*40.25*/.Assets.at("javascripts/controller/HomeCtrl.js"))),format.raw/*40.73*/("""" type="text/javascript"></script>

    <!-- directives -->
    <script src=""""),_display_(Seq[Any](/*43.19*/routes/*43.25*/.Assets.at("javascripts/directive/dirEnter/directive.js"))),format.raw/*43.82*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*44.19*/routes/*44.25*/.Assets.at("javascripts/directive/dirFieldDate/directive.js"))),format.raw/*44.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*45.19*/routes/*45.25*/.Assets.at("javascripts/directive/dirFieldSelect/directive.js"))),format.raw/*45.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*46.19*/routes/*46.25*/.Assets.at("javascripts/directive/dirFieldText/directive.js"))),format.raw/*46.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*47.19*/routes/*47.25*/.Assets.at("javascripts/directive/dirFocusMe/directive.js"))),format.raw/*47.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*48.19*/routes/*48.25*/.Assets.at("javascripts/directive/dirInputNumber/directive.js"))),format.raw/*48.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*49.19*/routes/*49.25*/.Assets.at("javascripts/directive/dirFieldCheck/directive.js"))),format.raw/*49.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*50.19*/routes/*50.25*/.Assets.at("javascripts/directive/dirFieldDocument/directive.js"))),format.raw/*50.90*/("""" type="text/javascript"></script>

    <!-- filters -->
    <script src=""""),_display_(Seq[Any](/*53.19*/routes/*53.25*/.Assets.at("javascripts/filter/TranslateTextFilter.js"))),format.raw/*53.80*/("""" type="text/javascript"></script>

    <!-- modals -->
    <script src=""""),_display_(Seq[Any](/*56.19*/routes/*56.25*/.Assets.at("javascripts/modal/LoginModal/LoginModal.js"))),format.raw/*56.81*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*57.19*/routes/*57.25*/.Assets.at("javascripts/modal/RegistrationModal/RegistrationModal.js"))),format.raw/*57.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*58.19*/routes/*58.25*/.Assets.at("javascripts/modal/ChangeEmail/ChangeEmailModal.js"))),format.raw/*58.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*59.19*/routes/*59.25*/.Assets.at("javascripts/modal/ChangePassword/ChangePasswordModal.js"))),format.raw/*59.94*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*60.19*/routes/*60.25*/.Assets.at("javascripts/modal/ForgotPassword/ForgotPasswordModal.js"))),format.raw/*60.94*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*61.19*/routes/*61.25*/.Assets.at("javascripts/modal/HelpModal/HelpModalCtrl.js"))),format.raw/*61.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*62.19*/routes/*62.25*/.Assets.at("javascripts/modal/EditProfileModal/EditProfileModal.js"))),format.raw/*62.93*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*63.19*/routes/*63.25*/.Assets.at("javascripts/modal/DownloadFieldModal/DownloadFieldModal.js"))),format.raw/*63.97*/("""" type="text/javascript"></script>


    <!-- services -->
    <script src=""""),_display_(Seq[Any](/*67.19*/routes/*67.25*/.Assets.at("javascripts/service/DirectiveService.js"))),format.raw/*67.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*68.19*/routes/*68.25*/.Assets.at("javascripts/service/FlashService.js"))),format.raw/*68.74*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*69.19*/routes/*69.25*/.Assets.at("javascripts/service/GenerateIdService.js"))),format.raw/*69.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*70.19*/routes/*70.25*/.Assets.at("javascripts/service/TranslationService.js"))),format.raw/*70.80*/("""" type="text/javascript"></script>

<!--
    <script src=""""),_display_(Seq[Any](/*73.19*/routes/*73.25*/.Assets.at("dist/angular.min.js"))),format.raw/*73.58*/("""" type="text/javascript"></script>
-->
    <!-- css -->
    <!-- dependencies -->
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*77.50*/routes/*77.56*/.Assets.at("components/angucomplete/angucomplete.css"))),format.raw/*77.110*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*78.50*/routes/*78.56*/.Assets.at("components/bootstrap/dist/css/bootstrap.min.css"))),format.raw/*78.117*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*79.50*/routes/*79.56*/.Assets.at("components/bootstrap/dist/css/bootstrap-theme.min.css"))),format.raw/*79.123*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*80.50*/routes/*80.56*/.Assets.at("components/messenger/build/css/messenger.css"))),format.raw/*80.114*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*81.50*/routes/*81.56*/.Assets.at("components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css"))),format.raw/*81.140*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*82.50*/routes/*82.56*/.Assets.at("components/font-awesome/css/font-awesome.min.css"))),format.raw/*82.118*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*83.50*/routes/*83.56*/.Assets.at("components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css"))),format.raw/*83.157*/("""">

    <!-- main -->
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*86.50*/routes/*86.56*/.Assets.at("stylesheets/main.css"))),format.raw/*86.90*/("""">

</head>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 18 14:11:14 CEST 2015
                    SOURCE: /home/florian/idea/project/app/be/flo/project/views/pageElement/header.scala.html
                    HASH: f692920ef63b2793b4a133b52e84c78a88f9ec4e
                    MATRIX: 795->1|890->3|945->23|987->44|1248->270|1262->276|1315->308|1421->378|1436->384|1508->434|1597->487|1612->493|1681->540|1820->643|1835->649|1916->708|2005->761|2020->767|2102->827|2191->880|2206->886|2277->935|2366->988|2381->994|2465->1056|2554->1109|2569->1115|2658->1182|2747->1235|2762->1241|2837->1294|2926->1347|2941->1353|3016->1406|3105->1459|3120->1465|3190->1513|3279->1566|3294->1572|3399->1654|3488->1707|3503->1713|3586->1774|3675->1827|3690->1833|3783->1904|3872->1957|3887->1963|3960->2014|4049->2067|4064->2073|4135->2122|4224->2175|4239->2181|4331->2251|4420->2304|4435->2310|4528->2381|4617->2434|4632->2440|4697->2483|4812->2562|4827->2568|4897->2616|4986->2669|5001->2675|5074->2726|5163->2779|5178->2785|5255->2840|5344->2893|5359->2899|5429->2947|5543->3025|5558->3031|5637->3088|5726->3141|5741->3147|5824->3208|5913->3261|5928->3267|6013->3330|6102->3383|6117->3389|6200->3450|6289->3503|6304->3509|6385->3568|6474->3621|6489->3627|6574->3690|6663->3743|6678->3749|6762->3811|6851->3864|6866->3870|6953->3935|7064->4010|7079->4016|7156->4071|7266->4145|7281->4151|7359->4207|7448->4260|7463->4266|7555->4336|7644->4389|7659->4395|7744->4458|7833->4511|7848->4517|7939->4586|8028->4639|8043->4645|8134->4714|8223->4767|8238->4773|8318->4831|8407->4884|8422->4890|8512->4958|8601->5011|8616->5017|8710->5089|8823->5166|8838->5172|8913->5225|9002->5278|9017->5284|9088->5333|9177->5386|9192->5392|9268->5446|9357->5499|9372->5505|9449->5560|9544->5619|9559->5625|9614->5658|9781->5789|9796->5795|9873->5849|9961->5901|9976->5907|10060->5968|10148->6020|10163->6026|10253->6093|10341->6145|10356->6151|10437->6209|10525->6261|10540->6267|10647->6351|10735->6403|10750->6409|10835->6471|10923->6523|10938->6529|11062->6630|11169->6701|11184->6707|11240->6741
                    LINES: 26->1|29->1|31->3|31->3|37->9|37->9|37->9|41->13|41->13|41->13|42->14|42->14|42->14|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|78->50|81->53|81->53|81->53|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|101->73|101->73|101->73|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|114->86|114->86|114->86
                    -- GENERATED --
                */
            