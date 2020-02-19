# Phonebook Application
## DEMO 

![alt text](https://github.com/hunaidee007/PhoneBook-Repo/blob/master/Demo.gif)

## Features
1. Layered Architecture
2. RestFull Services
3. Swagger enabled (Rest Service specific action)
4. Dependency Injection / Inversion of Control
5. JPA ORM for Database connectivity
6. Unit Tested (with Mockito)


## Layered Architecture
![alt text](https://github.com/hunaidee007/PhoneBook-Repo/blob/master/Architecture.png)

## API

### Get all Phonebooks
```http
GET /phonebooks
```
#### Response
```javascript
[{
  "id" : int,
  "name" : "string"
}]
```

---

### Save a Phonebook
```http
POST /phonebooks
```
##### Request

```javascript
[{
  "name" : "string"
}]
```
---
### Get all Contacts in a Phonebook
```http
GET /phonebooks/{phonebookId}/contacts
```
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `phonebookId` | `string` | **Optional**. Phonebook Id |
---
### Save a Contact in a Phonebook
```http
POST /phonebooks/{phonebookId}/contacts
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `phonebookId` | `string` | **Required**. Phonebook Id |
---
### Seach a Contact by name
```http
POST /phonebooks/{phonebookId}/contacts/{name}
```
| Parameter | Type | Description |
| :--- | :--- | :--- |
| `phonebookId` | `string` | **Required**. Phonebook Id |
| `name` | `string` | **Optional**. Name of the contact to search |




