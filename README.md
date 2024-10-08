# Wikimedia Event Stream Kafka Producer

## Description
This project is a Spring Boot microservices application that integrates Kafka to stream real-time change events from Wikimedia. The producer service listens to Wikimedia's live updates and sends the data to a Kafka topic, making it suitable for event-driven architectures in distributed systems.

## Features
- Streams live change events from Wikimedia.
- Kafka producer integration for scalable event processing.
- Built with Spring Boot and Apache Kafka.
  
## Project Structure
- **WikimediaProducerService**: Responsible for connecting to the Wikimedia event stream and publishing data to Kafka.
- **KafkaConfig**: Configuration for Kafka producer properties.
- **Controller**: API to start or stop streaming events.

## Requirements
- Java 11+
- Apache Kafka
- Zookeeper
- Spring Boot 2.5+
- Maven or Gradle

## Setup & Running the Application
1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/wikimedia-event-stream-kafka-producer.git
    cd wikimedia-event-stream-kafka-producer
    ```

2. **Start Kafka and Zookeeper**:
    Follow the [Kafka Quickstart](https://kafka.apache.org/quickstart) guide to set up Kafka and Zookeeper locally.

3. **Build and run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Start streaming Wikimedia events**:
   The service will start streaming events from Wikimedia to a Kafka topic.

## Configuration
- You can configure the Kafka topic, bootstrap servers, and other settings in the `application.yml` file.
  
## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

### Contributions
Feel free to contribute by forking the repository and submitting a pull request. All contributions are welcome!

