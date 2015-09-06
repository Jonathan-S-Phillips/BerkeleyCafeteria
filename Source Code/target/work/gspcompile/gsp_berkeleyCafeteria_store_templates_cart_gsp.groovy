import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_store_templates_cart_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/templates/_cart.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(order.countMenuItems())
printHtmlPart(1)
invokeTag('formatNumber','g',5,['number':(order.price()),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',12,['controller':("store"),'action':("emptyCart"),'class':("btn btn-default pull-right"),'role':("button")],1)
printHtmlPart(4)
invokeTag('menuItems','storeTag',18,['menuItems':(order.menuItems()),'order':(order),'displayQuantityField':(displayQuantityField)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',24,['number':(order.price()),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441552676927L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
