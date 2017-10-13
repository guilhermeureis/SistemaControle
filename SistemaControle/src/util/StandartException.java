package util;

class StandartException extends Exception{
  
  public StandartException(String arg0)
  {
    super(arg0);
  }
  
  public StandartException(Throwable arg0) { super(arg0); }
  
  public StandartException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }
}