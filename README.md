# FUN_DEMO_PROJECT

This testing project focuses on conducting UI tests for native mobile applications (iOS and Android) and web applications.
The project includes a variety of tests, such as functional tests for native mobile apps and screenshot comparison tests
for web apps.

Continuous Integration (CI) has been implemented using GitHub Actions, ensuring automated builds and tests are executed
upon each code change. The project is integrated with the Sauce Labs device farm, which provides a wide range of real 
devices for testing across different platforms and configurations.

For test result reporting, the project utilizes the Jira plugin X-Ray. This plugin enables seamless integration with Jira,
allowing test results and associated details to be easily tracked, managed, and reported within the project management 
system.

Overall, this testing project combines the power of CI, cloud-based device testing, and comprehensive reporting to 
ensure reliable and efficient testing of native mobile apps and web applications.

# ENVIRONMENTS/BROWSERS

`gradle test --tests "WebTest.compare image" -Denv=remote -Dbrowser=ie`  -- run single test class against Internet Explorer

There are web environments:

- selenoid

  Tests run in Docker containers ( Containers should be installed https://aerokube.com/selenoid/) located locally

- remote

  Tests run in selenoid located remotely.

By default, tests run against Chrome browser on local selenoid browser

There are mobile environments:

- android_local

- android_remote

- ios_local

- ios_remote

`gradle test --tests "MobileTest.Echo Box tab works well" -Denv=ios_remote`

# SCREENSHOTS COMPARISON

`gradle test --tests "WebTest.compare image" -Denv=remote -Dbaseline=true`  -- make baseline images

`gradle test --tests "WebTest.compare image"`  -- run comparison

TODO: tune reporting
TODO: tune cross-platform testing with SauceLabs
TODO: complete readme
TODO: figure out what wrong with tags
`gradle test -Dspock.tags=ios`
TODO: slack integration
TODO: any ideas ......

# useful links
https://github.com/amuthansakthivel/SelenideAppiumFramework/tree/master