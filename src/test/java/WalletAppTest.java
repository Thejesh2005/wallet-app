import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WalletAppTest {

    @Test
    void testCreditTransaction() {
        assertEquals(1200,
            WalletApp.processTransaction(1000, 200, "credit"));
    }

    @Test
    void testDebitTransaction() {
        assertEquals(800,
            WalletApp.processTransaction(1000, 200, "debit"));
    }

    @Test
    void testInsufficientBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            WalletApp.processTransaction(500, 1000, "debit");
        });
    }

    @Test
    void testInvalidTransactionType() {
        assertThrows(IllegalArgumentException.class, () -> {
            WalletApp.processTransaction(500, 100, "transfer");
        });
    }
}