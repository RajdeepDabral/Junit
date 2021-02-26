import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {
    public static EmailService emailService=new EmailService();

    @Test
    void createStaticInstance(){
        assertEquals(EmailService.getInstance(),EmailService.getInstance()
                ,"static instance are pointing to same Object");
    }
    @Test
    void testSendEmailWithOrder(){
        assertThrows(RuntimeException.class , () -> emailService.sendEmail(new Order()));
    }
    @Test
    void testSendEmailWithOrderAndString(){
        assertTrue(emailService.sendEmail(new Order() , new String()));
    }
}