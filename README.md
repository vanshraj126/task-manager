# Task Manager

A full-stack REST API for managing projects, tasks, and teams with role-based access control.

## Live URL
https://task-manager-production-fade.up.railway.app

## Tech Stack
- Java + Spring Boot
- Spring Security + JWT
- PostgreSQL
- Railway (Deployment)

## Features
- User authentication (Register/Login)
- JWT token based security
- Role based access (Admin/Member)
- Project management
- Task creation and assignment
- Task status tracking (TODO/IN_PROGRESS/DONE)

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register a new user |
| POST | /api/auth/login | Login and get JWT token |

### Tasks
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/tasks | Create a task (Admin only) |
| GET | /api/tasks | Get all tasks |
| PUT | /api/tasks/{id}/status | Update task status |

### Projects
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/projects | Create a project (Admin only) |
| GET | /api/projects | Get all projects |
| GET | /api/projects/{id} | Get project by id |
| DELETE | /api/projects/{id} | Delete a project (Admin only) |

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/users | Get all users (Admin only) |
| GET | /api/users/{id} | Get user by id (Admin only) |

## Setup Locally
1. Clone the repo
2. Configure PostgreSQL in application.properties
3. Run DemoApplication.java

## Role Based Access
- **ADMIN** → full access to all endpoints
- **MEMBER** → can view tasks and projects only

## Authentication
All protected endpoints require:
Authorization: Bearer your-token

Get token by calling /api/auth/login
