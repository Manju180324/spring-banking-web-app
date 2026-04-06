package com.bank.app.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
/*
interface UserRepository
👉 No class, no implementation

You don’t write logic — Spring does it for you.

🔹 extends JpaRepository<User, Long>

👉 This is the magic.

It gives you:

save() → insert/update
findById() → fetch
findAll() → list
deleteById() → delete

👉 Without writing SQL.

Breakdown:
JpaRepository<User, Long>
User → Entity
Long → type of primary key
🔹 Custom Method
Optional<User> findByEmail(String email);

👉 You didn’t implement it… but it works.

Why?

👉 Spring Data JPA parses method name and creates query automatically.

Equivalent SQL:

SELECT * FROM users WHERE email = ?
🔹 Why Optional<User>?

👉 Avoids null problems

Instead of:

User user = null;

You get:

Optional<User>

Forces you to handle:

. present
. not present
 */