import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_store_templates_order_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/templates/_order.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',3,['format':("MM/dd/yyyy h:mm a"),'date':(order.pickupTime)],-1)
printHtmlPart(1)
expressionOut.print(student.name)
printHtmlPart(2)
invokeTag('listMenuItems','storeTag',7,['order':(order)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',10,['number':(order.price()),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(4)
invokeTag('orderActions','storeTag',12,['addActionButtons':(addActionButtons),'order':(order)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441557685774L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
