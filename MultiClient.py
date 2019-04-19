# Import socket module 
import socket 
import random
  
  
def Main(): 
    # local host IP '127.0.0.1' 
    host = '127.0.0.1'
  
    # Define the port on which you want to connect 
    port = 1234
  
    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM) 
  
    # connect to server on local computer 
    s.connect((host,port)) 
  
    # message you send to server 
    #message = input("Type r to roll die: ")
    while True: 
        message = input("Type r to roll die: ")
        # message sent to server 
        s.send(message.encode('ascii')) 
  
        # message received from server 
        data = s.recv(1024) 
        if data == "You won!":
           break  
        # print the received message 
        # here it would be a reverse of sent message 
        print('Received from the server :',str(data.decode('ascii'))) 
  
        # ask the client to continue
        ans = input('\nRoll again?(y/n): ') 
        if ans != 'n': 
            continue
        else: 
            break
    # close the connection 
    s.close() 
  
if __name__ == '__main__': 
    Main() 

