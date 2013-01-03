package utfpr.ct.dainf.if6ae.test.unit;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import utfpr.ct.dainf.if6ae.exemplos.suporte.ParamUtil;

/**
 * Executa os testes unitários.
 * @author Wilson
 */
public class ServletTest {

    // parâmetros fictícios para teste
    private static final Map<String, String[]> params = new HashMap<>();
    private static final String param1 = "param1";
    private static final String value1 = "value1";
    private static final String param2 = "param2";
    private static final String[] value2 = { "value21", "value22", "value23" };
    private static final String param3 = "param3";
    private static final String value3 = "123";
    private static final String paramX = "paramX";
    static {
        params.put(param1, new String[] { value1 });
        params.put(param2, value2);
        params.put(param3, new String[] { value3 });
    }
    private static final ParamUtil paramUtil = new ParamUtil(params);

    @Test
    public void existsTest() {
        Assert.assertTrue(paramUtil.exists(param1));
        Assert.assertFalse(paramUtil.exists(paramX));
    }

    @Test
    public void getParamValueTest() {
        Assert.assertArrayEquals(paramUtil.getParamValue(param2), value2);
    }

    @Test
    public void getStringTest() {
        Assert.assertEquals(paramUtil.getString(param1), value1);
        Assert.assertEquals(paramUtil.getString(param2), value2[0]);
        Assert.assertNull(paramUtil.getString(paramX));
    }

    @Test
    public void getTextTest() {
        Assert.assertEquals(paramUtil.getText(param1), value1);
        Assert.assertEquals(paramUtil.getText(param2), value2[0]);
        Assert.assertEquals(paramUtil.getText(paramX), "");
    }

    @Test
    public void getIntTest() {
        Assert.assertEquals(paramUtil.getInt(param3), Integer.parseInt(value3));
    }
}
