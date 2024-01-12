# Choosing redis to store secrets

Date: 2024-01-12

## Status

Accepted

## Context

We need a database management system to store secrets.
Secrets are stored in a key-value format.
We need the most simple storage system to implement an MVP as soon as possible.

## Decision

We are going to use redis to store secrets.

1. Redis stores data in a key-value format in a native way.
2. Redis is a simple database management system because is schemaless and is in-memory.

## Consequences

1. Redis is not a persistent database management system. If the server crashes, the data will be
   lost.
   In the future, we need to use another persistent database management system.
2. Redis is not a relational database management system. If we need to store relational data,
   such as user data or permission data, we need to use another database management system.
3. The secrets values stored in redis does not have any type of schema validation. If we need to
   validate the data, we need to use another database management system.
