import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_storepastOrders_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/store/pastOrders.gsp" }
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
expressionOut.print(resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/sortable', file: 'bootstrap-sortable.css'))
printHtmlPart(4)
invokeTag('javascript','g',7,['src':("js-lib/bootstrap-3.3.4-dist/sortable/moment.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',8,['src':("js-lib/bootstrap-3.3.4-dist/sortable/bootstrap-sortable.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',9,['src':("store/store.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('success','applicationTag',14,['success':(flash.success)],-1)
printHtmlPart(7)
invokeTag('render','g',28,['template':("/store/templates/pastOrders"),'model':(['orders':outstanding, 'addActions':true])],-1)
printHtmlPart(8)
invokeTag('render','g',31,['template':("/store/templates/pastOrders"),'model':(['orders':completed, 'addActions':true])],-1)
printHtmlPart(9)
invokeTag('render','g',34,['template':("/store/templates/pastOrders"),'model':(['orders':missed, 'addActions':true])],-1)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',39,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441558397713L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
