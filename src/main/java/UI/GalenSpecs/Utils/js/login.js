// These two values are passed from Galen test
var userLogin = arg.login;
var userPassword = arg.password

// Just clicks to the login button
driver.findElement(By.cssSelector(".button-login")).click();

// Waiting till login page is shown 
function pageIsLoaded() {
    return driver.findElement(By.name("login.username")) != null;
}

// Sending username and password to the form
driver.findElement(By.name("login.username")).sendKeys(userLogin);
driver.findElement(By.name("login.password")).sendKeys(userPassword);

// Submitting the login form
driver.findElement(By.cssSelector(".button-login")).click();

// Waiting till my notes page is shown 
function pageIsLoaded() {
    return driver.findElement(By.id("my-notes-page")) != null;
}


waitFor(pageIsLoaded);

function waitFor(func) {
    var timeout = 10;

    while(timeout > 0 && !func()) {
        timeout = timeout - 1;
        Thread.sleep(1000);
    }

    if (!func()) {
        throw new Error("Wait timeout");
    }
}