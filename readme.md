Players IPC
========================

<b>Running one PID scenario:</b>
- mvn clean compile exec:java

<b>Running two PIDs scenario:</b>
- mvn clean install
- java -cp target/Players-1.0-SNAPSHOT.jar org.pingpong.game.remote.runner.ExecutorServer
- java -cp target/Players-1.0-SNAPSHOT.jar org.pingpong.game.remote.runner.ExecutorClient