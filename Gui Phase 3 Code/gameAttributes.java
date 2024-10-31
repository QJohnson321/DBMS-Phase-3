public class gameAttributes {


    private int gameid;
    private String title;
    private String genre;
    private String releaseDMYear;
    private String console;
    private String productId;
    private String multiplayer;
    private String studio;
    private double price;

    private String items;
    private int quantity;
    //private double price;


    public gameAttributes(int gameid, String title, String genre, String releaseDMYear,
                          String console, String studio, String productId, String multiplayer, double price) {

        this.gameid = gameid;
        this.title = title;
        this.genre = genre;
        this.releaseDMYear = releaseDMYear;
        this.console = console;
        this.studio = studio;
        this.productId = productId;
        this.multiplayer = multiplayer;

        this.items = items;
        this.price = price;
        this.quantity = quantity;

    }
    public int getGameid() {
        return gameid;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getReleaseDMYear() {
        return releaseDMYear;

    }
    public String getConsole() {
        return console;
    }
    public String getStudio() {
        return studio;
    }

    public String getProductId() {
        return productId;

    }
    public String getMultiplayer() {
        return multiplayer;
    }
    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setReleaseDMYear(String releaseDMYear) {
        this.releaseDMYear = releaseDMYear;
    }
    public void setConsole(String console) {
        this.console = console;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }



    public String toString() {
        return "Game Id: "  + gameid + " \nTitle: " + title + " \nGenre: " + genre + " \nReleaseDMYear: "+ releaseDMYear +
                " \nConsole: " + console + " \nStudio: " + studio + " \nMultiplayer: " + multiplayer + " \nPrice: $ " +price;
    }
}

