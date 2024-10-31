    public class cartSetup {

    private String title;
    private double price;
    private int quantity;



        public cartSetup(String title,  double price) {
            this.title = title;
            this.price = price;
            this.quantity = 1;


        }
        public String getTitle() {
            return title;
        }
        public double getPrice() {
            return price;
        }
        public int getQuantity() {
            return quantity;
        }

       // public void setItems(String items) {
        //    this.items = items;
       // }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public void incrementQuantity() {
            this.quantity++;
        }

    }

