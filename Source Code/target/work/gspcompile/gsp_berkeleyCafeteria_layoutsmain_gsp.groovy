import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_berkeleyCafeteria_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',6,['default':("SmartCaseLaw")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'bootstrap.min.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'sticky-footer.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'js/js-lib/bootstrap-3.3.4-dist/css', file: 'custom-navbar.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'main.css'))
printHtmlPart(4)
invokeTag('javascript','asset',12,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',13,['src':("js-lib/jQuery/jquery-1.11.2.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',14,['src':("js-lib/bootstrap-3.3.4-dist/js/bootstrap.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',15,[:],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',18,['template':("/layouts/templates/header")],-1)
printHtmlPart(1)
invokeTag('layoutBody','g',19,[:],-1)
printHtmlPart(1)
invokeTag('render','g',20,['template':("/layouts/templates/footer")],-1)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',21,[:],1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441488243846L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
