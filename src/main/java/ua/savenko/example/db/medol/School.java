package ua.savenko.example.db.medol;

public class School {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRINCIPAL = "principal";

    private int id;
    private String name;
    private String description;
    private String principal;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public School(String name, String description, String principal) {
        this.name = name;
        this.description = description;
        this.principal = principal;
    }

    public School(int id, String name, String description, String principal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
