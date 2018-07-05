

  this.LoginPage = $page("Login page", {
    username:     "[name*='login.username']"  , 
    password:     "[name*='login.password']"  , 
    loginButton:  ".button-login"             , 
  
    loginAs: function (username, password) {
        this.   username    .typeText(username);
        this.   password    .typeText(password);
        this.   loginButton .click();
    },
    clicklogin: function () {
        this.loginButton.click();
      }
  });