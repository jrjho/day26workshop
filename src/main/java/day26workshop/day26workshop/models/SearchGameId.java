package day26workshop.day26workshop.models;

public class SearchGameId {
    
     private Integer gid;
    
     private String name;
 
     private Integer year;
 
     private Integer ranking;
 
     private Integer users_rated;
 
     private String url;
 
     private String image;
 
 
 
   
 
     public Integer getYear() {
         return year;
     }
 
     public void setYear(Integer year) {
         this.year = year;
     }
 
   
 
     public String getUrl() {
         return url;
     }
 
     public void setUrl(String url) {
         this.url = url;
     }
 
    
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

    public Integer getUsers_rated() {
        return users_rated;
    }

    public void setUsers_rated(Integer users_rated) {
        this.users_rated = users_rated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
