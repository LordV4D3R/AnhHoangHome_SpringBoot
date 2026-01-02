🏠 Rental Property Management System (Backend)
A robust Spring Boot backend designed for managing multi-tenant rental properties, boarding houses, and co-living spaces. This system handles complex hierarchies (Property → Unit → Room) and automates billing for shared services.

🚀 Tech Stack
Language: Java 17+ (or 21)

Framework: Spring Boot 3.x

Database: PostgreSQL / MySQL

ORM: Hibernate / Spring Data JPA

Security: Spring Security + JWT

Build Tool: Maven / Gradle

🧠 Database Architecture (ERD Overview)
This system uses a normalized database schema designed for scalability.

Core Entities
User: Central authentication table. Uses Role (Admin, Owner, Tenant) to handle permissions.

Profiles: Separate Owner and Tenant tables linked to User to store role-specific data (Bank info, Emergency contacts).

Property Hierarchy
Property: The building/land address.

Unit: The physical suite/floor. Contains TotalRooms (count).

Room: The rentable space. Contains MaxOccupancy (capacity).

Logic: One Room can hold multiple Tenants (Co-living model).

Contract & Billing Logic
Contract: Links a Tenant to a Room.

Renewal Strategy: Renewals create a new row with a ParentContractID to preserve history.

Service & ServiceUsage: Tracks variable costs (Water/Electricity) per Room.

Invoice: Linked to Contract.

Splitting Logic: Variable room costs (e.g., Water) are split among active contracts in that room and added as line items in InvoiceDetail.

🛠️ Installation & Setup
Clone the repository

Bash

git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
Configure Database Update src/main/resources/application.properties:

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/rental_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Run the Application

Bash

./mvnw spring-boot:run
🔌 API Endpoints (Preview)
POST /api/auth/login - Returns JWT Token

GET /api/properties - List all buildings

POST /api/contracts/renew - Extends a lease (creates new history record)

POST /api/invoices/generate/{month} - Triggers calculation of rent + split service fees

📝 TODO / Roadmap
[ ] Implement InvoiceDetail logic for automated water bill splitting.

[ ] Add image upload service (Cloudinary/S3) for IdCardFrontUrl.

[ ] Create "Owner Dashboard" analytics API.

License MIT