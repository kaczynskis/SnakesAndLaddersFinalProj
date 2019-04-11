import java.util.Scanner;

class ReadHandler implements Runnable {
    	String name;
        Scanner consoleInput;
        Scanner in;
        ReadHandler(String name, Scanner consoleInput, Scanner in){
        	this.name = name;
    		this.consoleInput = consoleInput;
    		this.in = in;
    	}

		@Override
		public void run() {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("MESSAGE") && !line.contains(name + ":")) {
                    System.out.println(line.substring(8));
                }
            }
		}
    }
