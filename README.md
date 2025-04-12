# Trello API Test Suite

This project is a **REST API test automation suite** for Trello's core board operations using **Java**, **Rest Assured**, and **JUnit 5**. It validates critical CRUD (Create, Read, Update, Delete) functionality of Trello boards and ensures proper error handling for invalid credentials.

---

## 🚀 Project Overview

The goal of this project is to ensure **reliable and secure interaction** with Trello’s REST API through automated tests. These tests simulate real-world API usage and verify response status codes, response bodies, and schema contracts.

---

## 🛠️ Key Features & Technologies

- ✅ **Create**, **Get**, **Update**, and **Delete** Trello boards
- 🔐 Error handling tests for **unauthorized** or **invalid token**
- 📦 Built with:
    - **Java 21**
    - **Maven**
    - **Rest Assured 5.3**
    - **JUnit Jupiter 5**
    - **Hamcrest**
    - **Dotenv Java** – for managing secrets securely

---
## 🧑‍💻 Recommended IDE

We recommend using **IntelliJ IDEA** for the best experience. IntelliJ offers:

- Native support for Maven
- Advanced JUnit test runners
- Environment variable configuration
- Syntax highlighting and code assistance for Java and REST tests

> You can also use Eclipse or VS Code with the Java and Maven extensions installed.

---

## 📥 Importing the Project

### Option 1: IntelliJ IDEA

1. **Open IntelliJ IDEA**
2. Click on `File` → `Open` → Select the `trello-api-tests` folder.
3. IntelliJ will auto-detect it as a Maven project.
4. Wait for the Maven dependencies to finish downloading.
5. Right-click on `src/test/java` → Run individual tests or test classes.

### Option 2: Eclipse

1. Open Eclipse.
2. Go to `File` → `Import` → `Existing Maven Projects`.
3. Browse to and select the `trello-api-tests` folder.
4. Click `Finish`.

---

## 📂 Project Structure

trello-api-tests/ ├── src/ │ └── test/ │ └── java/ │ └── com/ │ └── trello/ │ ├── TrelloApiTest.java │ └── TrelloTestBase.java ├── .env ├── pom.xml └── README.md


---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/your-username/trello-api-tests.git
cd trello-api-tests
```

### 2. Add your Trello API credentials

Create a .env file in the root folder and add:

TRELLO_API_KEY=your_api_key_here
TRELLO_TOKEN=your_token_here

🔒 Never commit your .env file. Add .env to .gitignore.

2️⃣ Open in Your IDE


🧠 IntelliJ IDEA (Recommended)
Open IntelliJ IDEA.

Click on File → Open → Select the trello-api-tests folder you just cloned.

IntelliJ will auto-detect it as a Maven project and resolve dependencies.

After indexing completes, go to src/test/java, right-click on test class → Run Tests.

🧠 Eclipse (Alternative)
Open Eclipse.

Go to File → Import → Maven → Existing Maven Projects.

Browse and select the trello-api-tests directory.

Click Finish.

### 3. Run tests (option to run from command line, make sure maven is installed)

mvn clean test

### 4. ✅ Sample Test Report

---------------------------------------------------------
Trello API Test Summary
---------------------------------------------------------
✓ createBoard_shouldReturn200_andValidateSchema     [PASS]
✓ getBoard_shouldReturn200_andMatchId               [PASS]
✓ updateBoard_shouldReturn200_andUpdateName         [PASS]
✓ deleteBoard_shouldReturn200_andVerifyBoardDeleted [PASS]
✓ createBoard_withInvalidToken_shouldReturn401      [PASS]
✓ accessBoard_withMissingKey_shouldReturn401        [PASS]
---------------------------------------------------------
✅ Total Tests: 6 | ✅ Passed: 6 | ❌ Failed: 0

🧪 Postman Collection

This project includes a Postman collection for testing Trello's Board API endpoints. Follow the steps below to import, configure, and run the collection.

📥 1. Import the Collection & Environment

Download the following files from repo:

TrelloAPI.postman_collection.json (Contains all API requests)

TrelloEnvironment.postman_environment.json (Contains your API key, token, and dynamic board ID)

Open Postman.

Click Import (top left), go to the "File" tab, and upload both JSON files.

Go to the Environments tab (⚙️ gear icon, top-right), and select TrelloEnvironment from the dropdown to activate it.

🔧 2. Configure Your Environment
In Postman, navigate to the Environments tab.
After importing the environment, configure it with your actual credentials:

Variable	Description	Required
TRELLO_API_KEY	Your Trello API key	✅
TRELLO_TOKEN	Your Trello API token	✅
boardId	Auto-generated during tests	❌

💡 The boardId is used and updated automatically by test scripts during runtime.

To update values:

Go to the Environments tab.

Click on TrelloEnvironment.

Replace your_api_key_here and your_token_here with real values.

Click Update.

▶️ 3. Run the Collection
Open the TrelloAPI collection.

Run requests individually or as a sequence using the Collection Runner.

Ensure the active environment is set to TrelloEnvironment.

✅ Included Tests

Create Board

Get Board

Update Board

Delete Board

Invalid Token Handling

Missing API Key Handling

Each request includes basic test validations and automatically updates environment variables like boardId.

📎 Notes
Make sure your Trello API key and token have appropriate permissions.

Optional schema validation file (board-schema.json) can be updated if Trello's API structure changes.

You can integrate this project with CI/CD tools for automated testing pipelines.





