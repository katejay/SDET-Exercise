# Test-Architecture-Linux

A complete end-to-end automation test architecture template for Linux systems using Java, Maven, Docker, and Jenkins.

## 📌 Overview

This repository provides a robust and scalable test automation framework designed for Linux environments. It integrates modern testing tools and CI/CD practices to ensure efficient and maintainable automated testing.

## 🚀 Features

- **Java & TestNG** – Leverages Java for scripting and TestNG for structured test execution.
- **Maven** – Simplifies project management and dependency resolution.
- **Docker** – Enables containerized test execution for consistency across environments.
- **Jenkins Integration** – Supports CI/CD pipelines for automated test execution.
- **Scalability** – Designed to be modular and extendable for various testing needs.

## ❗ Problem Statement

Automation testers often need to set up the entire test environment manually to run test cases in parallel across different operating systems and browsers. This process can be time-consuming and complex, especially when building a complete end-to-end framework from scratch.

With this template, SDET can simply update their test cases in the `src/test` folder and configure `testng.xml` accordingly. The framework allows efficient execution by running independent test cases in parallel across different operating systems and browsers as needed, reducing setup time and effort significantly.

## 🛠️ Prerequisites

Ensure the following dependencies are installed on your host system:

- **Java 11+**  
- **Maven**   
- **Docker**  
- **Jenkins** (Mandatory for CI/CD integration)  

## 🔧 Installation & Setup

Follow these steps to set up the project on your system:

1. **Install Java 11+**
   - Download and install Java 11+ from the official Oracle website: [Java Downloads](https://www.oracle.com/in/java/technologies/downloads/)

2. **Install Docker**
   - Download and install Docker from the official website: [Docker Downloads](https://www.docker.com/)

3. **Download Jenkins**
   - Download the `jenkins.war` file from the official website: [Jenkins Downloads](https://www.jenkins.io/download/)

4. **Run and Set Up Jenkins**
   - Navigate to the directory where `jenkins.war` is downloaded and run the following command:
     ```sh
     java -jar jenkins.war
     ```
   - If you encounter a port issue, try running:
     ```sh
     java -jar jenkins.war --httpPort=9090
     ```

5. **Login to Jenkins as Admin**
   - Once Jenkins is running, open your browser and go to `http://localhost:8080` (or `http://localhost:9090` if you changed the port).
   - Log in using the admin credentials.

6. **Create a New Pipeline**
   - This step ensures that the template is working correctly on your system. If it does not work, there may be an issue with your Java, Docker, or Jenkins setup, and your host system may not be able to identify these dependencies or Compatibility issues .
   - In Jenkins, create a new **Pipeline** project.
   - Navigate to the **Configure** section of the pipeline.
   - Under **Definition**, select **Pipeline script from SCM**.
   - Under **SCM**, select **Git**.
   - Use the following Repository URL:
     ```
     https://github.com/katejay/Test-Architecture-Linux.git
     ```
   - Change **Branch Specifier** to:
     ```
     */main
     ```
   - Set **Script Path** to:
     ```
     .jenkinsfile
     ```
   - Click **Apply** and **Save**.

7. **Run the Pipeline**
   - Click **Build Now** to trigger the pipeline execution.

8. **Customize as per Your Project Requirements**
   - Once the template is working correctly on your system, clone this repository.
   - Update your test cases in the `src/test` folder and list them in the `testng.xml` file.
   - Add any necessary dependencies in `pom.xml` as per your project requirements.
   - Ensure that you do not remove any Docker-related files.
   - Replace the `TestCase1`, `TestCase2`, and `TestCase3` Java files with your actual test files.
   - Push the updated code to your public Git repository.
   - Follow steps **6 and 7** again.
   - This time, instead of using:
     ```
     https://github.com/katejay/Test-Architecture-Linux.git
     ```
     as the repository URL, use your own repository link.


## 🔄 Workflow

When the pipeline is triggered, it will first fetch the repository specified in the **Repository URL** under the **Configure** section of the pipeline. It will pull the repository and look for the `.jenkinsfile`, following the instructions mentioned in the file.

1. **Debug Process**
   - Initially, it will verify whether Docker is running.
   - Once confirmed, it will begin executing scripts on the host system.

2. **Docker Initialization**
   - The `Initialize` script will execute, which starts the Docker service.
   - A guest operating system (Container) will be created on the host system.
   - Before this step, the `output.txt` file is deleted to ensure a fresh log is generated.
   - While running Docker, a new `output.txt` file is created to store terminal logs.
   - The script will check for the log message **"registered to the hub and ready to use"** to confirm that Docker is ready.

3. **Scaling the Browsers**
   - The pipeline will scale the browsers as specified in the `scale.sh` script.
   - The scaling configuration can be modified as per project requirements.

4. **Parallel Test Execution**
   - Test cases (`TestCase1`, `TestCase2`, and `TestCase3`) will be executed in parallel across different containers.

5. **Stopping Docker Services**
   - After the successful execution of test cases, the `stopDocker` script will run to stop the Docker service.

## 📂 Project Structure

```
Test-Architecture-Linux/
│-- src/
│   ├── test/                    # Contains all test-related files
│       ├── Initialize           # Script to start and stop Docker service
│       ├── TestCase1            # Test cases to run on the first container
│       ├── TestCase2            # Test cases to run on the second container
│       ├── TestCase3            # Test cases to run on the third container
│-- pom.xml                      # Maven dependencies (Selenium, TestNG, etc.)
│-- testng.xml                   # Specifies which test cases should run and parallel execution count
│-- docker-compose.yaml          # Defines the setup for Docker containers
│-- dockerUp.sh                  # Script to start Docker services from the terminal
│-- scale.sh                     # Script to scale the number of required containers
│-- dockerDown.sh                # Script to shut down Docker services from the terminal
│-- .jenkinsfile                 # Jenkins pipeline script
│-- output.txt                   # Stores terminal logs
│-- README.md                    # Project documentation
```

This structure ensures modularity and flexibility, enabling parallel test execution across multiple containers while integrating seamlessly with Jenkins and Docker.

Refer to a video for setup and walkthrough.
