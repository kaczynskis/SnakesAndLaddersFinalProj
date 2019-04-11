import java.io.PrintWriter;
import java.util.Scanner;

class SendHandler implements Runnable {
        Scanner consoleInput;
    	PrintWriter out;
    	SendHandler(Scanner consoleInput, PrintWriter out){
    		this.consoleInput = consoleInput;
    		this.out = out;
    	}

		@Override
		public void run() {
			String msg = "";
			while (!msg.equals("{quit}")) {
				msg = consoleInput.nextLine();
				out.println(msg);
			}
		}
    }
