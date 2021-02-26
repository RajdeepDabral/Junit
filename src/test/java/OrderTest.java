import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    public static Order orderBook=new Order().setPrice(50).setItemName("Book").setQuantity(25).setPriceWithTex(1250.0);;
    public static Order orderPen =new Order(10 , "Pen" ,50.55).setPriceWithTex(505.5);


    @Test
    @DisplayName("Constructor with Parameter values")
    public void testOrderConstructorWithParameterValue(){
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
    public void testOrderConstructorWithoutParameterValue(){
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
}
