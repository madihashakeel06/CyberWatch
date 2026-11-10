# Component 1: Continuous Integration using Jenkins

## Project
CyberWatch – Login Monitoring and Brute Force Detection

## Objective
To implement Continuous Integration (CI) using Jenkins by connecting the GitHub repository, automatically checking for source code changes, running Maven tests, packaging the application, and archiving build artifacts.

## Tools and Technologies
- Git and GitHub
- Jenkins
- Java
- Maven
- Spring Boot

## Implementation

### 1. GitHub Repository
The CyberWatch application source code is maintained in GitHub.

Repository: https://github.com/madihashakeel06/CyberWatch

### 2. Jenkins Freestyle Job
A Jenkins Freestyle job named `CyberWatch-CI` was configured with:
- GitHub repository URL as Source Code Management.
- Branch: `feature/component2`
- Poll SCM trigger configured with schedule `* * * * *`.
- Shell build command: `./mvnw clean test package`
- Artifact archiving: `target/*.jar`

### 3. Automated Build Trigger
Jenkins polls the GitHub repository every minute for new commits.

A test commit was pushed to GitHub, and Jenkins automatically triggered a new build without manually clicking Build Now.

### 4. Build and Testing
The Jenkins build successfully:
- Checked out source code from GitHub.
- Executed Maven tests.
- Packaged the Spring Boot application.
- Archived the generated JAR file.

### 5. Jenkins Pipeline
A Jenkins Pipeline job named `CyberWatch-Pipeline` was configured using the repository's `Jenkinsfile`.

Pipeline stages:
1. Checkout
2. Test
3. Build
4. Archive

The Pipeline completed successfully, and build artifacts were archived with fingerprints.

## Result
The CyberWatch project successfully implemented Jenkins Continuous Integration. Source code changes are detected through Git polling, builds are automatically triggered, Maven tests and packaging execute successfully, and build artifacts are archived.

## Evidence
Screenshots included:
- Freestyle build history
- Git polling log
- Successful Freestyle console output
- Successful Pipeline console output
- Pipeline stage visualization
- Automatic build after GitHub push

## Repository
https://github.com/madihashakeel06/CyberWatch
