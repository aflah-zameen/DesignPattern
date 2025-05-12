class Logger{
    private Logger(){}
    public static class LoggerHolder{
        private static final Logger instance = new Logger();
    }
    public static Logger getInstance(){
        return LoggerHolder.instance;
    }
    public void print(){
        System.out.println("heyy");
    }
}

public class LoggerMain {
    public static void main(String [] args){
        Logger obj = Logger.getInstance();
        obj.print();
    }}
