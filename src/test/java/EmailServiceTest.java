import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EmailServiceTest {
    public static EmailService emailService=new EmailService();
    
    @Test
    public void createStaticInstance(){
        Assertions.assertEquals(EmailService.getInstance(),EmailService.getInstance()
                ,"static instance are pointing to same Object");
    }
    @Test
    public void testSendEmailWithOrder(){
        Assertions.assertThrows(RuntimeException.class , () -> emailService.sendEmail(new Order()));
    }
    @Test
    public void testSendEmailWithOrderAndString(){
        Assertions.assertTrue(emailService.sendEmail(new Order() , new String()));
    }
}