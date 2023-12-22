describe('Home', () => {

    it('should navigate to home', () => {
        cy.visit('http://localhost:80/')
        cy.url().should('include', 'localhost')
    })
})