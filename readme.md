Players IPC
========================

Running one PID scenario:

mvn clean compile exec:java

Running two PIDs scenario:

mvn clean install
java -cp target/Players-1.0-SNAPSHOT.jar org.pingpong.game.remote.runner.ExecutorServer
java -cp target/Players-1.0-SNAPSHOT.jar org.pingpong.game.remote.runner.ExecutorClient