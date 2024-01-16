package bags;

public class Signup {
    private int id;
    private String name, contact, email, password, filename, path, role, feedback, intention, cpassword, npassword, faqtitle, faqsolution;
    public Signup(){
        /*1st constructor with no parameters */
    }
    public Signup(String name, String contact, String email, String password, String filename, String path, String role, String feedback, String intention, String cpassword, String npassword, String faqtitle, String faqsolution){
        /* 2nd constructor */
        this.name = name;
        this.contact = contact;
        this.email  = email;
        this.password = password;
        this.filename = filename;
        this.path = path;
        this.feedback = feedback;
        this.intention = intention;
        this.cpassword = cpassword;
        this.npassword = npassword;
        this.faqtitle = faqtitle;
        this.faqsolution = faqsolution;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getNpassword() {
        return npassword;
    }

    public void setNpassword(String npassword) {
        this.npassword = npassword;
    }

    public String getFaqtitle() {
        return faqtitle;
    }

    public void setFaqtitle(String faqtitle) {
        this.faqtitle = faqtitle;
    }

    public String getFaqsolution() {
        return faqsolution;
    }

    public void setFaqsolution(String faqsolution) {
        this.faqsolution = faqsolution;
    }
    
}