### Start the application by running NotificationApplication.java
### Send message to kafka topic "inbound". 
	docker-compose up -d
	docker container exec -it kafka /bin/bash
	kafka-console-producer --broker-list localhost:9092 --topic inbound
	{"firstName":"foo","lastName":"bar"}

	http://localhost:8080

### Start Kafka with the -d option to run in detached mode
	docker-compose up -d

	http://localhost:3040

### Produce message to Kafka
	docker container exec -it kafka /bin/bash
	kafka-console-producer --broker-list localhost:9092 --topic test-message-in
	{"name":"Ron Nash", "email":"ron.nash@example.com"}
	
### Consume message from Kafka
	docker container exec -it kafka /bin/bash
	kafka-console-consumer --bootstrap-server localhost:9092 --topic test-message-in -from-beginning

### Useful commands
	# create kafka topic with custom partitions
	kafka-topics --bootstrap-server localhost:9092 --topic YOUR_TOPIC --create --partitions 2
	
	# list of kafka topics
	kafka-topics --bootstrap-server localhost:9092 --list
	kafka-topics --bootstrap-server localhost:9092 --describe
	
	# delete kafka topic
	kafka-topics --bootstrap-server localhost:9092 --delete --topic YOUR_TOPIC

### Directory 
	/var/log/ - all log files.
	/data/kafka/logdir/ - all kafka topics (provided as directories).
	/data/kafka/logdir/test-message-in-0/ - directory for topic test-message-in, partition 0
	
### Stop Kafka
	docker-compose down
		