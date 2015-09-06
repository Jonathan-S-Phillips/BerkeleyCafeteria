import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_storedisplayCart_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/displayCart.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
expressionOut.print(resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.date.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/js-lib/jQuery/pickadate', file: 'default.time.css'))
printHtmlPart(5)
invokeTag('javascript','g',9,['src':("js-lib/jQuery/jquery-ui-1.11.0.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',10,['src':("js-lib/jQuery/jquery.blockUI.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',11,['src':("js-lib/date.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',12,['src':("js-lib/jQuery/pickadate/picker.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',13,['src':("js-lib/jQuery/pickadate/picker.date.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',14,['src':("js-lib/jQuery/pickadate/picker.time.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',15,['src':("store/store.js")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('stores','storeTag',21,[:],-1)
printHtmlPart(8)
invokeTag('render','g',26,['template':("/store/templates/checkout")],-1)
printHtmlPart(9)
invokeTag('success','applicationTag',30,['success':(flash.success)],-1)
printHtmlPart(10)
invokeTag('error','applicationTag',31,['error':(flash.error)],-1)
printHtmlPart(11)
invokeTag('render','g',34,['template':("/store/templates/cart"),'model':(['displayQuantityField':true])],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',39,['controller':("session"),'action':("index"),'class':("btn btn-default"),'role':("button")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',42,['url':("#"),'class':("btn btn-default"),'role':("button"),'onclick':("checkout();")],2)
printHtmlPart(16)
expressionOut.print(request.contextPath)
printHtmlPart(17)
expressionOut.print(order.cafeteriaOrderMenuItems?.size())
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441554315739L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
