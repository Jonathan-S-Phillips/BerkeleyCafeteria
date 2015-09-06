import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_session_templates_userMenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/session/templates/_userMenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(session.cartItems)
printHtmlPart(2)
})
invokeTag('link','g',5,['controller':("store"),'action':("displayCart")],1)
printHtmlPart(3)
expressionOut.print(user.name)
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',15,['controller':("store"),'action':("pastOrders")],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',17,['controller':("session"),'action':("logout")],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441559103962L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
