workspace {

    model {
        developer = person "Developer" "A user how use the secrets."
        admin = person "Admin" "A user who manage the secrets."
        vault = softwareSystem "Vault" "Software that manage secrets."{
            frontend = container "backoffice" "React SPA" 
            api = container "vault API" " Spring Boot WebService"
            redis = container "BBDD" "Redis storage for secrets" {
                tags "Database"
            }
            library = container "Library" "Spring Boot Java Library"

        }
        app = softwareSystem "App" "Random app that uses vault."


        developer -> app "Develops"
        admin -> frontend "Manages secrets in"
        frontend -> api "Manage secrets"
        api -> redis "stores secrets in"
        library -> api "Consumes secrets from"
        app -> library "Uses"

    }

    views {
        systemLandscape "VaultLandscape" {
            include *
            autoLayout
        }
        container vault "vaultcontainer"{
            include *
            autoLayout lr
        }

        styles {
            element "Software System" {
                background #1168bd
                color #ffffff
            }
            element "Person" {
                shape person
                background #08427b
                color #ffffff
            }
            element "Container" {
                background #438dd5
                color #ffffff
            }
            element "Database" {
                shape Cylinder
            }
        }
    }

}