package utfpr.ct.dainf.if6ae.exemplos.suporte;

import java.util.Map;

/**
 * Esta classe encapsula um mapa de parâmetros e implementa
 * métodos auxiliares que facilitam o acesso aos valores.
 * @author Wilson
 */
public class ParamUtil {
    private Map<String, String[]> params;

    public ParamUtil(Map<String, String[]> params) {
        this.params = params;
    }

    /**
     * Retorna {@code true} se o parâmetro identificado por {@code name}
     * existir.
     * @param name O nome do parâmetro
     * @return {@code true} se o parâmetro existir
     */
    public boolean exists(String name) {
        return params.containsKey(name);
    }

    /**
     * Retorna o valor de um parâmetro de nome {@code name}.
     * @param name O nome do parâmetro
     * @return O valor do parâmetro ou {@code null}, caso não exista.
     */
    public String[] getParamValue(String name) {
        return params.get(name);
    }

    /**
     * Retorna o primeiro valor de um parâmetro que deve ser um texto. Caso
     * parâmetro não exista, retorna {@code null}.
     * @param name O nome do parâmetro
     * @return O valor valor do parâmetro
     */
    public String getString(String name) {
        return exists(name) ? getParamValue(name)[0] : null;
    }

    /**
     * Retorna o primeiro valor de um parâmetro que deve ser um texto. Caso
     * parâmetro não exista, retorna um texto vazio.
     * @param name O nome do parâmetro
     * @return O valor valor do parâmetro
     */
    public String getText(String name) {
        return exists(name) ? getParamValue(name)[0] : "";
    }

    /**
     * Retorna o valor de um parâmetro que deve representar um valor inteiro
     * dentro da faixa de valores de um {@code int}. Caso não seja possível
     * converter o valor para inteiro, lança uma exceção.
     * @param name O nome do parâmetro
     * @return O valor do parâmetro convertido para inteiro
     */
    public int getInt(String name) {
        return Integer.parseInt(getText(name));
    }
}
