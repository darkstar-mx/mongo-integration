import grails.util.Environment
import mx.blogspot.decibelelektrobeat.ApplicationRole
import mx.blogspot.decibelelektrobeat.ApplicationUser

class BootStrap {

    def bcryptService

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            ApplicationRole adminRole 				= new ApplicationRole(name: 'ADMIN', description: 'Administrator role')
            adminRole.save(failOnError:true)

            ApplicationRole user1Role 				= new ApplicationRole(name:'USER', description: 'User role')
            user1Role.save(failOnError:true)

            ApplicationUser user 		= new ApplicationUser()
            user.username 				= "john"
            user.password 				= bcryptService.hashPassword("john1234xx")
            user.enabled 				= true
            user.accountNonExpired 		= true
            user.accountNonLocked 		= true
            user.credentialsNonExpired 	= true
            user.forceLocalLogin 		= true


            user.roles 					= []
            user.roles 					<< user1Role
            user.roles 					<< adminRole


            ApplicationUser.withTransaction {
                user.save(failOnError: true)
            }

        }
    }
    def destroy = {
    }
}
