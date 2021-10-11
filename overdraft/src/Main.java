public class Main {
    public static void main(String[] args) {
        Datamodel dataModel = new Datamodel();
        //dataModel.getSubscriberInfo();
/*        Subscriber sub = new Subscriber("277750089012", "149810043210", "254724901601",
                "Roshan Adah", "radah@ymail.com", "87889090", "02", "en");
        boolean insertSuccess = dataModel.insertSubscriberInfo(sub);
        if(insertSuccess){
            System.out.println("Subscriber successfully activated");
        }*/

//        boolean updateSuccess = dataModel.updateSubscriberInfo("254704922600");
//        if(updateSuccess){
//            System.out.println("Subscriber successfully opted out");
//        }

        boolean updateEmailSuccess = dataModel.updateSubscriberEmail("254724901600", "mail.com");
        if(updateEmailSuccess){
            System.out.println("Subscriber email updated successfully");
        }
    }
}
