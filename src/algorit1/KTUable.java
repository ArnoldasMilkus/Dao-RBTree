package algorit1;

/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 23
 *
 * Tai yra  interfeisas, kurį turi tenkinti KTU studentų kuriamos duomenų klasės
 *       Metodai užtikrina patogų duomenų suformavimą iš String eilučių
 ******************************************************************************/
public interface KTUable<T> extends Comparable<T> {

   

    /**
     * this objektas sulyginamas su e obj.
     *
     * @param e
     * @return
     */
    @Override
    int compareTo(T e);

    /**
     * Atvaizduoja objektą į String eilutę
     *
     * @return
     */
    @Override
    String toString();
}
