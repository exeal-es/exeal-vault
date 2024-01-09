workspace {

    model {
        developer = person "Developer" "A user how use the secrets."
        admin = person "Admin" "A user who manage the secrets."
        vault = softwareSystem "Vault" "Software that manage secrets."
        app = softwareSystem "App" "Random app that uses vault."


        developer -> app "Develops"
        admin -> vault "Manages secrets in"
        app -> vault "Consumes secrets from"
        
    }

    views {
        systemLandscape "VaultLandscape" {
            include *
            autoLayout
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
        }
    }
    
}