# Selenium Automation Framework (Java + TestNG + Maven)

This is a scalable automation framework built using:
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager

## Features
✔ Cross-browser support  
✔ Config-driven execution  
✔ Page Object Model (POM)  
✔ Data-driven capability  
✔ Supports parallel execution  
✔ Extent reporting integration  
✔ Jenkins / CI-ready structure

## Tech Stack
| Component | Tool |
|----------|------|
| Programming | Java |
| Build Tool | Maven |
| Test Runner | TestNG |
| Design Pattern | POM |
| Browser Drivers | WebDriverManager |
| Reporting | Extent Reports |

## Project Structure
src/main/java  
 ├ base → test setup & teardown  
 ├ driver → WebDriver lifecycle  
 ├ pages → page object classes  
 ├ utils → reusable helper utilities  
src/test/java  
 └ tests → test classes

## How to run
mvn clean test -DsuiteXmlFile=testng.xml


## Test Scenarios
- Valid login
- Invalid login

## CI/CD
Jenkins pipeline support will be added.

## Roadmap
⬜ Parallel execution  
⬜ Screenshot capture on failure  
⬜ Configuration from config.properties  
⬜ Allure/Extent reporting  
⬜ API + UI integration tests
