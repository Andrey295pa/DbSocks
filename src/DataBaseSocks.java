import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class DataBaseSocks {

    ArrayList<Type> DbType = new ArrayList<Type>();
    ArrayList<Material> DbMterial = new ArrayList<Material>();
    ArrayList<Socks> DbSocks = new ArrayList<Socks>();

    Connection con = null;
    Scanner scanner= new Scanner(System.in);

    public  void  InsertDbType(){
        //Conection.OpenConection("path");

        Type tmp=new Type();


        System.out.print("Enter name");
        String name=scanner.nextLine();
        tmp.name=name;
        DbType.add(tmp);

        String query=
                        "INSERT INTO users(name,phone)"+
                        "VALUES ('"+ name+"','"+name+"')";

        try
        {
            Statement statement=con.createStatement();
            statement.executeUpdate(query);
            System.out.print("Row add");
            statement.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    public  void  InsertDbSocks(){

        Socks tmp=new Socks();

        System.out.print("Enter size");
        String size=scanner.nextLine();
        tmp.size=size;
        System.out.print("Enter color");
        String color=scanner.nextLine();
        tmp.color=color;
        System.out.print("Enter type");
        String type=scanner.nextLine();
        for( Type item:DbType)
        {
            if(item.id==Integer.parseInt(type)){
                tmp.type=Integer.parseInt(type);
            }

        }

        System.out.print("Enter type");
        String material=scanner.nextLine();
        for( Material item:DbMterial)
        {
            if(item.id==Integer.parseInt(material)){
                tmp.material=Integer.parseInt(material);
            }

        }
        if(tmp.material!=0 && tmp.type!=0)
        {
            DbSocks.add(tmp);
            String query=
                            "INSERT INTO Socks(size,color,type,material)"+
                            "VALUES ('"+ size+"','"+color+"','"+ type+"','"+material+"')";
            try
            {
                Statement statement=con.createStatement();
                statement.executeUpdate(query);
                System.out.print("Row add");
                statement.close();
            }
            catch(Exception e)
            {
                System.out.print(e.getMessage());
            }
        }
        else
            System.out.print("Wrong data");


    }
}
