class Student{
    private String id;
    private String name;
    private double javaScore;
    private double sqlScore;
    private double htmlScore;

    public Student(String id, String name, double javaScore, double sqlScore, double htmlScore){
        this.id = id;
        this.name = name;
        this.javaScore = javaScore;
        this.sqlScore = sqlScore;
        this.htmlScore = htmlScore;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getJava(){
        return javaScore;
    }
    public double getSql(){
        return sqlScore;
    }
    public double getHtml(){
        return htmlScore;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setJava(double java){
        this.javaScore = java;
    }
    public void setSql(double sql){
        this.sqlScore = sql;
    }
    public void setHtml(double html){
        this.htmlScore = html;
    }

    public double calculateAverage(){
        return (javaScore + sqlScore + htmlScore )/ 3.0;
    }

    public boolean isPassed(){
        return calculateAverage() >= 5;
    }

    public void getRank(){
        if(calculateAverage() >= 8) System.out.println("Great");
        else if(calculateAverage() >= 6.5) System.out.println("Good");
        else if(calculateAverage() >= 5) System.out.println("Intermediate");
        else System.out.println("Below average");
    }

    public void printInfo(){
        System.out.println("ID: " + id + ", NAME: " + name + ", JAVASCORE: " + javaScore + ", SQLSCORE: " + sqlScore + ", HTMLSCORE: " + htmlScore);
        System.out.println("AVERAGE: " + calculateAverage());
        System.out.println("PASS (T/F): " + isPassed());
        getRank();

    }

}