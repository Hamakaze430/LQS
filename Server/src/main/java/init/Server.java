package init;

public class Server {

    public static void main(String[] args) {
        try {
        	System.out.println("Try start server...");
            RMIHelper.init();
            System.out.println("Server is now running!");
        } catch (ServerInitException e) {
        	System.out.println("fail!");
        	 e.printStackTrace(System.out);
        }
    }
}
