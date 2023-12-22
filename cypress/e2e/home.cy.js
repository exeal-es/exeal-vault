describe('Home', () => {

    it('should display secrets', () => {
        cy.visit('http://localhost:80/')
        cy.url().should('include', 'localhost')

        cy.get('p').contains('api_secret')
        cy.get('p').contains('123456')
    })


})

