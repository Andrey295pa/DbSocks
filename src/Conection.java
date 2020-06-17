import java.sql.Connection;
import java.sql.DriverManager;

 public  final class Conection {
    private static Connection con;

    static void  OpenConection(String path) //выходит немного неочевидно. чтобы получить конекшн мне нужно дернуть какойто метод который ничего не возвращает.
     //почему бы не поступить проче и не сделать синглтон который возвращает конекшн, или фабрику, или инициализировать конекшн в конструкторе
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
           // con= DriverManager.getConnection(
                   // "jdbc:sqlite:D:\\Install\\SQLite\\users.db");
            con= DriverManager.getConnection(
                    "jdbc:sqlite:"+path);
            System.out.print("Connection open");
        }
        catch (Exception e)
        {
            System.out.print((e.getMessage()));
        }
    }
    static   void ClosedConection(Connection con)
    {
        if(con!=null) {
            try{
                con.close();
                System.out.print("Conection closed!!!!!");
            }
            catch (Exception e)
            {
                System.out.print(e.getMessage());
            }
        }
    }
    private Conection() //а зачем приватный конструктор?
    {
          con= null;
    }
}
