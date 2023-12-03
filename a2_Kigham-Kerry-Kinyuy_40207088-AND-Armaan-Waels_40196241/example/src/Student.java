public class Student {
    private int ID;
    private String Name;
    private double GPA;

    public Student(int ID, String Name, double GPA){
        this.ID=ID;
        this.Name=Name;
        this.GPA=GPA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        else if (getClass()!= obj.getClass()) {
        return false;
        }
        else
        return false;
    }
}
