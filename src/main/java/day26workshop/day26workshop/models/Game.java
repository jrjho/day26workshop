package day26workshop.day26workshop.models;

public class Game {
    

    private Integer gid;
    
    private String name;

    private Integer ranking;


    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    
}
