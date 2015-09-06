class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"session", action:"index")
        "500"(view:'/error')
		"/login"(controller:"session", action:"login")
	}
}
