import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_store_templates_menuItem_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/templates/_menuItem.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('img','g',3,['dir':("images/food"),'file':(menuItem.image),'width':("64"),'height':("64")],-1)
printHtmlPart(1)
expressionOut.print(menuItem.name)
printHtmlPart(2)
invokeTag('formatNumber','g',9,['number':(menuItem.price * quantity),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(3)
invokeTag('menuItemQuantity','storeTag',15,['menuItem':(menuItem),'quantity':(quantity),'displayQuantityField':(displayQuantityField)],-1)
printHtmlPart(4)
invokeTag('addToCartButton','storeTag',18,['menuItem':(menuItem),'displayAddToCartButton':(displayAddToCartButton)],-1)
printHtmlPart(5)
invokeTag('removeFromCartButton','storeTag',19,['menuItem':(menuItem),'displayRemoveFromCartButton':(displayRemoveFromCartButton)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441505345474L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
