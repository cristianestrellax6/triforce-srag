this.WelcomePage = $page("Welcome page", {
    loginButton:  ".button-login", 
  
    clicklogin: function () {
        this.loginButton.click();
      }
  });