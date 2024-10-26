### README

# Project: Software Testing Automation

## Overview

This project focuses on testing procedures for various services, including `AppointmentService`, `ContactService`, and `TaskService`. The primary goal is to ensure the reliability and correctness of these services through comprehensive unit testing using JUnit.

## Project Structure

```
grand-strand-systems/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── grandstrandsystems/
│   │               ├── appointmentservice/
│   │               │   ├── Appointment.java
│   │               │   └── AppointmentService.java
│   │               ├── contactservice/
│   │               │   ├── Contact.java
│   │               │   └── ContactService.java
│   │               └── taskservice/
│   │                   ├── Task.java
│   │                   └── TaskService.java
│   └── test/
│       └── java/
│           └── com/
│               └── grandstrandsystems/
│                   ├── test/
│                   │   ├── appointmentservice/
│                   │   │   ├── AppointmentServiceTest.java
│                   │   │   └── AppointmentTest.java
│                   │   ├── contactservice/
│                   │   │   ├── ContactServiceTest.java
│                   │   │   └── ContactTest.java
│                   │   └── taskservice/
│                   │       ├── TaskServiceTest.java
│                   │       └── TaskTest.java
```

## Testing Procedures

### Unit Testing

Unit tests are written using JUnit 5 to verify the functionality of individual components. Each test class is designed to test a specific service or entity.

#### AppointmentService Tests

- **Test Class**: `AppointmentServiceTest`
- **Tested Methods**:
    - `addAppointment(Appointment appointment)`
    - `deleteAppointment(String appointmentId)`
    - `getAppointments()`
- **Example Test**:
  ```java
  @Test
  public void testAddAppointment() {
      AppointmentService appointmentService = new AppointmentService();
      Date futureDate = new Date(System.currentTimeMillis() + 7200);
      Appointment appointment = new Appointment("1", futureDate, "Test Description");
      appointmentService.addAppointment(appointment);
      assertEquals(1, appointmentService.getAppointments().size());
  }
  ```

#### ContactService Tests

- **Test Class**: `ContactServiceTest`
- **Tested Methods**:
    - `addContact(Contact contact)`
    - `deleteContact(String contactID)`
    - `updateContact(String contactID, String firstName, String lastName, String phone, String address)`
- **Example Test**:
  ```java
  @Test
  public void testAddContact() {
      ContactService contactService = new ContactService();
      Contact contact = new Contact("1112", "Best", "MomEver", "1234567891", "123 MyHouse St");
      assertTrue(contactService.addContact(contact));
  }
  ```

#### TaskService Tests

- **Test Class**: `TaskServiceTest`
- **Tested Methods**:
    - `addTask(Task task)`
    - `deleteTask(String taskID)`
    - `updateTask(String taskID, String name, String description)`
- **Example Test**:
  ```java
  @Test
  public void testAddTask() {
      TaskService taskService = new TaskService();
      Task task = new Task("1", "Task 1", "Description 1");
      assertTrue(taskService.addTask(task));
  }
  ```

### Test Coverage

JaCoCo is used to measure test coverage. It instruments the bytecode and collects execution data during test runs, generating detailed reports on which parts of the code were executed and which were missed.

### Running Tests

To run the tests, use the following Maven command:

```sh
mvn test
```

This command will execute all the test cases and generate a test report.

## Conclusion

This project demonstrates a comprehensive approach to unit testing, ensuring that all critical functionalities are thoroughly tested. The use of JUnit and JaCoCo provides a robust framework for verifying the correctness and coverage of the code.