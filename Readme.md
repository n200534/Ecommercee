

# 🛒 E-Commerce Backend API

A secure and scalable E-commerce backend built using **Spring Boot**, **PostgreSQL**, and **JWT-based authentication**.
The system supports product management, cart operations, and transactional order processing with role-based authorization.

---

# 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Maven

---

# 🏗️ Architecture

The project follows a clean layered architecture:

```
Controller → Service → Repository → Database
```

Additional layers:

* DTO layer (Request / Response separation)
* Global Exception Handling
* Validation layer
* Security layer (JWT + Role-based access)

---

# 🔐 Authentication & Authorization

### ✅ JWT-based Authentication

* Stateless authentication
* Password encrypted using BCrypt
* Token required for all secured endpoints

### ✅ Role-Based Authorization

Two roles supported:

* `USER`
* `ADMIN`

Access control implemented using:

```
@PreAuthorize("hasRole('ADMIN')")
```

| Feature             | USER | ADMIN |
| ------------------- | ---- | ----- |
| View Products       | ✅    | ✅     |
| Add to Cart         | ✅    | ❌     |
| Place Order         | ✅    | ❌     |
| Create Product      | ❌    | ✅     |
| Delete Product      | ❌    | ✅     |
| Update Order Status | ❌    | ✅     |

---

# 📦 Core Features

## 👤 User

* Register
* Login
* Secure JWT token generation
* Role stored in database

---

## 🗂️ Category

* Create category (ADMIN)
* Assign products to category

---

## 📦 Product

* Create product (ADMIN only)
* Delete product (ADMIN only)
* Get all products
* Get product by ID
* Get products by category
* Validation and error handling

---

## 🛒 Cart

* Add product to cart
* Remove product from cart
* View current user cart
* Stock validation before adding

Cart is user-specific and extracted from JWT (no userId in URL).

---

## 🧾 Order

* Place order (Transactional)
* Stock deduction on checkout
* Price snapshot stored in OrderItem
* Clear cart after successful order
* View user order history
* Admin can update order status

Order placement uses:

```
@Transactional
```

to ensure atomic checkout.

---

# 🧠 Important Design Decisions

### 1️⃣ Stateless Security

JWT is used instead of session-based authentication.

### 2️⃣ Transaction Management

Checkout logic is wrapped inside `@Transactional` to ensure:

* Stock consistency
* Order atomicity
* Automatic rollback on failure

### 3️⃣ DTO Pattern

Entities are never exposed directly.
Separate Request and Response DTOs are used.

### 4️⃣ Global Exception Handling

Centralized error handling using `@RestControllerAdvice`.

Standard error response structure:

```json
{
  "timestamp": "...",
  "status": 400,
  "error": "Bad Request",
  "message": "...",
  "path": "..."
}
```

### 5️⃣ Validation

Input validation implemented using Jakarta Validation:

* `@NotBlank`
* `@Email`
* `@Positive`
* `@Min`

---

# 🗄️ Database Design

Main Entities:

```
User
Category
Product
Cart
CartItem
Order
OrderItem
```

Relationships:

* User → OneToMany → Orders
* User → OneToOne → Cart
* Cart → OneToMany → CartItem
* Order → OneToMany → OrderItem
* Product → ManyToOne → Category

---

# 🧪 Sample API Flow

### 1️⃣ Register

```
POST /api/auth/register
```

### 2️⃣ Login

```
POST /api/auth/login
```

Receive JWT token.

### 3️⃣ Use Token

Add header:

```
Authorization: Bearer <token>
```

### 4️⃣ Add to Cart

```
POST /api/cart
```

### 5️⃣ Place Order

```
POST /api/orders
```

---

# ⚙️ How To Run

1. Clone repository
2. Create PostgreSQL database:

```sql
CREATE DATABASE ecommerce_db;
```

3. Configure `application.yml`
4. Run:

```
mvn spring-boot:run
```

---

# 📈 Future Improvements

* Pagination & Sorting
* Product search API
* Refresh token implementation
* Unit & Integration tests
* Dockerization
* Payment gateway integration

---

# 👨‍💻 Author

Built as a backend engineering learning project focusing on clean architecture, security, and transactional integrity.

---

