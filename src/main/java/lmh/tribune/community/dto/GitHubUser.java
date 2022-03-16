package lmh.tribune.community.dto;

/**
 * @Description: TODO
 * @author: lmh
 * @date: 2022年03月14日 16:38
 */
public class GitHubUser {
  private String login;
  private Long id;
  private  String bio;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
