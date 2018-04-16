package task5;

public class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final User user = (User)obj;
        if (id != user.id) return false;
        return name !=null ? name.equals(user.name) : user.name == null;
    }



    @Override
    public int hashCode() {
        int result = id;
        result = 31*result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " id" + id ;
    }

}
