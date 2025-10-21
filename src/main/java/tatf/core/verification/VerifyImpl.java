package tatf.core.verification;

import org.junit.jupiter.api.Assertions;

class VerifyImpl implements IVerify {
    @Override
    public void verifyTrue(boolean actual, String message) {
        Assertions.assertTrue(actual, message);
    }

    @Override
    public void verifyTrue(boolean[] actual, String message) {
        for (boolean b : actual)
            this.verifyTrue(b, message);
    }

    @Override
    public void verifyFalse(boolean actual, String message) {
        Assertions.assertFalse(actual, message);
    }

    @Override
    public void verifyFalse(boolean[] actual, String message) {
        for (boolean b : actual)
            this.verifyFalse(b, message);
    }

    @Override
    public void verifyFail(String message) {
        Assertions.fail(message);
    }

    @Override
    public void verify(Object expected, Object actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }

    @Override
    public void verify(Object[] expected, Object[] actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }

    @Override
    public void verifyNotNull(Object actual, String message) {
        Assertions.assertNotNull(actual, message);
    }

    @Override
    public void verifyNotNull(Object[] actual, String message) {
        Assertions.assertNotNull(actual, message);
    }

    @Override
    public void verifyNull(Object actual, String message) {
        Assertions.assertNull(actual, message);
    }

    @Override
    public void verifyNull(Object[] actual, String message) {
        Assertions.assertNull(actual, message);
    }

    @Override
    public void notVerify(Object expected, Object actual, String message) {
        Assertions.assertNotEquals(expected, actual, message);
    }

    @Override
    public void notVerify(Object[] expected, Object[] actual, String message) {
        Assertions.assertNotEquals(expected, actual, message);
    }
}