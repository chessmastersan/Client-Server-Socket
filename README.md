# VTU CN LAB Program: Client-Server using TCP/IP

## Aim:
Using TCP/IP Sockets, write a client-server program to make client sending the file 
name and the server to send back the contents of the requested file if present. Implement the 
above program using as message queues or FIFOs as IPC channels.

## Sockets in JAVA
Socket is an interface which enables the client and the server to communicate and pass on 
information from one another. Sockets provide the communication mechanism between two 
computers using TCP. A client program creates a socket on its end of the communication and 
attempts to connect that socket to a server. When the connection is made, the server creates a 
socket object on its end of the communication. The client and the server can now communicate 
by writing to and reading from the socket.
