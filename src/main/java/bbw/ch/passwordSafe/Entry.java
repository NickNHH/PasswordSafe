package bbw.ch.passwordSafe;

public class Entry {
    private long id;
    private String url;
    private String password;
    private String loginName;
    private String email;
    private String comment;

    Entry() {
        super();
    }

    Entry(long id, String url, String password, String loginName, String email, String comment) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.loginName = loginName;
        this.email = email;
        this.comment = comment;
    }

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
