import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("Constructor with Parameter values")
    void testOrderConstructorWithParameterValue(){
        Order orderPen =new Order(10 , "Pen" ,50.55).setPriceWithTex(505.5);
        int quantity= 10;
        String itemName="Pen";
        double price = 50.55;
        double priceTax=505.5;
        assertAll(
                () -> assertEquals(quantity , orderPen.getQuantity()),
                () -> assertEquals(itemName, orderPen.getItemName()),
                () -> assertEquals(price , orderPen.getPrice()),
                () -> assertEquals(priceTax, orderPen.getPriceWithTex())
        );
    }
    @Test
    @DisplayName("Constructor without Parameter values")
    void testOrderConstructorWithoutParameterValue(){
        Order orderBook=new Order().setPrice(50).setItemName("Book").setQuantity(25).setPriceWithTex(1250.0);
        int quantity= 25;
        String itemName="Book";
        double price = 50;
        double priceTax=1250.0;
        assertAll(
                () -> assertEquals(quantity , orderBook.getQuantity()),
                () -> assertEquals(itemName, orderBook.getItemName()),
                () -> assertEquals(price , orderBook.getPrice()),
                () -> assertEquals(priceTax, orderBook.getPriceWithTex())
        );
    }
    @Nested
    class OrderWithoutData{
        private Order orderWithoutData;
        @Test
        void testOrderWithoutItemName(){
            orderWithoutData = new Order().setPrice(10)
                                    .setQuantity(10)
                                    .setPriceWithTex(100);
            assertNull(orderWithoutData.getItemName(),"ItemName is Null");
        }
        @Test
        void testOrderWithoutPrice(){
            orderWithoutData = new Order().setQuantity(10)
                                    .setPriceWithTex(100)
                                    .setItemName("Cap");
            assertEquals(0.0d,orderWithoutData.getPrice(),"Price is Not Provided");
        }
        @Test
        void testOrderWithoutQuantity(){
            orderWithoutData = new Order()
                                .setPrice(10)
                                .setPriceWithTex(100)
                                .setItemName("Cap");
            assertEquals(0,orderWithoutData.getQuantity(),"Quantity not Provided");
        }
        @Test
        void testOrderWithoutPriceTax(){
            orderWithoutData = new Order()
                            .setPrice(10)
                            .setQuantity(10)
                            .setItemName("Cap");
            assertEquals(0.0d,orderWithoutData.getItemName(),"Price tax not provided");
        }

    }
    @Nested
    class OrderWithNegativeOrZeroValue{
        private Order orderWithNegativeOrZero = null;
        @Test
        void testOrderWithNegativePrice(){
            orderWithNegativeOrZero =  new Order().setPrice(-100).setQuantity(0)
                    .setItemName("Box").setPriceWithTex(0);
            assertEquals(-100,orderWithNegativeOrZero.getPrice(),"Price cannot be negative");
        }
        @Test
        void testOrderWithNegativePriceTax(){
            orderWithNegativeOrZero =  new Order().setPrice(100).setQuantity(100)
                    .setItemName("Box").setPriceWithTex(-100);
            assertEquals(-100,orderWithNegativeOrZero.getPriceWithTex(),"Price tax cannot be negative");
        }
        @Test
        void testOrderWithZeroQuantity(){
            orderWithNegativeOrZero =  new Order().setPrice(100).setQuantity(0)
                    .setItemName("Box").setPriceWithTex(10);
            assertEquals(0,orderWithNegativeOrZero.getQuantity(),"Quantity cannot be zero");
        }
        @Test
        void testOrderWithZeroPriceTax(){
            orderWithNegativeOrZero =  new Order().setPrice(100).setQuantity(100)
                    .setItemName("Box").setPriceWithTex(0);
            assertEquals(0,orderWithNegativeOrZero.getPriceWithTex(),"PriceTax cannot be zero");
        }
        @Test
        void testOrderWithZeroPrice(){
            orderWithNegativeOrZero =  new Order().setPrice(0).setQuantity(10)
                    .setItemName("Box").setPriceWithTex(10);
            assertEquals(0,orderWithNegativeOrZero.getPrice(),"Price cannot be zero");
        }
    }

}
