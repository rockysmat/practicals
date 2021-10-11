import java.util.Date;

public class Subscriber {
    private String identityId;
    private String mmIdentityId;
    private String identity;
    private String identityName;
    private String identityEmail;
    private String documentId;
    private String documentType;
    private String status;
    private String language;
    private Date subscriptionDate;
    private Date unSubscriptionDate;
    private Date updateDate;

    public Subscriber() {
    }

    public Subscriber(String identityId, String mmIdentityId, String identity, String identityName,
                      String identityEmail, String documentId, String documentType,
                      String language) {
        this.identityId = identityId;
        this.mmIdentityId = mmIdentityId;
        this.identity = identity;
        this.identityName = identityName;
        this.identityEmail = identityEmail;
        this.documentId = documentId;
        this.documentType = documentType;
        this.language = language;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        if(identityId.length()==12 && identityId.matches("\\d+")) {
            this.identityId = identityId;
        }
    }

    public String getMmIdentityId() {
        return mmIdentityId;
    }

    public void setMmIdentityId(String mmIdentityId) {
        if(mmIdentityId.length()==12 && mmIdentityId.matches("\\d+")) {
            this.mmIdentityId = mmIdentityId;
        }
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        if(identity.startsWith("2547") && identity.length()==12 && identity.matches("\\d+")) {
            this.identity = identity;
        }
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        if(identityName.matches("[a-zA-Z]+") && identityName.length() >= 3) {
            this.identityName = identityName;
        }
    }

    public String getIdentityEmail() {
        return identityEmail;
    }

    public void setIdentityEmail(String identityEmail) throws Exception{
        if(identityEmail.contains("@")) {
            this.identityEmail = identityEmail.toLowerCase();
        }
        else throw new Exception();
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Date getUnSubscriptionDate() {
        return unSubscriptionDate;
    }

    public void setUnSubscriptionDate(Date unSubscriptionDate) {
        this.unSubscriptionDate = unSubscriptionDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
