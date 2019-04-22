
# import socket programming library 
import socket
import json
from _thread import * 
  
# import thread module 
from _thread import *
import threading 

# import random
import random

#set up an array to hold clients
clients = {}
  
print_lock = threading.Lock() 
  
#thread fuction
def threaded(c):
   p1Location = 0 
   while True: 
       # data received from client 
       data = c.recv(1024)

       if not data: 
           print('Bye') 
             
           # lock released on exit 
           print_lock.release() 
           break
  
       # update location
       beforeString = "before: " + str(p1Location)
       randInt = random.randint(1,7) 
       p1Location = p1Location + randInt

       #check if user landed on snake or ladder
       if(p1Location == 1):
         p1Location = 38
       elif(p1Location == 4):
         p1Location = 14
       elif(p1Location == 9):
         p1Location = 31
       elif(p1Location == 28):
         p1Location = 84
       elif(p1Location == 21):
         p1Location = 42
       elif(p1Location == 36):
         p1Location = 44
       elif(p1Location == 51):
         p1Location = 67
       elif(p1Location == 80):
         p1Location = 100
       elif(p1Location == 71):
         p1Location = 91
       elif(p1Location == 16):
         p1Location = 6
       elif(p1Location == 49):
         p1Location = 11
       elif(p1Location == 62):
         p1Location = 19
       elif(p1Location == 87):
         p1Location = 24
       elif(p1Location == 48):
         p1Location = 26
       elif(p1Location == 98):
         p1Location = 78
      
       afterString = "after: " + str(p1Location)
       if(p1Location >= 100):
         toSend = "You won!"
         c.send(toSend.encode())
         exit()
       toSend = beforeString + "   " + afterString   
       #send updated location to client 
       c.send(toSend.encode())
  
    #connection closed 
   c.close()   
  
def Main(): 
    host = "" 
  
    # using port 1234
    port = 1234
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
    s.bind((host, port)) 
    print("connected", port) 
  
    # put the socket into listening mode 
    s.listen(5) 
    print("socket is listening") 
  
    # a forever loop until client wants to exit 
    while True: 
  
        # establish connection with client 
        c, addr = s.accept() 

        # lock acquired by client 
        print_lock.acquire() 
        print('Connected to :', addr[0], ':', addr[1]) 
  
        # Start a new thread and return its identifier 
        clients[c] = start_new_thread(threaded, (c,)) 
    s.close() 
  
  
if __name__ == '__main__': 
    Main()
