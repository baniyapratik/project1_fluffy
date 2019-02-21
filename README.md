# project1_fluffy: CMPE275

Current Features:
1. Create/Update/Delete/List TextServices Using GRPC. 
2. Usign Mongo Atlas to store and receive the data.


Load Balancer, to do list:
1. Check the CPU usage
2. Ping to check the health status
3. RabitMQ to stack the incoming request.
4. Threading to create tasks to send to the the server farm. Have an ack so that we know we dont have to re-try to send the message.
5. Method to stack the requets if servers are already across threshold, we do not have to crash the server.
6. Fault tolerant? Need to create a Master/Slave paradigm for election if the primary load balancer goes down.
