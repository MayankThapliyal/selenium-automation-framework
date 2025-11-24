# 🚀 Selenium Automation Framework

![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-Automation-orange)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Page Object Model](https://img.shields.io/badge/Pattern-Page%20Object%20Model-yellow)
![WebDriverManager](https://img.shields.io/badge/WebDriverManager-Automation-informational)
![Extent Reports](https://img.shields.io/badge/Reporting-Extent%20Reports-blueviolet)
![GitHub Actions](https://img.shields.io/badge/CI-GitHub%20Actions-lightgrey)

---

## 📌 Overview
This repository contains a **production-grade Selenium Test Automation Framework** built with Java, TestNG, Maven, and Page Object Model (POM).  
It is designed to demonstrate **enterprise-level automation engineering capability** — including configurability, scalability, clean architecture, multibrowser execution, advanced reporting, and CI/CD readiness.

---

## 🏗 Architecture

┌──────────────────────────────────────────┐
│ TestNG Test Suite │
└──────────────────────────────────────────┘
│
▼
┌──────────────────────────────────────────┐
│ Test Classes │
└──────────────────────────────────────────┘
│
▼
┌──────────────────────────────────────────┐
│ Page Object Model (Pages Layer) │
└──────────────────────────────────────────┘
│
▼
┌──────────────────────────────────────────┐
│ Driver Manager | ElementActions | Waits │
└──────────────────────────────────────────┘
│
▼
┌──────────────────────────────────────────┐
│ Reporting + Listeners + Logs │
└──────────────────────────────────────────┘

---

## 📁 Project Structure

src
└─ test
├─ java
│ ├─ base
│ ├─ driver
│ ├─ listeners
│ ├─ pages
│ ├─ tests
│ └─ utils
└─ resources
├─ config.properties
└─ testng.xml
reports
└─ run_<timestamp>
├─ ExtentReport.html
└─ screenshots

---

## 🔥 Framework Highlights

| Feature | Status |
|--------|--------|
| Selenium + TestNG | ✔ |
| Page Object Model | ✔ |
| Multi-browser (Chrome / Firefox / Edge) | ✔ |
| Config-driven URL & browser | ✔ |
| Explicit Wait wrapper | ✔ |
| Centralized ElementActions with retries | ✔ |
| Extent Reports with logs | ✔ |
| Screenshots on failure | ✔ |
| Unique report folder per execution | ✔ |
| CI compatibility | ✔ |

---

## 🧪 How to Run

### 📍 From IDE (TestNG Suite)
Right-click `testng.xml` → **Run as TestNG Suite**

### 📍 Using Maven
mvn clean test

### 🌐 Override Browser
mvn clean test -Dbrowser=edge

### 🔗 Override URL
mvn clean test -Durl=https://google.com
---

## 📸 Sample Report Output

> File generated at:  
> `reports/run_<timestamp>/ExtentReport.html`

Contains:
- step-by-step logging
- system details
- screenshots attached on failure

---

## 🛣 Roadmap
| Upgrade | Status |
|---------|-------|
| Current Extent Reporting | ✔ Completed |
| Retry Analyzer for flaky tests | 🔜 |
| Parallel execution support | 🔜 |
| Video recording | 🔜 |
| Automatic run trigger via GitHub Actions | 🔜 |
| API testing integration (Rest-Assured) | 🔜 |

---

## 👤 Author
**Mayank Thapliyal — SDET & Automation Engineer**

🔗 LinkedIn: *https://www.linkedin.com/in/mayank-thapliyal-201822*  
🔗 GitHub: *https://github.com/MayankThapliyal*

---

If you find this project useful, a ⭐ on the repository is appreciated! 🙂