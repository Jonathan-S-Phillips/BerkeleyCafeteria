import berkeleycafeteria.StartUpActions

class BootStrap {
	
    def init = { servletContext ->
		StartUpActions.init()
    }
	
    def destroy = {
    }
}
