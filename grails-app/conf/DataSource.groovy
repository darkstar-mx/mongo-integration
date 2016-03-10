// environment specific settings
environments {
    development {

        grails {
            mongo {
                host = "localhost"
                port = 27107
                username = "user-dev"
                password = "user-dev"
                databaseName = "application-dev"
            }
        }
        /*
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
        }*/
    }
    test {
        grails {
            mongo {
                host = "localhost"
                port = 27107
                username = "user-test"
                password = "user-test"
                databaseName = "application-test"
            }
        }
        /*
        dataSource {
            dbCreate = "update"
        }*/
    }
    production {
        grails {
            mongo {
                host = "localhost"
                port = 27107
                username = "user-prod"
                password = "user-prod"
                databaseName = "application-prod"
            }
        }
    }
}
