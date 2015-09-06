import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_store_templates_cashierActionButtons_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/templates/_cashierActionButtons.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',5,['controller':("store"),'action':("updateOrderStatus"),'id':(order.id),'params':([status:'Picked Up']),'class':("btn btn-default")],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',9,['controller':("store"),'action':("updateOrderStatus"),'id':(order.id),'params':([status:'Missed']),'class':("btn btn-default")],1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441562114774L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
