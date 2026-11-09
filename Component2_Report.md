# Component 2: Deployment and Containerization of CyberWatch

## 1. Objective
The objective of Component 2 was to automate the deployment of the CyberWatch application using Ansible, Docker, and Kubernetes.

## 2. Ansible Deployment
Ansible was used to automate application deployment.

- Created inventory and playbook files.
- Configured an Ansible role for CyberWatch.
- Automated application JAR copying and startup.
- Configured variables and a restart handler.
- Verified playbook syntax and execution.

## 3. Docker Containerization
The CyberWatch application was containerized using Docker.

- Created a Dockerfile using Eclipse Temurin Java 21.
- Built the Docker image `cyberwatch:latest`.
- Started the application inside a Docker container.
- Verified application access through port 8081.

## 4. Kubernetes Deployment
The application was deployed to a local Kubernetes cluster using Kind.

- Created a Kind cluster named `cyberwatch`.
- Created a Kubernetes Deployment with three replicas.
- Configured a readiness probe for application health.
- Created a NodePort Service.
- Applied the Kubernetes configuration files.
- Verified that all three pods were running and available.

## 5. Scaling
The Kubernetes deployment was scaled from three replicas to five replicas and subsequently restored to three replicas.

This demonstrated the horizontal scaling capability of Kubernetes.

## 6. Application Verification
The application was accessed using port forwarding.

Command:
`curl -I http://localhost:8082`

Result:
`HTTP/1.1 200`

This confirmed that the CyberWatch application was responding successfully.

## 7. Conclusion
Component 2 successfully demonstrated automated deployment using Ansible, application containerization using Docker, and orchestration using Kubernetes. The application was deployed, verified, and scaled successfully.
