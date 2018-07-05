

// Just clicks to the login button
driver.findElement(By.cssSelector(".button-login")).click();

// Waiting till login page is shown 
function pageIsLoaded() {
    return driver.findElement(By.name("login.username")) != null;
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