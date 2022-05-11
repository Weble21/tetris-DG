package setting.exception;

 public class EmptyKeyException extends NullPointerException{

     public EmptyKeyException() {
         super("키 값이 없습니다.");
     }

     public EmptyKeyException(String s) {
         super(s);
     }

     @Override
     public synchronized Throwable fillInStackTrace() {
         return super.fillInStackTrace();
     }

     @Override
     public String getMessage() {
         return super.getMessage();
     }
 }