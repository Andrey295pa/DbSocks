public class Material {
    public Integer id;
    public  String name;

    public void SetName(String value)
    {   this.name=value;
        this.id++;
    }

    public  String Name(){
        return  this.name;
    }

    public  Integer Id(){
        return  this.id;}

    public  void SetId(Integer value){
        this.id=value;
    }

}
