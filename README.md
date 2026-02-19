# Amazon Web Testing Automation

BDD test automation framework for Amazon web application using Cucumber, Selenium, and TestNG.

## Tech Stack

- **Java 17**
- **Selenium 4.27** — browser automation
- **Cucumber 7.20** — BDD framework
- **TestNG 7.10** — test runner
- **Allure 2.29** — reporting
- **Logback** — logging
- **WebDriverManager** — automatic driver management

## Project Structure

```
src/
├── main/java/com/amazon/automation/
│   ├── config/         ConfigReader (env-aware)
│   ├── driver/         DriverFactory (thread-safe)
│   ├── pages/          Page objects (BasePage, AmazonHomePage)
│   └── utils/          WaitUtils, ScreenshotUtils
├── main/resources/
│   ├── config/         qa / staging / prod properties
│   └── logback.xml
├── test/java/com/amazon/automation/
│   ├── hooks/          Cucumber Before/After
│   ├── runners/        TestNG-Cucumber runner
│   └── steps/          Step definitions
└── test/resources/
    ├── features/       .feature files
    └── testng.xml
```

## Prerequisites

- Java 17+
- Maven 3.8+
- Chrome / Firefox / Edge browser

## Setup

```bash
git clone <repo-url>
cd AmazonWebTestingAutomation
mvn clean compile
```

## Run Tests

```bash
# default (qa environment, chrome)
mvn test

# specific environment
mvn test -Denv=staging

# specific browser
mvn test -Dbrowser=firefox

# headless mode is controlled by the environment properties
```

## Reports

```bash
# generate and open Allure report
mvn allure:serve

# or generate to target/site/allure-report
mvn allure:report
```

Logs are written to the console and `logs/automation.log`.
